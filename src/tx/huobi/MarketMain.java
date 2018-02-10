package tx.huobi;

import java.io.IOException;

import org.apache.http.HttpException;

import tx.huobi.rest.IMarketRestApi;
import tx.huobi.rest.impl.MarketRestApi;

public class MarketMain {

	public static void main(String[] args) {
		IMarketRestApi marketRestApi = new MarketRestApi();

		try {
			// 获取K线数据
			String ret = marketRestApi.kline("btcusdt", "1min", "10");
			System.out.println(ret);

			// 获取聚合行情(Ticker)
			ret = marketRestApi.merged("btcusdt");
			System.out.println(ret);

			// 获取 Market Depth 数据
			ret = marketRestApi.depth("btcusdt", "step0");
			System.out.println(ret);

			// 获取 Trade Detail 数据
			ret = marketRestApi.trade("btcusdt");
			System.out.println(ret);

			// 批量获取最近的交易记录
			ret = marketRestApi.tradeHistory("btcusdt", "10");
			System.out.println(ret);

			// 获取 Market Detail 24小时成交量数据
			ret = marketRestApi.detail24("btcusdt");
			System.out.println(ret);

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
