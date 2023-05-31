package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
	
	
	
	@Query("SELECT m FROM Medicine m WHERE m.ndc LIKE %:ndcAndName% OR m.name LIKE %:ndcAndName%")
	List<Medicine> searchMedicine(String ndcAndName);
	
	
	
	
	
	

	/*@Query("select t from Medicine t where t.ndc like %:ndcAndName% or t.name like %:ndcAndName%")
	//Page<Medicine> findByndcAndName(String ndcAndName, Pageable pageable);

	//@Query("select t from Medicine t where t.ndc like %:searchQuery% or t.name like %:searchQuery%")
	Page<Medicine> findByndcAndNameLike(String searchQuery, Pageable pageable);*/

	

	

}
