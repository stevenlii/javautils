package com.paymoon.demo.httpClient;

import java.util.HashMap;
import java.util.Map;

public class HTTPCollector {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		HttpClient httpClient = new HttpClient();
		String respTitleString = "百度一下，你就知道";
		map.put("respTitleString", respTitleString);
		// httpClient.get(map);

	}
}