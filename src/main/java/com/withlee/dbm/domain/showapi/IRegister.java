package com.withlee.dbm.domain.showapi;

import java.io.Serializable;

public class IRegister implements Serializable {
	
	private int id;            //主键
	private String username;   //用户名
	private String phone;       //手机号
	private String password;   //登录密码
	private String professional;  //专业
	private String school;        //学校
	private String level;          //用户等级
	
	public static final IRegister dao = new IRegister();
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	

}
