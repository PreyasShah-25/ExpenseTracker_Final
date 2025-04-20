package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.VendorEntity;

@Repository
public interface VendorRepository  extends JpaRepository<VendorEntity, Integer>{
		
	@Query(value = " select v.*  ,u.first_name from users u , vendor v where v.user_id = u.user_id and v.user_id = :userId", nativeQuery = true)
	List<Object[]> getAll(Integer userId);
	
	@Query(value = " select v.*  ,u.first_name from users u , vendor v where v.user_id = u.user_id and vendor_id = :vendorId", nativeQuery = true)
	List<Object[]> getByVendorId(Integer vendorId);
	
}
