package com.paymoon.demo.Ztest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test44 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		String str = "E7\\x94\\x9C\\xE7\\x8E\\x89\\xE7\\xB1\\xB3";
		System.out.println();
		MyUrlDeCode(str);
		String str2 = "甜玉米";
		MyUrlDeCode2(str2);
		System.out.println((int)Math.ceil((double)22 / 20));
		 String companyIdStr = "70125185";
	        String sub = companyIdStr.substring(companyIdStr.length() - 2, companyIdStr.length() - 1);
	        Integer num = Integer.valueOf(sub);
	        boolean numIsEven = num % 2 == 0;
	        if (!numIsEven) {
	            System.out.println(false);
	        }	
	   }

	public static String MyUrlDeCode(String str) {
		String[] bytesStr = str.split("\\\\x");
		StringBuffer sBuffer = new StringBuffer();
		byte[] bytes = new byte[bytesStr.length];
		for (int i = 0; i < bytesStr.length; i++) {
			sBuffer.append(bytesStr[i]);
		}
		String string16 = sBuffer.toString();
		//E7949CE78E89E7B1B3
		try {
			System.out.println(ByteUtils.fromHexString(string16));
		} catch (Exception e) {
		}
		return null;

	}
	public static String MyUrlDeCode2(String str) {
		System.out.println(ByteUtils.str2HexStrNginx(str));;
		return null;
		
	}
}
