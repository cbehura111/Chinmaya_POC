package com.chinmaya.cache.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.chinmaya.cache.constants.CommonConstants;

@Configuration
@PropertySource("file://${externalPropertyFile.path}")
public class ExternalProperties {

	public final Map<String, String> external = new HashMap<>();

	@Value("${ab.common.accTypeMapper}")
	private String accTypeMapper;

	@Value("${ab.common.accountNo}")
	private String accountNo;

	@Value("${ab.common.accountNumberParentNode}")
	private String accountNumberParentNode;

	@Value("${ab.common.accountTypeFlag}")
	private String accountTypeFlag;

	@Value("${ab.common.txnAppID}")
	private String txnAppID;

	@Value("${ab.common.storeFeedBackIntf}")
	private String storeFeedBackIntf;

	@Value("${ab.common.validateFeedBackIntf}")
	private String validateFeedBackIntf;

	@Value("${ab.common.accDtlsIntf}")
	private String accDtlsIntf;

	@Value("${ab.common.exchangeRateIntf}")
	private String exchangeRateIntf;

	@Value("${ab.common.fetchBenefIntf}")
	private String fetchBenefIntf;

	@Value("${ab.common.accUnMaskIntf}")
	private String accUnMaskIntf;

	@Value("${ab.common.customer360Intf}")
	private String customer360Intf;

	@Value("${ab.common.downloadReceiptIntf}")
	private String downloadReceiptIntf;

	@Value("${ab.common.validateCreditCardsIntf}")
	private String validateCreditCardsIntf;

	@Value("${ab.common.fetchBlockOutIntf}")
	private String fetchBlockOutIntf;

	@Value("${ab.common.notifHub}")
	private String notifHubFlg;

	@Value("${ab.common.vaptRequired}")
	private String vaptRequired;

	@Value("${ab.common.showHideAccountFlag}")
	private String showHideAccountFlag;

	@Value("${ab.common.isScheduleCacheRefreshEnabled}")
	private String isScheduleCacheRefreshEnabled;

	@Value("${ab.common.cacheRefreshPeriod}")
	private String cacheRefreshPeriod;

	@Value("${ab.common.defaultSegment}")
	private String defaultSegment;

	@Value("${ab.common.singleCurrencyLimit}")
	private String singleCurrencyLimit;

	@Value("${ab.common.accountNumberParentObj}")
	private String accountNumberParentObj;

	@Value("${ab.common.mpinAppID}")
	private String mPINAppId;

	@Value("${ab.common.verifyCustomerIntf}")
	private String verifyCustomerIntf;

	@Value("${ab.common.cardNumber}")
	private String cardNumber;

	@Value("${ab.common.cardNumberParentNode}")
	private String cardNumberParentNode;

	@Value("${ab.common.storeAndFwdTxnPayload}")
	private String storeAndFwdTxnPayload;
	
	@Value("${ab.common.authenticatorAppID}")
	private String authenticatorAppID;
	
	@Value("${ab.common.appId}")
	private String appId;

	public Map<String, String> getExternal() {

		String commonProp = CommonConstants.AB_COMMON_PROP;
		external.put(commonProp + CommonConstants.ACCTYPE_MAPPER_LW_TXT, accTypeMapper);
		external.put(commonProp + CommonConstants.ACCOUNT_NUMBER, accountNo);
		external.put(commonProp + CommonConstants.ACCOUNT_NUMBER_PARENT_NODE, accountNumberParentNode);
		external.put(commonProp + CommonConstants.ACCOUNT_TYPE_FLG, accountTypeFlag);
		external.put(commonProp + CommonConstants.TXN_APPID, txnAppID);
		external.put(commonProp + CommonConstants.STORE_FEEDBACK_DATA, storeFeedBackIntf);
		external.put(commonProp + CommonConstants.VALIDATE_FEEDBACK, validateFeedBackIntf);
		external.put(commonProp + CommonConstants.ACCOUNT_DETAILS, accDtlsIntf);
		external.put(commonProp + CommonConstants.GET_EXCHANGE_RATE, exchangeRateIntf);
		external.put(commonProp + CommonConstants.BENEFICIARY_FETCH, fetchBenefIntf);
		external.put(commonProp + CommonConstants.ACCOUNT_UNMASK, accUnMaskIntf);
		external.put(commonProp + CommonConstants.CUSTOMER_360, customer360Intf);
		external.put(commonProp + CommonConstants.DOWNLOAD_RECEIPT, downloadReceiptIntf);
		external.put(commonProp + CommonConstants.NOTIF_HUB_FLG, notifHubFlg);
		external.put(commonProp + CommonConstants.VALIDATE_CREDIT_CARD, validateCreditCardsIntf);
		external.put(commonProp + CommonConstants.BLOCKOUT_INTF, fetchBlockOutIntf);
		external.put(commonProp + CommonConstants.VAPT_REQ, vaptRequired);
		external.put(commonProp + CommonConstants.SHOW_HIDE_FLG, showHideAccountFlag);
		external.put(commonProp + CommonConstants.IS_SCHEDULED_CACHE_REFRESH, isScheduleCacheRefreshEnabled);
		external.put(commonProp + CommonConstants.CACHE_REFRESH_PERIOD, cacheRefreshPeriod);
		external.put(commonProp + CommonConstants.DEFAULT_SEGMENT, defaultSegment);
		external.put(commonProp + CommonConstants.SINGLE_CURRENCY_LIMIT, singleCurrencyLimit);
		external.put(commonProp + CommonConstants.ACCOUNT_NUMBER_PARENT_OBJ, accountNumberParentObj);
		external.put(commonProp + CommonConstants.MPIN_APP_ID, mPINAppId);
		external.put(commonProp + CommonConstants.VERIFY_CUSTOMER_INTF, verifyCustomerIntf);
		external.put(commonProp + CommonConstants.CARD_NO, cardNumber);
		external.put(commonProp + CommonConstants.CARD_NUMBER_PARENT_NODE, cardNumberParentNode);
		external.put(commonProp + CommonConstants.STORE_FWD_TXN_PAYLOAD, storeAndFwdTxnPayload);
		external.put(commonProp + CommonConstants.AUTHENTICATOR_APPID, authenticatorAppID);
		external.put(commonProp + CommonConstants.APP_ID, appId);
		return external;
	}
}
