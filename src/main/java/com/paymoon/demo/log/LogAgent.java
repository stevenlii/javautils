/**   
 * @Title: UtilLog.java
 * @Package com.upyoo.agent.util
 * @Description: TODO
 * @author StevenLii  
 * @date 2015年1月25日 下午10:54:55
 * @version V1.0   
 */
package com.paymoon.demo.log;

import org.apache.log4j.Logger;

import com.paymoon.demo.Util.PropConf;

/**
 * @ClassName: UtilLog
 * @Description: TODO
 * @author lizhiqiang
 * @param <T>
 * @date 2015年1月25日 下午10:54:55
 * 
 */
public class LogAgent<T> {

	private static Logger logger = Logger.getLogger("common");

	public static void info(Logger logger, String message, Object... args) {

		String agentid = PropConf.getVariable("menu.npm.agentid", "non-User");
		String user = PropConf.getVariable("menu.npm.appkey", "non-User");

		logger.info(String.format("%s,%s,%s", user, agentid,
				String.format(message, args)));
	}
	/**
	 * @deprecated
	 * @param message
	 * @param args
	 */
	public static void info(String message, Object... args) {

		String agentid = PropConf.getVariable("menu.npm.agentid", "test");
		String user = PropConf.getVariable("menu.npm.appkey", "non-User");

		logger.info(String.format("%s,%s,%s", user, agentid,
				String.format(message, args)));
	}

	public static void info(Logger logger, String message) {

		String agentid = PropConf.getVariable("menu.npm.agentid", "test");
		String user = PropConf.getVariable("menu.npm.appkey", "non-User");

		logger.info(String.format("%s,%s,%s", user, agentid,
				String.format(message)));
	}
	/**
	 * @deprecated not Recommend
	 * @param message
	 * @param args
	 */
	
	public static void info(String message) {
		logger.info(message);
	}
	public void info(T t, String message) {
		LogAgent.info(t.getClass() + message);
	}
	public static void warn(Logger logger, String message, Object... args) {

		String agentid = PropConf.getVariable("menu.npm.agentid", "test");
		String user = PropConf.getVariable("menu.npm.appkey", "non-User");

		logger.warn(String.format("%s,%s,%s", user, agentid,
				String.format(message, args)));
	}

	public static void error(Logger logger, String message, Throwable t,
			Object... args) {
		String agentid = PropConf.getVariable("menu.npm.agentid", "test");
		String user = PropConf.getVariable("menu.npm.appkey", "non-User");

		// if(t == null){
		logger.error(String.format("%s,%s,%s", user, agentid,
				String.format(message, args)));
		// }
		// else{
		// logger.error(String.format("%s,%s,%s, %s",user,agentid,String.format(message,args)),
		// t);
		// }
	}

	public static void error(Logger logger, String message, Object... args) {
		String agentid = PropConf.getVariable("menu.npm.agentid", "test");
		String user = PropConf.getVariable("menu.npm.appkey", "non-User");

		logger.error(String.format("%s,%s,%s", user, agentid,
				String.format(message, args)));
	}
	public static void main(String[] args) {
		LogAgent.info("sdfasf");
	}
}
