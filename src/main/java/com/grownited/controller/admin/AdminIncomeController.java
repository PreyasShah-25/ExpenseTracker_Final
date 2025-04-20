package com.grownited.controller.admin;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.IncomeEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.IncomeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminIncomeController {
	@Autowired
	IncomeRepository incomeRepository;
	@Autowired
	AccountRepository accountRepository;
	
	
	@GetMapping("adminnewincome")
	public String adminNewIncome(Model model) {
		List<AccountEntity> allAccount = accountRepository.findAll();
		model.addAttribute("allAccount", allAccount);
		return "AdminNewIncome";
	}
	@PostMapping("adminsaveincome")
	public String adminSaveIncome(IncomeEntity incomeEntity,HttpSession session) {
		UserEntity  user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		incomeEntity.setUserId(userId);	
		incomeRepository.save(incomeEntity);
		return "redirect:/adminlistincome";
	}
	
	@GetMapping("adminlistincome")
	public String adminListIncome(Model model,HttpSession session) {
		List<IncomeEntity> incomeList = incomeRepository.findAll();
		model.addAttribute("incomeList", incomeList);
		return "AdminListIncome";
	}
	
	@GetMapping("adminviewincome")
	public String adminViewIncome(Integer incomeId, Model model) {
		Optional<IncomeEntity> op=incomeRepository.findById(incomeId);
		if (op.isPresent()) {
			IncomeEntity income = op.get();
			model.addAttribute("income", income);
			
		}else {
			return "redirect:/adminlistincome";
		}
		
		return "AdminViewIncome";
	}
	
	@GetMapping("admineditincome")
	public String adminEditIncome(Integer incomeId,Model model) {
		Optional<IncomeEntity> op = incomeRepository.findById(incomeId);
		if (op.isEmpty()) {
			return "redirect:/adminlistincome";
			}else {
				model.addAttribute("allAccount", accountRepository.findAll());
				IncomeEntity income = op.get();
				model.addAttribute("income", income);
			}
				return "AdminEditIncome";
	}
	
	
	@PostMapping("adminupdateincome")
	public String adminUpdateIncome(IncomeEntity incomeEntity,Model model) {
		
		System.out.println(incomeEntity.getIncomeId());
		
		Optional<IncomeEntity> op = incomeRepository.findById(incomeEntity.getIncomeId());
		if (op.isPresent()) {
			IncomeEntity dbIncome =	op.get();
			dbIncome.setTitle(incomeEntity.getTitle());
			dbIncome.setAmount(incomeEntity.getAmount());
			dbIncome.setTranscationDate(incomeEntity.getTranscationDate());
			dbIncome.setDescription(incomeEntity.getDescription());
			incomeRepository.save(dbIncome);
			
		}
		return "redirect:/adminlistincome";
	}
	
	
	
	@GetMapping("admindeleteincome")
	public String adminDeleteIncome(Integer incomeId) {
		incomeRepository.deleteById(incomeId);
		return "redirect:/adminlistincome";
	}
}
