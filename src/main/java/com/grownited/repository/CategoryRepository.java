package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.CategoryEntity;

@Repository

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
	@Query(value = "select c.* , u.first_name from users u , category c where c.user_id = u.user_id and c.user_id = :userId", nativeQuery = true)
	List<Object[]>	getAll(Integer userId);

	
//	this command for extracting specific category details [comes in action when we hit "View"] 
	@Query(value = "select c.* , u.first_name from users u , category c where c.user_id = u.user_id and c.category_id = :categoryId", nativeQuery = true)
	List<Object[]> getByCategoryId(Integer categoryId);
}
