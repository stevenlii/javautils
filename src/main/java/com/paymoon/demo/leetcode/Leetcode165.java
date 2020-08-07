package com.paymoon.demo.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.alibaba.fastjson.JSONObject;

public class Leetcode165 {
	public static void main(String[] args) {
//		System.out.println(compareVersion("1.1", "1.0002"));
		json2();
	}
	 public static int compareVersion(String version1, String version2) {
	        String[] a1 = version1.split("\\.");
	        String[] a2 = version2.split("\\.");

	        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
	            int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
	            int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
	            if(i < j) return -1;
	            else if(i > j) return 1;
	        }
	        return 0;  
	    }
	 public static void json() {
	        List<Short> list = IntStream.range(1, 10).boxed().map(Integer::shortValue).collect(Collectors.toList());
	        JSONObject json = new JSONObject();
	        json.put("areaId", list);
	        System.out.println(json.toString());

	        String s = JSONObject.toJSONString(json);

//	        List<Long> list2 = (List<Long>) JSONArray.parseArray(json.getString("areaId"), Long.class);

	        JSONObject json2 = JSONObject.parseObject(s);
	        List<Long> list2 = (List<Long>)json2.get("areaId");
	        System.out.println(JSONObject.toJSONString(list2));
	        for(Long l : list2) {
	            System.out.println(l);
	        }
	        
	    }
	 public static void json2() {
	     List<Short> list = IntStream.range(1, 10).boxed().map(Integer::shortValue)
	    		 .collect(Collectors.toList());
		 Map<String, List> testMap = new HashMap<>();
		 testMap.put("test", list);
		 List<Long> list2 = (List<Long>) testMap.get("test");
		 for(Long l : list2) {
			 System.out.println(l);
		 }
		 
		
	 }
}
