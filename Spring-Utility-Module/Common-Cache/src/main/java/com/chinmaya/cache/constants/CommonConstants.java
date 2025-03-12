package com.chinmaya.cache.constants;

public class CommonConstants {

	private CommonConstants() {
	}
	
	public static final String ACC_TYPE_MAPPER = "accTypeMapper";
	public static final String ACCOUNT_NUMBER = "accountNo";
	public static final String ACCOUNT_NUMBER_PARENT_NODE = "accountNumberParentNode";
	public static final String ACCOUNT_NUMBER_PARENT_OBJ = "accountNumberParentObj";
	public static final String ACCOUNT_TYPE_FLG = "accountTypeFlag";
	public static final String TXN_APPID = "txnAppID";
	public static final String ERRORS = "Errors";
	
	public static final String ALTERNATEVALIDATION = "AlternateValidation";
	public static final String TPIN_NOT_SET = "APZ-REG-008";
	public static final String SECURE_IMAGE_NOT_SET = "APZ-REG-012";
	public static final String SECURE_TEXT_NOT_SET = "APZ-REG-011";
	public static final String PRIMARY_ACCOUNT_NOT_SET = "APZ-REG-009";
	public static final String SHOW_PRIMARY_ACC_CALL_REG = "APZ-REG-017";
	public static final String SECURE_IMG_NSET = "APZ-REG-012";
	public static final String SECRET_QUESTION_NOT_SET = "APZ-SEC-001";
	public static final String MPIN_ENT = "MPIN_ENTER";
	public static final String DEBIT_CARD_SHOW = "APZ-REG-006";
	public static final String IB_PASS_NOT_SET = "APZ-REG-001";
	public static final String MPIN_NOT_SET = "APZ-REG-007";
	public static final String MPIN_NOT_SET_CALL_REG = "APZ-REG-015";
	public static final String SHOW_IB_PASS = "APZ-REG-027";
	public static final String LEGACY_PASS_SHOW = "APZ-REG-005";
	public static final String LEGACY_PASS_NOT_SET = "APZ-REG-014";
	public static final String SHOW_MPIN = "APZ-REG-026";
	public static final String SHOW_IB_PASS_DEBIT = "APZ-REG-004";
	public static final String LEGACY_PASS_DEBIT_SHOW = "APZ-REG-002";
	public static final String IB_PASS_NOT_SET_CALL_REG = "APZ-REG-020";
	public static final String TPIN_NOT_SET_CALL_REG = "APZ-REG-016";
	public static final String SECURE_TEXT_IMG_NSET = "APZ-REG-030";
	public static final String SECURE_TEXT_CALL_REG = "APZ-REG-018";
	public static final String SECURE_IMG_CALL_REG = "APZ-REG-019";
	public static final String VALIDATEMPIN = "APZ-REG-026";
	public static final String SHOWMPINDEBIT = "APZ-REG-003";
	public static final String SHOWMPINCALLREG = "APZ-REG-028";
	public static final String NODATAFOUND = "NODATAFOUND";
	public static final String NOCONFIGFOUND = "NOCONFIGFOUND";
	public static final String SETSECUREIMGTEXTCALLREG = "APZ-REG-031";
	public static final String SETLOGINIBPASS = "APZ-LOGIN-001";
	public static final String SETMPIN = "APZ-LOGIN-002";
	public static final String ALL_DATA_SET = "All Data are Set for the user";
	public static final String ALL_SET = "APZ-REG-000";

	public static final String FAILURE = "1";
	public static final String SUCCESS = "0";
	public static final String NO_RESULT = "NR100";
	public static final String SERVICE_BLOCK = "SERV_BLOCK_000";
	public static final String SECU_IMG_TXT = "SECU_IMG_TXT_001";
	
	public static final String API_REQUEST = "apiRequest";
	public static final String REQUEST_OBJ = "requestObj";
	public static final String RESPONSE_HEADER = "ResponseHeader";
	public static final String RESPONSE_CODE = "ResponseCode";
	public static final String ERROR_CODE = "ErrorCode";
	public static final String ERROR_MESSAGE = "ErrorMessage";
	public static final String ERROR_CODE_LW_TXT = "errorCode";
	public static final String ERROR_DESC_LW_TXT = "errorDesc";
	public static final String API_RESPONSE = "apiResponse";
	public static final String RESPONSE_OBJ = "responseObj";

	public static final String RESPONSE_BODY = "ResponseBody";
	public static final String RESPONSE_MESSAGE = "ResponseMessage";
	public static final String MESSAGE = "Message";
	public static final String SERVICE_CODE = "ServiceCode";
	public static final String SERVICESTATUSCODE_CC = "serviceStatusCode";
	public static final String SERVICESTATUSMESSAGE_CC = "serviceStatusMessage";
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final String CURR_ACTION = "currentAction";
	/***************** Response Error Messages *****************/
	public static final String CONF_ERROR = "WorkFlow configuration maintenance error";
	public static final String IFACE_ERROR = "Interface invocation failed";
	public static final String VALIDATION_FAILURE = "Validation failure";
	public static final String OTP_FAILURE = "OTP Generation failed";
	public static final String OTP_VALIDATION_FAILURE = "OTP Validation failed";
	public static final String NOUSER_PROFILE_DETAILS = "User Profile Details not available";
	public static final String PASS_VALIDATION_FAILURE = "Transaction Password Validation failed";
	public static final String TPIN_VALIDATION_FAILURE = "Transaction PIN Validation failed";
	public static final String INVALID_REQ_FAILURE = "Invalid Request";
	public static final String MPIN_VALIDATION_FAILURE = "MPIN Validation failed";

	public static final String PASS_POLICY_FAILURE = "Unable to fetch the Password Policy";	
	public static final String PASS_POLICY_VALID_FAILURE = "Password Policy validation failure";
	public static final String SECU_POLICY_VALID_FAILURE = "Security Image and Text Updation Policy validation failure";
	
	public static final String GENERIC_ERR_MSG = "Oops! Something went wrong, Please try after some time.";
	public static final String USER_EXISTS = "APZ_TOTP_001";

	public static final String CODETYPE = "COMM"; // Common Code key
	public static final String CODE = "AUTHENTICATION"; // Common Code key
	public static final String AUTHTYPE = "AuthType"; // Common Code value for Authentication
	public static final String MODULE = "Module"; // Common Code value for Authentication
	public static final String AUTHENTICATION = "Authentication"; // Common Code value for Authentication
	public static final String AUTHMODULES = "AuthModules"; // Common Code value for Authentication
	public static final String TRANSACTIONTYPE = "transactionType"; // Request parameter
	public static final String FORGOTUSERPASS = "FORGOTUSERPASS"; // Common Code key
	public static final String PRIMARY = "Primary"; // Common Code value for Authentication
	public static final String ALTERNATE = "Alternate"; // Common Code value for Authentication
	public static final String APP_ID = "appId";
	public static final String USER_ID = "userId";
	public static final String DEVICE_ID = "deviceId";
	public static final String USER_NAME = "userName";
	public static final String MOBILE_NO = "mobileNo";
	public static final String SIM_DETAILS = "simDetails";
	public static final String CREATE_TS = "createTs";
	public static final String VERIFY_STATUS = "verifyStatus";
	public static final String PROFILE_PIC = "profilePic";
	public static final String SECURITY_TEXT = "securityText";
	public static final String SECURITY_IMAGE_ID = "securityImageId";
	public static final String SECURITY_IMAGE_BASE64 = "securityImageBae64";
	public static final String SECURITY_IMAGE_URL = "securityImageUrl";
	public static final String EMAIL_NOTI = "emailNotification";
	public static final String PUSH_NOTI = "pushNotification";
	public static final String SMS_NOTI = "smsNotification";
	public static final String STATUS = "Status";
	public static final String SYSDATE = "sysDate";
	public static final String SUCCESS_TXT_LW = "success";
	public static final String STATUS_LW_TXT = "status";
	public static final String FAILURE_TXT_LW = "failure";
	public static final String MSG_TXT_LW = "message";
	public static final String PAYLOAD_TXT_LW = "payload";
	public static final String COMMONPARAM_SERVICE = "commonParamService";
	public static final String APZ_ENCRYPTION_FAIL = "APZ-ENCRYPTION-FAIL";
	public static final String ENCRYPT_ACC_FAILED_MSG = "Failed to encrypt the account number";
	public static final String ENCRYPT_CARD_FAILED_MSG = "Failed to encrypt the card number";
	public static final String ENCRYPT_PRIMARY_CARD_FAILED_MSG = "Failed to encrypt the primary card number";
	public static final String APZBANKING_SERV_CAMELCASE_TXT = "apzBankingService";
	public static final String WFSERVICE_SERV_CAMELCASE_TXT = "workflowService";
	public static final String EXCEPTION_OCCURED = "Exception Occurred: {}";
	public static final String VALUE_LW_TXT = "value";
	public static final String KEY_LW_TXT = "key";
	public static final String MOBILENUMBER = "mobileNumber";
	public static final String CUSTOM_LOGIN_WF = "CustomLogin"; // Common Code key
	public static final String FETCH_CUSTOM_LOGIN = "FetchCustomLoginData"; // Common Code key
	
	public static final String PG_REQ_DATA = "merchantRequestData";
	
	public static final String CUSTOM_PG_LOGIN_WF = "CustomPGLogin"; // Common Code key
	public static final String FETCH_CUSTOM_PG_LOGIN = "FetchCustomPGLoginData"; // Common Code key
	
	public static final String CUSTOM_AUTHENTICATOR_LOGIN_WF = "CustomAuthenticatorLogin"; // Common Code key
	public static final String FETCH_CUSTOM_AUTHENTICATOR_LOGIN = "FetchCustomAuthenticatorLoginData"; // Common Code key

	public static final String CUSTOM_LOGIN_SERV = "AppzillonBankingServices"; // Service class name
	public static final String WORKFLOW_INTF_NAME = "WorkFlowService"; // Interface Name
	public static final String TXN_APP_ID = "txnAppID";
	public static final String MPIN_APP_ID = "mpinAppID";
	public static final String USER_INFO = "UserInfo";
	public static final String COMMON_CODE_DESC_LG_TXT = "Common Code description:";
	public static final String CUSTOMER_ID = "customerId";
	public static final String TFR_LIMIT_AUTH = "TRANSFERLIMITAUTH"; // Common Code key
	public static final String FLG_LW_TXT = "flag";
	public static final String LANGUAGE = "language";
	public static final String THEME = "theme";
	public static final String THEMES = "THEMES";
	public static final String THEME_OBJ = "Themes";
	public static final String THEME_DETAILS = "Theme details = ";
	public static final String DEFAULT_THEME = "DefaultTheme";
	public static final String IB = "IB";
	public static final String MB = "MB";
	
	public static final String ERR_CODE = "errorCode";
	public static final String ERR_DESC = "errorDesc";

	/******************* VAPT Validation Constants ****************/
	public static final String DEBIT_ACC_NO = "debitAcctNo"; // Request Parameter
	public static final String DEBIT_ACC_CCY = "debitAcctCcy"; // Request Parameter
	public static final String TFR_AMT = "transactionAmount"; // Request Parameter
	public static final String TFR_CCY = "transactionCcy"; // Request Parameter
	public static final String AVAIL_BALANCE = "availableBalance"; // Request Parameter
	public static final String ACC_TYPE = "accountType"; // Request Parameter
	public static final String INTF_NAME = "interfaceName"; // Request Parameter
	public static final String WF_ID = "workflowId"; // Request Parameter
	public static final String ACCOUNTS = "accounts"; // Response Parameter
	public static final String CURRENCY = "currency"; // Response Parameter
	public static final String TRANSACTION_CCY = "TRANSACTIONCURRENCY"; // Common Code Parameter
	public static final String TRANSACTION_CCY_CC = "TransactionCurrency"; // Common Code Value
	public static final String ACCOUNT_CCY = "accountCcy"; // Common Code Value
	public static final String EQ_AMT = "equivalentAmount";
	public static final String EXHCG_RATE = "exchangeRate";
	
	public static final String CARD_NUMBER = "cardNumber"; // Request Parameter
	public static final String CVV = "pin"; // Request Parameter
	public static final String EXPIRY_DATE = "expiryDate"; // Request Parameter
	public static final String CARD_TFR_TYPE = "cardTransferType"; // Request Parameter
	public static final String REGISTERED_CARDS = "REGISTERED"; // Request Parameter
	public static final String CREDIT_CARDS_LC_TXT = "creditCards"; // Response Parameter
	
	public static final String CARD_BALANCE = "cardBalance"; // Response Parameter
	public static final String CARD_CVV = "cardcvv"; // Response Parameter
	public static final String CARD_EXPIRY = "cardValidity"; // Response Parameter

	public static final String BENEF_ACC_NO = "benefAcctNo"; // Request Parameter
	public static final String BENE_ACCT_NO = "beneAcctNo"; // Request Parameter
	public static final String BENEF_ACC_TYPE = "benefAcctType"; // Request Parameter
	public static final String BENEF_ACC_CCY = "benefAcctCcy"; // Request Parameter
	public static final String BENEF_TYPE = "benefType"; // Request Parameter

	public static final String RESP_BENEF_ACC_NO = "beneficiaryAccountNo"; // Response Parameter
	public static final String RESP_BENEF_ACC_TYPE = "beneficiaryAccountType"; // Response Parameter
	public static final String RESP_BENEF_TYPE = "beneficiaryType"; // Response Parameter
	public static final String RESP_BENEF_ACC_CCY = "currency"; // Response Parameter
	public static final String TFR_TYPE = "transferType"; // Request Parameter
	public static final String OWN = "OWN"; // Request Transaction Type
	public static final String WIT = "WIT"; // Request Transaction Type
	public static final String OTH = "OTH"; // Request Transaction Type
	public static final String INT = "INT"; // Request Transaction Type
	public static final String DEP_AMT = "depositAmount"; // Request Parameter
	public static final String BILLER_ID = "billerId";
	/******************* End VAPT Validation Constants ****************/
	public static final String REGISTRATION = "REGISTRATION";
	public static final String SERVICE_TYPE = "serviceType";
	public static final String REF_NO_CC = "refNo";
	public static final String REF_NO_UC = "RefNo";
	public static final String CHANNEL_LW_TXT = "channel";

	/************ External Service Interfaces ****************/

	public static final String ACCOUNT_UNMASK = "accUnMaskIntf";
	public static final String ACCOUNT_DETAILS = "accDtlsIntf";
	public static final String GET_EXCHANGE_RATE = "exchangeRateIntf";
	public static final String BENEFICIARY_FETCH = "fetchBenefIntf";
	public static final String STORE_FEEDBACK_DATA = "storeFeedBackIntf";
	public static final String VALIDATE_FEEDBACK = "validateFeedBackIntf";
	public static final String CUSTOMER_360 = "customer360Intf";
	public static final String DOWNLOAD_RECEIPT = "downloadReceiptIntf";
	public static final String FETCH_BLOCKOUT_INTF = "fetchBlockOutIntf";
	public static final String VALIDATE_CREDIT_CARD = "validateCreditCardsIntf";
	public static final String  GET_CUST_DTLS_INTF = "GetCustomerDetails";
	public static final String  UPDATE_PROFILE_DET = "UpdateProfileDet";
	public static final String  USER_ENQUIRY = "UserEnquiry";
	public static final String BLOCKOUT_INTF = "fetchBlockOutIntf";
	public static final String VERIFY_CUSTOMER_INTF = "verifyCustomerIntf";
	public static final String NOTIF_HUB_FLG = "notifHub";
	public static final String NOTIF_PAYLOAD_INTF = "NotifPayloadIntf";
	
	/************ ACCOUNT MASKING Constants ****************/
	public static final String PRIMARY_CCY = "PRIMARYCURRENCY";

	//public static final String ACCOUNT_MASK_CODE = "ACCOUNTMASK";
	public static final String ACCOUNT_MASK_CODE = "MASKING";
	public static final String ACCOUNT_MASK = "AccountMask";
	public static final String MASKING = "Masking";
	public static final String ENCRYPTION = "Encryption";
	public static final String MASKING_FLAG = "flag";
	//public static final String DASHBOARD_MASKING = "DashboardMasking";
	public static final String ACCOUNT_MASKING = "AccountMasking";	
	public static final String START_POS = "StartPosition";
	public static final String TOTAL_MASK_COUNT = "TotalMaskCount";
	public static final String MASK_CHAR = "maskCharacter";

	public static final String ACCOUNT_MASKING_DETAILS = "Account Masking details = ";
	
	public static final String CARD_MASK_CODE = "CARDMASK";
	public static final String CARD_MASK = "CardMask";
	public static final String CARD_MASKING_DETAILS = "Card Masking Details = ";
	public static final String CARD_NUMBER_PARENT_OBJ = "cardNumberParentObj";


	/************ PROPERTY FILE CODE ****************/
	public static final String AB_COMMON_PROP = "ab.common.";
	
	public static final String ENCRYPTED_ACCOUNT_NUMBER = "encryptedAccountNumber";
	public static final String ENCRYPTED_CREDIT_ACCOUNT_NUMBER = "encryptedCreditAcctNo";
	public static final String ENCRYPTED_PAYOUT_ACCOUNT_NUMBER = "encryptedPayoutAccountNumber";
	public static final String ENCRYPTED_AUTODEBIT_ACCOUNT_NUMBER = "encryptedAutoDebitAccountNumber";
	public static final String ENCRYPTED_BENEF_ACCOUNT_NUMBER = "encryptedBeneficiaryAccountNumber";

	public static final String BENEFICIARY_ACCT_NUMBER = "beneficiaryAccountNo";
	public static final String BENEFICIARY_CUST_ID = "beneficiaryCustId";
	public static final String BENEF_ACCT_NO = "benefAccNo";
	public static final String DEBIT_ACCT_NO = "debitAcctNo";
	public static final String CREDIT_ACCT_NO = "creditAcctNo";
	public static final String PAYOUT_ACCT_NO = "payoutAccount";
	public static final String AUTODEBIT_ACCT_NO = "autoDebitAccNo";
	public static final String DEBITCARDS = "debitCards";
	public static final String CREDITCARDS = "creditCards";
	public static final String NOMINEES = "nominees";
	public static final String BENEF_DTLS = "benefDtlsList";
	
	public static final String IS_SCHEDULED_CACHE_REFRESH = "isScheduleCacheRefreshEnabled"; // Property file flag
	public static final String CACHE_REFRESH_PERIOD = "cacheRefreshPeriod"; // Property file flag

	/******* Account Type Mapper related common variables. **********/
	public static final String LOAN_TYPE = "loanType";
	public static final String ACCOUNT_TYPE = "accountType";
	public static final String DEBIT_ACC_TYPE = "debitAcctType";
	public static final String BENEFICIARY_ACC_TYPE = "beneficiaryAccountType";
	public static final String BENEF_ACCOUNT_TYPE = "benefAcctType";
	public static final String ACCTYPE_MAPPER = "ACCTYPE_MAPPER";
	public static final String ACCTYPE_MAPPER_LW_TXT = "accTypeMapper";
	
	public static final String CC_CODE = "code";
	public static final String DESC = "desc";
	public static final String GROUP = "group";
	public static final String ACC_TYPE_CODE = "accTypeCode";
	public static final String BENEF_ACC_TYPE_CODE = "benefAccTypeCode";
	
	/******* Account Type Mapper related common variables Ends. **********/
	public static final String MASKING_ENABLED_LOG = "Masking is enabled";
	public static final String ENCRYPT_ACC_TXT = "encryptedAccountNumber = ";
	public static final String RESP_LOG1 = "Replacing the complete array response";
	public static final String EXT_SER_RESP_TXT = "externalServiceResp = ";
	public static final String MASKANDENCRYPT_END_LOG = "End : maskAndEncryptAccountNumber";

	public static final String ERROR_RESPONSE_MSG = "Error response received from external service, returning the response without masking and encryption";
	public static final String USER_LANGUAGE = "language";
	public static final String VAPT_REQ = "vaptRequired";
	
	/******* Show Hide Account related common variables Ends. **********/
	public static final String SHOW_HIDE_FLG = "showHideAccountFlag"; // Property file flag
	public static final String SHOW_HIDE_ACCOUNT = "SHOWHIDEACCOUNT"; // Common Code Key
	public static final String SHOW_HIDE_ACCOUNT_LW_TXT = "showHideAccounts";
	
	public static final String CUSTOMER_TYPE = "customerType";	
	public static final String CUSTOMER_DETAILS = "customerDetails";	
	public static final String SEGMENT_CODE = "segmentCode";
	public static final String DEFAULT_SEGMENT = "defaultSegment";
	public static final String SINGLE_CURRENCY_LIMIT = "singleCurrencyLimit";
	public static final String CUSTOMER_SEGMENT = "customerSegment";
	public static final String CUSTOMER_NAME = "customerName";

	/************ CARD MASKING Constants ****************/
	
	public static final String ENCRYPTED_CARD_NUMBER = "encryptedCardNumber";
	public static final String CARD_NO = "cardNumber";
	public static final String CARD_NUMBER_PARENT_NODE = "cardNumberParentNode";
	public static final String ENCRYPT_CARD_TXT = "encryptedCardNumber = ";
	public static final String CVV_CARD = "cvv";
	public static final String PIN_CARD = "pin";
	public static final String PRIMARY_CARD_NUMBER = "primaryCardNumber";
	public static final String ENCRYPTED_PRIMARY_CARD_NUMBER = "encryptedPrimaryCardNumber";

	public static final String STORE_FWD_TXN_PAYLOAD = "storeAndFwdTxnPayload";
	public static final String REF_NO_LW_TXT = "refNo";
	
	public static final String AUTHENTICATOR_APPID = "authenticatorAppID";
	
	
	public static final String QUESTION_NO = "questionNo";
	
	public static final String TPINEXP = "TPINEXP";
	public static final String MPINEXP = "MPINEXP";
	public static final String PASSEXP = "PASSEXP";
	
	/** Added part of BOM Project developement ***/
	/************ USER REGISTRATION Constants ****************/

	public static final String VAPT_VALIDATION = "VAPT validation failed";
	public static final String ACTION_TXT = "action";
	public static final String ATTRIBUTE_UPDT = "ATTRIBUTE_UPDT";
	public static final String TRANSACTION_RIGHTS_TEXT = "transRightsText";
	public static final String WHATSAPP_OPTED = "whatsappOpted";
}
