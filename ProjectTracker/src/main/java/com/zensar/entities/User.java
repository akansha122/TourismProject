package com.zensar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Component
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@Column(nullable = false)
	@Size(min = 3, max = 10)
	private String fName;
	private String lName;
	@Column(nullable = false, updatable = true)
	private String password;

	@OneToOne(mappedBy = "user")
	@JoinColumn(name = "statusId")
	private Status status;

	@OneToOne(mappedBy = "user")
	@JoinColumn(name = "userGroupId")
	private UserGroup userGroup;

	@OneToOne
	private UserAuth userAuth;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public UserAuth getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(UserAuth userAuth) {
		this.userAuth = userAuth;
	}
	
	

	/*
	 * public Status getStatus() { return status; }
	 * 
	 * public void setStatus(Status status) { this.status = status; }
	 * 
	 * public UserGroup getUserGroup() { return userGroup; }
	 * 
	 * public void setUserGroup(UserGroup userGroup) { this.userGroup = userGroup; }
	 */
}
