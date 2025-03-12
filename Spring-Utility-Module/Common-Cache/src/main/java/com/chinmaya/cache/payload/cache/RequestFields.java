package com.chinmaya.cache.payload.cache;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class RequestFields {
	// customer details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("userId")
	private String userId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("customerId")
	private String customerId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("custName")
	private String custName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("mobileNumber")
	private String mobileNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("deviceId")
	private String deviceId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("customerType")
	private String customerType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("customerCountryCode")
	private String customerCountryCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("email")
	private String email;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("fullName")
	private String fullName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("dob")
	private String dob;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loginPassword")
	private String loginPassword;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loginPin")
	private String loginPin;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("creditCardNumber")
	private String creditCardNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("idCardNo")
	private String idCardNo;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("idCardType")
	private String idCardType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("gender")
	private String gender;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("province")
	private String province;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("district")
	private String district;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("community")
	private String community;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("village")
	private String village;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("streetNumber")
	private String streetNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("kyc")
	private String kyc;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("userTitle")
	private String userTitle;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitAccountHolderAddress")
	private String debitAccountHolderAddress;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitAccountHolderHouseNum")
	private String debitAccountHolderHouseNum;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("residentStatus")
	private String residentStatus;

	// customer account details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitAcctNo")
	private String debitAcctNo;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitAcctBrn")
	private String debitAcctBrn;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitAcctCcy")
	private String debitAcctCcy;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitAcctType")
	private String debitAcctType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitProductType")
	private String debitProductType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitAccountHolderName")
	private String debitAccountHolderName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitAccountIfsc")
	private String debitAccountIfsc;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitBankCode")
	private String debitBankCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitAccBrnId")
	private String debitAccBrnId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("debitAccBalance")
	private String debitAccBalance;

	// fund transfer details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("transactionCcy")
	private String transactionCcy;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("transactionType")
	private String transactionType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("transferType")
	private String transferType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("transactionMode")
	private String transactionMode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("transactionAmount")
	private String transactionAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("transRemarks")
	private String transRemarks;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("transactionDate")
	private String transactionDate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("equivalentAmount")
	private String equivalentAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("transactionRefNumber")
	private String transactionRefNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("cbsId")
	private String cbsId;

	// limit details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("limitGroup")
	private String limitGroup;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("dailyLmt")
	private String dailyLmt;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("txnMinLmt")
	private String txnMinLmt;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("txnMaxLmt")
	private String txnMaxLmt;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("monthlyLmt")
	private String monthlyLmt;

	// charge fee details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("chargeAmount")
	private String chargeAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("chargeCurrency")
	private String chargeCurrency;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("chargeType")
	private String chargeType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("creditChargeAmount")
	private String creditChargeAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("feeAccount")
	private String feeAccount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("authStatus")
	private String authStatus;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("chargeWaive")
	private String chargeWaive;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("fromSlab")
	private String fromSlab;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("toSlab")
	private String toSlab;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("checkerId")
	private String checkerId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("makerId")
	private String makerId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("effectiveDate")
	private String effectiveDate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("transactionMinAmount")
	private String transactionMinAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("transactionMaxAmount")
	private String transactionMaxAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productDesc")
	private String productDesc;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("versionNumber")
	private String versionNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("flatAmount")
	private String flatAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("percentage")
	private String percentage;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("slabNumber")
	private String slabNumber;

	// biller details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerCategoryId")
	private String billerCategoryId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerCategory")
	private String billerCategory;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerId")
	private String billerId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerAccountId")
	private String billerAccountId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerName")
	private String billerName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerLocationId")
	private String billerLocationId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerLocation")
	private String billerLocation;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerShortName")
	private String billerShortName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerConsumerNumber")
	private String billerConsumerNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerStatus")
	private String billerStatus;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billNumber")
	private String billNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billerAccountNumber")
	private String billerAccountNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billName")
	private String billName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billNickName")
	private String billNickName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("payeeGroup")
	private String payeeGroup;

	// beneficiary details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefName")
	private String benefName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefImage")
	private String benefImage;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("beneficiaryCustId")
	private String beneficiaryCustId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("beneficiaryDeviceId")
	private String beneficiaryDeviceId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefMobileNum")
	private String benefMobileNum;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefType")
	private String benefType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefEmail")
	private String benefEmail;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefStatus")
	private String benefStatus;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefCoolingTime")
	private Timestamp benefCoolingTime;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefShortName")
	private String benefShortName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefCountryCode")
	private String benefCountryCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefAccountHolderName")
	private String benefAccountHolderName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefAccountHolderAddress")
	private String benefAccountHolderAddress;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefAccountHolderHouseNum")
	private String benefAccountHolderHouseNum;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("beneficiaryCreditCardNumber")
	private String beneficiaryCreditCardNumber;

	// beneficiary account details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefAcctNo")
	private String benefAcctNo;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefAcctCcy")
	private String benefAcctCcy;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefAcctType")
	private String benefAcctType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefBankName")
	private String benefBankName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefIfsc")
	private String benefIfsc;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefAcctBrn")
	private String benefAcctBrn;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefAccBrnId")
	private String benefAccBrnId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefAccBalance")
	private String benefAccBalance;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefBankCode")
	private String benefBankCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefBankAddress")
	private String benefBankAddress;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("benefProductType")
	private String benefProductType;

	// session details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("sessionId")
	private String sessionId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("userName")
	private String userName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("password")
	private String password;

	// transaction history details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupClass")
	private String groupClass;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("startDate")
	private String startDate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("endDate")
	private String endDate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("txnNumber")
	private String txnNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("txnCount")
	private String txnCount;

	// Loan Details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loanAccountNumber")
	private String loanAccountNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loanAccountType")
	private String loanAccountType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loanTenure")
	private String loanTenure;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loanAmount")
	private String loanAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loanPrincipalAmount")
	private String loanPrincipalAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loanInterestAmount")
	private String loanInterestAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loanRemarks")
	private String loanRemarks;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loanDate")
	private Date loanDate;

	// Deposit Details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("depositAccNumber")
	private String depositAccNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("depositType")
	private String depositType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("depositAmount")
	private String depositAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("depositCcy")
	private String depositCcy;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("depositRemarks")
	private String depositRemarks;

	// Deposit Calculator
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("principalAmount")
	private String principalAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("nominalInterestRate")
	private String nominalInterestRate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("numberOfYears")
	private String numberOfYears;

	// SMS Details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("messageSenderName")
	private String messageSenderName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("messageReceivername")
	private String messageReceivername;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("messageText")
	private String messageText;

	// Cheque Book details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("chequeNumber")
	private String chequeNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("numOfChequeBooks")
	private String numOfChequeBooks;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("numOfChequeLeaves")
	private String numOfChequeLeaves;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("deliverTo")
	private String deliverTo;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("stopChequeReason")
	private String stopChequeReason;

	// Passbook details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("passbookNumber")
	private String passbookNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("numOfPassbooks")
	private String numOfPassbooks;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("stopPassbookReason")
	private String stopPassbookReason;

	// FAQ Details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("question")
	private String question;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("answer")
	private String answer;

	// favourite details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("favouriteName")
	private String favouriteName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("fromaccountType")
	private String fromaccountType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("channelId")
	private String channelId;

	// Raise Complaint Parameters
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("complaintCategory")
	private String complaintCategory;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("complaintCategoryId")
	private String complaintCategoryId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("complaintDesc")
	private String complaintDesc;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("complaintReason")
	private String complaintReason;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("complaintDoc")
	private String complaintDoc;

	// otp parameters
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("authenticationReferenceCode")
	private String authenticationReferenceCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("otp")
	private String otp;

	// Schedule Transfer Parameters
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("scheduleId")
	private String scheduleId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("txnScheduleFromDate")
	private String txnScheduleFromDate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("txnScheduleToDate")
	private String txnScheduleToDate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("scheduleTxnType")
	private String scheduleTxnType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("noOfInstallments")
	private String noOfInstallments;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("scheduleFrequency")
	private String scheduleFrequency;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("txnScheduleDay")
	private String txnScheduleDay;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("txnScheduleMonth")
	private String txnScheduleMonth;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("scheduleTransferRemarks")
	private String scheduleTransferRemarks;

	// EMI Calculator parameters
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loanTenureInMonth")
	private String loanTenureInMonth;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("rateOfInterest")
	private String rateOfInterest;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("loanTenureInYears")
	private String loanTenureInYears;

	// Product Lead Parameters
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productBranchId")
	private String productBranchId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productCategoryId")
	private String productCategoryId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productChannelId")
	private String productChannelId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productCustomerId")
	private String productCustomerId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productEmailId")
	private String productEmailId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("contactNumber")
	private String contactNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productCityId")
	private String productCityId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productStateId")
	private String productStateId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productFirstName")
	private String productFirstName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productLastName")
	private String productLastName;

	// Locator parameters
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("longitude")
	private String longitude;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("lattitude")
	private String lattitude;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("city")
	private String city;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("state")
	private String state;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("branch")
	private String branch;

	// apply now details
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("depositTenureInMonths")
	private int depositTenureInMonths;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("depositInterestRate")
	private float depositInterestRate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("depositInterestPayout")
	private String depositInterestPayout;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("nomineeDetails")
	private String nomineeDetails;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("maturityAmount")
	private BigDecimal maturityAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("maturityDate")
	private Date maturityDate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("depositDate")
	private Date depositDate;

	// budget parameters
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("budgetId")
	private String budgetId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("budgetDesc")
	private String budgetDesc;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("budgetPeriod")
	private String budgetPeriod;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("budgetCategory")
	private String budgetCategory;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("budgetAmount")
	private String budgetAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("thresholdAmount")
	private String thresholdAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("budgetStart")
	private String budgetStart;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("budgetStatus")
	private String budgetStatus;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("durationtype")
	private String durationtype;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("quarter")
	private String quarter;

	// Goal Parameters
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("goalTxnId")
	private String goalTxnId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("goalImgId")
	private String goalImgId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("goalName")
	private String goalName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("goalDesc")
	private String goalDesc;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("targetAmount")
	private String targetAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("fundingAccount")
	private String fundingAccount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("allocatePercentage")
	private String allocatePercentage;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("goalStatus")
	private String goalStatus;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("goalAccNumber")
	private String goalAccNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("initialDepositAmt")
	private String initialDepositAmt;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("siRequired")
	private String siRequired;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("autoRedemption")
	private String autoRedemption;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("redemptAccountNum")
	private String redemptAccountNum;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("accNumberType")
	private String accNumberType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("accNumberDesc")
	private String accNumberDesc;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("currentAmount")
	private String currentAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("amountAsOf")
	private String amountAsOf;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("siSorceAccNumber")
	private String siSorceAccNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("siStatus")
	private String siStatus;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("siStartDate")
	private String siStartDate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("siFrequency")
	private String siFrequency;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("siAmount")
	private String siAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("goalAccountFlag")
	private String goalAccountFlag;

	// miscellaneous api parameters
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("channel")
	private String channel;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("apiDesc")
	private String apiDesc;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("id")
	private String id;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("base64String")
	private String base64String;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("fileType")
	private String fileType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("catalogCode")
	private String catalogCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("primaryAccountFlag")
	private String primaryAccountFlag;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupNumber")
	private String groupNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("stage")
	private String stage;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("handle")
	private String handle;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("language")
	private String language;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("signature")
	private String signature;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("timeStamp")
	private String timeStamp;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("brandId")
	private String brandId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("action")
	private String action;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("notification")
	private String notification;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("accessType")
	private String accessType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("code")
	private String code;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("errorCode")
	private String errorCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("errorMessage")
	private String errorMessage;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("networkType")
	private String networkType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("nomineeId")
	private String nomineeId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("relationship")
	private String relationship;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("guardianAddress")
	private String guardianAddress;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("guardianName")
	private String guardianName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("pinCode")
	private String pinCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("sameAddress")
	private String sameAddress;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("nomineeName")
	private String nomineeName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("frequency")
	private String frequency;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("cardType")
	private String cardType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("cardGrade")
	private String cardGrade;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("cardNumber")
	private String cardNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("cardName")
	private String cardName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("withdrawalLimit")
	private String withdrawalLimit;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("onlineTxnLimit")
	private String onlineTxnLimit;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("intTxnLimit")
	private String intTxnLimit;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("date")
	private String date;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("widget")
	private String widget;
	
	public RequestFields() {
		super();
	}

	public String getKyc() {
		return kyc;
	}

	public void setKyc(String kyc) {
		this.kyc = kyc;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getCbsId() {
		return cbsId;
	}

	public void setCbsId(String cbsId) {
		this.cbsId = cbsId;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getPrimaryAccountFlag() {
		return primaryAccountFlag;
	}

	public void setPrimaryAccountFlag(String primaryAccountFlag) {
		this.primaryAccountFlag = primaryAccountFlag;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getDebitAccBrnId() {
		return debitAccBrnId;
	}

	public void setDebitAccBrnId(String debitAccBrnId) {
		this.debitAccBrnId = debitAccBrnId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDebitAcctNo() {
		return debitAcctNo;
	}

	public void setDebitAcctNo(String debitAcctNo) {
		this.debitAcctNo = debitAcctNo;
	}

	public String getDebitAcctBrn() {
		return debitAcctBrn;
	}

	public void setDebitAcctBrn(String debitAcctBrn) {
		this.debitAcctBrn = debitAcctBrn;
	}

	public String getDebitAcctCcy() {
		return debitAcctCcy;
	}

	public void setDebitAcctCcy(String debitAcctCcy) {
		this.debitAcctCcy = debitAcctCcy;
	}

	public String getDebitAcctType() {
		return debitAcctType;
	}

	public void setDebitAcctType(String debitAcctType) {
		this.debitAcctType = debitAcctType;
	}

	public String getDebitProductType() {
		return debitProductType;
	}

	public void setDebitProductType(String debitProductType) {
		this.debitProductType = debitProductType;
	}

	public String getTransactionCcy() {
		return transactionCcy;
	}

	public void setTransactionCcy(String transactionCcy) {
		this.transactionCcy = transactionCcy;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransRemarks() {
		return transRemarks;
	}

	public void setTransRemarks(String transRemarks) {
		this.transRemarks = transRemarks;
	}

	public String getBenefAcctNo() {
		return benefAcctNo;
	}

	public void setBenefAcctNo(String benefAcctNo) {
		this.benefAcctNo = benefAcctNo;
	}

	public String getBenefName() {
		return benefName;
	}

	public void setBenefName(String benefName) {
		this.benefName = benefName;
	}

	public String getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(String chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public String getChargeCurrency() {
		return chargeCurrency;
	}

	public void setChargeCurrency(String chargeCurrency) {
		this.chargeCurrency = chargeCurrency;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getBillerName() {
		return billerName;
	}

	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}

	public String getBillerId() {
		return billerId;
	}

	public void setBillerId(String billerId) {
		this.billerId = billerId;
	}

	public String getBenefAcctType() {
		return benefAcctType;
	}

	public void setBenefAcctType(String benefAcctType) {
		this.benefAcctType = benefAcctType;
	}

	public String getBenefBankName() {
		return benefBankName;
	}

	public void setBenefBankName(String benefBankName) {
		this.benefBankName = benefBankName;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDebitAccountHolderName() {
		return debitAccountHolderName;
	}

	public void setDebitAccountHolderName(String debitAccountHolderName) {
		this.debitAccountHolderName = debitAccountHolderName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEquivalentAmount() {
		return equivalentAmount;
	}

	public void setEquivalentAmount(String equivalentAmount) {
		this.equivalentAmount = equivalentAmount;
	}

	public String getCreditChargeAmount() {
		return creditChargeAmount;
	}

	public void setCreditChargeAmount(String creditChargeAmount) {
		this.creditChargeAmount = creditChargeAmount;
	}

	public String getFeeAccount() {
		return feeAccount;
	}

	public void setFeeAccount(String feeAccount) {
		this.feeAccount = feeAccount;
	}

	public String getTransactionRefNumber() {
		return transactionRefNumber;
	}

	public void setTransactionRefNumber(String transactionRefNumber) {
		this.transactionRefNumber = transactionRefNumber;
	}

	public String getBeneficiaryCustId() {
		return beneficiaryCustId;
	}

	public void setBeneficiaryCustId(String beneficiaryCustId) {
		this.beneficiaryCustId = beneficiaryCustId;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getBeneficiaryCreditCardNumber() {
		return beneficiaryCreditCardNumber;
	}

	public void setBeneficiaryCreditCardNumber(String beneficiaryCreditCardNumber) {
		this.beneficiaryCreditCardNumber = beneficiaryCreditCardNumber;
	}

	public String getDebitBankCode() {
		return debitBankCode;
	}

	public void setDebitBankCode(String debitBankCode) {
		this.debitBankCode = debitBankCode;
	}

	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public String getLoanAccountType() {
		return loanAccountType;
	}

	public void setLoanAccountType(String loanAccountType) {
		this.loanAccountType = loanAccountType;
	}

	public String getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(String loanTenure) {
		this.loanTenure = loanTenure;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanPrincipalAmount() {
		return loanPrincipalAmount;
	}

	public void setLoanPrincipalAmount(String loanPrincipalAmount) {
		this.loanPrincipalAmount = loanPrincipalAmount;
	}

	public String getLoanInterestAmount() {
		return loanInterestAmount;
	}

	public void setLoanInterestAmount(String loanInterestAmount) {
		this.loanInterestAmount = loanInterestAmount;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getLoginPin() {
		return loginPin;
	}

	public void setLoginPin(String loginPin) {
		this.loginPin = loginPin;
	}

	public String getApiDesc() {
		return apiDesc;
	}

	public void setApiDesc(String apiDesc) {
		this.apiDesc = apiDesc;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBase64String() {
		return base64String;
	}

	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getCatalogCode() {
		return catalogCode;
	}

	public void setCatalogCode(String catalogCode) {
		this.catalogCode = catalogCode;
	}

	public String getUserTitle() {
		return userTitle;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	public String getDebitAccountHolderAddress() {
		return debitAccountHolderAddress;
	}

	public void setDebitAccountHolderAddress(String debitAccountHolderAddress) {
		this.debitAccountHolderAddress = debitAccountHolderAddress;
	}

	public String getDebitAccountHolderHouseNum() {
		return debitAccountHolderHouseNum;
	}

	public void setDebitAccountHolderHouseNum(String debitAccountHolderHouseNum) {
		this.debitAccountHolderHouseNum = debitAccountHolderHouseNum;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getBenefMobileNum() {
		return benefMobileNum;
	}

	public void setBenefMobileNum(String benefMobileNum) {
		this.benefMobileNum = benefMobileNum;
	}

	public String getBenefType() {
		return benefType;
	}

	public void setBenefType(String benefType) {
		this.benefType = benefType;
	}

	public String getBenefIfsc() {
		return benefIfsc;
	}

	public void setBenefIfsc(String benefIfsc) {
		this.benefIfsc = benefIfsc;
	}

	public String getBenefEmail() {
		return benefEmail;
	}

	public void setBenefEmail(String benefEmail) {
		this.benefEmail = benefEmail;
	}

	public String getBenefBankAddress() {
		return benefBankAddress;
	}

	public void setBenefBankAddress(String benefBankAddress) {
		this.benefBankAddress = benefBankAddress;
	}

	public Timestamp getBenefCoolingTime() {
		return benefCoolingTime;
	}

	public void setBenefCoolingTime(Timestamp benefCoolingTime) {
		this.benefCoolingTime = benefCoolingTime;
	}

	public String getBillerConsumerNumber() {
		return billerConsumerNumber;
	}

	public void setBillerConsumerNumber(String billerConsumerNumber) {
		this.billerConsumerNumber = billerConsumerNumber;
	}

	public String getBillerCategoryId() {
		return billerCategoryId;
	}

	public void setBillerCategoryId(String billerCategoryId) {
		this.billerCategoryId = billerCategoryId;
	}

	public String getBillerCategory() {
		return billerCategory;
	}

	public void setBillerCategory(String billerCategory) {
		this.billerCategory = billerCategory;
	}

	public String getBillerLocationId() {
		return billerLocationId;
	}

	public void setBillerLocationId(String billerLocationId) {
		this.billerLocationId = billerLocationId;
	}

	public String getBillerLocation() {
		return billerLocation;
	}

	public void setBillerLocation(String billerLocation) {
		this.billerLocation = billerLocation;
	}

	public String getBenefImage() {
		return benefImage;
	}

	public void setBenefImage(String benefImage) {
		this.benefImage = benefImage;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getBillerShortName() {
		return billerShortName;
	}

	public void setBillerShortName(String billerShortName) {
		this.billerShortName = billerShortName;
	}

	public String getBenefStatus() {
		return benefStatus;
	}

	public void setBenefStatus(String benefStatus) {
		this.benefStatus = benefStatus;
	}

	public String getBenefShortName() {
		return benefShortName;
	}

	public void setBenefShortName(String benefShortName) {
		this.benefShortName = benefShortName;
	}

	public String getLimitGroup() {
		return limitGroup;
	}

	public void setLimitGroup(String limitGroup) {
		this.limitGroup = limitGroup;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerCountryCode() {
		return customerCountryCode;
	}

	public void setCustomerCountryCode(String customerCountryCode) {
		this.customerCountryCode = customerCountryCode;
	}

	public String getBenefCountryCode() {
		return benefCountryCode;
	}

	public void setBenefCountryCode(String benefCountryCode) {
		this.benefCountryCode = benefCountryCode;
	}

	public String getDebitAccountIfsc() {
		return debitAccountIfsc;
	}

	public void setDebitAccountIfsc(String debitAccountIfsc) {
		this.debitAccountIfsc = debitAccountIfsc;
	}

	public String getBeneficiaryDeviceId() {
		return beneficiaryDeviceId;
	}

	public void setBeneficiaryDeviceId(String beneficiaryDeviceId) {
		this.beneficiaryDeviceId = beneficiaryDeviceId;
	}

	public String getBenefAccountHolderName() {
		return benefAccountHolderName;
	}

	public void setBenefAccountHolderName(String benefAccountHolderName) {
		this.benefAccountHolderName = benefAccountHolderName;
	}

	public String getBenefAccountHolderAddress() {
		return benefAccountHolderAddress;
	}

	public void setBenefAccountHolderAddress(String benefAccountHolderAddress) {
		this.benefAccountHolderAddress = benefAccountHolderAddress;
	}

	public String getBenefAccountHolderHouseNum() {
		return benefAccountHolderHouseNum;
	}

	public void setBenefAccountHolderHouseNum(String benefAccountHolderHouseNum) {
		this.benefAccountHolderHouseNum = benefAccountHolderHouseNum;
	}

	public String getBenefAcctCcy() {
		return benefAcctCcy;
	}

	public void setBenefAcctCcy(String benefAcctCcy) {
		this.benefAcctCcy = benefAcctCcy;
	}

	public String getBenefAcctBrn() {
		return benefAcctBrn;
	}

	public void setBenefAcctBrn(String benefAcctBrn) {
		this.benefAcctBrn = benefAcctBrn;
	}

	public String getBenefAccBrnId() {
		return benefAccBrnId;
	}

	public void setBenefAccBrnId(String benefAccBrnId) {
		this.benefAccBrnId = benefAccBrnId;
	}

	public String getBenefBankCode() {
		return benefBankCode;
	}

	public void setBenefBankCode(String benefBankCode) {
		this.benefBankCode = benefBankCode;
	}

	public String getBenefProductType() {
		return benefProductType;
	}

	public void setBenefProductType(String benefProductType) {
		this.benefProductType = benefProductType;
	}

	public String getDepositAccNumber() {
		return depositAccNumber;
	}

	public void setDepositAccNumber(String depositAccNumber) {
		this.depositAccNumber = depositAccNumber;
	}

	public String getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getDepositCcy() {
		return depositCcy;
	}

	public void setDepositCcy(String depositCcy) {
		this.depositCcy = depositCcy;
	}

	public String getDepositRemarks() {
		return depositRemarks;
	}

	public void setDepositRemarks(String depositRemarks) {
		this.depositRemarks = depositRemarks;
	}

	public String getMessageSenderName() {
		return messageSenderName;
	}

	public void setMessageSenderName(String messageSenderName) {
		this.messageSenderName = messageSenderName;
	}

	public String getMessageReceivername() {
		return messageReceivername;
	}

	public void setMessageReceivername(String messageReceivername) {
		this.messageReceivername = messageReceivername;
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getNumOfChequeBooks() {
		return numOfChequeBooks;
	}

	public void setNumOfChequeBooks(String numOfChequeBooks) {
		this.numOfChequeBooks = numOfChequeBooks;
	}

	public String getNumOfChequeLeaves() {
		return numOfChequeLeaves;
	}

	public void setNumOfChequeLeaves(String numOfChequeLeaves) {
		this.numOfChequeLeaves = numOfChequeLeaves;
	}

	public String getStopChequeReason() {
		return stopChequeReason;
	}

	public void setStopChequeReason(String stopChequeReason) {
		this.stopChequeReason = stopChequeReason;
	}

	public String getPassbookNumber() {
		return passbookNumber;
	}

	public void setPassbookNumber(String passbookNumber) {
		this.passbookNumber = passbookNumber;
	}

	public String getNumOfPassbooks() {
		return numOfPassbooks;
	}

	public void setNumOfPassbooks(String numOfPassbooks) {
		this.numOfPassbooks = numOfPassbooks;
	}

	public String getStopPassbookReason() {
		return stopPassbookReason;
	}

	public void setStopPassbookReason(String stopPassbookReason) {
		this.stopPassbookReason = stopPassbookReason;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getResidentStatus() {
		return residentStatus;
	}

	public void setResidentStatus(String residentStatus) {
		this.residentStatus = residentStatus;
	}

	public String getGroupClass() {
		return groupClass;
	}

	public void setGroupClass(String groupClass) {
		this.groupClass = groupClass;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTxnNumber() {
		return txnNumber;
	}

	public void setTxnNumber(String txnNumber) {
		this.txnNumber = txnNumber;
	}

	public String getTxnCount() {
		return txnCount;
	}

	public void setTxnCount(String txnCount) {
		this.txnCount = txnCount;
	}

	public String getFavouriteName() {
		return favouriteName;
	}

	public void setFavouriteName(String favouriteName) {
		this.favouriteName = favouriteName;
	}

	public String getFromaccountType() {
		return fromaccountType;
	}

	public void setFromaccountType(String fromaccountType) {
		this.fromaccountType = fromaccountType;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getComplaintCategory() {
		return complaintCategory;
	}

	public void setComplaintCategory(String complaintCategory) {
		this.complaintCategory = complaintCategory;
	}

	public String getComplaintCategoryId() {
		return complaintCategoryId;
	}

	public void setComplaintCategoryId(String complaintCategoryId) {
		this.complaintCategoryId = complaintCategoryId;
	}

	public String getComplaintDesc() {
		return complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}

	public String getComplaintReason() {
		return complaintReason;
	}

	public void setComplaintReason(String complaintReason) {
		this.complaintReason = complaintReason;
	}

	public String getComplaintDoc() {
		return complaintDoc;
	}

	public void setComplaintDoc(String complaintDoc) {
		this.complaintDoc = complaintDoc;
	}

	public String getAuthenticationReferenceCode() {
		return authenticationReferenceCode;
	}

	public void setAuthenticationReferenceCode(String authenticationReferenceCode) {
		this.authenticationReferenceCode = authenticationReferenceCode;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getTxnScheduleFromDate() {
		return txnScheduleFromDate;
	}

	public void setTxnScheduleFromDate(String txnScheduleFromDate) {
		this.txnScheduleFromDate = txnScheduleFromDate;
	}

	public String getScheduleTxnType() {
		return scheduleTxnType;
	}

	public void setScheduleTxnType(String scheduleTxnType) {
		this.scheduleTxnType = scheduleTxnType;
	}

	public String getNoOfInstallments() {
		return noOfInstallments;
	}

	public void setNoOfInstallments(String noOfInstallments) {
		this.noOfInstallments = noOfInstallments;
	}

	public String getScheduleFrequency() {
		return scheduleFrequency;
	}

	public void setScheduleFrequency(String scheduleFrequency) {
		this.scheduleFrequency = scheduleFrequency;
	}

	public String getScheduleTransferRemarks() {
		return scheduleTransferRemarks;
	}

	public void setScheduleTransferRemarks(String scheduleTransferRemarks) {
		this.scheduleTransferRemarks = scheduleTransferRemarks;
	}

	public String getLoanTenureInMonth() {
		return loanTenureInMonth;
	}

	public void setLoanTenureInMonth(String loanTenureInMonth) {
		this.loanTenureInMonth = loanTenureInMonth;
	}

	public String getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getLoanTenureInYears() {
		return loanTenureInYears;
	}

	public void setLoanTenureInYears(String loanTenureInYears) {
		this.loanTenureInYears = loanTenureInYears;
	}

	public String getProductBranchId() {
		return productBranchId;
	}

	public void setProductBranchId(String productBranchId) {
		this.productBranchId = productBranchId;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductChannelId() {
		return productChannelId;
	}

	public void setProductChannelId(String productChannelId) {
		this.productChannelId = productChannelId;
	}

	public String getProductCustomerId() {
		return productCustomerId;
	}

	public void setProductCustomerId(String productCustomerId) {
		this.productCustomerId = productCustomerId;
	}

	public String getProductEmailId() {
		return productEmailId;
	}

	public void setProductEmailId(String productEmailId) {
		this.productEmailId = productEmailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getProductCityId() {
		return productCityId;
	}

	public void setProductCityId(String productCityId) {
		this.productCityId = productCityId;
	}

	public String getProductStateId() {
		return productStateId;
	}

	public void setProductStateId(String productStateId) {
		this.productStateId = productStateId;
	}

	public String getProductFirstName() {
		return productFirstName;
	}

	public void setProductFirstName(String productFirstName) {
		this.productFirstName = productFirstName;
	}

	public String getProductLastName() {
		return productLastName;
	}

	public void setProductLastName(String productLastName) {
		this.productLastName = productLastName;
	}

	public String getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(String principalAmount) {
		this.principalAmount = principalAmount;
	}

	public String getNominalInterestRate() {
		return nominalInterestRate;
	}

	public void setNominalInterestRate(String nominalInterestRate) {
		this.nominalInterestRate = nominalInterestRate;
	}

	public String getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(String numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDebitAccBalance() {
		return debitAccBalance;
	}

	public void setDebitAccBalance(String debitAccBalance) {
		this.debitAccBalance = debitAccBalance;
	}

	public String getBenefAccBalance() {
		return benefAccBalance;
	}

	public void setBenefAccBalance(String benefAccBalance) {
		this.benefAccBalance = benefAccBalance;
	}

	public String getLoanRemarks() {
		return loanRemarks;
	}

	public void setLoanRemarks(String loanRemarks) {
		this.loanRemarks = loanRemarks;
	}

	public int getDepositTenureInMonths() {
		return depositTenureInMonths;
	}

	public void setDepositTenureInMonths(int depositTenureInMonths) {
		this.depositTenureInMonths = depositTenureInMonths;
	}

	public float getDepositInterestRate() {
		return depositInterestRate;
	}

	public void setDepositInterestRate(float depositInterestRate) {
		this.depositInterestRate = depositInterestRate;
	}

	public String getDepositInterestPayout() {
		return depositInterestPayout;
	}

	public void setDepositInterestPayout(String depositInterestPayout) {
		this.depositInterestPayout = depositInterestPayout;
	}

	public String getNomineeDetails() {
		return nomineeDetails;
	}

	public void setNomineeDetails(String nomineeDetails) {
		this.nomineeDetails = nomineeDetails;
	}

	public BigDecimal getMaturityAmount() {
		return maturityAmount;
	}

	public void setMaturityAmount(BigDecimal maturityAmount) {
		this.maturityAmount = maturityAmount;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getDeliverTo() {
		return deliverTo;
	}

	public void setDeliverTo(String deliverTo) {
		this.deliverTo = deliverTo;
	}

	public String getTxnScheduleToDate() {
		return txnScheduleToDate;
	}

	public void setTxnScheduleToDate(String txnScheduleToDate) {
		this.txnScheduleToDate = txnScheduleToDate;
	}

	public String getTxnScheduleDay() {
		return txnScheduleDay;
	}

	public void setTxnScheduleDay(String txnScheduleDay) {
		this.txnScheduleDay = txnScheduleDay;
	}

	public String getTxnScheduleMonth() {
		return txnScheduleMonth;
	}

	public void setTxnScheduleMonth(String txnScheduleMonth) {
		this.txnScheduleMonth = txnScheduleMonth;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDailyLmt() {
		return dailyLmt;
	}

	public void setDailyLmt(String dailyLmt) {
		this.dailyLmt = dailyLmt;
	}

	public String getTxnMinLmt() {
		return txnMinLmt;
	}

	public void setTxnMinLmt(String txnMinLmt) {
		this.txnMinLmt = txnMinLmt;
	}

	public String getTxnMaxLmt() {
		return txnMaxLmt;
	}

	public void setTxnMaxLmt(String txnMaxLmt) {
		this.txnMaxLmt = txnMaxLmt;
	}

	public String getMonthlyLmt() {
		return monthlyLmt;
	}

	public void setMonthlyLmt(String monthlyLmt) {
		this.monthlyLmt = monthlyLmt;
	}

	public String getBillerStatus() {
		return billerStatus;
	}

	public void setBillerStatus(String billerStatus) {
		this.billerStatus = billerStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public String getBillNickName() {
		return billNickName;
	}

	public void setBillNickName(String billNickName) {
		this.billNickName = billNickName;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getPayeeGroup() {
		return payeeGroup;
	}

	public void setPayeeGroup(String payeeGroup) {
		this.payeeGroup = payeeGroup;
	}

	public String getBillerAccountNumber() {
		return billerAccountNumber;
	}

	public void setBillerAccountNumber(String billerAccountNumber) {
		this.billerAccountNumber = billerAccountNumber;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getChargeWaive() {
		return chargeWaive;
	}

	public void setChargeWaive(String chargeWaive) {
		this.chargeWaive = chargeWaive;
	}

	public String getCheckerId() {
		return checkerId;
	}

	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}

	public String getMakerId() {
		return makerId;
	}

	public void setMakerId(String makerId) {
		this.makerId = makerId;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getTransactionMinAmount() {
		return transactionMinAmount;
	}

	public void setTransactionMinAmount(String transactionMinAmount) {
		this.transactionMinAmount = transactionMinAmount;
	}

	public String getTransactionMaxAmount() {
		return transactionMaxAmount;
	}

	public void setTransactionMaxAmount(String transactionMaxAmount) {
		this.transactionMaxAmount = transactionMaxAmount;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getFromSlab() {
		return fromSlab;
	}

	public void setFromSlab(String fromSlab) {
		this.fromSlab = fromSlab;
	}

	public String getToSlab() {
		return toSlab;
	}

	public void setToSlab(String toSlab) {
		this.toSlab = toSlab;
	}

	public String getFlatAmount() {
		return flatAmount;
	}

	public void setFlatAmount(String flatAmount) {
		this.flatAmount = flatAmount;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getSlabNumber() {
		return slabNumber;
	}

	public void setSlabNumber(String slabNumber) {
		this.slabNumber = slabNumber;
	}

	public String getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}

	public String getBudgetDesc() {
		return budgetDesc;
	}

	public void setBudgetDesc(String budgetDesc) {
		this.budgetDesc = budgetDesc;
	}

	public String getBudgetPeriod() {
		return budgetPeriod;
	}

	public void setBudgetPeriod(String budgetPeriod) {
		this.budgetPeriod = budgetPeriod;
	}

	public String getBudgetCategory() {
		return budgetCategory;
	}

	public void setBudgetCategory(String budgetCategory) {
		this.budgetCategory = budgetCategory;
	}

	public String getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(String budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public String getThresholdAmount() {
		return thresholdAmount;
	}

	public void setThresholdAmount(String thresholdAmount) {
		this.thresholdAmount = thresholdAmount;
	}

	public String getBudgetStart() {
		return budgetStart;
	}

	public void setBudgetStart(String budgetStart) {
		this.budgetStart = budgetStart;
	}

	public String getBudgetStatus() {
		return budgetStatus;
	}

	public void setBudgetStatus(String budgetStatus) {
		this.budgetStatus = budgetStatus;
	}

	public String getDurationtype() {
		return durationtype;
	}

	public void setDurationtype(String durationtype) {
		this.durationtype = durationtype;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getGoalTxnId() {
		return goalTxnId;
	}

	public void setGoalTxnId(String goalTxnId) {
		this.goalTxnId = goalTxnId;
	}

	public String getGoalImgId() {
		return goalImgId;
	}

	public void setGoalImgId(String goalImgId) {
		this.goalImgId = goalImgId;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	public String getGoalDesc() {
		return goalDesc;
	}

	public void setGoalDesc(String goalDesc) {
		this.goalDesc = goalDesc;
	}

	public String getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(String targetAmount) {
		this.targetAmount = targetAmount;
	}

	public String getFundingAccount() {
		return fundingAccount;
	}

	public void setFundingAccount(String fundingAccount) {
		this.fundingAccount = fundingAccount;
	}

	public String getAllocatePercentage() {
		return allocatePercentage;
	}

	public void setAllocatePercentage(String allocatePercentage) {
		this.allocatePercentage = allocatePercentage;
	}

	public String getGoalStatus() {
		return goalStatus;
	}

	public void setGoalStatus(String goalStatus) {
		this.goalStatus = goalStatus;
	}

	public String getGoalAccNumber() {
		return goalAccNumber;
	}

	public void setGoalAccNumber(String goalAccNumber) {
		this.goalAccNumber = goalAccNumber;
	}

	public String getInitialDepositAmt() {
		return initialDepositAmt;
	}

	public void setInitialDepositAmt(String initialDepositAmt) {
		this.initialDepositAmt = initialDepositAmt;
	}

	public String getSiRequired() {
		return siRequired;
	}

	public void setSiRequired(String siRequired) {
		this.siRequired = siRequired;
	}

	public String getAutoRedemption() {
		return autoRedemption;
	}

	public void setAutoRedemption(String autoRedemption) {
		this.autoRedemption = autoRedemption;
	}

	public String getRedemptAccountNum() {
		return redemptAccountNum;
	}

	public void setRedemptAccountNum(String redemptAccountNum) {
		this.redemptAccountNum = redemptAccountNum;
	}

	public String getAccNumberType() {
		return accNumberType;
	}

	public void setAccNumberType(String accNumberType) {
		this.accNumberType = accNumberType;
	}

	public String getAccNumberDesc() {
		return accNumberDesc;
	}

	public void setAccNumberDesc(String accNumberDesc) {
		this.accNumberDesc = accNumberDesc;
	}

	public String getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(String currentAmount) {
		this.currentAmount = currentAmount;
	}

	public String getAmountAsOf() {
		return amountAsOf;
	}

	public void setAmountAsOf(String amountAsOf) {
		this.amountAsOf = amountAsOf;
	}

	public String getSiSorceAccNumber() {
		return siSorceAccNumber;
	}

	public void setSiSorceAccNumber(String siSorceAccNumber) {
		this.siSorceAccNumber = siSorceAccNumber;
	}

	public String getSiStatus() {
		return siStatus;
	}

	public void setSiStatus(String siStatus) {
		this.siStatus = siStatus;
	}

	public String getSiStartDate() {
		return siStartDate;
	}

	public void setSiStartDate(String siStartDate) {
		this.siStartDate = siStartDate;
	}

	public String getSiFrequency() {
		return siFrequency;
	}

	public void setSiFrequency(String siFrequency) {
		this.siFrequency = siFrequency;
	}

	public String getSiAmount() {
		return siAmount;
	}

	public void setSiAmount(String siAmount) {
		this.siAmount = siAmount;
	}

	public String getGoalAccountFlag() {
		return goalAccountFlag;
	}

	public void setGoalAccountFlag(String goalAccountFlag) {
		this.goalAccountFlag = goalAccountFlag;
	}

	public String getBillerAccountId() {
		return billerAccountId;
	}

	public void setBillerAccountId(String billerAccountId) {
		this.billerAccountId = billerAccountId;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getNomineeId() {
		return nomineeId;
	}

	public void setNomineeId(String nomineeId) {
		this.nomineeId = nomineeId;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getGuardianAddress() {
		return guardianAddress;
	}

	public void setGuardianAddress(String guardianAddress) {
		this.guardianAddress = guardianAddress;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getSameAddress() {
		return sameAddress;
	}

	public void setSameAddress(String sameAddress) {
		this.sameAddress = sameAddress;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardGrade() {
		return cardGrade;
	}

	public void setCardGrade(String cardGrade) {
		this.cardGrade = cardGrade;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	public String getWithdrawalLimit() {
		return withdrawalLimit;
	}

	public void setWithdrawalLimit(String withdrawalLimit) {
		this.withdrawalLimit = withdrawalLimit;
	}

	public String getOnlineTxnLimit() {
		return onlineTxnLimit;
	}

	public void setOnlineTxnLimit(String onlineTxnLimit) {
		this.onlineTxnLimit = onlineTxnLimit;
	}

	public String getIntTxnLimit() {
		return intTxnLimit;
	}

	public void setIntTxnLimit(String intTxnLimit) {
		this.intTxnLimit = intTxnLimit;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWidget() {
		return widget;
	}

	public void setWidget(String widget) {
		this.widget = widget;
	}

	@Override
	public String toString() {
		return "RequestFields [userId=" + userId + ", customerId=" + customerId + ", custName=" + custName
				+ ", mobileNumber=" + mobileNumber + ", deviceId=" + deviceId + ", customerType=" + customerType
				+ ", customerCountryCode=" + customerCountryCode + ", email=" + email + ", fullName=" + fullName
				+ ", dob=" + dob + ", loginPassword=" + loginPassword + ", loginPin=" + loginPin + ", creditCardNumber="
				+ creditCardNumber + ", idCardNo=" + idCardNo + ", idCardType=" + idCardType + ", gender=" + gender
				+ ", province=" + province + ", district=" + district + ", community=" + community + ", village="
				+ village + ", streetNumber=" + streetNumber + ", kyc=" + kyc + ", userTitle=" + userTitle
				+ ", debitAccountHolderAddress=" + debitAccountHolderAddress + ", debitAccountHolderHouseNum="
				+ debitAccountHolderHouseNum + ", residentStatus=" + residentStatus + ", debitAcctNo=" + debitAcctNo
				+ ", debitAcctBrn=" + debitAcctBrn + ", debitAcctCcy=" + debitAcctCcy + ", debitAcctType="
				+ debitAcctType + ", debitProductType=" + debitProductType + ", debitAccountHolderName="
				+ debitAccountHolderName + ", debitAccountIfsc=" + debitAccountIfsc + ", debitBankCode=" + debitBankCode
				+ ", debitAccBrnId=" + debitAccBrnId + ", debitAccBalance=" + debitAccBalance + ", transactionCcy="
				+ transactionCcy + ", transactionType=" + transactionType + ", transferType=" + transferType
				+ ", transactionMode=" + transactionMode + ", transactionAmount=" + transactionAmount
				+ ", transRemarks=" + transRemarks + ", transactionDate=" + transactionDate + ", equivalentAmount="
				+ equivalentAmount + ", transactionRefNumber=" + transactionRefNumber + ", cbsId=" + cbsId
				+ ", limitGroup=" + limitGroup + ", dailyLmt=" + dailyLmt + ", txnMinLmt=" + txnMinLmt + ", txnMaxLmt="
				+ txnMaxLmt + ", monthlyLmt=" + monthlyLmt + ", chargeAmount=" + chargeAmount + ", chargeCurrency="
				+ chargeCurrency + ", chargeType=" + chargeType + ", creditChargeAmount=" + creditChargeAmount
				+ ", feeAccount=" + feeAccount + ", authStatus=" + authStatus + ", chargeWaive=" + chargeWaive
				+ ", fromSlab=" + fromSlab + ", toSlab=" + toSlab + ", checkerId=" + checkerId + ", makerId=" + makerId
				+ ", effectiveDate=" + effectiveDate + ", transactionMinAmount=" + transactionMinAmount
				+ ", transactionMaxAmount=" + transactionMaxAmount + ", productDesc=" + productDesc + ", versionNumber="
				+ versionNumber + ", flatAmount=" + flatAmount + ", percentage=" + percentage + ", slabNumber="
				+ slabNumber + ", billerCategoryId=" + billerCategoryId + ", billerCategory=" + billerCategory
				+ ", billerId=" + billerId + ", billerAccountId=" + billerAccountId + ", billerName=" + billerName
				+ ", billerLocationId=" + billerLocationId + ", billerLocation=" + billerLocation + ", billerShortName="
				+ billerShortName + ", billerConsumerNumber=" + billerConsumerNumber + ", billerStatus=" + billerStatus
				+ ", billNumber=" + billNumber + ", billerAccountNumber=" + billerAccountNumber + ", billName="
				+ billName + ", billNickName=" + billNickName + ", payeeGroup=" + payeeGroup + ", benefName="
				+ benefName + ", benefImage=" + benefImage + ", beneficiaryCustId=" + beneficiaryCustId
				+ ", beneficiaryDeviceId=" + beneficiaryDeviceId + ", benefMobileNum=" + benefMobileNum + ", benefType="
				+ benefType + ", benefEmail=" + benefEmail + ", benefStatus=" + benefStatus + ", benefCoolingTime="
				+ benefCoolingTime + ", benefShortName=" + benefShortName + ", benefCountryCode=" + benefCountryCode
				+ ", benefAccountHolderName=" + benefAccountHolderName + ", benefAccountHolderAddress="
				+ benefAccountHolderAddress + ", benefAccountHolderHouseNum=" + benefAccountHolderHouseNum
				+ ", beneficiaryCreditCardNumber=" + beneficiaryCreditCardNumber + ", benefAcctNo=" + benefAcctNo
				+ ", benefAcctCcy=" + benefAcctCcy + ", benefAcctType=" + benefAcctType + ", benefBankName="
				+ benefBankName + ", benefIfsc=" + benefIfsc + ", benefAcctBrn=" + benefAcctBrn + ", benefAccBrnId="
				+ benefAccBrnId + ", benefAccBalance=" + benefAccBalance + ", benefBankCode=" + benefBankCode
				+ ", benefBankAddress=" + benefBankAddress + ", benefProductType=" + benefProductType + ", sessionId="
				+ sessionId + ", userName=" + userName + ", password=" + password + ", groupClass=" + groupClass
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", txnNumber=" + txnNumber + ", txnCount="
				+ txnCount + ", loanAccountNumber=" + loanAccountNumber + ", loanAccountType=" + loanAccountType
				+ ", loanTenure=" + loanTenure + ", loanAmount=" + loanAmount + ", loanPrincipalAmount="
				+ loanPrincipalAmount + ", loanInterestAmount=" + loanInterestAmount + ", loanRemarks=" + loanRemarks
				+ ", loanDate=" + loanDate + ", depositAccNumber=" + depositAccNumber + ", depositType=" + depositType
				+ ", depositAmount=" + depositAmount + ", depositCcy=" + depositCcy + ", depositRemarks="
				+ depositRemarks + ", principalAmount=" + principalAmount + ", nominalInterestRate="
				+ nominalInterestRate + ", numberOfYears=" + numberOfYears + ", messageSenderName=" + messageSenderName
				+ ", messageReceivername=" + messageReceivername + ", messageText=" + messageText + ", chequeNumber="
				+ chequeNumber + ", numOfChequeBooks=" + numOfChequeBooks + ", numOfChequeLeaves=" + numOfChequeLeaves
				+ ", deliverTo=" + deliverTo + ", stopChequeReason=" + stopChequeReason + ", passbookNumber="
				+ passbookNumber + ", numOfPassbooks=" + numOfPassbooks + ", stopPassbookReason=" + stopPassbookReason
				+ ", question=" + question + ", answer=" + answer + ", favouriteName=" + favouriteName
				+ ", fromaccountType=" + fromaccountType + ", channelId=" + channelId + ", complaintCategory="
				+ complaintCategory + ", complaintCategoryId=" + complaintCategoryId + ", complaintDesc="
				+ complaintDesc + ", complaintReason=" + complaintReason + ", complaintDoc=" + complaintDoc
				+ ", authenticationReferenceCode=" + authenticationReferenceCode + ", otp=" + otp + ", scheduleId="
				+ scheduleId + ", txnScheduleFromDate=" + txnScheduleFromDate + ", txnScheduleToDate="
				+ txnScheduleToDate + ", scheduleTxnType=" + scheduleTxnType + ", noOfInstallments=" + noOfInstallments
				+ ", scheduleFrequency=" + scheduleFrequency + ", txnScheduleDay=" + txnScheduleDay
				+ ", txnScheduleMonth=" + txnScheduleMonth + ", scheduleTransferRemarks=" + scheduleTransferRemarks
				+ ", loanTenureInMonth=" + loanTenureInMonth + ", rateOfInterest=" + rateOfInterest
				+ ", loanTenureInYears=" + loanTenureInYears + ", productBranchId=" + productBranchId
				+ ", productCategoryId=" + productCategoryId + ", productChannelId=" + productChannelId
				+ ", productCustomerId=" + productCustomerId + ", productEmailId=" + productEmailId + ", contactNumber="
				+ contactNumber + ", productCityId=" + productCityId + ", productStateId=" + productStateId
				+ ", productFirstName=" + productFirstName + ", productLastName=" + productLastName + ", longitude="
				+ longitude + ", lattitude=" + lattitude + ", city=" + city + ", state=" + state + ", branch=" + branch
				+ ", depositTenureInMonths=" + depositTenureInMonths + ", depositInterestRate=" + depositInterestRate
				+ ", depositInterestPayout=" + depositInterestPayout + ", nomineeDetails=" + nomineeDetails
				+ ", maturityAmount=" + maturityAmount + ", maturityDate=" + maturityDate + ", depositDate="
				+ depositDate + ", budgetId=" + budgetId + ", budgetDesc=" + budgetDesc + ", budgetPeriod="
				+ budgetPeriod + ", budgetCategory=" + budgetCategory + ", budgetAmount=" + budgetAmount
				+ ", thresholdAmount=" + thresholdAmount + ", budgetStart=" + budgetStart + ", budgetStatus="
				+ budgetStatus + ", durationtype=" + durationtype + ", quarter=" + quarter + ", goalTxnId=" + goalTxnId
				+ ", goalImgId=" + goalImgId + ", goalName=" + goalName + ", goalDesc=" + goalDesc + ", targetAmount="
				+ targetAmount + ", fundingAccount=" + fundingAccount + ", allocatePercentage=" + allocatePercentage
				+ ", goalStatus=" + goalStatus + ", goalAccNumber=" + goalAccNumber + ", initialDepositAmt="
				+ initialDepositAmt + ", siRequired=" + siRequired + ", autoRedemption=" + autoRedemption
				+ ", redemptAccountNum=" + redemptAccountNum + ", accNumberType=" + accNumberType + ", accNumberDesc="
				+ accNumberDesc + ", currentAmount=" + currentAmount + ", amountAsOf=" + amountAsOf
				+ ", siSorceAccNumber=" + siSorceAccNumber + ", siStatus=" + siStatus + ", siStartDate=" + siStartDate
				+ ", siFrequency=" + siFrequency + ", siAmount=" + siAmount + ", goalAccountFlag=" + goalAccountFlag
				+ ", channel=" + channel + ", apiDesc=" + apiDesc + ", id=" + id + ", base64String=" + base64String
				+ ", fileType=" + fileType + ", catalogCode=" + catalogCode + ", primaryAccountFlag="
				+ primaryAccountFlag + ", groupNumber=" + groupNumber + ", stage=" + stage + ", handle=" + handle
				+ ", language=" + language + ", signature=" + signature + ", timeStamp=" + timeStamp + ", brandId="
				+ brandId + ", action=" + action + ", notification=" + notification + ", accessType=" + accessType
				+ ", code=" + code + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", networkType="
				+ networkType + ", nomineeId=" + nomineeId + ", relationship=" + relationship + ", guardianAddress="
				+ guardianAddress + ", guardianName=" + guardianName + ", pinCode=" + pinCode + ", sameAddress="
				+ sameAddress + ", nomineeName=" + nomineeName + ", frequency=" + frequency + ", cardType=" + cardType
				+ ", cardGrade=" + cardGrade + ", cardNumber=" + cardNumber + ", cardName=" + cardName
				+ ", withdrawalLimit=" + withdrawalLimit + ", onlineTxnLimit=" + onlineTxnLimit + ", intTxnLimit="
				+ intTxnLimit + ", date=" + date + ", widget=" + widget + "]";
	}
}
