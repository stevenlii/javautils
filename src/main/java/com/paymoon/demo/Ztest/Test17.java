package com.paymoon.demo.Ztest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.blueocn.mall.cargo.client.CargoHelper;

public class Test17 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		App u = new App();
		if (null == u || !(u.getAppNum().equals(null))) {
			logger.error("failed");
		}
		
	}
}
