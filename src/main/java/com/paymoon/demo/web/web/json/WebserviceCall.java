package com.paymoon.demo.web.web.json;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymoon.demo.httpClient.NetUtil;

// 动态构造调用串，灵活性更大
public class WebserviceCall {
	private static final Logger logger = LogManager.getLogger();
	public static void main(String[] args) throws Exception {
		String body = NetUtil.get("http://c.onealert.com/alert/api/alert?JSESSIONID=7692467e-051e-4e98-889f-edc5be1fe31f");
		Map<String, Object> paramMap = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		paramMap = mapper.readValue(body, Map.class);
		 
		if(paramMap == null)
		  return;
		java.util.ArrayList<Map> lists = (java.util.ArrayList<Map>)paramMap.get("data");
		for (Map m : lists) {
			System.out.println(m.get("alarmId"));
		}
		if (lists != null && lists.size()>0) {
			System.out.println(true);
		}
	}

}