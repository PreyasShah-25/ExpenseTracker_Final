package com.grownited.controller;

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
public class SubCategoryController {
	@Autowired
	SubCategoryRepository subCategoryRepository;
																									
	@Autowired
	CategoryRepository categoryRepository;	
	
	@GetMapping("newsubcategory")
	public String newSubCategory(Model model,HttpSession session) {
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
	List<Object[]>  allCategory =categoryRepository.getAll(userId);
	model.addAttribute("allCategory", allCategory);
		
		return "NewSubCategory";
	}
	
	@PostMapping("savesubcategory")
	public String saveSubCategory(SubCategoryEntity subCategoryEntity,HttpSession session) {
		
		UserEntity  user= (UserEntity)   session.getAttribute("user");
		Integer userId = user.getUserId();
		subCategoryEntity.setUserId(userId);
		
		subCategoryRepository.save(subCategoryEntity);
		
		return "redirect:/listsubcategory";
	}
	
	@GetMapping("listsubcategory")
	public String listSubCategory(Model model,HttpSession session) {
UserEntity user	= (UserEntity)	session.getAttribute("user");
		List<Object[]> scList = subCategoryRepository.getAll(user.getUserId());
		model.addAttribute("scList", scList);
		return "ListSubCategory";
	}
	
	
	@GetMapping("viewsubcategory")
	public String viewSubCategory(Integer subCategoryId,Model model) {
		
	List<Object[]> op=subCategoryRepository.getBySubCategoryId(subCategoryId);

		model.addAttribute("subCategory",op);	
	
		return "ViewSubCategory";
	}
	
	
	@GetMapping("editsubcategory")
	public String editSubCategory(Integer subCategoryId,   Model model, SubCategoryEntity subCategoryEntity) {
Optional<SubCategoryEntity> op =subCategoryRepository.findById(subCategoryId);
if (op.isEmpty()) {
		return "redirect:/listsubcategory";
		} else {
			model.addAttribute("allCategory",categoryRepository.findAll());
			model.addAttribute("subCategory", op.get());
			return "EditSubCategory";
		}
	}
	
	@PostMapping("updatesubcategory")
	public String updateSubCategory(SubCategoryEntity subCategoryEntity) {
		Optional<SubCategoryEntity> op = subCategoryRepository.findById(subCategoryEntity.getSubCategoryId());
		if (op.isPresent()) {
				SubCategoryEntity dbSubCategory = op.get();
				dbSubCategory.setTitle(subCategoryEntity.getTitle());
				dbSubCategory.setCategoryId(subCategoryEntity.getCategoryId());
				subCategoryRepository.save(dbSubCategory);
			
		}
		return "redirect:/listsubcategory";
	}
	
	
	
	@GetMapping("deletesubcategory")
	public String deleteCategory(Integer subCategoryId) {
		subCategoryRepository.deleteById(subCategoryId);
		return "redirect:/listsubcategory";
	}

}
