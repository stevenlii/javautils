package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test23 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		
		String aaString  = "price_center_t_type_cost_price";
		String database = "price_center_";
		String tableString = StringUtils.substring(aaString, database.length());
		System.out.println(tableString);
		String tableString2 = StringUtils.substring(aaString, aaString.lastIndexOf("price_center_"));
		System.out.println(tableString2);
	}
	
}
