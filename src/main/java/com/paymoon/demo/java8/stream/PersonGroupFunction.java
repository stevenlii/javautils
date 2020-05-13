package com.paymoon.demo.java8.stream;

import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author lizhiqiang09 接口
 *
 */
@Service
public class PersonGroupFunction implements Function<Person, Person> {

	@Override
	public Person apply(Person person) {
		Person personGroupParam = new Person();
		BeanUtils.copyProperties(person, personGroupParam);
		//以person聚合，ignore id
		personGroupParam.setId(null);
		return personGroupParam;
	}

}
