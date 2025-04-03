package com.chinmaya.cache.enums;

public enum Messages {

	DATEERROR("DT_TIME_INVL", "Date and Time is invalid"),
	SEVICETIMEDOUTERROR("EXT_TIME_OUT", "Timed out trying to reach external service"),
	SEVICENOTREACHABLEERROR("SERV_NOT_RECHABLE", "Unable to reach the service"), 
	SERVICEERROR("SERV_RESP_INVL", "Service Response Invalid"),
	PERSISTENCEERROR("PERSISTENCE_ERR", "Persistence Error"),
	GENERIC_ERROR("GENERIC_ERR", "Oops! Something went wrong, Please try again."),
	NORECORD("NR100", "No Record/Data Found"),
	INSERTRECORD("REC_INSERT_SUCCESS", "Record inserted successfully"),
	RECORDEXISTSERROR("REC_EXISTS", "Record already exists"), 
	DATEFORMATINVALIDERROR("DT_NOT_ACCEPTABLE", "Date format is not acceptable"),
	TIMEFORMATINVALIDERROR("TIME_NOT_ACCEPTABLE", "Time format is not acceptable"),
	DATETIMEFORMATINVALIDERROR("DT_TIME_NOT_ACCEPTABLE", "Date-Time format is not acceptable"),
	LIMITMISSINGERROR("LIMITS_NOT_EXISTS", "Limits non-existent"), 
	DATAINSERTIONSUCCESS("ABS_COM_001", "Data insertion successful"),
	DATAINSERTIONFAILURE("ABS_COM_002", "Unable to insert the record"),
	DATAUPDATIONSUCCESS("ABS_COM_003", "Data updation successful"),
	DATAUPDATIONFAILURE("ABS_COM_004", "Unable to update the record(s)"),
	DATADELETIONSUCCESS("ABS_COM_005", "Data deletion successful"),
	DATADELETIONFAILURE("ABS_COM_006", "Unable to deletion the record"),
	DATAFETCHSUCCESS("ABS_COM_007", "Data fetch successful"),
	DATAFETCHFAILURE("ABS_COM_008", "Unable to fetch the data"),
	BENEFICIARYDELETIONERROR("ABS_COM_009","A transfer is scheduled for this beneficiary in future, so please delete the scheduled transfer before deleting the beneficiary"),
	BENEFICIARYADDERROR("ABS_COM_010","Matching beneficiary already exists"),
	SERVERERROR("SERV_ERR","Server Error. Please try again later"),
	EXTERNALSERVICEERROR("EXT_SERV_FAIL","Failed to execute the external service");
	
	private final String errorCode;
	private final String errorMessage;

	Messages(String id, String msg) {
		this.errorCode = id;
		this.errorMessage = msg;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}
}
