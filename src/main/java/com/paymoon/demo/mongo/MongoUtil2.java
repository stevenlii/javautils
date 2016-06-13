package com.paymoon.demo.mongo;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.paymoon.demo.Util.MyProp;

public class MongoUtil2 {  
    private final static ThreadLocal<Mongo> mongos = new ThreadLocal<Mongo>();  
    public static DB getdb(){  
    	String mongoDBName = MyProp.getVariable("xxx.mongo.db", "testdb");
        try {
			return getMongos().getDB(mongoDBName);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;  
    }  
    public static Mongo getMongos() throws UnknownHostException {  
    	Mongo mongo = mongos.get();  
        if (mongo == null) {  
            try {  
            	String mongoIP = MyProp.getVariable("xxx.mongo.ip", "ci3.test.110monitor.com");
            	String mongoPort = MyProp.getVariable("xxx.mongo.port", "27017");
                mongo =new Mongo(mongoIP,Integer.valueOf(mongoPort));  
                mongos.set(mongo);  
            } catch (MongoException e) {  
                e.printStackTrace();  
            }  
        }  
        return mongo;  
    }  
    public static void close(){  
        Mongo mongo = mongos.get();  
        if(mongo!=null){  
            mongo.close();  
            mongos.remove();  
        }  
    }  
    /** 
     * 获取集合（表） 
     *  
     * @param collection 
     */
    public static DBCollection getCollection(String collection) {  
        return getdb().getCollection(collection);  
    }  
    /** 
     * 插入 
     *  
     * @param collection 
     * @param o 插入 
     *     
     */  
    public static void insert(String collection, DBObject o) {  
          
        getCollection(collection).insert(o);  
    }  
  
    /** 
     * 批量插入 
     *  
     * @param collection 
     * @param list 
     *            插入的列表 
     */  
    public void insertBatch(String collection, List<DBObject> list) {  
  
        if (list == null || list.isEmpty()) {  
            return;  
        }  
  
        getCollection(collection).insert(list);  
  
    }  
    /** 
     * 删除 
     *  
     * @param collection 
     * @param q 
     *            查询条件 
     */
    public void delete(String collection, DBObject q) {  
        getCollection(collection).remove(q);  
    }  
    /** 
     * 批量删除 
     *  
     * @param collection 
     * @param list 
     *            删除条件列表 
     */
    public void deleteBatch(String collection, List<DBObject> list) {  
        if (list == null || list.isEmpty()) {  
            return;  
        }  
        for (int i = 0; i < list.size(); i++) {  
            getCollection(collection).remove(list.get(i));  
        }  
    }  
    /** 
     * 更新 
     *  
     * @param collection 
     * @param q 
     *            查询条件 
     * @param setFields 
     *            更新对象 
     */
    public static void update(String collection, DBObject q, DBObject setFields) {  
        getCollection(collection).updateMulti(q,  
                new BasicDBObject("$set", setFields));  
    }  
    /** 
     * 查找集合所有对象 
     *  
     * @param collection 
     */
    public static List<DBObject> findAll(String collection) {  
        return getCollection(collection).find().toArray();  
    }  
    /** 
     * 按顺序查找集合所有对象 
     *  
     * @param collection 
     *            数据集 
     * @param orderBy 
     *            排序 
     */
    public static List<DBObject> findAll(String collection, DBObject orderBy) {  
        return getCollection(collection).find().sort(orderBy)  
                .toArray();  
    }  
    /** 
     * 查找（返回一个对象） 
     *  
     * @param collection 
     * @param q 
     *            查询条件 
     */
    public static DBObject findOne(String collection, DBObject q) {  
        return getCollection(collection).findOne(q);  
    }  
    /** 
     * 查找（返回一个对象） 
     *  
     * @param collection 
     * @param q 
     *            查询条件 
     * @param fileds 
     *            返回字段 
     */
    public static DBObject findOne(String collection, DBObject q, DBObject fileds) {  
        return getCollection(collection).findOne(q, fileds);  
    }  
    /** 
     * 分页查找集合对象，返回特定字段 
     *  
     * @param collection 
     * @param q 
     *            查询条件 
     * @param fileds 
     *            返回字段 
     * @pageNo 第n页 
     * @perPageCount 每页记录数 
     */
    public static List<DBObject> findLess(String collection, DBObject q, DBObject fileds, int pageNo,  
            int perPageCount) {  
        return getCollection(collection).find(q, fileds)  
                .skip((pageNo - 1) * perPageCount).limit(perPageCount)  
                .toArray();  
    }  
    public static void main(String[] args) {
    	insert("user",  
    			new BasicDBObject().append("name", "admin3").append("type", "2").append("score", 70)
				.append("level", 2).append("inputTime", new Date().getTime())); 
	}
    

}