package com.paymoon.demo.io2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymoon.demo.Util.Rpid;
import com.paymoon.demo.httpClient.PostAlertEventAPI;

/** Assumes UTF-8 encoding. JDK 7+. */
/**
 * Java Practices -> Reading and writing text files
http://www.javapractices.com/topic/TopicAction.do?Id=42
 * @author yol
 *
 */
/**
 *
 *
{"result":"success","message":null,"data":[{"accountendpoint":"http://1412580518114250.mns.cn-beijing.aliyuncs.com","mnsAccesskeyId":"Jkyctl1JLRkQWNgV","mnsAccesskeySecret":"noc1dwMsrRY0o3n1vVFczOHd1v6bjG","appkey":"111111","queue":"myfirstqueue","status":null,"deleted":null,"remark":null,"timestamp":null}],"totalCount":0,"code":"200"}
 * @author yol
 *
 */
public class ReadWithScannerAliyunUserInfo {

	public static void main(String... aArgs) throws IOException {
		String msg4Aliyun = readJson();
		Map<String, Object> dataMaps = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		dataMaps = mapper.readValue(msg4Aliyun, Map.class);
		
		List<Map<String, String>> lists = new ArrayList<>();
		lists = (ArrayList<Map<String, String>>)dataMaps.get("data");
        for (int i = 0; i < lists.size(); i++) {
    		Map<String, String> maps = new HashMap<>();
    		maps = lists.get(i);
    		System.out.println("aaaaaaaaaaaaa");
    		for (String key : maps.keySet()) {
				System.out.println("key>>"+key +" value>>"+maps.get(key));
				
			}

        }
	}

	private static String readJson() {
		StringBuilder sb = new StringBuilder();
		try (Scanner scanner = new Scanner(Paths.get("/Users/yol/Downloads/alijson3"), StandardCharsets.UTF_8.toString())) {
			while (scanner.hasNextLine()) {
//				System.out.println(scanner.nextLine());
				sb.append(scanner.nextLine());
				sb.append("\n");
			}
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Map<String, Object> viewJsonTree(Object m,Map<String, Object> rtnMap){
		if (m == null) {
			System.out.println("over...");
			return null;
		}
	    	try {
	    		Map mp = null;
	    		List ls = null;
	    		if(m instanceof Map || m instanceof LinkedHashMap){
	    			mp = (LinkedHashMap)m;
	    			for(Iterator ite = mp.entrySet().iterator(); ite.hasNext();){  
	    				Map.Entry e = (Map.Entry) ite.next();  
	    				
	    				if(e.getValue() instanceof String){
	    					System.out.println("[String]"+e.getKey()+" | " + e.getValue());
	    					rtnMap.put(String.valueOf(e.getKey()), e.getValue());
	    				}else if(e.getValue() instanceof LinkedHashMap){
	    					System.out.println("{Map}"+ e.getKey()+" | "+e.getValue());
	    					rtnMap.putAll(viewJsonTree((LinkedHashMap)e.getValue(),rtnMap));
	    				}else if(e.getValue() instanceof ArrayList){
	    					System.out.println("[Array]"+ e.getKey()+" | "+e.getValue());
	    					rtnMap.putAll(viewJsonTree((ArrayList)e.getValue(),rtnMap));
	    				}else if(e.getValue() instanceof Integer) {
	    					System.out.println("[Integer]"+e.getKey()+" | " + e.getValue());
	    					rtnMap.put(String.valueOf(e.getKey()), e.getValue());
	    				}else if(e.getValue() instanceof Long) {
	    					System.out.println("[Long]"+e.getKey()+" | " + e.getValue());
	    					rtnMap.put(String.valueOf(e.getKey()), e.getValue());
	    				}else if(e.getValue() instanceof Double) {
	    					System.out.println("[Double]"+e.getKey()+" | " + e.getValue());
	    					rtnMap.put(String.valueOf(e.getKey()), e.getValue());
	    				}
	    			}     
	    		}
	    		if(m instanceof List || m instanceof ArrayList){
	    			ls = (ArrayList)m;
	    			for(int i=0;i<ls.size();i++){
	    				if(ls.get(i) instanceof LinkedHashMap){
	    					rtnMap.putAll(viewJsonTree((LinkedHashMap)ls.get(i),rtnMap));
	    				}else if(ls.get(i) instanceof ArrayList){
	    					rtnMap.putAll(viewJsonTree((ArrayList)ls.get(i),rtnMap));
	    				}   
	    			}
	    		}   
//	    		System.out.println();
	    	} catch (Exception e) {
//	    		System.out.println("###[Error] viewJsonTree() "+e.getMessage());
	    	}
	    	return rtnMap;
	    }
	
}