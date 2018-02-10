package tx.huobi.rest;

import java.io.IOException;
import java.util.Date;

import org.apache.http.HttpException;


public interface IMarketRestApi {
	/**
	 * 获取K线数据
	 * @param symbol	交易对
	 * @param period	K线类型	1min, 5min, 15min, 30min, 60min, 1day, 1mon, 1week, 1year
	 * @param size		获取数量 [1,2000]
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String kline(String symbol, String period, String size) throws HttpException, IOException;
	
	
	/**
	 * 获取聚合行情
	 * @param symbol	交易对
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String merged(String symbol) throws HttpException, IOException;
	
	/**
	 * 获取 Market Depth 数据
	 * @param symbol	交易对
	 * @param type	step0, step1, step2, step3, step4, step5（合并深度0-5）；step0时，不合并深度
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String depth(String symbol, String type) throws HttpException, IOException;
	
	/**
	 * 获取 Trade Detail 数据
	 * @param symbol	交易对
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String trade(String symbol) throws HttpException, IOException;
	
	/**
	 * 批量获取最近的交易记录
	 * @param symbol	交易对
	 * @param size 	获取交易记录的数量 	[1, 2000]
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String tradeHistory(String symbol, String size) throws HttpException, IOException;
	
	
	/**
	 * 获取 Market Detail 24小时成交量数据
	 * @param symbol	交易对
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String detail24(String symbol) throws HttpException, IOException;
}
