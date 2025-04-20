package com.grownited.controller;

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
public class AccountController {
	@Autowired
	AccountRepository accountRepository;
	
	
	@GetMapping("newaccount")
	public String newAccount() {
		return "NewAccount";
	}
	
	@PostMapping("saveaccount")
	public String saveAccount(AccountEntity accountEntity,HttpSession session) {
		
		UserEntity user =(UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
		accountEntity.setUserId(userId);
		accountRepository.save(accountEntity);
		return "redirect:/listaccount";
	}
	
	@GetMapping("listaccount")
	public String listAccount(Model model,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
	List<Object[]> accountList	= accountRepository.getAll(user.getUserId());
	model.addAttribute("accountList",accountList);
	return "ListAccount";
	}
	
	@GetMapping("viewaccount")
	public String viewAccount(Integer accountId,Model model) {
		List<Object[]> op = accountRepository.getByAccountId(accountId);
		model.addAttribute("account", op);
		return "ViewAccount";
	}
	
	@GetMapping("editaccount")
	public String editAccount(Integer accountId, Model model) {
		Optional<AccountEntity> op = accountRepository.findById(accountId);
		if (op.isEmpty()) {
			return "redirect;/listaccount";
			}else {
				model.addAttribute("account", op.get());
				return "EditAccount";
			}
	}
	
	@PostMapping("updateaccount")
	public String updateAccount(AccountEntity accountEntity) {
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
	
	@GetMapping("deleteaccount")
	public String deleteAccount(Integer accountId,Model model) {
	accountRepository.deleteById(accountId);
	return "redirect:/listaccount";
		
	}

}
