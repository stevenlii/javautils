package com.paymoon.demo.io.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * java 7 创建文件并分配读写权限
 * @author paymoon.com
 *
 */
public final class Listing_2_4_1 {
	private static Logger logger = LogManager.getLogger(Listing_2_4_1.class);

	public static void main(String[] args) throws IOException {
		Path targetFile = Paths.get("/Users/yol/Desktop/create.demo").normalize();
		Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw-");
		FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
		Files.createFile(targetFile, attr);
	}
}