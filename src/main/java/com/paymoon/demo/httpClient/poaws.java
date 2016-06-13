package com.paymoon.demo.httpClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;
import com.paymoon.demo.Util.Dict;
import com.paymoon.demo.Util.PropConf;
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
public class poaws {

	/**
	 * @throws FileNotFoundException 
	 * @Fields serialVersionUID : TODO
	 */

	public static void main(String[] args) throws FileNotFoundException {
		String map = null;
		Scanner scanner = new Scanner(new File("/Users/yol/Desktop/response.html"));
		  StringBuilder builder = new StringBuilder();
		    while (scanner.hasNextLine()) {
		        builder.append(scanner.nextLine());
		    }
		  //https://api.hubapi.com/contacts/v2/properties?hapikey=ca045806-e87a-4d5d-9320-46ee0c5dae45&portalId=1698991
		System.out.println("map is:>" + builder.toString());
		push2HubSpot(map,"http://localhost:8080/zaws/aws");
	}
	
	@SuppressWarnings("deprecation")
	public static String push2HubSpot(String map, String url) {
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
			post.setRequestHeader("x-amz-sns-message-type",
					"SubscriptionConfirmation");
			
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