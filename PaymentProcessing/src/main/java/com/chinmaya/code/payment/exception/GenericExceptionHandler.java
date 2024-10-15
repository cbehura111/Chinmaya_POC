package com.chinmaya.code.payment.exception;

import com.chinmaya.code.payment.dto.response.ErrorResponse;
import com.chinmaya.code.payment.enums.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Slf4j
@RestControllerAdvice(basePackages = {"com.chinmaya.code"})
@RequiredArgsConstructor
public class GenericExceptionHandler {

    @ExceptionHandler({ServletRequestBindingException.class})
    public ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, WebRequest request) {
        log.error("handleMethodArgumentNotValid: {}",ex.getMessage());
        ErrorResponse response = ErrorResponse.builder()
                .status(Status.F.getStaus())
                .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .errorCode(HttpStatus.BAD_REQUEST.name())
                .detail(ex.getMessage())
                .timeStamp(LocalDateTime.now(ZoneOffset.UTC))
                .uri(request.getDescription(false))
                .build();
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler({ResourceNotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        log.error("Resource not found exception occurred: {}", exception.getMessage());
        ErrorResponse response = ErrorResponse.builder()
                .status(Status.F.getStaus())
                .httpStatusCode(HttpStatus.NOT_FOUND.value())
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .timeStamp(LocalDateTime.now(ZoneOffset.UTC))
                .uri(request.getDescription(false))
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler({InternalServerException.class})
    protected ResponseEntity<ErrorResponse> handleInternalServerException(InternalServerException exception, WebRequest request) {
        log.error("Server exception occurred: {}", exception.getMessage());
        ErrorResponse response = ErrorResponse.builder()
                .status(Status.F.getStaus())
                .httpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .timeStamp(LocalDateTime.now(ZoneOffset.UTC))
                .uri(request.getDescription(false))
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler({BadRequestException.class})
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException exception, WebRequest request) {
        log.error("BadRequestException occurred: {}", exception.getMessage());
        ErrorResponse response = ErrorResponse.builder()
                .status(Status.F.getStaus())
                .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .timeStamp(LocalDateTime.now(ZoneOffset.UTC))
                .uri(request.getDescription(false))
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    @ExceptionHandler({JSONProcessingException.class})
    protected ResponseEntity<Object> handleJSONProcessingException(JSONProcessingException exception, WebRequest request) {
        log.error("JSONProcessingException occurred: {}", exception.getMessage());
        ErrorResponse response = ErrorResponse.builder()
                .status(Status.F.getStaus())
                .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .timeStamp(LocalDateTime.now(ZoneOffset.UTC))
                .uri(request.getDescription(false))
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({DuplicateResourceFoundException.class})
    protected ResponseEntity<Object> handleDuplicateResourceFound(DuplicateResourceFoundException exception, WebRequest request) {
        log.error("DuplicateResourceFoundException occurred: {}", exception.getMessage());
        ErrorResponse response = ErrorResponse.builder()
                .status(Status.F.getStaus())
                .httpStatusCode(HttpStatus.CONFLICT.value())
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .timeStamp(LocalDateTime.now(ZoneOffset.UTC))
                .uri(request.getDescription(false))
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @ExceptionHandler({PaymentProcessException.class})
    protected ResponseEntity<Object> handlePaymentProcessException(PaymentProcessException exception, WebRequest request) {
        log.error("handle PaymentProcessException occurred: {}", exception.getMessage());
        ErrorResponse response = ErrorResponse.builder()
                .status(Status.F.getStaus())
                .httpStatusCode(HttpStatus.CONFLICT.value())
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .maxValue(exception.getMax()!=null? exception.getMax() : null)
                .minValue(exception.getMin()!=null?exception.getMin():null)
                .timeStamp(LocalDateTime.now(ZoneOffset.UTC))
                .uri(request.getDescription(false))
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @ExceptionHandler({RestServiceException.class})
    protected ResponseEntity<Object> handleRestServiceException(RestServiceException exception, WebRequest request) {
        log.error("handleRestServiceException occurred: {}", exception.getMessage());
        ErrorResponse response = ErrorResponse.builder()
                .status(Status.F.getStaus())
                .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .timeStamp(LocalDateTime.now(ZoneOffset.UTC))
                .uri(request.getDescription(false))
                .build();
        return ResponseEntity.status(response.getHttpStatusCode()).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
