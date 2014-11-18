package com.paymoon.demo.Ztest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Assert;
/**
 * 
* @ClassName: TestAssert
* @Description: 用来测试Spring的Assert类
* @author lizhiqiang
* @date 2014年11月18日 下午12:32:14
*
 */
public class TestAssert {
	private static final Logger log = LogManager.getLogger();
	public static void main(String[] args) {
		new TestAssert().run(null);
		
	}
	
	public void run(String name) {
		try {
			Assert.notNull(name);
		} catch (IllegalArgumentException  e) {
			log.error(e);
			
		}
	}
}
