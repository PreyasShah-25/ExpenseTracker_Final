package com.grownited.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.IncomeRepository;
import com.grownited.repository.UserRepository;
import com.grownited.service.MailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
	
	@Autowired
	MailService mailService;
		
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
    Cloudinary cloudinary;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	IncomeRepository incomeRepository;
	
	
	
	@GetMapping("signup")
	public String Signup() {
		return "SignUp";
	}
	@GetMapping("login")
	public String Login() {
		
		return "Login";
	}
	
	@PostMapping("saveuser")
	public String saveUser(UserEntity userEntity, MultipartFile profilePic) {
		
		System.out.println(profilePic.getOriginalFilename());
		
		try {
	Map result = cloudinary.uploader().upload(profilePic.getBytes(),
			ObjectUtils.emptyMap());
	
	System.out.println(result);
	System.out.println(result.get("url"));
	
			userEntity.setProfilePicPath(result.get("url").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		
		
	String encPassword =encoder.encode(userEntity.getPassword());
	
		userEntity.setPassword(encPassword);
		
		
		
		userEntity.setCity("Ahmedabad");
		userEntity.setRole("USER");
		userEntity.setStatus(true);
		userEntity.setCreatedAt(new Date());
		userEntity.setBornYear("2003");
		repoUser.save(userEntity);
		
		mailService.sendWelcomeEmail(userEntity.getEmail(), userEntity.getFirstName());
		
		
		
		return "redirect:/listuser";
	}
	
	@GetMapping("listuser")
	public String listUser(Model model) {
	List<UserEntity> userList= repoUser.findAll();
	model.addAttribute("userList",userList);
	
	return "ListUser";
	}
	
	@GetMapping("viewuser")
	public String viewUser(Integer userId,Model model) {
	Optional<UserEntity> op =	repoUser.findById(userId);
	if(op.isEmpty()) {
	
	}
	else {
		UserEntity users =	op.get();
		model.addAttribute("users", users);
	}
	
	
	return "ViewUser";
	}
	
	@GetMapping("deleteuser")
	public String deleteAccount(Integer userId,Model model) {
	repoUser.deleteById(userId);
	
	return "redirect:/listuser";
		
	}

	
	
	
	
	@GetMapping("forgetpassword")
	public String forgetPassword() {
		return "ForgetPassword";
	}
	
	@PostMapping("sendOtp")
	public String sendOtp(String email,Model model) {
	Optional< UserEntity> op =repoUser.findByEmail(email);
			if(op.isEmpty()) {
				model.addAttribute("error", "Email not found");
				return "ForgetPassword";
			}else {
				String otp = "";
				otp = (int) (Math.random() * 1000000) + "";
				
				UserEntity user = op.get();
			user.setOtp(otp);
				repoUser.save(user);// update otp for user
				mailService.sendOtpForForgetPassword(email, user.getFirstName(), otp);
				return "ChangePassword";
			}
	}
	 
	@PostMapping("updatepassword")
	public String updatePassword(String email,String password,String otp,Model model) {
		Optional< UserEntity> op =	repoUser.findByEmail(email);
		if(op.isEmpty()) {
			model.addAttribute("error","Invalid Data");
			return "changePassword";
			
		}
		else {
			UserEntity user = op.get();
						if(user.getOtp().equals(otp)) {
						String encPwd =	encoder.encode(password);
						user.setPassword(encPwd);
						user.setOtp("");
						repoUser.save(user);
						}else {
									model.addAttribute("error","Invalid Data");
									return "changePassword";
							}
		}
		model.addAttribute("msg", "Password updated");
		return "Login";
	}
	@PostMapping("authenticate")
	public String authenticate(String email,String password,Model model,HttpSession session) {
		
		Optional<UserEntity> op	= repoUser.findByEmail(email);
				
					if(op.isPresent()) {
							UserEntity dbuser = op.get();
							boolean ans = encoder.matches(password, dbuser.getPassword());
									if(ans==true) {
			
												session.setAttribute("user", dbuser);
												if(dbuser.getRole().equals("ADMIN")) {
													return "redirect:/admindashboard";
											} else if(dbuser.getRole().equals("USER")) {
												return "redirect:/homedashboard";
											} else {
												model.addAttribute("error", "Please contact Admin with Error Code #0991");
												return "Login";
											}
									}
					}
							
					model.addAttribute("error","Invalid Crendentials");
					return "Login";
	}
	
	
	@GetMapping("homedashboard")
	public String home(HttpSession session,Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();

		//count of user's account
		Integer totalAccountsOfUser = accountRepository.getAllAccounts(userId);
		model.addAttribute("totalAccountsOfUser", totalAccountsOfUser);
		
		
		//sum of total expense
		BigDecimal totalExpense = expenseRepository.totalExpense(userId);
		model.addAttribute("totalExpense", totalExpense);
		
		//sum of total income
		BigDecimal totalIncome = incomeRepository.totalIncome(userId);
		model.addAttribute("totalIncome", totalIncome);
		
		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();
		
		
		
		Integer[] monthWiseExpense = new Integer[12];
	    for (int i = 1; i <= 12; i++) {
	        BigDecimal monthlyExpense = expenseRepository.expenseOfThisMonth(i, userId);
	        monthWiseExpense[i-1] = monthlyExpense != null ? monthlyExpense.intValue() : 0;
	    }
	    model.addAttribute("monthWiseExpense", monthWiseExpense);
		return "Home";
	}
	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
