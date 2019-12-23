package com.test.www.po;

public class User {
	private int id;
	private String u_username;
	private String u_password;
	private String u_classes;
	private String u_number;
	private String u_sex;
	private String u_tel;
	private String u_authority;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getU_username() {
		return u_username;
	}


	public void setU_username(String u_username) {
		this.u_username = u_username;
	}


	public String getU_password() {
		return u_password;
	}


	public void setU_password(String u_password) {
		this.u_password = u_password;
	}


	public String getU_classes() {
		return u_classes;
	}


	public void setU_classes(String u_classes) {
		this.u_classes = u_classes;
	}


	public String getU_number() {
		return u_number;
	}


	public void setU_number(String u_number) {
		this.u_number = u_number;
	}


	public String getU_sex() {
		return u_sex;
	}


	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}


	public String getU_tel() {
		return u_tel;
	}


	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}


	public String getU_authority() {
		return u_authority;
	}


	public void setU_authority(String u_authority) {
		this.u_authority = u_authority;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", u_username=" + u_username + ", u_password=" + u_password + ", u_classes="
				+ u_classes + ", u_number=" + u_number + ", u_sex=" + u_sex + ", u_tel=" + u_tel + ", u_authority="
				+ u_authority + "]";
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
