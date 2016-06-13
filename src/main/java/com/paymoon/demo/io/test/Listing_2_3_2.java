package com.paymoon.demo.io.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 递归树下的文件
 * @author yol
 *
 */
public final class Listing_2_3_2 {
	private static Logger logger = LogManager.getLogger(Listing_2_3_2.class);

	public static void main(String[] args) throws IOException {
		Path listing = Paths.get("/Users/yol/software/testwk/agent-alert").normalize();
//		logger.info("listing.getFileName():{}",listing.getFileName());

		Files.walkFileTree(listing, new FildJavaVisitor());
		
	}
	/**
	 * @author yol
	 *
	 */
	private static class FildJavaVisitor extends SimpleFileVisitor<Path>{

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			if (file.toString().endsWith(".java")) {
				
				System.out.println(file.toAbsolutePath());
			}
			return FileVisitResult.CONTINUE;
		}
		
	}
}