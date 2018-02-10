package tx.huobi.rest;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpException;

public interface IV1RestApi {

	/**
	 * 查询系统支持的所有交易对及精度
	 * 
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String commonSymbols() throws HttpException, IOException;

	/**
	 * 查询系统支持的所有币种
	 * 
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String commonCurrencys() throws HttpException, IOException;

	/**
	 * 查询系统当前时间
	 * 
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String commonTimestamp() throws HttpException, IOException;
	
	/**
	 * 查询当前用户的所有账户(即account-id)
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String accounts() throws HttpException, IOException;
	
	/**
	 * 查询指定账户的余额
	 * @param accountId	账户 ID
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String accountsBalance(String accountId) throws HttpException, IOException;
	

	/**
	 * 下单
	 * @param accountId	账户 ID
	 * @param amount	限价单表示下单数量，市价买单时表示买多少钱，市价卖单时表示卖多少币	
	 * @param price	下单价格，市价单不传该参数
	 * @param source	订单来源		默认api，如果使用借贷资产交易，请填写‘margin-api’
	 * @param symbol	交易对
	 * @param type	订单类型	buy-market：市价买, sell-market：市价卖, buy-limit：限价买, sell-limit：限价卖
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String place(String accountId, String amount, String price, String source, String symbol, String type) throws HttpException, IOException;
	
	/**
	 * 申请撤销一个订单请求
	 * @param orderId		订单ID
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String submitcancel(String orderId) throws HttpException, IOException;
	
	/**
	 * 批量撤销订单
	 * @param orderIds	撤销订单ID列表
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String batchcancel(List<String> orderIds) throws HttpException, IOException;
	
	/**
	 * 查询某个订单详情
	 * @param orderId	订单ID
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String orders(String orderId) throws HttpException, IOException;
		
	/**
	 * 查询某个订单的成交明细
	 * @param orderId	订单ID
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String matchresults(String orderId) throws HttpException, IOException;
	
	/**
	 * 查询当前委托、历史委托
	 * @param symbol	交易对
	 * @param types	查询的订单类型组合，使用','分割	buy-market：市价买, sell-market：市价卖, buy-limit：限价买, sell-limit：限价卖
	 * @param startDate	查询开始日期, 日期格式yyyy-mm-dd
	 * @param endDate	查询结束日期, 日期格式yyyy-mm-dd
	 * @param states	查询的订单状态组合，使用','分割		pre-submitted 准备提交, submitted 已提交, partial-filled 部分成交, partial-canceled 部分成交撤销, filled 完全成交, canceled 已撤销
	 * @param from	查询起始 ID
	 * @param direct	查询方向		prev 向前，next 向后
	 * @param size	查询记录大小
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String orders(String symbol, String types, String startDate, String endDate, String states,String from, String direct,String size) throws HttpException, IOException;
	
	/**
	 * 查询当前成交、历史成交
	 * @param symbol	交易对
	 * @param types	查询的订单类型组合，使用','分割	buy-market：市价买, sell-market：市价卖, buy-limit：限价买, sell-limit：限价卖
	 * @param startDate	查询开始日期, 日期格式yyyy-mm-dd
	 * @param endDate	查询结束日期, 日期格式yyyy-mm-dd
	 * @param from	查询起始 ID
	 * @param direct	查询方向		prev 向前，next 向后
	 * @param size	查询记录大小
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String matchresults(String symbol, String types, String startDate, String endDate, String from, String direct,String size) throws HttpException, IOException;
	
	/**
	 * 现货账户划入至借贷账户
	 * @param symbol	交易对
	 * @param currency	币种
	 * @param amount
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String transferInMargin(String symbol, String currency, String amount) throws HttpException, IOException;
	
	/**
	 * 借贷账户划出至现货账户
	 * @param symbol	交易对
	 * @param currency	币种
	 * @param amount	金额
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String transferOutMargin(String symbol, String currency, String amount) throws HttpException, IOException;
	
	/**
	 * 申请借贷
	 * @param symbol	交易对
	 * @param currency	币种
	 * @param amount	金额
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String marginOrders(String symbol, String currency, String amount) throws HttpException, IOException;
	
	/**
	 * 归还借贷
	 * @param orderId	借贷订单 ID
	 * @param amount	还款量
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String marginOrdersRepay(String orderId, String amount) throws HttpException, IOException;
	
	/**
	 * 借贷订单
	 * @param symbol	交易对
	 * @param currency	币种
	 * @param startDate	查询开始日期, 日期格式yyyy-mm-dd
	 * @param endDate	查询结束日期, 日期格式yyyy-mm-dd
	 * @param states 状态
	 * @param from	查询起始 ID
	 * @param direct	查询方向		prev 向前，next 向后
	 * @param size	查询记录大小
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String marginLoanOrders(String symbol, String currency, String startDate, String endDate, String states, String from, String direct,String size) throws HttpException, IOException;
	
	
	/**
	 * 借贷账户详情
	 * @param symbol	交易对
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String marginAccountsBalance(String symbol) throws HttpException, IOException;
	
	/**
	 * 申请提现虚拟币
	 * @param address	提现地址
	 * @param amount		提币数量
	 * @param currency	资产类型
	 * @param fee	转账手续费	
	 * @param addrTag	虚拟币共享地址tag，XRP特有
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public String withdraw(String address, String amount, String currency, String fee, String addrTag) throws HttpException, IOException;
	
}
