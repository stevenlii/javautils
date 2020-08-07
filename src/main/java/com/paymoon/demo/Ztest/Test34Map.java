package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test34Map {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Test34Map test34Map= new Test34Map();
		Map<String, String> map = null;
		map  = test34Map.getm1();
		 System.out.println(map);
	}
	public Map<String, String> getm1() {
		Map<String, String> map = new HashedMap();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.forEach(t -> getm12(t,map));
		return map;
	}
	public void getm12(Integer tt,Map<String, String> map) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.forEach(t -> map.put(t+"i", t+"a"));
	}
}
