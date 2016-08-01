package com.paymoon.demo.mq.produce;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class ProducerMain {
	private static final Logger logger = LogManager.getLogger();

	public TopicProducer topicProducer = null;
    public ProducerMain() throws Exception{
    	  topicProducer = new TopicProducer();
    	
    	
    }
   public void createApp() { /**
		 * operate.task.task_0_newService
		 */
	   String username = "751674759";
		HashMap operateTaskMap = new HashMap();
		operateTaskMap.put("username", username);
		operateTaskMap.put("task", "task_0_newService");
		operateTaskMap.put("operator", username);
		try {
			logger.info("start to send MQ operate.task.task_0_newService.username:"+username);
			topicProducer.sendMessage("operate.task.task_0_newService", operateTaskMap);
		} catch (IOException e1) {
			logger.error(e1.getMessage());
		}}
   public void test1() { /**
    * operate.task.task_0_newService
    */
	   String username = "751674759";
	   HashMap operateTaskMap = new HashMap();
	   operateTaskMap.put("username", username);
	   operateTaskMap.put("task", "task_0_newService");
	   operateTaskMap.put("operator", username);
	   try {
		   logger.info("start to send MQ operate.task.task_0_newService.username:"+username);
		   topicProducer.sendMessage("user.password", operateTaskMap);
	   } catch (IOException e1) {
		   logger.error(e1.getMessage());
	   }}
   public void newUser() throws IOException {
  	 HashMap m=new HashMap();
       
       m.put("username", "912068025");
       m.put("role", "admin");
       m.put("owner", "912068025");
       m.put("invited", "584340895");
  	topicProducer.sendMessage("operate.task.task_0_invite", m);
   }
   public void newSmartQQ() throws IOException {
	   HashMap m=new HashMap();
	   
	   m.put("username", "912068025");
	   m.put("role", "admin");
	   m.put("owner", "912068025");
	   m.put("invited", "584340895");
	   topicProducer.sendMessage("alert.trigger.notification.qq.b", m);
   }
     
    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
//      new Main3().createApp();
      new ProducerMain().newSmartQQ();
    }
}