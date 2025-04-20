package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.IncomeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReportController {
	@Autowired
	ExpenseRepository expenseRepository;
	@Autowired
	IncomeRepository incomeRepository;
	
	@GetMapping("expensereport")
	public String expenseReport(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		List<Object[]> expenseList = expenseRepository.getAll(userId);
		model.addAttribute("expenseList",expenseList);
		return "ExpenseReport";
	}
	
	@GetMapping("incomereport")
	public String incomeReport(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		List<Object[]> incomeList = incomeRepository.getAll(userId);
		model.addAttribute("incomeList", incomeList);
		return "IncomeReport";
	}

}
