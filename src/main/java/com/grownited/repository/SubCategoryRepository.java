package com.grownited.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.SubCategoryEntity;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Integer> {
	@Query(value = "select sb.*, u.first_name , c.category_name from users u,category c, subcategory sb where sb.user_id = u.user_id and sb.category_id = c.category_id and sb.user_id = :userId",nativeQuery = true)
	List<Object[]>	getAll(Integer userId);
	
	@Query(value = "select sb.*, c.category_name from category c, subcategory sb where sb.category_id = c.category_id",nativeQuery = true)
	List<Object[]> getAll();

@Query(value = "select sb.*, u.first_name , c.category_name from users u,category c, subcategory sb where sb.user_id = u.user_id and sb.category_id = c.category_id  and sb.sub_category_id = :subCategoryId",nativeQuery = true)
List<Object[]>	getBySubCategoryId(Integer subCategoryId);
	
	
}