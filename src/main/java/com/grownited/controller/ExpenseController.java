package com.grownited.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.CategoryEntity;
import com.grownited.entity.ExpenseEntity;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.SubCategoryRepository;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ExpenseController {
	
	
	@Autowired
	ExpenseRepository expenseRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubCategoryRepository subCategoryRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	VendorRepository vendorRepository;

	@GetMapping("newexpense")
	public String newExpense(Model model,HttpSession session) {
		UserEntity user = (UserEntity)session.getAttribute("user");
		/*
		 * Integer userId = user.getUserId();
		 */		
		List<AccountEntity> allAccount = accountRepository.findAll();
		model.addAttribute("allAccount", allAccount);
		
		List<VendorEntity> allVendor = vendorRepository.findAll();
		model.addAttribute("allVendor", allVendor);
		
		List<SubCategoryEntity> allSubCategory = subCategoryRepository.findAll();
		model.addAttribute("allSubCategory", allSubCategory);
		
		List<CategoryEntity>  allCategory =	categoryRepository.findAll();
		model.addAttribute("allCategory", allCategory);
		
		return "NewExpense";
	}
	
	@PostMapping("saveexpense")
	public String saveExpense(ExpenseEntity expenseEntity,HttpSession session,AccountEntity accountEntity) {
		
		UserEntity  user= (UserEntity)   session.getAttribute("user");
		Integer userId = user.getUserId();
		expenseEntity.setUserId(userId);
		expenseRepository.save(expenseEntity);
		
//		Business Logic //
		Optional<AccountEntity> account =accountRepository.findById(accountEntity.getAccountId());
		if (account.isPresent()) {
				AccountEntity op = account.get();
				op.setAmount(op.getAmount().subtract(expenseEntity.getAmount()));
				
//				(	100rs.         -           50rs.) ---> set(50) --> bank account
				accountRepository.save(op);
		}else {
			return "redirect:/listexpense";
		}
		
		return "redirect:/listexpense";
	}
	
	
	@GetMapping("listexpense")
	public String listExpense(Model model,HttpSession session) {
	UserEntity user = (UserEntity)session.getAttribute("user");
	
		List<Object[]> expenseList = expenseRepository.getAll(user.getUserId());
	
		model.addAttribute("expenseList", expenseList);
		
		return "ListExpense";
	}
	
	@GetMapping("viewexpense")
	public String viewExpense(Integer expenseId,Model model) {
		
			List<Object[]> op	= expenseRepository.getByExpenseId(expenseId);
			model.addAttribute("expense", op);	
			return "ViewExpense";
	}
	
	
	@GetMapping("editexpense")
	public String editExpense(Integer expenseId,Model model) {
		Optional<ExpenseEntity> op = expenseRepository.findById(expenseId);
		if (op.isEmpty()) {
				return "redirect:/listexpense";
			}else {
				
				model.addAttribute("allCategory",categoryRepository.findAll());
				model.addAttribute("allSubCategory", subCategoryRepository.findAll());
				model.addAttribute("allAccount", accountRepository.findAll());
				model.addAttribute("allVendor",vendorRepository.findAll());
				model.addAttribute("expense", op.get());
				return "EditExpense"; 
			}
		
	
	}
	
	@PostMapping("updateexpense")
	public String updateExpense(ExpenseEntity expenseEntity, Model model) {
		Optional<ExpenseEntity> op = expenseRepository.findById(expenseEntity.getExpenseId());
		if (op.isPresent()) {
			ExpenseEntity  dbExpense = op.get();
			
			// Calculate the amount difference before updating
			
			BigDecimal amountDifference = dbExpense.getAmount().subtract(expenseEntity.getAmount());
			System.out.println(amountDifference);
			
			
			dbExpense.setTitle(expenseEntity.getTitle());
			dbExpense.setAmount(expenseEntity.getAmount()); 
			dbExpense.setTranscationDate(expenseEntity.getTranscationDate());
			dbExpense.setDescription(expenseEntity.getDescription());
			dbExpense.setAccountId(expenseEntity.getAccountId());
			dbExpense.setCategoryId(expenseEntity.getCategoryId());
			dbExpense.setSubCategoryId(expenseEntity.getSubCategoryId());
			
			Optional<AccountEntity> accountOpt = accountRepository.findById(expenseEntity.getAccountId());
			if (accountOpt.isPresent()) {
					AccountEntity account = accountOpt.get();
					if(amountDifference.signum()>0) {
						account.setAmount(account.getAmount().add(amountDifference.abs()));
					}else if(amountDifference.signum()<0) {
						account.setAmount(account.getAmount().subtract(amountDifference.abs()));
					}
					if (account.getAmount().compareTo(BigDecimal.ZERO) < 0) {
		                throw new RuntimeException("Insufficient account balance");
		            }
					accountRepository.save(account);
			}
			expenseRepository.save(dbExpense);
		}
		
		return "redirect:/listexpense";
	}
	
	@GetMapping("deleteexpense")
	public String deleteExpense(Integer expenseId, Model model ,ExpenseEntity expenseEntity) {
		//1. Find the expense to be deleted
		Optional<ExpenseEntity> expenseOpt = expenseRepository.findById(expenseId);
		if (expenseOpt.isPresent()) {
			ExpenseEntity expense = expenseOpt.get();
			//2. Find the associated account
			Optional<AccountEntity> accountOpt=accountRepository.findById(expense.getAccountId());
			if (accountOpt.isPresent()) {
				AccountEntity account = accountOpt.get();
				
				//3. Add expense amount back to the account
				account.setAmount(account.getAmount().add(expense.getAmount()));
				accountRepository.save(account);
				}
			
			//4. Delete the expense
			expenseRepository.deleteById(expenseId);
		}
		
		return "redirect:/listexpense";
	}
	
	
}
