package com.emr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.CptCategory1;

@Repository
public interface CptCategoryRepository extends JpaRepository<CptCategory1, Integer> {
    
	/*@Query(value="CALL getCptCategorySearchCodeOrDesc(:codeOrdesc)",nativeQuery=true)
	List<CptCategory1> getCptCategorySearchCodeOrDesc(String codeOrdesc);*/
    
	
	
	@Query(value="CALL getCptCategory1CodeOrShortName(:codeOrShortName)",nativeQuery=true)
	List<CptCategory1> getCptCategory1CodeOrShortName(String codeOrShortName);
    
	
   
   
	
	/*@Query(value = "CALL getCptCategorySearchShortName(:shortName)", nativeQuery = true)
    List<CptCategory> getCptCategorySearchShortName(String shortName);*/
    
}
