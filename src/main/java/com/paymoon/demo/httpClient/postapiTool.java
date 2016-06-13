package com.paymoon.demo.httpClient;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: POST 测试接口
 * @Description: TODO
 * @author StevenLii
 * @date 2014年11月19日 下午11:01:24
 * 
 */
public class postapiTool {

	/**
	 * @Fields serialVersionUID : TODO
	 */

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		  map.put("description", "12345");
		  map.put("escalationId", "02e74f13-06eb-64d9-a97f-7871a5a48512");
		  map.put("integrateType", "aliyunmns");
		  map.put("autoResolve", "30");
		  map.put("mnsAccountEndpoint", "http://1412580518114250.mns.cn-beijing.aliyuncs.com");
		  map.put("mnsAccesskeySecret", "noc1dwMsrRY0o3n1vVFczOHd1v6bjG");
		  map.put("mnsAccesskeyId", "Jkyctl1JLRkQWNgV");

		  //https://api.hubapi.com/contacts/v2/properties?hapikey=ca045806-e87a-4d5d-9320-46ee0c5dae45&portalId=1698991

		push2HubSpot(map,"http://ci2.test.110monitor.com:28080/alert/api/service/?UPYOO_TOKEN=095386bd-8d02-43e9-8601-424e94575563");
	}
	
	@SuppressWarnings("deprecation")
	public static String push2HubSpot(Map<String,Object> map, String url) {
		long timebefore = System.currentTimeMillis();
		int status = 0;
		PostMethod post =null;
		HttpClient httpClient = null;
		try {
			String surl = url;
			System.out.println("push url is: "+surl);
			/////////////////////
			
//			JSONArray js = JSONArray.fromObject(map);
			String js = JSON.toJSONString(map);
			System.out.println("data is: "+js.toString());
			httpClient = new HttpClient();
			post = new PostMethod(surl);
			post.setRequestHeader("Content-Type",
					"application/json;charset=utf-8");
			
//				NameValuePair[] param = { new NameValuePair("properties", js.toString()) };
//				post.setRequestBody(param);
			post.setRequestBody(js.toString());
			post.getParams().setContentCharset("utf-8");
			post.releaseConnection();
			status = httpClient.executeMethod(post);
			
			System.out.println("push status " + status);
			if (status == HttpStatus.SC_OK) {
				
				System.out.println("push response " + post.getResponseBodyAsString());
			}
			long timeafter = System.currentTimeMillis();
//			System.out.println(timeafter - timebefore);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			//logger.error("发送数据失败!!!", e);
		}finally {  
			if (post != null) {  
				post.releaseConnection();  
				post = null;  
				httpClient = null;  
			}  
		}  
		return String.valueOf(status);
	}
	

}