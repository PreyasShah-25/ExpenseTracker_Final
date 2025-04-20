package com.grownited.controller.admin;

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
public class AdminCategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
		
	@GetMapping("adminnewcategory")
	public String adminNewCategory() {
		return "AdminNewCategory";
		
	}
	@PostMapping("adminsavecategory")
	public String adminSaveCategory(CategoryEntity categoryEntity,HttpSession session) {
		
		
		UserEntity  user= (UserEntity)   session.getAttribute("user");
		Integer userId = user.getUserId();
		categoryEntity.setUserId(userId);
		
		categoryRepository.save(categoryEntity);
		
		return "redirect:/adminlistcategory";
	}
	
	
	@GetMapping("adminlistcategory")
	public String adminListCategory(Model model,HttpSession session) {
	
		List<CategoryEntity> categoryList  = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);
		return "AdminListCategory";
	}
	
	
	@GetMapping("adminviewcategory")
	public String adminViewCategory(Integer categoryId,Model model) {
		Optional<CategoryEntity> op = categoryRepository.findById(categoryId);
		if (op.isPresent()) {
			CategoryEntity category = op.get();
			model.addAttribute("category", category);
			}else {
				return "redirect:/adminlistcategory";
			}
		
		
		return "AdminViewCategory";
	}
	
	
	
	@GetMapping("admineditcategory")
	public String adminEditCategory(Integer categoryId, Model model) {
		Optional<CategoryEntity> op = categoryRepository.findById(categoryId);
		if(op.isEmpty()) {
			return "redirect:/adminlistcategory";
		} else {
			model.addAttribute("category", op.get());
			return "AdminEditCategory";
		}
	}
	
	
	@PostMapping("adminupdatecategory")
	public String adminUpdateCatgegory(CategoryEntity categoryEntity) {
		Optional<CategoryEntity> op = categoryRepository.findById(categoryEntity.getCategoryId()); //here category id is fetched which is 
																									//passed from "EditCategory" JSP (in hidden format).
		if(op.isPresent()) {
			CategoryEntity dbCategory =  op.get();
			dbCategory.setCategoryName(categoryEntity.getCategoryName());
			categoryRepository.save(dbCategory);

		}

		return "redirect:/adminlistcategory";
	}
	
	@GetMapping("admindeletecategory")
	public String adminDeleteCategory(Integer categoryId) {
		categoryRepository.deleteById(categoryId);
		return "redirect:/adminlistcategory";
	}

}
