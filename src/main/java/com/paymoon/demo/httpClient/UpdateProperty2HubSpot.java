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

import net.sf.json.JSONArray;

/**
 * @ClassName: HelloWorld
 * @Description: TODO
 * @author StevenLii
 * @date 2014年11月19日 下午11:01:24
 * 
 */
public class UpdateProperty2HubSpot {

	/**
	 * @Fields serialVersionUID : TODO
	 */

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		  map.put("name", "newcustomproperty");
		  map.put("label", "A New Custom Property");
		  map.put("description", "A new property for you");
		  map.put("groupName", "contactinformation");
		  map.put("type", "string");
		  map.put("fieldType", "text");
		  map.put("formField", true);
		  map.put("displayOrder", 6);
		  map.put("options", "[]");

		  //https://api.hubapi.com/contacts/v2/properties?hapikey=ca045806-e87a-4d5d-9320-46ee0c5dae45&portalId=1698991

		push2HubSpot(map,"https://api.hubapi.com/contacts/v2/properties?hapikey=demo&portalId=62515");
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