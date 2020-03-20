package com.zensar.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserAuth {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userAuthId;

	@Column(nullable = false, updatable = true, unique = true)
	private String tokenId;

	@Column(nullable = false, updatable = true)
	private LocalDate sessionExpireDate;

	@OneToOne
	@JoinColumn(name = "user")
	private User user;

	@OneToOne
	private UserGroup userGroup;

	@OneToOne(mappedBy = "userAuth")
	private Status status;

	public Long getUserAuthId() {
		return userAuthId;
	}

	public void setUserAuthId(Long userAuthId) {
		this.userAuthId = userAuthId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public LocalDate getSessionExpireDate() {
		return sessionExpireDate;
	}

	public void setSessionExpireDate(LocalDate sessionExpireDate) {
		this.sessionExpireDate = sessionExpireDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
