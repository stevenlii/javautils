package com.paymoon.demo.Ztest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.java8.stream.Person;

public class Test49 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		new Test49().name();
	}
	public void name() {

		List<Person> strings = new ArrayList<>();
		Person p = new Person();
		p.setAge(0);
		p.setId(11);
		strings.add(p);
		Person p1 = new Person();
		p1.setAge(0);
		p1.setId(11);
		strings.add(p1);
		Person p2 = new Person();
		p2.setAge(0);
		p2.setId(11);
		strings.add(p2);
		List<Person> strings2 = deepCopy(strings);
		
		for (int i = 0; i < strings2.size(); i++) {
			Person pp = strings2.get(i);
			if (i == 1) {
				pp.setAge(8888);
			}
		}
		System.out.println(strings);
		System.out.println(strings2);
		
	}
	/**
     * 对集合进行深拷贝
     * 注意需要岁泛型类进行序列化（实现serializable）
     *
     * @param src
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> List<T> deepCopy(List<T> src) {
        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
             ObjectOutputStream outputStream = new ObjectOutputStream(byteOut);
        ) {
            outputStream.writeObject(src);
            try (ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
                 ObjectInputStream inputStream = new ObjectInputStream(byteIn);
            ) {
                return (List<T>) inputStream.readObject();
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
