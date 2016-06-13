package com.paymoon.demo.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilprotocol {
	public static Map afterUDPClient(List<Map> returnList) {
		Map rtnMap = new HashMap();
		int num = 0;
		int numOK = 0;
		int numOUT = 0;
		long timeCosts = 0;//(total time)
		long timeCostsOK = 0;//(total OK time)
		boolean timeoutALL =true;//默认连不通
		int timeoutCount = 0;
		long min=-1;
		long max=-1;
		long avg=-1;
		long mdev=-1;
		
		String url = "";
		String type = "";
		for (Map map : returnList) {
			
			url = (String) map.get(Dict.URL);
			type = (String) map.get(Dict.TYPE);
			
			
			boolean timeout_UDP = (Boolean)map.get(Dict.UDP_TIME_OUT);//超时
			
			long timeCost = (Long)map.get(Dict.UDP_COST_TIME);//响应时间()
			timeCosts += timeCost;//响应总时间
			
			if (timeout_UDP) {
				numOUT++;
				timeoutCount++;
			}else {
				numOK ++;
				timeCostsOK += timeCost;
			}
			
			
			if (min == -1) {
				min = timeCostsOK;
			}
			if (timeCostsOK > max) {
				max = timeCostsOK;
			}
			if (timeCostsOK < min) {
				min = timeCostsOK;
			}
			
		}
		
		num = returnList.size();//发包总数
		
		
		if (timeoutCount != num) {
			timeoutALL = false;//通了
		}
		System.out.println("--- " + url +" "+ type +" statistics ---");
		String protocolMsg = "";
		String protocolMsgRespTime = "";
		if (timeoutALL) {
			 protocolMsg = num
					+ " packets transmitted, 0 received, 100% packet loss, time "
					+ UtilTransfer.nano2Ms(timeCosts) + "ms";
				protocolMsgRespTime = "rtt min/avg/max/mdev = -1/-1/-1/-1 ms";

			// 连不通
			System.out
					.println(protocolMsg);
		} else {
			
			avg = timeCostsOK/numOK;
			mdev = max - min;
			protocolMsg = num + " packets transmitted, " + numOK
					+ " received, " + ((double)numOK/(double)num)*100 + "% packet loss, time " + UtilTransfer.nano2Ms(timeCostsOK)
					+ "ms";
			protocolMsgRespTime = "rtt min/avg/max/mdev = "+UtilTransfer.nano2Ms(min,3)+"/"+UtilTransfer.nano2Ms(avg,3)+"/"+UtilTransfer.nano2Ms(max,3)+"/"+UtilTransfer.nano2Ms(mdev,3)+" ms";
			System.out.println(protocolMsg);
			System.out.println(protocolMsgRespTime);
		}
		rtnMap.put(Dict.UDP_TIME_OUT, timeoutALL);
		rtnMap.put(Dict.PROTOCOL_MESSAGE_PACKET_LOSS_PERCENT, protocolMsg);
		
		return rtnMap;
	}
}
