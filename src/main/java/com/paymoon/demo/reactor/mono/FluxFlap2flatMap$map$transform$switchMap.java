package com.paymoon.demo.reactor.mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import reactor.core.publisher.Flux;

/**
 * flux转换操作示例
 * flatMap、map、transform、switchMap
https://blog.csdn.net/weixin_43931625/article/details/106985527 
toIterable、toStream


*/
class Person {

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Person))
			return false;
		Person person = (Person) o;
		return Objects.equals(getName(), person.getName()) && Objects.equals(getAge(), person.getAge());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getAge());
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}

public class FluxFlap2flatMap$map$transform$switchMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("name", "瓜田李下");
		map.put("age", "20");

		Flux.just(map).flatMap(m -> {
			String name = m.get("name");
			Integer age = Integer.parseInt(m.get("age"));

			Person person = new Person();
			person.setName(name);
			person.setAge(age);

			return Flux.just(person);
		}).subscribe(System.out::println);

		Flux.just(map).map(m -> {
			String name = m.get("name");
			Integer age = Integer.parseInt(m.get("age"));

			Person person = new Person();
			person.setName(name);
			person.setAge(age);

			return person;
		}).subscribe(System.out::println);

		Flux.just(map).transform(flux -> flux.flatMap(m -> {
			String name = m.get("name");
			Integer age = Integer.parseInt(m.get("age"));

			Person person = new Person();
			person.setName(name);
			person.setAge(age);

			return Flux.just(person);
		})).subscribe(System.out::println);

		Flux.just(map).transform(flux -> flux.map(m -> {
			String name = m.get("name");
			Integer age = Integer.parseInt(m.get("age"));

			Person person = new Person();
			person.setName(name);
			person.setAge(age);

			return person;
		})).subscribe(System.out::println);

		Flux.just(map).switchMap(m -> {
			String name = m.get("name");
			Integer age = Integer.parseInt(m.get("age"));

			Person person = new Person();
			person.setName(name);
			person.setAge(age);

			return Flux.just(person);
		}).subscribe(System.out::println);
	}
}
