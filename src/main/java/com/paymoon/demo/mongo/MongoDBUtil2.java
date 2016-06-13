package com.paymoon.demo.mongo;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.paymoon.demo.Util.MyProp;
import com.mongodb.WriteConcern;

/**
 * MongoDB工具类 Mongo实例代表了一个数据库连接池，即使在多线程的环境中，一个Mongo实例对我们来说已经足够了<br>
 * 注意Mongo已经实现了连接池，并且是线程安全的。 <br>
 * 设计为单例模式， 因 MongoDB的Java驱动是线程安全的，对于一般的应用，只要一个Mongo实例即可，<br>
 * Mongo有个内置的连接池（默认为10个） 对于有大量写和读的环境中，为了确保在一个Session中使用同一个DB时，<br>
 * DB和DBCollection是绝对线程安全的<br>
 *
 * @author zhoulingfei
 * @date 2015-5-29 上午11:49:49
 * @version 0.0.0
 * @Copyright (c)1997-2015 NavInfo Co.Ltd. All Rights Reserved.
 */
public enum MongoDBUtil2 {
	/**
	 * 定义一个枚举的元素，它代表此类的一个实例
	 */
	instance;
	private MongoClient mongoClient;

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	static {
		System.out.println("===============MongoDBUtil初始化========================");
		CompositeConfiguration config = new CompositeConfiguration();
		try {
			String mongoIP = MyProp.getVariable("xxx.mongo.ip", "ci3.test.110monitor.com");
        	String mongoPort = MyProp.getVariable("xxx.mongo.port", "27017");
			config.addConfiguration(new PropertiesConfiguration("mongodb.properties"));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		// 从配置文件中获取属性值
		String ip = config.getString("host");
		int port = config.getInt("port");
		instance.mongoClient = new MongoClient(ip, port);
		// or, to connect to a replica set, with auto-discovery of the primary,
		// supply a seed list of members
		// List<ServerAddress> listHost = Arrays.asList(new
		// ServerAddress("localhost", 27017),new ServerAddress("localhost",
		// 27018));
		// instance.mongoClient = new MongoClient(listHost);
		// 大部分用户使用mongodb都在安全内网下，但如果将mongodb设为安全验证模式，就需要在客户端提供用户名和密码：
		// boolean auth = db.authenticate(myUserName, myPassword);
		Builder options = new MongoClientOptions.Builder();
		// options.autoConnectRetry(true);// 自动重连true
		// options.maxAutoConnectRetryTime(10); // the maximum auto connect
		// retry time
		options.connectionsPerHost(300);// 连接池设置为300个连接,默认为100
		options.connectTimeout(15000);// 连接超时，推荐>3000毫秒
		options.maxWaitTime(5000); //
		options.socketTimeout(0);// 套接字超时时间，0无限制
		options.threadsAllowedToBlockForConnectionMultiplier(5000);// 线程队列数，如果连接线程排满了队列就会抛出“Out
																	// of
																	// semaphores
																	// to get
																	// db”错误。
		options.writeConcern(WriteConcern.SAFE);//
		options.build();
	}
}