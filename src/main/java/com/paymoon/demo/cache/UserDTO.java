package com.paymoon.demo.cache;

import java.io.Serializable;

public class UserDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long creationTime;
	private String user;
	private String email;
	private Integer subjectId;
	private String uuid;
	private String mobile;
	private String password;
	private String owner;
	private Integer level;
	private String wechat;
	private String companyName;
	private String contactName;
	private String role;
	private Integer ext;
	private String sourceCode;
	private String licenseType;
	private String license;
	private String infoMsg;
	private long licenseExpiredTime;
	private String userParentGroupId;

	
	public long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getExt() {
		return ext;
	}
	public void setExt(Integer ext) {
		this.ext = ext;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public UserDTO(){}
//	public UserDTO(String user,String email,String mobile,Integer subjectId,String uuid,String owner,Integer level){
//		this.user=user;
//		this.email=email;
//		this.mobile=mobile;
//		this.subjectId=subjectId;
//		this.uuid=uuid;
//		this.owner=owner;
//		this.level=level;
//	}
	public UserDTO(String contactName,String user,String email,String mobile,Integer subjectId,String uuid,String owner,Integer level,String companyName,Integer ext){
		this.contactName=contactName;
		this.user=user;
		this.email=email;
		this.mobile=mobile;
		this.subjectId=subjectId;
		this.uuid=uuid;
		this.owner=owner;
		this.level=level;
		this.companyName=companyName;
		this.ext=ext;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getContactName() {
		if(contactName==null)
			return this.user;
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	
	public long getLicenseExpiredTime() {
		return licenseExpiredTime;
	}
	public void setLicenseExpiredTime(long licenseExpiredTime) {
		this.licenseExpiredTime = licenseExpiredTime;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserParentGroupId() {
		return userParentGroupId;
	}
	public void setUserParentGroupId(String userParentGroupId) {
		this.userParentGroupId = userParentGroupId;
	}
	
	
}
