package com.paymoon.demo.Ztest;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymoon.demo.httpClient.NetUtil;

public class Test18 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		System.out.println(isVirginLogin("966786578", "a1e3a3e6-d577-4d28-a728-0bc2c3156db9", null));
//		postVirginLogin("966786578", "a1e3a3e6-d577-4d28-a728-0bc2c3156db9", null);
	}
	public static boolean isVirginLogin(String username, String token,String property) {
		/**
		 *  true means current user is virgin login 
		 *  false means other...
		 */
		boolean isVirginLogin = true;
//		String ucidUrl = "http://ci1.test.110monitor.com:28080/ucid/";
		String ucidUrl = "http://c.ci1.test.110monitor.com/ucid/";
		ucidUrl += "api/property/"+username+"/VIRGINLOGIN?UPYOO_TOKEN=" + token;
		ObjectMapper mapper = new ObjectMapper();
		try {
		JsonNode root = mapper.readTree(NetUtil.get(ucidUrl));
			String result = root.get("result").asText();
			JsonNode data = root.get("data");
			boolean propertyIsExit = data.hasNonNull("resource");
			if (StringUtils.isNotBlank(result) && result.equals("success") && propertyIsExit) 
				isVirginLogin = false;
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return isVirginLogin;
	}

	public static boolean postVirginLogin(String username, String token, String property) {
		String ucidUrl = "http://c.ci1.test.110monitor.com/ucid/";
		ucidUrl += "api/property/" + username + "/VIRGINLOGIN?UPYOO_TOKEN=" + token;
		NetUtil.post(null, ucidUrl);
		return false;
		}
}
