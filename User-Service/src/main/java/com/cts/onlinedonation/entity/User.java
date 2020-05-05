package com.cts.onlinedonation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="This is the User Model")
@Entity
@Table(name="User")
public class User {
	@ApiModelProperty(value="A unique key for each User")
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="user_id")
	 public int userId;
	 @ApiModelProperty(value="User name for User")
	 @Column(name="user_name")
	 public String username;
	 @ApiModelProperty(value="User password for User")
	 @Column(name="pass")
	 public String password;
	 
	 public User() {
		 
	 }

	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}
	 
	 

}
