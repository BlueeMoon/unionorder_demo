package com.allinpay.syb.test;

import java.util.Map;
import java.util.Random;

import com.allinpay.syb.lib.SybPayService;

public class NotifyThread  extends Thread implements Runnable{
	public String mAgentip = "";
	public int mAgentPort = 0;
	public String mUrl = "";
	public String idNum = "";
	public void run(){
		SybPayService service = new SybPayService();
		//http://172.16.2.46:8082/vo-apidemo/NotifyServlet
		//http://113.108.182.3:10080/vo-apidemo/NotifyServlet
		//reqsn = "12345b";
		 for(int i=0;i<30;i++){
			 try {
				 String reqsn = String.valueOf(System.currentTimeMillis())+new Random().nextInt(1000);
					Map<String, String> map = service.pay(1, reqsn, "Q02", "标题", "备注", "", "","http://172.16.2.46:8082/vo-apidemo/NotifyServlet","");
					System.out.println("返回:"+map);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		 }
		
    }
	public String getmAgentip() {
		return mAgentip;
	}
	public void setmAgentip(String mAgentip) {
		this.mAgentip = mAgentip;
	}
	public int getmAgentPort() {
		return mAgentPort;
	}
	public void setmAgentPort(int mAgentPort) {
		this.mAgentPort = mAgentPort;
	}
	public String getmUrl() {
		return mUrl;
	}
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	
}
