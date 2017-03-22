package com.allinpay.syb.test;

import java.util.Map;

import com.allinpay.syb.lib.SybPayService;


public class ApiTestV2 {
	public static void main(String[] args) throws Exception{
		testPay();
		//testCancel();
		//testRefund();
		//testQuery();
	}
	
	public static void testQuery() throws Exception{
		SybPayService service = new SybPayService();
		Map<String, String> map = service.query("12345b78", "229521939");
		print(map);
	}
	
	public static void testRefund() throws Exception{
		SybPayService service = new SybPayService();
		String reqsn = String.valueOf(System.currentTimeMillis());
		Map<String, String> map = service.refund(1, reqsn, "103276577", "");
		print(map);
	}
	
	public static void testCancel() throws Exception{
		SybPayService service = new SybPayService();
		String reqsn = String.valueOf(System.currentTimeMillis());
		Map<String, String> map = service.cancel(1, reqsn, "", "1481015015272");
		print(map);
	}
	
	public static void testPay() throws Exception{
		SybPayService service = new SybPayService();
		String reqsn = String.valueOf(System.currentTimeMillis());
		//http://172.16.2.46:8082/vo-apidemo/NotifyServlet
		//http://113.108.182.3:10080/vo-apidemo/NotifyServlet
		//reqsn = "12345b78";
		Map<String, String> map = service.pay(1, reqsn, "W04", "标题", "备注", "", "130178468907560360","http://172.16.2.46:8082/vo-apidemo/NotifyServlet","");
		print(map);
	}
	
	public static void print(Map<String, String> map){
		System.out.println("返回数据如下:");
		if(map!=null){
			for(String key:map.keySet()){
				System.out.println(key+";"+map.get(key));
			}
		}
	}
	
	
}
