package com.paymoon.demo.mq.delExchange;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paymoon.demo.Util.MyProp;
 
public class DelMQ {
    public DelMQ() throws Exception{
         
    	TopicDeleted topicProducer = new TopicDeleted();
    	List<String> exchangesNames = new ArrayList<>();
    	List<String> QNames = new ArrayList<>();
    	String SYSCONF="sysconf_operation.properties";
    	for (int i = 0; i < 50; i++) {
    		String prefix="mq.topic";
    		String topic=MyProp.getProperty(SYSCONF, prefix+"."+i);
    		if(topic==null||"".equalsIgnoreCase(topic))
    			continue;
    		
    			String Q=MyProp.getProperty(SYSCONF, prefix+"."+i+".queue.0");
    			if(Q==null||"".equalsIgnoreCase(Q))
        			continue;
    			
    			QNames.add(Q);
    		exchangesNames.add(topic);
		}
    	topicProducer.delExchangeName(exchangesNames,QNames);
    	
    }
     
    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
      new DelMQ();
    }
}