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
import com.grownited.entity.IncomeEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.IncomeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class IncomeController {
	@Autowired
	IncomeRepository incomeRepository;
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("newincome")
	public String newIncome(Model model,HttpSession session) {
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
		List<Object[]> allAccount = accountRepository.getAll(userId);
		model.addAttribute("allAccount", allAccount);
		return "NewIncome";
	}
	
		@PostMapping("saveincome")
		public String saveIncome(IncomeEntity incomeEntity,Boolean TRUE,HttpSession session,AccountEntity accountEntity) {
			UserEntity  user = (UserEntity)   session.getAttribute("user");
			Integer userId = user.getUserId();
			incomeEntity.setUserId(userId);
				
			incomeRepository.save(incomeEntity);
			
			Optional<AccountEntity> accountOpt = accountRepository.findById(incomeEntity.getAccountId());
			if(accountOpt.isPresent()) {
				AccountEntity account = accountOpt.get();
				account.setAmount(account.getAmount().add(incomeEntity.getAmount()));
				accountRepository.save(account);
			}
			return "redirect:/listincome";
		}     
		
		@GetMapping("listincome")
		public String listIncome(Model model,HttpSession session) {
	UserEntity user	= (UserEntity)	session.getAttribute("user");
	List<Object[]> incomeList= incomeRepository.getAll(user.getUserId());
	model.addAttribute("incomeList", incomeList);
	return "ListIncome";
		}
		
		@GetMapping("viewincome")
		public String viewIncome(Integer incomeId, Model model) {
			
		List<Object[]> op	= incomeRepository.getByIncomeId(incomeId);
		
			model.addAttribute("income", op);
			return "ViewIncome";
		}
		
		@GetMapping("editincome")
		public String editIncome(Integer incomeId,Model model) {
			Optional<IncomeEntity> op = incomeRepository.findById(incomeId);
			if (op.isEmpty()) {
				return "redirect:/listincome";
				}else {
					model.addAttribute("allAccount", accountRepository.findAll());
					model.addAttribute("income", op.get());
				}
					return "EditIncome";
		}
		
		
		@PostMapping("updateincome")
		public String updateIncome(IncomeEntity incomeEntity,Model model) {
			
			System.out.println(incomeEntity.getIncomeId());
			
			Optional<IncomeEntity> op = incomeRepository.findById(incomeEntity.getIncomeId());
			if (op.isPresent()) {
				IncomeEntity dbIncome =	op.get();
				
				BigDecimal amountDifference = dbIncome.getAmount().subtract(incomeEntity.getAmount());
				System.out.println(amountDifference);
				
				
				dbIncome.setTitle(incomeEntity.getTitle());
				dbIncome.setAmount(incomeEntity.getAmount());
				dbIncome.setTranscationDate(incomeEntity.getTranscationDate());
				dbIncome.setDescription(incomeEntity.getDescription());
		
				
				Optional<AccountEntity> accountOpt = accountRepository.findById(incomeEntity.getAccountId());
				if (accountOpt.isPresent()) {
							AccountEntity account = accountOpt.get();
							if(amountDifference.signum()>0) {
								account.setAmount(account.getAmount().add(amountDifference).abs());
							}else if(amountDifference.signum()<0) {
								account.setAmount(account.getAmount().subtract(amountDifference).abs());
							}
							if (account.getAmount().compareTo(BigDecimal.ZERO) < 0) {
				                throw new RuntimeException("Insufficient account balance");
				            }
							accountRepository.save(account);
				}
					incomeRepository.save(dbIncome);
			}
			return "redirect:/listincome";
		}
		
		
		
		@GetMapping("deleteincome")
		public String deleteIncome(Integer incomeId,Model model,IncomeEntity incomeEntity) {
			
			//1. Find the income to be deleted.
			Optional<IncomeEntity> incomeOpt = incomeRepository.findById(incomeId);
			if(incomeOpt.isPresent()) {
				IncomeEntity income = incomeOpt.get();
				
				//2. Find the associated account.
				Optional<AccountEntity> accountOpt = accountRepository.findById(income.getAccountId());
				if(accountOpt.isPresent()) {
					AccountEntity account = accountOpt.get();
					
					//3. Subtract the income amount from the account.
					account.setAmount(account.getAmount().subtract(income.getAmount()));
					accountRepository.save(account);
				}
				//4. Delete the income (by id)
				incomeRepository.deleteById(incomeId);
			}
			
			return "redirect:/listincome";
		}

}
