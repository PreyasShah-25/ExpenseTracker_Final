package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
	
	
	
	@Query(value = "select a.*, u.first_name from users u , account a where a.user_id = u.user_id and a.user_id = :userId", nativeQuery = true)
	List<Object[]> getAll(Integer userId);
	
	@Query(value = "select a.*, u.first_name from users u , account a where a.user_id = u.user_id and account_id = :accountId", nativeQuery = true)
	List<Object[]> getByAccountId(Integer accountId);
	@Query(nativeQuery = true, value ="select count(title) from account a where a.user_id = :userId")
	Integer getAllAccounts(Integer userId);
}
