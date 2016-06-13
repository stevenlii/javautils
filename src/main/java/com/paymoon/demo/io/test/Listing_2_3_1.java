package com.paymoon.demo.io.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 当前目录下的文件
 * @author yol
 *
 */
public final class Listing_2_3_1 {
	private static Logger logger = LogManager.getLogger(Listing_2_3_1.class);

	public static void main(String[] args) {
		Path listing = Paths.get("/Users/yol/software/testwk/agent-alert").normalize();
//		logger.info("listing.getFileName():{}",listing.getFileName());

		try(DirectoryStream<Path> stream = Files.newDirectoryStream(listing,"*.java")){
			StringBuilder sb = new StringBuilder();
			for (Path entry:stream){
				System.out.println(entry.toAbsolutePath());
				System.out.println(entry.getFileName().toAbsolutePath());
				sb.append("源代码："+entry.getFileName());
				Scanner scanner = new Scanner(entry.toAbsolutePath());
				while (scanner.hasNext()) {
					
					sb.append("\r\n");
					 sb.append(scanner.next());
				}
			}
			System.out.println(sb.toString());
		}catch (IOException e) {
			System.out.println("ERR");
		}
		
	}
}