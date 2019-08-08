package com.chen.demo;
 
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class Test3 {
	
	public static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
	public static BlockingQueue<String> myQueue = new LinkedBlockingQueue<>(800);

	public static Object obj = new Object();
	public static int MAX = 500;
	public static int MIN = 1;
	public static int count = 0;
	public static Test3 test = new Test3();
	static ThreadPoolExecutor executor = null;
	ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
	public static int MAXPOOLSIZE = 8;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread w1 = new Thread(test.new Write());
		w1.start();
		executor = new ThreadPoolExecutor(10, 10, 60*1000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(10));
		for(int i = 0;i<3;i++){
			executor.execute(test.new Read());
		}
	}
	
	public class Write implements Runnable{
 
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				if(myQueue.size() > MAX){
					System.out.println("超过最大存储，待读取...........");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
				String uuid = UUID.randomUUID().toString();
				try {
					for (int i = 0; i < 1000; i++) {
						myQueue.put(uuid+"_"+i);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public class Read implements Runnable{
 
		@Override
		public void run() {
			String tName = Thread.currentThread().getName();
			// TODO Auto-generated method stub
			Long start = System.currentTimeMillis();
			while(true){
				if(myQueue.size() < MIN){
					System.out.println("等待写入..........");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
				if(executor.getActiveCount() >= MAXPOOLSIZE){
					System.out.println("等待任务处理完毕++++++++::::"+tName);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
				try {
					String takeIdString = myQueue.take();
					System.out.println(tName+"读取:"+takeIdString);
					System.out.println("已完成任务"+count++);
				} catch (InterruptedException e) {
				}
				
			}
		}
		
	}
	
	public class Del implements Runnable{
		private String value;
		public Del(String value){
			this.value = value;
		}
		@Override
		public void run() {
			try {
				System.out.println("-------------------------------------------------处理中:"+this.value);
				Thread.sleep(2000);
				System.out.println("-------------------------------------------------处理完毕:"+this.value);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			
		}
		
	}
}