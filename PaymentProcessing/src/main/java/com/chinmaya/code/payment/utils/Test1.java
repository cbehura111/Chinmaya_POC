package com.chinmaya.code.payment.utils;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.common.bytesource.ByteSourceInputStream;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.constants.TiffTagConstants;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class Test1 {
    public static void main(String[] args) {
        String s = "";
        stripExif(s);

    }
    public static String stripExif(String base64Image) {
        System.out.println("START METHOD :: stripExif()");
        String cleanedImage = "";
        if(StringUtils.isNotEmpty(base64Image)) {
            try {
                // Step 1: Decode Base64 to byte array
                byte[] imageBytes = decodeBase64(base64Image);
                // Check if the image format supports EXIF metadata (JPEG or TIFF)
                if (!supportsExifMetadata(imageBytes)) {
                    System.out.println("Uploaded file does not support EXIF metadata. Returning original Base64.");
                    return base64Image;
                }
                System.out.println("Image base64 sanitation is in process ...");
                int orientation = getImageOrientation(new ByteArrayInputStream(imageBytes));
                // Step 2: Convert byte array to BufferedImage
                BufferedImage bufferedImage = Imaging.getBufferedImage(new ByteArrayInputStream(imageBytes));
                BufferedImage correctedImage = correctImageOrientation(bufferedImage, orientation);

                // Step 3: Write the image back without metadata to a ByteArrayOutputStream
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(correctedImage, "jpg", outputStream);
                byte[] cleanImageBytes = outputStream.toByteArray();
                cleanedImage = encodeBase64(cleanImageBytes);
                System.out.println("Image base64 sanitised");
            } catch (Exception e) {
                System.out.println("Error in stripExif: {}"+ e);
                //throw ErrorResponseUtil.getException(ErrorCodeConstants.APZ_INTERNAL_ERR, ErrorCodeConstants.APZ_INTERNAL_ERR_MSG);
            }
        }
        System.out.println("END METHOD :: stripExif()");
        return cleanedImage;
    }

    private static byte[] decodeBase64(String base64Image) {

        System.out.println("START METHOD :: decodeBase64()");
        // Remove the "data:image/xxx;base64," prefix if present
        if (base64Image.contains(",")) {
            base64Image = base64Image.split(",")[1];
        }
        System.out.println("END METHOD :: decodeBase64()");
        return Base64.getDecoder().decode(base64Image);
    }
    private static String encodeBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    private static boolean supportsExifMetadata(byte[] imageBytes) {
        System.out.println("START METHOD :: supportsExifMetadata()");
        try (InputStream inputStream = new ByteArrayInputStream(imageBytes)) {
            String formatName = Imaging.guessFormat(new ByteSourceInputStream(inputStream, "image")).getName();
            System.out.println("END METHOD :: supportsExifMetadata()");
            return "JPEG".equalsIgnoreCase(formatName) || "TIFF".equalsIgnoreCase(formatName);
        } catch (IOException e) {
            System.out.println("Error while checking image format: {}"+ e);
            return false;
        }
    }


    public static int getImageOrientation(InputStream inputStream) {
        // Use the correct `getMetadata` method for InputStream
        ImageMetadata metadata = null;
        Integer orientation = 1;
        try {
            metadata = Imaging.getMetadata(inputStream, "image");
            if (metadata != null && metadata instanceof TiffImageMetadata) {
                TiffImageMetadata tiffMetadata = (TiffImageMetadata) metadata;
                orientation = tiffMetadata.findField(
                        TiffTagConstants.TIFF_TAG_ORIENTATION).getIntValue();
            } else if (metadata != null && metadata instanceof JpegImageMetadata) {
                JpegImageMetadata jpegMetadata  = (JpegImageMetadata) metadata;
                TiffField orientationField = jpegMetadata.findEXIFValue(TiffTagConstants.TIFF_TAG_ORIENTATION);
                if (orientationField != null) {
                    orientation = orientationField.getIntValue();
                }
            }
        } catch (ImageReadException | IOException e) {
            throw new RuntimeException(e);
        }
        return orientation != null ? orientation : 1; // Default orientation is 1 (normal)
    }

    private static BufferedImage correctImageOrientation(BufferedImage image, int orientation) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage correctedImage = new BufferedImage(width, height, image.getType());
        Graphics2D g = correctedImage.createGraphics();

        // Apply transformation based on EXIF orientation
        switch (orientation) {
            case 1: // Normal
                g.drawImage(image, 0, 0, null);
                break;
            case 3: // Upside down
                g.transform(AffineTransform.getRotateInstance(Math.PI, width / 2.0, height / 2.0));
                g.drawImage(image, 0, 0, null);
                break;
            case 6: // Rotate 90 degrees clockwise
                g.transform(AffineTransform.getRotateInstance(Math.PI / 2, height / 2.0, height / 2.0));
                g.translate(0, -width);
                g.drawImage(image, 0, 0, null);
                break;
            case 8: // Rotate 90 degrees counterclockwise
                g.transform(AffineTransform.getRotateInstance(-Math.PI / 2, width / 2.0, width / 2.0));
                g.translate(-height, 0);
                g.drawImage(image, 0, 0, null);
                break;
            default:
                g.drawImage(image, 0, 0, null); // Default orientation
        }
        g.dispose();
        return correctedImage;
    }
}
