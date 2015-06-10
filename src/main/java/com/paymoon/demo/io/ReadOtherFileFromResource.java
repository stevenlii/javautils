package com.paymoon.demo.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.Util.PropConf;


public class ReadOtherFileFromResource {
	private static Logger logger = LogManager.getLogger(ReadOtherFileFromResource.class);

	public static String readIpString(String pathname,
			String prePath) {
		
		List<String> list = new ArrayList<String>();
		// 加载读取resource 下面的文件
		InputStream csvread = ReadOtherFileFromResource.class.getClass().getResourceAsStream(
				"/iplist");
		// FileInputStream csvread = new
		BufferedReader csvReader = null;
		
		try {

			csvReader = new BufferedReader(new InputStreamReader(
					csvread, "utf-8"), 1024);
			String s = "";
			// 随机读取iplist下的文件, 文件内容 www.baidu.com,www.dangdang.com,www.csdn.net

			Random random = new Random();
			while ((s = csvReader.readLine()) != null) {
				String[] ips = s.split(",");
				int i = random.nextInt(ips.length);
				String ip = ips[i];
				return ip;
			}
		} catch (UnsupportedEncodingException e) {
			LogAgent.error(logger, "UnsupportedEncodingException %s", e.getMessage());
		} catch (FileNotFoundException e) {
			LogAgent.error(logger, "File: %s NotFound, filepath: %s", "iplist", prePath+pathname);
		} catch (IOException e) {
			LogAgent.info(logger, "iplist IOException %s, maybe is not a right fmt iplist[ip,ip,ip]", e.getMessage());
		}
		return "ipisnotset";

	}
	public static List<String> readIpList(String pathname,
			String prePath) {
		List<String> list = new ArrayList<String>();
		while (true) {
		String ip = ReadOtherFileFromResource.readIpString(pathname, prePath);
		
			if (null != ip && "".equals(ip)) {
				list.add(ip);
			}else if(ip.equals("ipisnotset")){
				list.add("180.149.132.47");
			}
			if (list.size() == 2) 
			break;
		}
		return list;
	}

public static void main(String[] args) {
	System.out.println(ReadOtherFileFromResource.readIpList("iplilst",PropConf.getDir()+PropConf.CONF));

}
}
