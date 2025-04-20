package com.grownited.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "expense")
public class ExpenseEntity {
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
		private		Integer	expenseId;
		private		String	title;
		private		Integer	categoryId;//fk
		private		Integer	subCategoryId;//fk
		private		Integer	vendorId;//fk
		private		Integer	accountId;//fk
		private		String	status;
		private		BigDecimal	amount;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Temporal(TemporalType.DATE)
		private	    Date	transcationDate;
		private		String	description;
		private		Integer	userId;//fk
		
		
		
		public Integer getExpenseId() {
			return expenseId;
		}
		public void setExpenseId(Integer expenseId) {
			this.expenseId = expenseId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Integer getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}
		
		public Integer getVendorId() {
			return vendorId;
		}
		public void setVendorId(Integer vendorId) {
			this.vendorId = vendorId;
		}
		public Integer getAccountId() {
			return accountId;
		}
		public void setAccountId(Integer accountId) {
			this.accountId = accountId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public BigDecimal getAmount() {
			return amount;
		}
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
		public Date getTranscationDate() {
			return transcationDate;
		}
		public void setTranscationDate(Date transcationDate) {
			this.transcationDate = transcationDate;
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
		public Integer getSubCategoryId() {
			return subCategoryId;
		}
		public void setSubCategoryId(Integer subCategoryId) {
			this.subCategoryId = subCategoryId;
		}
		
		

}
