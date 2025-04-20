package com.grownited.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.SubCategoryRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminSubCategoryController {

	
	@Autowired
	SubCategoryRepository subCategoryRepository;
																									
	@Autowired
	CategoryRepository categoryRepository;	
	
	@GetMapping("adminnewsubcategory")
	public String adminNewSubCategory(Model model) {
	List<CategoryEntity>  allCategory =	categoryRepository.findAll();
	model.addAttribute("allCategory", allCategory);
		
		return "AdminNewSubCategory";
	}
	
	@PostMapping("adminsavesubcategory")
	public String adminSaveSubCategory(SubCategoryEntity subCategoryEntity,HttpSession session) {
		
		UserEntity  user= (UserEntity)   session.getAttribute("user");
		Integer userId = user.getUserId();
		subCategoryEntity.setUserId(userId);
		
		subCategoryRepository.save(subCategoryEntity);
		
		return "redirect:/adminlistsubcategory";
	}
	
	@GetMapping("adminlistsubcategory")
	public String adminListSubCategory(Model model,HttpSession session) {
		List<Object[]> scList = subCategoryRepository.getAll();
		model.addAttribute("scList", scList);
		return "AdminListSubCategory";
	}
	
	
	@GetMapping("adminviewsubcategory")
	public String adminViewSubCategory(Integer subCategoryId,Model model) {
		List<Object[]> subCategory = subCategoryRepository.getBySubCategoryId(subCategoryId);
		model.addAttribute("subCategory", subCategory);
		return "AdminViewSubCategory";
	}
	
	
	@GetMapping("admineditsubcategory")
	public String adminEditSubCategory(Integer subCategoryId,   Model model, SubCategoryEntity subCategoryEntity) {
			Optional<SubCategoryEntity> op =subCategoryRepository.findById(subCategoryId);
				if (op.isEmpty()) {
						return "redirect:/adminlistsubcategory";
				} else {
						model.addAttribute("allCategory",categoryRepository.findAll());
						model.addAttribute("subCategory", op.get());
						return "AdminEditSubCategory";
		}
	}
	
	@PostMapping("adminupdatesubcategory")
	public String adminUpdateSubCategory(SubCategoryEntity subCategoryEntity) {
		Optional<SubCategoryEntity> op = subCategoryRepository.findById(subCategoryEntity.getSubCategoryId());
		if (op.isPresent()) {
				SubCategoryEntity dbSubCategory = op.get();
				dbSubCategory.setTitle(subCategoryEntity.getTitle());
				dbSubCategory.setCategoryId(subCategoryEntity.getCategoryId());
				subCategoryRepository.save(dbSubCategory);
			
		}
		return "redirect:/adminlistsubcategory";
	}
	
	
	
	@GetMapping("admindeletesubcategory")
	public String adminDeleteCategory(Integer subCategoryId) {
		subCategoryRepository.deleteById(subCategoryId);
		return "redirect:/adminlistsubcategory";
	}
}
