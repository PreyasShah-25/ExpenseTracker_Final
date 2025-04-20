package com.grownited.controller.admin;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.repository.UserRepository;

@Controller

public class AdminController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("admindashboard")
	public String AdminDashboard(Model model) {
		
		Integer totalClients = userRepository.findByRole("USER").size(); //total "USERS"
		Integer totalAdmins = userRepository.findByRole("ADMIN").size(); //total "ADMIN"
		model.addAttribute("totalClients", totalClients);
		
		
		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();
		
		Integer thisMonthUserCount = userRepository.countThisMonthUsers(month); 
//		Integer openInternship = internshipRepository.findByStatus("OPEN").size();
		
		Integer monthWiseUsers [] = new Integer[12];
		
		for(int i=1;i<=12;i++) {
			monthWiseUsers [i-1] = userRepository.countThisMonthUsers(i);
		}
		
		model.addAttribute("thisMonthUsersCount",thisMonthUserCount);
		model.addAttribute("currentMonth",LocalDate.now().getMonth().name());
		model.addAttribute("monthWiseUsers",monthWiseUsers);

		return "AdminDashBoard";
	}

}
