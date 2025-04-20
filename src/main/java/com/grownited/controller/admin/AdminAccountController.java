package com.grownited.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminAccountController {
	@Autowired
	AccountRepository accountRepository;
	
	
	@GetMapping("adminnewaccount")
	public String adminNewAccount() {
		return "AdminNewAccount";
	}
	
	@PostMapping("adminsaveaccount")
	public String adminSaveAccount(AccountEntity accountEntity,HttpSession session) {
		
		UserEntity user =(UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
		accountEntity.setUserId(userId);
		accountRepository.save(accountEntity);
		return "redirect:/adminlistaccount";
	}
	
	@GetMapping("adminlistaccount")
	public String adminListAccount(Model model,HttpSession session) {
		
	List<AccountEntity> accountList	= accountRepository.findAll();
	model.addAttribute("accountList",accountList);
	return "AdminListAccount";
	}
	
	@GetMapping("adminviewaccount")
	public String viewAccount(Integer accountId,Model model) {
	Optional<AccountEntity> op =	accountRepository.findById(accountId);
	if (op.isPresent()) {
		AccountEntity account = op.get();
		model.addAttribute("account", account);
		}else {
			return "redirect:/adminlistaccount";
		}
		
		/*
		 * List<Object[]> op = accountRepository.getByAccountId(accountId);
		 * model.addAttribute("account", op);
		 */
		return "AdminViewAccount";
	}
	
	@GetMapping("admineditaccount")
	public String editAccount(Integer accountId, Model model) {
		Optional<AccountEntity> op = accountRepository.findById(accountId);
		if (op.isEmpty()) {
			return "redirect;/adminlistaccount";
			}else {
				model.addAttribute("account", op.get());
				return "AdminEditAccount";
			}
	}
	
	@PostMapping("adminupdateaccount")
	public String adminUpdateAccount(AccountEntity accountEntity) {
		Optional<AccountEntity>  op = accountRepository.findById(accountEntity.getAccountId());
		if(op.isPresent()) {
			AccountEntity dbAccount= op.get();
			dbAccount.setTitle(accountEntity.getTitle());
			dbAccount.setAmount(accountEntity.getAmount());
			dbAccount.setDescription(accountEntity.getDescription());
			accountRepository.save(dbAccount);
			
		}
		return "redirect:/adminlistaccount";
	}
	@GetMapping("admindeleteaccount")
	public String adminDeleteAccount(Integer accountId,Model model) {
	accountRepository.deleteById(accountId);
	
	return "redirect:/adminlistaccount";
		
	}


}
