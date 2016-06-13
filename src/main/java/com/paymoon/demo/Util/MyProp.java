package com.paymoon.demo.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class MyProp {
	public static final String CONF = "/conf/";
	public static final String BIN = "/bin/";
	public static final String DATA = "/data/";
	public static final String LIB = "/lib/";
	private static Map propsCache=new HashMap();
	public static String getDir() {
		String bindir = System.getProperty("user.dir");
		if (bindir.indexOf("/bin") != -1) {
			bindir = bindir.substring(0,bindir.indexOf("/bin"));
		}else {
			bindir += "/target/classes";
		}
		return bindir;
	}
	/**
	 * lizq
	 * @param filename (path/filename)
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

		appendContent(filename, sb.toString());

	}
	/**
	 * B方法追加文件：使用FileWriter
	 * 
	 * @throws IOException
	 */
	private static void appendContent(String fileName, String content)
			throws IOException {
		// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
		FileWriter writer = new FileWriter(fileName, false);
		writer.write(content);
		writer.close();

	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	private static List readFileByLines(String resourceName) {
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
	private static String getProperty(String resourceName,String key,String defaultValue,Locale locale){
		String prefix=resourceName.substring(0,resourceName.lastIndexOf("."));
		String after=resourceName.substring(resourceName.lastIndexOf(".")+1,resourceName.length());
		String newResourceName=prefix+"_"+locale.getDisplayName()+"."+after;
		return getProperty(newResourceName,key,defaultValue);
	}
	private static String getProperty(String resourceName,String key,String defaultValue){
		try {
			String value=getPropertyInFile(resourceName,key);
			if(value!=null&&!"".equalsIgnoreCase(value))
				return value;
			return defaultValue;
		} catch (Exception e) {
//			logger.error(e);
			return defaultValue;
		}
	}
	private static String getPropertyInFile(String resourceName,String key) throws Exception{
	        
		Properties props=(Properties)propsCache.get(resourceName);
		MyProp utilProperties = new MyProp();
		if(props==null){
			props = new Properties();
			ClassLoader loader=null;
			if (loader == null) {
	            try {
	                loader = Thread.currentThread().getContextClassLoader();
	            } catch (SecurityException e) {
	                loader = utilProperties.getClass().getClassLoader();
	            }
	        }
			
			String url=getDir();
			InputStream in = null;
			Reader reader = null;
	        try {
//	            in = new FileInputStream(url+CONF+resourceName);
//	            in = new FileInputStream(url+resourceName);
	            reader = new InputStreamReader(in, "UTF-8");
	            props.load(reader);
	        } catch (Exception e) {
	        	try{
	        	in=utilProperties.getClass().getResourceAsStream("/"+resourceName);
	        	 reader = new InputStreamReader(in, "UTF-8");
		         props.load(reader);
	        	}catch(Exception e1){
	        		 throw e1;
	        	}
	        }
		}
		propsCache.put(resourceName, props);
		return props.getProperty(key);
	}
	public static String getProperty(String resourceName,String key){
		return getProperty(resourceName,key, "");
	}
	private static String fileArray[]=new String[]{"version.properties","db.properties","runtime.properties","sysconf.properties","common.properties"};
	public static String getVariable(String key){
		for(int i=0;i<fileArray.length;i++){
			String value=null;;
			try {
				value = getPropertyInFile(fileArray[i],key);
				if(value!=null&&!"".equalsIgnoreCase(value))
					return StringUtils.trim(value);
			} catch (Exception e) {
				if (null != e.getMessage() && !e.getMessage().equals("null")) 
					System.out.println(e.getMessage());
			}
			
		}
		return null;
	}
	public static String getVariable(String key,String defaultValue){
		for(int i=0;i<fileArray.length;i++){
			String value=null;;
			try {
//				value = redis.clients.jedis.get();
				if (value == null || "".equalsIgnoreCase(value))
					value = getPropertyInFile(fileArray[i],key);
				if(value!=null&&!"".equalsIgnoreCase(value))
					return StringUtils.trim(value);
			} catch (Exception e) {
				if(!(e instanceof NullPointerException))
					System.out.println(e.getMessage());
			}
			
		}
		return StringUtils.trim(defaultValue);
	}
	public static String getVariable(String file,String key,String defaultValue){
			String value=null;;
			try {
				value = getPropertyInFile(file,key);
				if(value!=null&&!"".equalsIgnoreCase(value))
					return StringUtils.trim(value);
			} catch (Exception e) {
				if(e instanceof NullPointerException)
					System.out.println("file is not exit "+file);
				else 
					System.out.println("MyProp Exception:"+e.getMessage());
			}
			
		return StringUtils.trim(defaultValue);
	}
	
}