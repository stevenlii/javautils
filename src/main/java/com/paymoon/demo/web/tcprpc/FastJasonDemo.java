/**   
* @Title: HelloWorld.java
 * @Package com.paymoon.demo.web
 * @Description: test序列化 fastjason
 * @author StevenLii  
* @date 2014年11月19日 下午11:01:24
 * @version V1.0   
*/
package com.paymoon.demo.web.tcprpc;

import com.alibaba.fastjson.JSON;
import com.paymoon.demo.vo.Person;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * @ClassName: FastJasonDemo
 * @Description: TODO
 * @author StevenLii
 * @date 2014年11月19日 下午11:01:24
 * 
 */
public class FastJasonDemo{
	public String  seri2json() {
		Person person = new Person("steven", "25", "mail", "175", "LYU");
		String jsonString = JSON.toJSONString(person);
		return jsonString;

	}
	public Person  unSeri2json(String jsonString) {
		Person vo = JSON.parseObject(jsonString, Person.class);
		return vo;
	}
	public String  seri2xml() {
		Person person = new Person("steven", "25", "mail", "175", "LYU");
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("person", Person.class);
		
		String xmlString = xStream.toXML(person);
		return xmlString;
		
	}
	public Person  unSeri2xml(String xmlString) {
		XStream xStream = new XStream();
		//这句话得有
		xStream.alias("person", Person.class);

		Person vo = (Person)xStream.fromXML(xmlString);
		return vo;
	}
	
	public static void main(String[] args) {
		FastJasonDemo fastJasonDemo = new FastJasonDemo();
		String jsonString = fastJasonDemo.seri2json();
		System.out.println("seri resutl");
		System.out.println(jsonString);
		Person voPerson = fastJasonDemo.unSeri2json(jsonString);
		System.out.println("unseri result");
		System.out.println(voPerson.toString());
		System.err.println("------------------------");
		String xmlString = fastJasonDemo.seri2xml();
		System.out.println("seri resutl");
		System.out.println(xmlString);
		Person voPersonxml = fastJasonDemo.unSeri2xml(xmlString);
		System.out.println("unseri result");
		System.out.println(voPersonxml.toString());
		
	}
}
