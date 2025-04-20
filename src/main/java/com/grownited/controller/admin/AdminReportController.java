package com.grownited.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.ExpenseEntity;
import com.grownited.entity.IncomeEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.IncomeRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminReportController {
	@Autowired
	ExpenseRepository expenseRepository;
	@Autowired
	IncomeRepository incomeRepository;
	@Autowired 
	UserRepository userRepository;
	
	@GetMapping("adminexpensereport")
	public String expenseReport(HttpSession session, Model model) {
		
		List<ExpenseEntity> expenseList2 = expenseRepository.findAll();
		model.addAttribute("expenseList2",expenseList2);
		return "AdminExpenseReport";
	}
	
	@GetMapping("adminincomereport")
	public String incomeReport(HttpSession session, Model model) {
		
		List<IncomeEntity> incomeList2 = incomeRepository.findAll();
		model.addAttribute("incomeList2", incomeList2);
		return "AdminIncomeReport";
	}
	@GetMapping("adminuserreport")
	public String userReport(HttpSession session, Model model) {
		
		List<UserEntity> userList =userRepository.findAll();
	model.addAttribute("userList", userList);	
		return "AdminUserReport";
	}


}
