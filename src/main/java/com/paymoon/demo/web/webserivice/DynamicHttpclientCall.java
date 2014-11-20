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

// 动态构造调用串，灵活性更大
public class DynamicHttpclientCall {

    private String namespace;
    private String methodName;
    private String wsdlLocation;
    private String soapResponseData;

    public DynamicHttpclientCall(String namespace, String methodName,
            String wsdlLocation) {

        this.namespace = namespace;
        this.methodName = methodName;
        this.wsdlLocation = wsdlLocation;
    }

    private int invoke(String soapRequestData) throws Exception {
        PostMethod postMethod = new PostMethod(wsdlLocation);

        byte[] bytes = soapRequestData.getBytes("utf-8");
        InputStream inputStream = new ByteArrayInputStream(bytes, 0,
                bytes.length);
        //http://wenzhixin.net.cn/2013/11/08/rss_atom_feed_php
        //由于RSS前途未卜，而且RSS标准发展存在诸多问题或不足，于是ATOM横空出世，可理解为RSS的替代品。 ATOM是IETF的建议标准，Atom Syndication Format是基于XML格式，Atom Publishing Protocol则是基于HTTP协议格式。
        //application/soap+xml 是ATOM Feed的一种格式
        RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
                bytes.length, "application/soap+xml; charset=utf-8");
        postMethod.setRequestEntity(requestEntity);

        HttpClient httpClient = new HttpClient();
        int statusCode = httpClient.executeMethod(postMethod);
        soapResponseData = postMethod.getResponseBodyAsString();

        return statusCode;
    }

    private String buildRequestData(Map<String, String> patameterMap) {
        StringBuffer soapRequestData = new StringBuffer();
        soapRequestData.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        soapRequestData
                .append("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
                        + " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
                        + " xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">");
        soapRequestData.append("<soap12:Body>");
        soapRequestData.append("<" + methodName + " xmlns=\"" + namespace
                + "\">");
        soapRequestData.append("<" + methodName + "Request>");

        Set<String> nameSet = patameterMap.keySet();
        for (String name : nameSet) {
            soapRequestData.append("<" + name + ">" + patameterMap.get(name)
                    + "</" + name + ">");
        }
        
        soapRequestData.append("</" + methodName + "Request>");
        soapRequestData.append("</" + methodName + ">");
        soapRequestData.append("</soap12:Body>");
        soapRequestData.append("</soap12:Envelope>");

        return soapRequestData.toString();
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        DynamicHttpclientCall dynamicHttpclientCall = new DynamicHttpclientCall(
                "http://shippingapi.ebay.cn/", "GetAPACShippingPackage",
                "http://epacketws.pushauction.net/v3/orderservice.asmx?wsdl");

        Map<String, String> patameterMap = new HashMap<String, String>();

        patameterMap.put("TrackCode", "123");
        patameterMap.put("Version", "123");
        patameterMap.put("APIDevUserID", "123");
        patameterMap.put("APIPassword", "123");
        patameterMap.put("APISellerUserID", "123");
        patameterMap.put("MessageID", "123");
        patameterMap.put("TrackCode", "123");

        String soapRequestData = dynamicHttpclientCall.buildRequestData(patameterMap);
        System.out.println(soapRequestData);

        int statusCode = dynamicHttpclientCall.invoke(soapRequestData);
        if(statusCode == 200) {
            System.out.println("调用成功！");
            System.out.println(dynamicHttpclientCall.soapResponseData);
        }
        else {
            System.out.println("调用失败！错误码：" + statusCode);
        }
        
    }

}