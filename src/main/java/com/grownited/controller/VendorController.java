package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class VendorController {
	@Autowired
	VendorRepository vendorRepository;

	
	@GetMapping("newvendor")
	public String newVendor() {
		return "NewVendor";
	}
	
	@PostMapping("savevendor")
	public String saveVendor(VendorEntity vendorEntity,HttpSession session) {
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId  = user.getUserId();
			vendorEntity.setUserId(userId);
		
		vendorRepository.save(vendorEntity);
		
		
		return "redirect:/listvendor";
	}
	
	
	@GetMapping("listvendor")
	public String listVendor(Model model,HttpSession session) {
	UserEntity user = (UserEntity)	session.getAttribute("user");
	List<Object[]> vendorList = vendorRepository.getAll(user.getUserId());
	model.addAttribute("vendorList", vendorList);
	
		return "ListVendor";
	}
	@GetMapping("viewvendor")
	public String viewExpense(Integer vendorId,Model model) {
		List<Object[]>  op = vendorRepository.getByVendorId(vendorId);
		model.addAttribute("vendor", op);
		
		return "ViewVendor";
	}
	
	@GetMapping("editvendor")
	public String editVendor(Integer vendorId, Model model) {
		Optional<VendorEntity> op = vendorRepository.findById(vendorId);
		if (op.isEmpty()) {
			return "redirect:/listvendor";
			}else {
				model.addAttribute("vendor", op.get());
			}
		return"EditVendor";
	}
	
	@PostMapping("updatevendor")
	public String updateVendor(VendorEntity vendorEntity) {
		Optional<VendorEntity> op = vendorRepository.findById(vendorEntity.getVendorId());
		if(op.isPresent()) {
			VendorEntity dbVendor = op.get();
			dbVendor.setTitle(vendorEntity.getTitle());
			vendorRepository.save(dbVendor);
		}
		

		return "redirect:/listvendor";		
	}
	
	@GetMapping("deletevendor")
	public String deleteExpense(Integer vendorId) {
		vendorRepository.deleteById(vendorId);
		return "redirect:/listvendor";
	}
	
	
}
