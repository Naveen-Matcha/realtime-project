package com.example.demo.Repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.CptCategory;


@Repository
public interface CptCategoryRepository extends JpaRepository<CptCategory, Integer> {

	

	@Query(value = "select distinct cs.*, ctg.cpt_major_category, ctg.cpt_minor_category " +
	            "from cpt_short cs " +
	            "left join cptcategory ctg on cs.code between ctg.start_code and ctg.end_code " +
	            "where version_state='Valid' and code like %:searchCode% or short_name like %:searchCode%", nativeQuery = true)
	List<CptCategory> getCptCategorySearch(String searchCode);

	
	

	//@Query("SELECT cc FROM CptCategory cc JOIN cc.cpt c WHERE c.shortName like %:searchCode% or c.code like %:searchCode%")
	


}
