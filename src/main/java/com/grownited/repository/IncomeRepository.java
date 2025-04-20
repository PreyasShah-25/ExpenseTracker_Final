package com.grownited.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grownited.entity.IncomeEntity;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer> {
	@Query(value = "select i.*, u.first_name from users u , income i where u.user_id = i.user_id and i.user_id = :userId",nativeQuery = true)
	List<Object[]> getAll(Integer userId);
	
	
	@Query(value = "select i.*, u.first_name from users u , income i where u.user_id = i.user_id and i.income_id = :incomeId",nativeQuery = true)
	List<Object[]> getByIncomeId(Integer incomeId);
	
	@Query(nativeQuery = true, value = "SELECT SUM(amount) FROM income WHERE user_id = :userId")
	BigDecimal totalIncome(@Param("userId") Integer userId);

}
