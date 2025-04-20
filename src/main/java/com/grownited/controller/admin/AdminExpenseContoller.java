package com.grownited.controller.admin;

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
public class AdminExpenseContoller {
	

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

	@GetMapping("adminnewexpense")
	public String adminNewExpense(Model model) {
		
		List<AccountEntity> allAccount = accountRepository.findAll();
		model.addAttribute("allAccount", allAccount);
		
		List<VendorEntity> allVendor = vendorRepository.findAll();
		model.addAttribute("allVendor", allVendor);
		
		List<SubCategoryEntity> allSubCategory = subCategoryRepository.findAll();
		model.addAttribute("allSubCategory", allSubCategory);
		
		List<CategoryEntity>  allCategory =	categoryRepository.findAll();
		model.addAttribute("allCategory", allCategory);
		
		return "AdminNewExpense";
	}
	
	@PostMapping("adminsaveexpense")
	public String adminSaveExpense(ExpenseEntity expenseEntity,HttpSession session) {
		
		UserEntity  user= (UserEntity)   session.getAttribute("user");
		Integer userId = user.getUserId();
		expenseEntity.setUserId(userId);
		expenseRepository.save(expenseEntity);
		return "redirect:/adminlistexpense";
	}
	
	
	@GetMapping("adminlistexpense")
	public String adminListExpense(Model model,HttpSession session) {
	
		List<ExpenseEntity> expenseList =	expenseRepository.findAll();
		model.addAttribute("expenseList", expenseList);
		return "AdminListExpense";
	}
	
	@GetMapping("adminviewexpense")
	public String adminViewExpense(Integer expenseId,Model model) {
		
			Optional<ExpenseEntity> op	= expenseRepository.findById(expenseId);
			
			if (op.isPresent()) {
					ExpenseEntity expense =op.get();
					model.addAttribute("expense", expense);
			}else {
				return "redirect:/adminlistexpense";
			}
			
			return "AdminViewExpense";
	}
	
	
	@GetMapping("admineditexpense")
	public String adminEditExpense(Integer expenseId,Model model) {
		Optional<ExpenseEntity> op = expenseRepository.findById(expenseId);
		if (op.isEmpty()) {
				return "redirect:/listexpense";
			}else {
				
				model.addAttribute("allCategory",categoryRepository.findAll());
				model.addAttribute("allSubCategory", subCategoryRepository.findAll());
				model.addAttribute("allAccount", accountRepository.findAll());
				model.addAttribute("allVendor",vendorRepository.findAll());
				model.addAttribute("expense", op.get());
				return "AdminEditExpense"; 
			}
		
	
	}
	
	@PostMapping("adminupdateexpense")
	public String adminUpdateExpense(ExpenseEntity expenseEntity, Model model) {
		Optional<ExpenseEntity> op = expenseRepository.findById(expenseEntity.getExpenseId());
		if (op.isPresent()) {
			ExpenseEntity  dbExpense = op.get();
			dbExpense.setTitle(expenseEntity.getTitle());
			dbExpense.setAmount(expenseEntity.getAmount()); 
			dbExpense.setTranscationDate(expenseEntity.getTranscationDate());
			dbExpense.setDescription(expenseEntity.getDescription());
			dbExpense.setAccountId(expenseEntity.getAccountId());
			dbExpense.setCategoryId(expenseEntity.getCategoryId());
			dbExpense.setSubCategoryId(expenseEntity.getSubCategoryId());
			expenseRepository.save(dbExpense);
		}
		
		return "redirect:/adminlistexpense";
	}
	
	@GetMapping("admindeleteexpense")
	public String adminDeleteExpense(Integer expenseId) {
		expenseRepository.deleteById(expenseId);
		return "redirect:/adminlistexpense";
	}


}
