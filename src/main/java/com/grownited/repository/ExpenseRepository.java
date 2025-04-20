package com.grownited.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer> {
	@Query(value = "select e.expense_id, e.title,e.description, e.amount, a.title, v.title, sb.title, c.category_name, e.account_id, e.transcation_date from expense e, users u, subcategory sb, category c, account a, vendor v where e.vendor_id = v.vendor_id and e.account_id = a.account_id and e.category_id = c.category_id and e.sub_category_id = sb.sub_category_id and u.user_id = e.user_id and e.user_id = :userId",nativeQuery = true)
	List<Object[]> getAll(Integer userId);
		
		
	@Query(value = "select e.*,u.first_name from users u , expense e where e.user_id = u.user_id and expense_id = :expenseId ",nativeQuery = true)	
	List<Object[]> getByExpenseId(Integer expenseId);
	
	
	 @Query(nativeQuery = true, value = "SELECT SUM(amount) FROM expense WHERE MONTH(transcation_date) = :month AND user_id = :userId")
	 BigDecimal expenseOfThisMonth(@Param("month") Integer month, @Param("userId") Integer userId);
	
	 @Query(nativeQuery = true, value = "SELECT SUM(amount) FROM expense WHERE user_id = :userId")
	 BigDecimal totalExpense(@Param("userId") Integer userId);
		
}
