package com.paymoon.demo.web.webserivice;
 import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
  
  
 /**
* @ClassName: GetCountryCityByIp
* @Description: 一个Webservice，调用webxml.com.cn得知电话归属地
* @author lizhiqiang
* @date 2014年11月21日 下午1:58:25
*http://www.111cn.net/jsp/Java/64757.htm
*/
public class PhoneNum {
     // 提供IP地址搜索WEB服务的URL
     private String url = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx"; // 在浏览器中打开url，可以找到
    // private String soapAction="http://WebXml.com.cn/getCountryCityByIp"
     private String namespace = "http://WebXml.com.cn/";// targetNamespace
     private String actionURI = "getMobileCodeInfo"; // Action路径
    private String op = "getMobileCodeInfo"; // 要调用的方法名
 
      
     public String GetCityByPhone() {
         Service service = new Service();
         try {
             Call call = (Call) service.createCall();
             call.setTargetEndpointAddress(new java.net.URL(url));
             call.setUseSOAPAction(true);
             // action uri
             call.setSOAPActionURI(namespace + actionURI);
             // 设置要调用哪个方法
            call.setOperationName(new QName(namespace, op));
             // 设置参数名称，具体参照从浏览器中看到的
            call.addParameter(new QName(namespace, "mobileCode"),
                     XMLType.XSD_STRING, ParameterMode.IN); // 要返回的数据类型
            call.setReturnType(new QName(namespace, op), String.class); // 入参：对应theIpAddress
             Object[] params = new Object[]{"18210988626"}; // 调用方法并传递参数
            String v = (String) call.invoke(params);
            System.out.println(v);
            return v;
         } catch (Exception ex) {
             ex.printStackTrace();
         }
          
         return "wrong";
     }
     public static void main(String[] args) {
		new PhoneNum().GetCityByPhone();
	}
 }