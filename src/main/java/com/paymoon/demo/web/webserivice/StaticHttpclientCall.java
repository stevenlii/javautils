package com.paymoon.demo.web.webserivice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

public class StaticHttpclientCall {

    /**
     * @param args
     * @throws IOException
     * @throws HttpException
     */
    /**
    	 * ***************** TODO  *****************<br>
    	 * http://www.cnblogs.com/lanxuezaipiao/archive/2013/05/10/3072216.html
    	 * @param args
    	 * @throws HttpException
    	 * @throws IOException        
    	 * @return		 :  void
    	 * @author       :  lizhiqiang 2014年11月20日下午3:17:57
    	 * **********************************************
    */
    public static void main(String[] args) throws HttpException, IOException {
        // TODO Auto-generated method stub

        String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
                + " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
                + " xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"
                + " <soap12:Body>"
                + " <GetAPACShippingPackage xmlns=\"http://shippingapi.ebay.cn/\">"
                + " <GetAPACShippingPackageRequest>"
                + " <TrackCode>123</TrackCode>"
                + " <Version>123</Version>"
                + " <APIDevUserID>123</APIDevUserID>"
                + " <APIPassword>123</APIPassword>"
                + " <APISellerUserID>123</APISellerUserID>"
                + " <MessageID>123</MessageID>"
                + " </GetAPACShippingPackageRequest>"
                + " </GetAPACShippingPackage>" + "</soap12:Body>"
                + " </soap12:Envelope>";

        System.out.println(soapRequestData);

        PostMethod postMethod = new PostMethod(
                "http://epacketws.pushauction.net/v3/orderservice.asmx?wsdl");

        // 然后把Soap请求数据添加到PostMethod中
        byte[] b = soapRequestData.getBytes("utf-8");
        InputStream is = new ByteArrayInputStream(b, 0, b.length);
        RequestEntity re = new InputStreamRequestEntity(is, b.length,
                "application/soap+xml; charset=utf-8");
        postMethod.setRequestEntity(re);

        // 最后生成一个HttpClient对象，并发出postMethod请求
        HttpClient httpClient = new HttpClient();
        int statusCode = httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            System.out.println("调用成功！");
            String soapResponseData = postMethod.getResponseBodyAsString();
            System.out.println(soapResponseData);
        }
        else {
            System.out.println("调用失败！错误码：" + statusCode);
        }

    }

}