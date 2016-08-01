package com.paymoon.demo.mq.consumer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
 
public class ConsumerMain {
    public ConsumerMain() throws Exception{
         
    	TopicConsumer consumer = new TopicConsumer();
    	consumer.init("alert.trigger.notification.qq.b", "alert.trigger.notification.qq.b.send");
    	Thread consumerThread  = new Thread(consumer);
    	consumerThread.start();
    }
     
    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
      new ConsumerMain();
    }
}