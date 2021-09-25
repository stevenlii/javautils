package com.paymoon.demo.vo;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class Person2 {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String company;
	private Object detail;
	private Person2 p2;

	public Person2() {
		HashMap<String, Object> detailMap = new HashMap<>();
		detailMap.put("cc", 11);
		detailMap.put("bb", 22L);
		detailMap.put("aa", "aa");
		this.detail = detailMap;
	}


	public Person2(Integer id,String firstname) {
		this.id = id;
		this.firstname = firstname;
		this.p2 = new Person2();
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	 public Object getDetail() {
		return detail;
	}

	public void setDetail(Object detail) {
		this.detail = detail;
	}
	
	public Person2 getP2() {
		return p2;
	}


	public void setP2(Person2 p2) {
		this.p2 = p2;
	}


	/**
     * object 转换为map，因为detail属性是动态的
     * @param detailInfo
     * @return
     */
    public HashMap<String, Object> detailInfo2Map(Object detailInfo) {
		HashMap<String, Object> detailMap = new HashMap<>();
		if (detailInfo == null) {
			return detailMap;
		}
		detailMap = JSON.parseObject(JSON.toJSONString(detailInfo),
				new TypeReference<HashMap<String, Object>>() {
				});
		return detailMap;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"");
		builder.append(id);
		builder.append("\", \"firstname\":\"");
		builder.append(firstname);
		builder.append("\", \"lastname\":\"");
		builder.append(lastname);
		builder.append("\", \"phone\":\"");
		builder.append(phone);
		builder.append("\", \"email\":\"");
		builder.append(email);
		builder.append("\", \"company\":\"");
		builder.append(company);
		builder.append("\", \"detail\":\"");
		builder.append(detail);
		builder.append("\", \"p2\":\"");
		builder.append(p2);
		builder.append("\"}\n");
		return builder.toString();
	}
    
    
}