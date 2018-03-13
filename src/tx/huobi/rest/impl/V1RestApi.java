package tx.huobi.rest.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import tx.huobi.Const;
import tx.huobi.rest.IV1RestApi;
import tx.huobi.tools.CryptoUtils;
import tx.huobi.tools.HttpUtilManager;
import tx.huobi.tools.ParamUtils;

public class V1RestApi implements IV1RestApi {

	private static String V1_URL = "https://api.huobipro.com";

	private static String SIGN_URL = "api.huobipro.com";

	@Override
	public String commonSymbols() throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		return httpUtil.requestHttpGet(V1_URL, "/v1/common/symbols");
	}

	@Override
	public String commonCurrencys() throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		return httpUtil.requestHttpGet(V1_URL, "/v1/common/currencys");
	}

	@Override
	public String commonTimestamp() throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		return httpUtil.requestHttpGet(V1_URL, "/v1/common/timestamp");
	}

	private Map<String, String> getCommonParam() {
		Map<String, String> signMap = new HashMap<String, String>();
		signMap.put("AccessKeyId", Const.Access_Key);
		signMap.put("SignatureMethod", Const.SignatureMethod);
		signMap.put("SignatureVersion", Const.SignatureVersion);
		signMap.put("Timestamp", ParamUtils.getUTCDate());
		return signMap;
	}
	
	private void setParam(Map paramMap, String key, String value) {
		if(value != null) {
			paramMap.put(key, value);
		}
	}

	@Override
	public String accounts() throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/account/accounts";
		Map<String, String> signMap = getCommonParam();
		String sign = CryptoUtils.buildSign("GET", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		return httpUtil.requestHttpGet(V1_URL, url, signMap);
	}

	@Override
	public String accountsBalance(String accountId) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = String.format("/v1/account/accounts/%s/balance", accountId);
		Map<String, String> signMap = getCommonParam();
		String sign = CryptoUtils.buildSign("GET", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		return httpUtil.requestHttpGet(V1_URL, url, signMap);
	}

	@Override
	public String place(String accountId, String amount, String price, String source, String symbol, String type)
			throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/order/orders/place";
		Map<String, String> signMap = getCommonParam();
		ParamUtils.createLinkString(signMap);
		String sign = CryptoUtils.buildSign("POST", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		Map<String, String> paramMap = new HashMap<String, String>();
		setParam(paramMap, "account-id", accountId);
		setParam(paramMap, "amount", amount);
		setParam(paramMap, "price", price);
		setParam(paramMap, "source", source);
		setParam(paramMap, "symbol", symbol);
		setParam(paramMap, "type", type);

		return httpUtil.requestHttpPost(V1_URL, url, signMap, paramMap);
	}

	@Override
	public String submitcancel(String orderId) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = String.format("/v1/order/orders/%s/submitcancel", orderId);
		Map<String, String> signMap = getCommonParam();
		ParamUtils.createLinkString(signMap);
		String sign = CryptoUtils.buildSign("POST", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		return httpUtil.requestHttpPost(V1_URL, url, signMap);
	}

	@Override
	public String batchcancel(List<String> orderIds) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/order/orders/batchcancel";
		Map<String, String> signMap = getCommonParam();
		ParamUtils.createLinkString(signMap);
		String sign = CryptoUtils.buildSign("POST", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("order-ids", orderIds);

		return httpUtil.requestHttpPost(V1_URL, url, signMap, paramMap);
	}

	@Override
	public String orders(String orderId) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = String.format("/v1/order/orders/%s", orderId);
		Map<String, String> signMap = getCommonParam();
		String sign = CryptoUtils.buildSign("GET", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		return httpUtil.requestHttpGet(V1_URL, url, signMap);
	}

	@Override
	public String matchresults(String orderId) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = String.format("/v1/order/orders/%s/matchresults", orderId);
		Map<String, String> signMap = getCommonParam();
		String sign = CryptoUtils.buildSign("GET", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		return httpUtil.requestHttpGet(V1_URL, url, signMap);
	}

	@Override
	public String orders(String symbol, String types, String startDate, String endDate, String states, String from,
			String direct, String size) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/order/orders";
		Map<String, String> signMap = getCommonParam();
		setParam(signMap,"symbol",symbol);
		setParam(signMap,"types",types);
		setParam(signMap,"start-date",startDate);
		setParam(signMap,"end-date",endDate);
		setParam(signMap,"states",states);
		setParam(signMap,"from",from);
		setParam(signMap,"direct",direct);
		setParam(signMap,"size",size);
		String sign = CryptoUtils.buildSign("GET", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		return httpUtil.requestHttpGet(V1_URL, url, signMap);
	}

	@Override
	public String matchresults(String symbol, String types, String startDate, String endDate, String from,
			String direct, String size) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/order/matchresults";
		Map<String, String> signMap = getCommonParam();
		setParam(signMap,"symbol",symbol);
		setParam(signMap,"types",types);
		setParam(signMap,"start-date",startDate);
		setParam(signMap,"end-date",endDate);
		setParam(signMap,"from",from);
		setParam(signMap,"direct",direct);
		setParam(signMap,"size",size);
		String sign = CryptoUtils.buildSign("GET", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		return httpUtil.requestHttpGet(V1_URL, url, signMap);
	}

	@Override
	public String transferInMargin(String symbol, String currency, String amount) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/dw/transfer-in/margin";
		Map<String, String> signMap = getCommonParam();
		ParamUtils.createLinkString(signMap);
		String sign = CryptoUtils.buildSign("POST", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		Map<String, String> paramMap = new HashMap<String, String>();
		setParam(paramMap, "symbol", symbol);
		setParam(paramMap, "currency", currency);
		setParam(paramMap, "amount", amount);

		return httpUtil.requestHttpPost(V1_URL, url, signMap, paramMap);
	}

	@Override
	public String transferOutMargin(String symbol, String currency, String amount) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/dw/transfer-out/margin";
		Map<String, String> signMap = getCommonParam();
		ParamUtils.createLinkString(signMap);
		String sign = CryptoUtils.buildSign("POST", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		Map<String, String> paramMap = new HashMap<String, String>();
		setParam(paramMap, "symbol", symbol);
		setParam(paramMap, "currency", currency);
		setParam(paramMap, "amount", amount);

		return httpUtil.requestHttpPost(V1_URL, url, signMap, paramMap);
	}

	@Override
	public String marginOrders(String symbol, String currency, String amount) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/margin/orders";
		Map<String, String> signMap = getCommonParam();
		ParamUtils.createLinkString(signMap);
		String sign = CryptoUtils.buildSign("POST", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		Map<String, String> paramMap = new HashMap<String, String>();
		setParam(paramMap, "symbol", symbol);
		setParam(paramMap, "currency", currency);
		setParam(paramMap, "amount", amount);

		return httpUtil.requestHttpPost(V1_URL, url, signMap, paramMap);
	}

	@Override
	public String marginOrdersRepay(String orderId, String amount) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = String.format("/v1/margin/orders/%s/repay",orderId);
		Map<String, String> signMap = getCommonParam();
		ParamUtils.createLinkString(signMap);
		String sign = CryptoUtils.buildSign("POST", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		Map<String, String> paramMap = new HashMap<String, String>();
		setParam(paramMap, "amount", amount);

		return httpUtil.requestHttpPost(V1_URL, url, signMap, paramMap);
	}

	@Override
	public String marginLoanOrders(String symbol, String currency, String startDate, String endDate, String states,
			String from, String direct, String size) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/margin/loan-orders";
		Map<String, String> signMap = getCommonParam();
		setParam(signMap,"symbol",symbol);
		setParam(signMap,"currency",currency);
		setParam(signMap,"start-date",startDate);
		setParam(signMap,"end-date",endDate);
		setParam(signMap,"states",states);
		setParam(signMap,"from",from);
		setParam(signMap,"direct",direct);
		setParam(signMap,"size",size);
		String sign = CryptoUtils.buildSign("GET", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		return httpUtil.requestHttpGet(V1_URL, url, signMap);
	}

	@Override
	public String marginAccountsBalance(String symbol) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/margin/accounts/balance";
		Map<String, String> signMap = getCommonParam();
		setParam(signMap,"symbol",symbol);
		String sign = CryptoUtils.buildSign("GET", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		return httpUtil.requestHttpGet(V1_URL, url, signMap);
	}

	@Override
	public String withdraw(String address, String amount, String currency, String fee, String addrTag)
			throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		String url = "/v1/dw/withdraw/api/create";
		Map<String, String> signMap = getCommonParam();
		ParamUtils.createLinkString(signMap);
		String sign = CryptoUtils.buildSign("POST", SIGN_URL, url, signMap);
		signMap.put("Signature", sign);

		Map<String, String> paramMap = new HashMap<String, String>();
		setParam(paramMap, "address", address);
		setParam(paramMap, "amount", amount);
		setParam(paramMap, "currency", currency);
		setParam(paramMap, "fee", fee);
		setParam(paramMap, "addrTag", addrTag);

		return httpUtil.requestHttpPost(V1_URL, url, signMap, paramMap);
	}

}
