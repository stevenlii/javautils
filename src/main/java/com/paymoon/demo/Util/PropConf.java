package com.paymoon.demo.Util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropConf {
	public static final String CONF = "/conf/";
	public static final String BIN = "/bin/";
	public static final String DATA = "/data/";
	public static final String LIB = "/lib/";
	private static Map propsCache=new HashMap();
	private static Log logger=LogFactory.getLog(PropConf.class);
	public static String getDir() {
		String bindir = System.getProperty("user.dir");
		if (bindir.indexOf("/bin") != -1) {
			bindir = bindir.substring(0,bindir.indexOf("/bin"));
		}else {
			bindir += "/target/classes";
		}
		return bindir;
	}
	public static String getProperty(String resourceName,String key,String defaultValue,Locale locale){
		String prefix=resourceName.substring(0,resourceName.lastIndexOf("."));
		String after=resourceName.substring(resourceName.lastIndexOf(".")+1,resourceName.length());
		String newResourceName=prefix+"_"+locale.getDisplayName()+"."+after;
		return getProperty(newResourceName,key,defaultValue);
	}
	public static String getProperty(String resourceName,String key,String defaultValue){
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
		PropConf utilProperties = new PropConf();
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

	        try {
	        	// the prop path here(support any path)
	            in = new FileInputStream(url+CONF+resourceName);
	            props.load(in);
	        } catch (Exception e) {
	        	try{
	        	in=utilProperties.getClass().getResourceAsStream("/"+resourceName);
	        	props.load(in);
	        	}catch(Exception e1){
	        		 throw e1;
	        	}
	        }
		}
		return props.getProperty(key);
	}
	public static String getProperty(String resourceName,String key){
		return getProperty(resourceName,key, "");
	}
	private static String fileArray[]=new String[]{"version.properties","runtime.local.properties","runtime.properties","sysconf.properties"};
	public static String getVariable(String key){
		for(int i=0;i<fileArray.length;i++){
			String value=null;;
			try {
				value = getPropertyInFile(fileArray[i],key);
				if(value!=null&&!"".equalsIgnoreCase(value))
					return value;
			} catch (Exception e) {
//				logger.error(e);
			}
			
		}
		return null;
	}
	public static String getVariable(String key,String defaultValue){
		for(int i=0;i<fileArray.length;i++){
			String value=null;;
			try {
				value = getPropertyInFile(fileArray[i],key);
				if(value!=null&&!"".equalsIgnoreCase(value))
					return value;
			} catch (Exception e) {
				if(!(e instanceof NullPointerException))
					logger.error(e);
			}
			
		}
		return defaultValue;
	}
	
}
