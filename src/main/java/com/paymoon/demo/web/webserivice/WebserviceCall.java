package com.paymoon.demo.web.webserivice;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// 动态构造调用串，灵活性更大
public class WebserviceCall {
	private static final Logger logger = LogManager.getLogger();
	public static final String SOAP12 = "soap12";
	private Map<String, Object> map = new HashMap<String, Object>();

	// 命名空间
	private String namespace = "http://WebXml.com.cn/";
	// 调用的方法名称
	private String methodName = "getMobileCodeInfo";
	// EndPoint
	private String wsdlLocation = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx";
	/**
	 * 返回数据
	 */
	private String soapResponseData;
	// SOAP Action
	String soapAction = "http://WebXml.com.cn/getMobileCodeInfo";

	public WebserviceCall(String namespace, String methodName,
			String wsdlLocation) {

		this.namespace = namespace;
		this.methodName = methodName;
		this.wsdlLocation = wsdlLocation;
	}

	private PostMethod invoke(String soapRequestData) throws Exception {
		PostMethod postMethod = new PostMethod(wsdlLocation);
		logger.info("request invoke wsdlLocation : {} " , wsdlLocation);
		byte[] bytes = soapRequestData.getBytes("utf-8");
		InputStream inputStream = new ByteArrayInputStream(bytes, 0,
				bytes.length);
		// http://wenzhixin.net.cn/2013/11/08/rss_atom_feed_php
		// 由于RSS前途未卜，而且RSS标准发展存在诸多问题或不足，于是ATOM横空出世，可理解为RSS的替代品。
		// ATOM是IETF的建议标准，Atom Syndication Format是基于XML格式，Atom Publishing
		// Protocol则是基于HTTP协议格式。
		// application/soap+xml 是ATOM Feed的一种格式
		RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
				bytes.length, "application/soap+xml; charset=utf-8");
		postMethod.setRequestEntity(requestEntity);
		return postMethod;
	}

	public int status(String soapRequestData) throws Exception {
		PostMethod postMethod = invoke(soapRequestData);
		HttpClient httpClient = new HttpClient();
		int statusCode = httpClient.executeMethod(postMethod);

		return statusCode;
	}

	public String responseDate(String soapRequestData) throws Exception {
		PostMethod postMethod = invoke(soapRequestData);
		soapResponseData = postMethod.getResponseBodyAsString();
		return soapResponseData;
	}

	public String buildRequestData(String soapversion) {
		StringBuffer soapRequestData = new StringBuffer();
		soapRequestData.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		soapRequestData
				.append("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
						+ " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
						+ " xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">");
		soapRequestData.append("<soap12:Body>");
		soapRequestData.append("<" + methodName + " xmlns=\"" + namespace
				+ "\">");
//		soapRequestData.append("<" + methodName + "Request>");

		Set<String> nameSet = map.keySet();
		for (String name : nameSet) {
			soapRequestData.append("<" + name + ">" + map.get(name) + "</"
					+ name + ">");
		}

//		soapRequestData.append("</" + methodName + "Request>");
		soapRequestData.append("</" + methodName + ">");
		soapRequestData.append("</soap12:Body>");
		soapRequestData.append("</soap12:Envelope>");

		return soapRequestData.toString();
	}


	public void addProperty(String key, String value) {
		map.put(key, value);
	}
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		PhoneInvoke pInvoke = new PhoneInvoke();
		String phoneNum = "18210988626";
		logger.info("request phoneNum : {} " , phoneNum);
		pInvoke.doCheck(phoneNum);
		pInvoke.getRemoteInfo(phoneNum);
	}

}