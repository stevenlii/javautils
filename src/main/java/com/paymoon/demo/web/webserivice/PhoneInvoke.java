package com.paymoon.demo.web.webserivice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Android平台调用WebService（手机号码归属地查询）
 * 
 * @author liufeng
 * @date 2011-05-18
 */
public class PhoneInvoke {
	private static final Logger logger = LogManager.getLogger(); 

	public String doCheck(String phoneSec) {
		// 手机号码（段）
		// 简单判断用户输入的手机号码（段）是否合法
		if ("".equals(phoneSec) || phoneSec.length() < 7) {
			// 给出错误提示
			logger.error("您输入的手机号码（段）有误！{}" , phoneSec );
			return "9999";
		}
		// 查询手机号码（段）信息
		return "0000";
	}

	/**
	 * 手机号段归属地查询
	 * 
	 * @param phoneSec 手机号段
	 */
	public void getRemoteInfo(String phoneSec) {
		// 命名空间
		String nameSpace = "http://WebXml.com.cn/";
		// 调用的方法名称
		String methodName = "getMobileCodeInfo";
		// EndPoint
		String endPoint = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx";
		// SOAP Action
		String soapAction = "http://WebXml.com.cn/getMobileCodeInfo";

		// 指定WebService的命名空间和调用的方法名
		WebserviceCall rpc = new WebserviceCall(nameSpace, methodName,endPoint);

		// 设置需调用WebService接口需要传入的两个参数mobileCode、userId
		rpc.addProperty("mobileCode", phoneSec);
		rpc.addProperty("userId", "");

		// 生成调用WebService方法的SOAP请求信息,并指定SOAP的版本
		String soapRequestData  = rpc.buildRequestData(WebserviceCall.SOAP12);
		logger.info("request soapRequestData :{} " , soapRequestData);
		try {
			// 调用WebService
			 int statusCode = rpc.status(soapRequestData);
			logger.info("response statusCode :{} " , statusCode);
			// 获取返回的数据
			String soapResponseData = rpc.responseDate(soapRequestData);
			logger.info("response soapResponseData:{} " , soapResponseData);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}