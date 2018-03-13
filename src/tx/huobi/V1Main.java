package tx.huobi;

import tx.huobi.rest.IV1RestApi;
import tx.huobi.rest.impl.V1RestApi;

public class V1Main {

	public static void main(String[] args) {
		IV1RestApi v1RestApi = new V1RestApi();

		try {
			String ret = "";

			// 查询系统支持的所有交易对及精度
			ret = v1RestApi.commonSymbols();
			System.out.println(ret);
//			
//			// 查询系统支持的所有币种
//			ret = v1RestApi.commonCurrencys();
//			System.out.println(ret);
//			
//			// 查询系统当前时间
//			ret = v1RestApi.commonTimestamp();
//			System.out.println(ret);
//			long longTime = JSON.parseObject(ret).getLongValue("data");
//			System.out.println(new Date(longTime));
//			
//			// 查询当前用户的所有账户(即account-id)
			ret = v1RestApi.accounts();
			System.out.println(ret);
//			
//			// 查询当前用户的所有账户(即account-id)
//			ret = v1RestApi.accountsBalance("100512");
//			System.out.println(ret);
//			
//			// 下单
//			ret = v1RestApi.place("100512", "1", "800", "api", "qtumusdt", "sell-limit");
//			System.out.println(ret);
//			
//			// 申请撤销一个订单请求
//			ret = v1RestApi.submitcancel("707017938");
//			System.out.println(ret);
//			
//			// 批量撤销订单
//			List<String> orderIds = new ArrayList<String>();
//			orderIds.add("707450476");
//			orderIds.add("707499914");
//			ret = v1RestApi.batchcancel(orderIds);
//			System.out.println(ret);
//			
//			// 查询某个订单详情
//			ret = v1RestApi.orders("707450476");
//			System.out.println(ret);
//			
//			// 查询某个订单的成交明细
//			ret = v1RestApi.matchresults("565214281");
//			System.out.println(ret);
//			
//			// 查询当前委托、历史委托
//			ret = v1RestApi.orders("qtumusdt", null, null, null, "filled", null, null, null);
//			System.out.println(ret);
//
//			// 查询当前成交、历史成交
//			ret = v1RestApi.matchresults("qtumusdt", null, null, null, null, null, "50");
//			System.out.println(ret);
//			
//			// 现货账户划入至借贷账户
//			ret = v1RestApi.transferInMargin("qtumusdt", "qtum", "1");
//			System.out.println(ret);
//			
//			// 现货账户划入至借贷账户
//			ret = v1RestApi.transferOutMargin("qtumusdt", "qtum", "1");
//			System.out.println(ret);
			
			// 借贷账户详情
//			ret = v1RestApi.marginAccountsBalance(null);
//			System.out.println(ret);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
