package com.paymoon.demo.io.test;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Listing_2_1 {
	private static Logger logger = LogManager.getLogger(Listing_2_1.class);

	public static void main(String[] args) {
		Path listing = Paths.get("/Users/yol").normalize();
		logger.info("listing.getFileName():{}",listing.getFileName());
		logger.info("num:{}",listing.getNameCount());
		logger.info("getFileSystem:{}",listing.getFileSystem());
		logger.info("getParent:{}",listing.getParent());
		logger.info("getRoot:{}",listing.getRoot());
		
		
	}
}