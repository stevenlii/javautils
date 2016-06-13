package com.paymoon.demo.io.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * java 7 创建文件并分配读写权限
 * 
 * @author paymoon.com
 *
 */
public final class Listing_2_4_2_readAttr {
	private static Logger logger = LogManager.getLogger(Listing_2_4_2_readAttr.class);

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("/Users/yol/Desktop/444.html");
		BasicFileAttributes attr;
		try {
			attr = Files.readAttributes(path, BasicFileAttributes.class);
			System.out.println("Creation time: " + attr.creationTime());
			System.out.println("Last access time: " + attr.lastAccessTime());
			System.out.println("Last modified time: " + attr.lastModifiedTime());
			System.err.println();
			Map f  = Files.readAttributes(path, "*");

	        System.out.println(f);
		} catch (IOException e) {
			System.out.println("oops un error! " + e.getMessage());
		}
	}
}