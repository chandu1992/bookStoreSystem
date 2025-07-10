package com.mksss.cummins.bookStoreSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_login_tbl")
public class UserLoginEntity {

	@Id
	private String mobilenumber;
	private String password;
	
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
