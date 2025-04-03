package com.chinmaya.utils.utils;

import com.chinmaya.utils.constants.CommonConstants;
import com.chinmaya.utils.enums.Messages;
import com.chinmaya.utils.payload.core.ResponseHeader;

public class ResponseUtils {

	public static void generateHeaderForSuccess(ResponseHeader responseHeader) {
		responseHeader.setResponseCode(CommonConstants.SUCCESS);
		responseHeader.setResponseMessage("");
	}

	public static void generateHeaderForFailure(ResponseHeader responseHeader, String errorMsg) {
		responseHeader.setResponseCode(CommonConstants.FAILURE);
		responseHeader.setResponseMessage(errorMsg);
	}

	public static void generateHeaderForGenericError(ResponseHeader responseHeader) {
		responseHeader.setResponseCode(CommonConstants.FAILURE);
		responseHeader.setErrorCode(Messages.GENERIC_ERROR.getErrorCode());
		responseHeader.setResponseMessage(Messages.GENERIC_ERROR.getErrorMessage());
	}

	public static void generateHeaderForDBError(ResponseHeader responseHeader) {
		responseHeader.setResponseCode(CommonConstants.FAILURE);
		responseHeader.setResponseMessage(Messages.PERSISTENCEERROR.getErrorMessage());
	}

	public static void generateHeaderForNoResult(ResponseHeader responseHeader) {
		responseHeader.setResponseMessage(Messages.NORECORD.getErrorMessage());
		responseHeader.setResponseCode(Messages.NORECORD.getErrorCode());
	}

	public static void generateHeaderForDBConfigFailure(ResponseHeader responseHeader) {
		responseHeader.setResponseMessage("DB Configuration Error, Please retry after sometime.");
		responseHeader.setResponseCode(CommonConstants.FAILURE);
	}

	public static void generateHeaderForBeneficiaryDeletionFailure(ResponseHeader responseHeader) {
		responseHeader.setResponseMessage(Messages.BENEFICIARYDELETIONERROR.getErrorMessage());
		responseHeader.setResponseCode(Messages.BENEFICIARYDELETIONERROR.getErrorCode());
	}

	public static void generateHeaderForAddBeneficiaryFailure(ResponseHeader responseHeader) {
		responseHeader.setResponseMessage(Messages.BENEFICIARYADDERROR.getErrorMessage());
		responseHeader.setResponseCode(CommonConstants.FAILURE);
	}
}
