package com.paymoon.demo.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 操作properties 文件，读写操作 不改变文件结构和顺序
 * 
 * @author wangcy
 *
 */
public class PropertiesUtil {

	private static String PFILE = "runtime.properties";

	public static void modify(String key, String value) throws IOException {
		write(PFILE, key, value);
	}
	/**
	 * 
	 * @param filename
	 * @param key 
	 * @param value
	 * @throws IOException
	 */
	public static void write(String filename, String key, String value)
			throws IOException {

		boolean exsitKey = false;

		List<String> t = readFileByLines(filename);
		StringBuffer sb = new StringBuffer();
		for (String str : t) {
			if (!str.startsWith("#") && str.startsWith(key)) {
				exsitKey = true;
				str = str.substring(0, str.indexOf("=") + 1) + value;
			}
			sb.append(str).append("\n");
		}
		if (!exsitKey) {
			sb.append(key).append("=").append(value).append("\n");
		}

		appendMethodB(filename, sb.toString());

	}

	/**
	 * B方法追加文件：使用FileWriter
	 * 
	 * @throws IOException
	 */
	public static void appendMethodB(String fileName, String content)
			throws IOException {
		// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
		FileWriter writer = new FileWriter(fileName, false);
		writer.write(content);
		writer.close();

	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	public static List readFileByLines(String resourceName) {
		List strs = new ArrayList();

		File file = new File(resourceName);
		BufferedReader reader = null;
		try {
			// System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				strs.add(tempString);
				// System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return strs;
	}

	private static String getFile(String resourceName) {
		// ClassLoader loader=null;
		// if (loader == null) {
		// try {
		// loader = Thread.currentThread().getContextClassLoader();
		// } catch (SecurityException e) {
		// loader = PropertiesUtil.class.getClassLoader();
		// }
		// }
		//
		// URL url=loader.getSystemResource(resourceName);

		// System.out.printf("!!!!!!!!!!!"+url.getFile());
		return PropConf.getDir() + PropConf.CONF + resourceName;
	}

	public static void main(String s[]) {

		/*
		 * User u1 = new User(); u1.setPppp("20"); //u1.setName("wwwwwwww");
		 * User u2 = new User(); u2.setPppp("qqq20");
		 * //u2.setName("qqqwwwwwwww"); List l = new ArrayList(); l.add(u1);
		 * l.add(u2); //JSONArray js = JSONArray.fromObject(l) ;
		 * 
		 * Map m = new HashMap(); m.put("qqq", "ppp"); m.put("qqq2", "ppp2");
		 * Map m2 = new HashMap(); m2.put("qqq", "ppp"); m2.put("qqq22",
		 * "ppp22");
		 * 
		 * l.add(m2); l.add(m);
		 * 
		 * JSONObject object = JSONObject.fromObject(m); String
		 * str=object.toString(); //Map m = new HashMap(); //m.put("map123", l);
		 * JSONArray js = JSONArray.fromObject(l) ;
		 */

		// System.out.println(js);
		// modify("menu.npm.agentid","http://ppppppppppppppp123");

		// readFileByLines(PFILE);

	}

}
