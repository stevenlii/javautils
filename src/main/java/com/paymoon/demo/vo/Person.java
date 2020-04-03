package com.paymoon.demo.vo;

public class Person {
private Long id;
private String name;
private String age;
private String gender;
private String height;
private String edu;
public Person() {
	// TODO Auto-generated constructor stub
}
public Person(String name, String age, String gender, String height,
		String edu) {
	super();
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.height = height;
	this.edu = edu;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getHeight() {
	return height;
}
public void setHeight(String height) {
	this.height = height;
}
public String getEdu() {
	return edu;
}
public void setEdu(String edu) {
	this.edu = edu;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", height=" + height
			+ ", edu=" + edu + "]";
}
@Override
public int hashCode() {
	return Long.hashCode(id.longValue());
}
@Override
public boolean equals(Object obj) {
	if (obj instanceof Person) {
		Person o = (Person)obj;
//		boolean isNameEq = this.name.equals(o.getName());
		boolean isIdEq = this.id.longValue() == o.getId();
		return isIdEq;
	}
	return false;
}


}
