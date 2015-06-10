package com.paymoon.demo.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.io.BufferedRW;

public class logtest {
	private static Logger logger = LogManager.getLogger(logtest.class);
	public static void main(String[] args) {
		logger.entry();  
        logger.info("Hello, World! {}","hello");   
        logger.exit();  
	}

}
