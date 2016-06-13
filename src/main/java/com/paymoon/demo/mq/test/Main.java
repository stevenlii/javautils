package com.paymoon.demo.mq.test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
 
public class Main {
    public Main() throws Exception{
         
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
         
        Producer producer = new Producer("queue");
         
        for (int i = 0; i < 10; i++) {
            HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("Message Number "+ i +" sent.");
        }
    }
     
    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
      new Main();
    }
}