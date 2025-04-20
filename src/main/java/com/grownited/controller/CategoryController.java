package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CategoryRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
		
	@GetMapping("newcategory")
	public String newCategory() {
		return "NewCategory";
		
	}
	@PostMapping("savecategory")
	public String saveCategory(CategoryEntity categoryEntity,HttpSession session) {
		
		
		UserEntity  user= (UserEntity)   session.getAttribute("user");
		Integer userId = user.getUserId();
		categoryEntity.setUserId(userId);
		
		categoryRepository.save(categoryEntity);
		
		return "redirect:/listcategory";
	}
	
	
	@GetMapping("listcategory")
	public String listCategory(Model model,HttpSession session) {
	UserEntity user = (UserEntity)	session.getAttribute("user");
		List<Object[]> categoryList  = categoryRepository.getAll(user.getUserId());
        model.addAttribute("categoryList", categoryList);
		return "ListCategory";
	}
	
	
	@GetMapping("viewcategory")
	public String viewCategory(Integer categoryId,Model model) {
		List<Object[]> op = categoryRepository.getByCategoryId(categoryId);
		model.addAttribute("category", op);
		
		return "ViewCategory";
	}
	
	
	
	@GetMapping("editcategory")
	public String editCategory(Integer categoryId, Model model) {
		Optional<CategoryEntity> op = categoryRepository.findById(categoryId);
		if(op.isEmpty()) {
			return "redirect:/listcategory";
		} else {
			model.addAttribute("category", op.get());
			return "EditCategory";
		}
	}
	
	
	@PostMapping("updatecategory")
	public String updateCatgegory(CategoryEntity categoryEntity) {
		Optional<CategoryEntity> op = categoryRepository.findById(categoryEntity.getCategoryId()); //here category id is fetched which is 
																									//passed from "EditCategory" JSP (in hidden format).
		if(op.isPresent()) {
			CategoryEntity dbCategory =  op.get();
			dbCategory.setCategoryName(categoryEntity.getCategoryName());
			categoryRepository.save(dbCategory);

		}

		return "redirect:/listcategory";
	}
	
	@GetMapping("deletecategory")
	public String deleteCategory(Integer categoryId) {
		categoryRepository.deleteById(categoryId);
		return "redirect:/listcategory";
	}
}
	