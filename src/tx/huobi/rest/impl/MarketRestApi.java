package tx.huobi.rest.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;

import tx.huobi.rest.IMarketRestApi;
import tx.huobi.tools.HttpUtilManager;

public class MarketRestApi implements IMarketRestApi {

	private static String MARKET_URL = "https://api.huobipro.com";

	@Override
	public String kline(String symbol, String period, String size) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("symbol", symbol);
		paramMap.put("period", period);
		paramMap.put("size", size);

		return httpUtil.requestHttpGet(MARKET_URL, "/market/history/kline", paramMap);
	}

	@Override
	public String merged(String symbol) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("symbol", symbol);

		return httpUtil.requestHttpGet(MARKET_URL, "/market/detail/merged", paramMap);
	}

	@Override
	public String depth(String symbol, String type) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("symbol", symbol);
		paramMap.put("type", type);

		return httpUtil.requestHttpGet(MARKET_URL, "/market/depth", paramMap);
	}

	@Override
	public String trade(String symbol) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("symbol", symbol);

		return httpUtil.requestHttpGet(MARKET_URL, "/market/trade", paramMap);
	}

	@Override
	public String tradeHistory(String symbol, String size) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("symbol", symbol);
		paramMap.put("size", size);

		return httpUtil.requestHttpGet(MARKET_URL, "/market/history/trade", paramMap);
	}

	@Override
	public String detail24(String symbol) throws HttpException, IOException {
		HttpUtilManager httpUtil = HttpUtilManager.getInstance();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("symbol", symbol);

		return httpUtil.requestHttpGet(MARKET_URL, "/market/detail", paramMap);
	}

}
