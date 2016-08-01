package com.paymoon.demo.mq.consumer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
 
public class Main3 {
    public Main3() throws Exception{
         
    	TopicConsumer consumer = new TopicConsumer();
    	consumer.init("operate.task.task_0_invite", "operate.user.new.queue");
    	Thread consumerThread  = new Thread(consumer);
    	consumerThread.start();
    }
     
    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
      new Main3();
    }
}