package com.grownited.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")

public class AccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private	Integer accountId;
private	 String    title;
private BigDecimal	amount;
private String	description;
private Integer	userId;



public Integer getAccountId() {
	return accountId;
}
public void setAccountId(Integer accountId) {
	this.accountId = accountId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public BigDecimal getAmount() {
	return amount;
}
public void setAmount(BigDecimal amount) {
	this.amount = amount;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}




     
}
