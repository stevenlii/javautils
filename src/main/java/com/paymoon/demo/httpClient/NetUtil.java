package com.paymoon.demo.httpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName: POST 测试接口
 * @Description: TODO
 * @author StevenLii
 * @date 2014年11月19日 下午11:01:24
 * 
 */
public class NetUtil {

	/**
	 * @throws UnsupportedEncodingException 
	 * @Fields serialVersionUID : TODO
	 */

	public static void main(String[] args) throws UnsupportedEncodingException {
//		Map<String,String> map = new HashMap<>();
//		  map.put("alertAppkey", "111111");
//		  map.put("mnsQueue", "myfirstqueue");
//		  map.put("mnsAccountEndpoint", "http://1412580518114250.mns.cn-beijing.aliyuncs.com");
//		  map.put("mnsAccesskeySecret", "noc1dwMsrRY0o3n1vVFczOHd1v6bjG");
//		  map.put("mnsAccesskeyId", "Jkyctl1JLRkQWNgV");
//
//		  //https://api.hubapi.com/contacts/v2/properties?hapikey=ca045806-e87a-4d5d-9320-46ee0c5dae45&portalId=1698991
//
//		post(map,"http://localhost:8080/mongoservice/mongo/saveorupdate");
//		get("http://localhost:8080/mongoservice/mongo/query");
		//http://ci1.test.110monitor.com:28080/alert/api/nim/nim2onealert_CT_100100_ctmonitor100100_http://www.baidu.com/?UPYOO_TOKEN=357e3845-4f37-bcf8-c78b-08c5af2d6ca6
		String appkeyStr = "";
		 appkeyStr = URLEncoder.encode("nim2onealert_CT_100100_ctmonitor100100_http://www.baidu.com");
		 appkeyStr = URLEncoder.encode("nim2onealert_CT_100100_ctmonitor100100_www.baidu.com");
		 appkeyStr = URLEncoder.encode("nim2onealert_CT_1940_ctmonitor1940_http:abcdefg");
//		 appkeyStr = URLEncoder.encode("nim2onealert_CT_100100_ctmonitor100100_aabbbbbbcccc");
//		 appkeyStr = new String(Base64Utils.encode("nim2onealert_CT_100100_ctmonitor100100_aabbbbbbcccc".getBytes()));
		System.out.println(appkeyStr);
//		appkeyStr = URLDecoder.decode(appkeyStr);
//		System.out.println(appkeyStr);
//		appkeyStr = URLDecoder.decode(convertToUTF8(appkeyStr), "UTF-8");
//		System.out.println(appkeyStr);
		StringBuilder sb = new StringBuilder("http://");
		sb.append("uat.test.110monitor.com:28080");
		sb.append("/alert/api/nim/");
		sb.append(appkeyStr);
//		sb.append("/query");
		sb.append("?UPYOO_TOKEN=");
		sb.append("a1815667-e310-8e45-ab01-787c684e54d4");
		get(sb.toString());
	}
	protected static String convertToUTF8(String s) {
		if ((s == null) || (s.length() == 0))
			return s;
		try {
			byte[] b = s.getBytes("ISO8859_1");
			for (int i = 0; i < b.length; ++i)
				if (b[i] + 0 < 0)
					return new String(b, "UTF-8");
			b = s.getBytes("UTF-8");
			for (int i = 0; i < b.length; ++i)
				if (b[i] + 0 < 0)
					return new String(b, "UTF-8");
		} catch (Exception localException) {
		}
		return s;
	}
	@SuppressWarnings("deprecation")
	public static String post(Map<String,String> map, String url) {
		long timebefore = System.currentTimeMillis();
		int status = 0;
		PostMethod post =null;
		HttpClient httpClient = null;
		try {
			String surl = url;
			System.out.println("push url is: "+surl);
			/////////////////////
			
//			JSONArray js = JSONArray.fromObject(map);
			ObjectMapper ob = new ObjectMapper();
			String js = ob.writeValueAsString(map);
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
				return post.getResponseBodyAsString();
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
	public static String push(Map<String,Object> map, String url) {
		int status = 0;
		PostMethod post =null;
		HttpClient httpClient = null;
		try {
			String surl = url;
			System.out.println("push url is: "+surl);
			/////////////////////
			
//			JSONArray js = JSONArray.fromObject(map);
			ObjectMapper ob = new ObjectMapper();
			String js = ob.writeValueAsString(map);
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
				return post.getResponseBodyAsString();
			}
			
			
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
	public static String get(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httpget.  
			HttpGet httpget = new HttpGet(url);
			System.out.println("executing request " + httpget.getURI());
			// 执行get请求.  
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体  
				HttpEntity entity = response.getEntity();
				System.out.println("--------------------------------------");
				// 打印响应状态  
				System.out.println(response.getStatusLine());
				if (entity != null) {
					// 打印响应内容长度  
					System.out.println("Response content length: " + entity.getContentLength());
					String  responseContent = EntityUtils.toString(entity);
					// 打印响应内容  
					System.out.println("Response content: " + responseContent);
					return responseContent;
				}
				System.out.println("------------------------------------");
			} finally {
				response.close();
			}
		} catch (ParseException |IOException e) {
			System.out.println("NETUIIL ParseException |IOException :" + e.getMessage());
		} finally {
			// 关闭连接,释放资源  
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}