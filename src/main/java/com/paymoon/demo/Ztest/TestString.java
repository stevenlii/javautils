package com.paymoon.demo.Ztest;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * 
* @ClassName: TestAssert
* @Description: 用来测试Spring的Assert类
* @author lizhiqiang
* @date 2014年11月18日 下午12:32:14
*
 */
public class TestString {
	private static final Logger log = LogManager.getLogger();
	public static void main(String[] args) {
		
		TestString testString = new TestString();
		testString.charset("s");
	}
	
	public void charset(String name) {
		String str = "人民";
		String fmt = "the charset Str is: %s";
		try {
			byte[] b = str.getBytes();
//			String str2 = new String(b,"utf16");
			String str2 = new String(b,"utf8");
			System.out.println(String.format(fmt, str2));
			log.info("hh");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void format(String name) {
		String str = "人民";
		String fmt = "the charset Str is: %s";
		try {
			byte[] b = str.getBytes();
//			String str2 = new String(b,"utf16");
			String str2 = new String(b,"utf8");
			System.out.println(String.format(fmt, str2));
			log.info("hh");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
