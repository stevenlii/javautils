package com.paymoon.demo.httpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import com.alibaba.fastjson.JSON;
import com.paymoon.demo.Util.Dict;
import com.paymoon.demo.vo.Metric;
import com.paymoon.demo.vo.Person2;

/**
 * @ClassName: HelloWorld
 * @Description: TODO
 * @author StevenLii
 * @date 2014年11月19日 下午11:01:24
 * 
 */
public class Post {

	/**
	 * @Fields serialVersionUID : TODO
	 */

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		map.put(Dict.URL, "https://api.hubapi.com/contacts/v1/contact?hapikey=ca045806-e87a-4d5d-9320-46ee0c5dae45");
		push2HubSpot(map);
	}
	@SuppressWarnings("deprecation")
	public static String push2HubSpot(Map<String,Object> map) {
	String url = (String)map.remove(Dict.URL);
	return push2HubSpot(map, url);
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
			
//			map.put("hapikey", "6cd96aa5-871f-485e-b06f-65d8d1ce9f80");
//			map.put("email", "123123123@hubspot.com");
			//JSONArray js = JSONArray.fromObject(map);
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
			System.out.println(timeafter - timebefore);
			
			
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