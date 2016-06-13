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
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
 {
"app": "d1337d7f-9be7-d55b-57a1-f787f5791e5d",
"eventId": "12345",
"eventType": "trigger",
"alarmName": "FAILURE for production/HTTP on machine 192.168.0.253",
"entityName": "host-192.168.0.253",
"entityId": "host-192.168.0.253",
"priority": 1,
"alarmContent": {
"ping time": "2500ms",
"load avg": 0.75
}
}
 * @author yol
 *
 */
public class ReadWithScanner3 {

	public static void main(String... aArgs) throws IOException {
		String msg4Aliyun = readJson();
		Map<String, Object> dataMaps = new HashMap<>();
		Map<String, Object> maps = new HashMap<>();
		Map<String, Object> postMap = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		dataMaps = mapper.readValue(msg4Aliyun, Map.class);
		maps = viewJsonTree(dataMaps,maps);
		System.out.println("----------------");
		maps.get("expression");
		postMap.put("app", "0e229d34-6f77-9369-e00a-8034e9015561");
		//发生告警
		if (maps.get("levelDescription").equals("发生告警"))
			postMap.put("eventType", "trigger");
		
		StringBuilder alarmNameSB = new StringBuilder();
		//metricProject 云服务器名称/云服务器实例ID  levelDescription : metricName expression 

//		alarmNameSB.append(maps.get("metricProject"));
		String[] dimensionsArr = ((String)maps.get("dimensions")).split(",");
		String dimensionsName = dimensionsArr[0].substring(dimensionsArr[0].indexOf("=")+1, dimensionsArr[0].length());
		String dimensionsID = dimensionsArr[1].substring(dimensionsArr[1].indexOf("=")+1, dimensionsArr[1].length());
		String dimensionsIP = dimensionsArr[2].substring(dimensionsArr[2].indexOf("=")+1, dimensionsArr[2].length());
		alarmNameSB.append(dimensionsName);
		alarmNameSB.append("/");
		alarmNameSB.append(dimensionsID);
		alarmNameSB.append(maps.get("levelDescription"));
		alarmNameSB.append(":");
		alarmNameSB.append(maps.get("metricName"));
		alarmNameSB.append(maps.get("expression"));
		postMap.put("alarmName", alarmNameSB.toString());
		postMap.put("entityName", dimensionsID);
		postMap.put("entityId", dimensionsIP);
		postMap.put("priority", 1);
		
		StringBuilder alarmContentSB = new StringBuilder();
		//dimensions levelDescription metricName  在period 内出现 evaluationCount 次以上expression ，当前值为curValue unit 
		alarmContentSB.append(maps.get("dimensions"));
		alarmContentSB.append(" ");
		alarmContentSB.append(maps.get("levelDescription"));
		alarmContentSB.append(maps.get("metricName"));
		alarmContentSB.append(" 在");
		alarmContentSB.append(maps.get("period"));
		alarmContentSB.append("内出现 ");
		alarmContentSB.append(maps.get("expression"));
		alarmContentSB.append(" ");
		alarmContentSB.append(maps.get("evaluationCount"));
		alarmContentSB.append("次以上");
		alarmContentSB.append("，当前值为");
		alarmContentSB.append(maps.get("curValue"));
		alarmContentSB.append(maps.get("unit"));
		alarmContentSB.append("。");
		
		postMap.put("alarmContent", alarmContentSB.toString());
		postMap.put("host", dimensionsIP);
		postMap.put("service", maps.get("metricName"));
		
		StringBuilder preMd5Sb = new StringBuilder();
		preMd5Sb.append((String)maps.get("dimensions"));
		preMd5Sb.append(maps.get("metricName"));
		preMd5Sb.append(maps.get("expression"));
		preMd5Sb.append(maps.get("period"));
		postMap.put("eventId", com.paymoon.demo.io2.Rpid.generateWithMD5(preMd5Sb.toString()));
		System.out.println(postMap.get("eventId"));
		PostAlertEventAPI.push2HubSpot(postMap,"http://ci3.test.110monitor.com:28080/engine/api/event");
		Set<Map<String, String>> set = new HashSet<>();
		 Iterator it=postMap.keySet().iterator();
		 while(it.hasNext()){
			 Object key=it.next();
			 Object value=postMap.get(key);
			 
			 System.out.println(String.format("%s: %s",key,value));
			
		 }
		
	}

	private static String readJson() {
		StringBuilder sb = new StringBuilder();
		try (Scanner scanner = new Scanner(Paths.get("/Users/yol/Downloads/alijson2"), StandardCharsets.UTF_8.toString())) {
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