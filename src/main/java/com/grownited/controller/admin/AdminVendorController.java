package com.grownited.controller.admin;

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
public class AdminVendorController {
	@Autowired
	VendorRepository vendorRepository;

	
	@GetMapping("adminnewvendor")
	public String adminNewVendor() {
		return "AdminNewVendor";
	}
	
	@PostMapping("adminsavevendor")
	public String adminSaveVendor(VendorEntity vendorEntity,HttpSession session) {
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId  = user.getUserId();
			vendorEntity.setUserId(userId);
		
		vendorRepository.save(vendorEntity);
		
		
		return "redirect:/adminlistvendor";
	}
	
	
	@GetMapping("adminlistvendor")
	public String listVendor(Model model,HttpSession session) {
		List<VendorEntity> vendorList = vendorRepository.findAll();
		model.addAttribute("vendorList", vendorList);
			return "AdminListVendor";
	}
	
	@GetMapping("adminviewvendor")
	public String adminViewVendor(Integer vendorId,Model model) {
		Optional<VendorEntity>  op = vendorRepository.findById(vendorId);
		if (op.isPresent()) {
			VendorEntity vendor = op.get();
			model.addAttribute("vendor", vendor);
		}else {
			return "redirect:/adminlistvendor";
		}
		
		
		return "AdminViewVendor";
	}
	
	@GetMapping("admineditvendor")
	public String adminEditVendor(Integer vendorId, Model model) {
		Optional<VendorEntity> op = vendorRepository.findById(vendorId);
		if (op.isEmpty()) {
			return "redirect:/adminlistvendor";
			}else {
				model.addAttribute("vendor", op.get());
			}
		return"AdminEditVendor";
	}
	
	@PostMapping("adminupdatevendor")
	public String adminUpdateVendor(VendorEntity vendorEntity) {
		Optional<VendorEntity> op = vendorRepository.findById(vendorEntity.getVendorId());
		if(op.isPresent()) {
			VendorEntity dbVendor = op.get();
			dbVendor.setTitle(vendorEntity.getTitle());
			vendorRepository.save(dbVendor);
		}
		

		return "redirect:/adminlistvendor";		
	}
	
	@GetMapping("admindeletevendor")
	public String adminDeleteVendor(Integer vendorId) {
		vendorRepository.deleteById(vendorId);
		return "redirect:/adminlistvendor";
	}

}
