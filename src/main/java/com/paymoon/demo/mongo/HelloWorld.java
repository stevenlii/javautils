package com.paymoon.demo.mongo;

import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * Java + MongoDB Hello world Example
 * 
 */
public class HelloWorld {
  public static void main(String[] args) {

    mgrun();

  }

private static void mgrun() {
	try {

	/**** Connect to MongoDB ****/
	// Since 2.10.0, uses MongoClient
//	MongoClient mongo = new MongoClient("123.57.39.109");
	MongoClient mongo = new MongoClient("ci3.test.110monitor.com");

	/**** Get database ****/
	// if database doesn't exists, MongoDB will create it for you
	DB db = mongo.getDB("testdb");

	/**** Get collection / table from 'testdb' ****/
	// if collection doesn't exists, MongoDB will create it for you
	DBCollection table = db.getCollection("user");

	/**** Insert ****/
	// create a document to store key and value
	
	
//	BasicDBObject document = new BasicDBObject();
//	document.put("name", "mkyong");
//	document.put("age1", 30);
//	document.put("createdDate2", new Date());
//	table.insert(document);

	/**** Find and display ****/
	BasicDBObject searchQuery = new BasicDBObject();
//	searchQuery.put("name", "mkyong");

	DBCursor cursor = table.find(searchQuery);

	while (cursor.hasNext()) {
		System.out.println(cursor.next());
	}

	/**** Update ****/
	// search document where name="mkyong" and update it with new values
	
//	BasicDBObject query = new BasicDBObject();
//	query.put("name", "mkyong");
//
//	BasicDBObject newDocument = new BasicDBObject();
//	newDocument.put("name", "mkyong-updated");
//
//	BasicDBObject updateObj = new BasicDBObject();
//	updateObj.put("$set", newDocument);
//	
//
//	table.update(query, updateObj);

	/**** ???Find and display ****/
	BasicDBObject searchQuery2 
	    = new BasicDBObject().append("name", "mkyong-updated");

	DBCursor cursor2 = table.find(searchQuery2);

	while (cursor2.hasNext()) {
		System.out.println(cursor2.next());
	}

	/**** Done ****/
	System.out.println("Done");
	System.exit(0);
    } catch (MongoException e) {
	e.printStackTrace();
    }
}
}