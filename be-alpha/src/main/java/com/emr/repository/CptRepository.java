package com.emr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.Cpt;
import com.emr.model.CptCategory1;

@Repository
public interface CptRepository extends JpaRepository<Cpt, Integer> {
	
    @Query(value = "select * from cpt_short where shortName like %:shortName% or Code like %:shortName% or Description like %:shortName%",nativeQuery=true)
	public Page<Cpt> getCptSearchById(String shortName, Pageable pageable);
    
    @Query(value = "select * from cpt_short where Code=:code and versionState='Valid'",nativeQuery=true)
	public Optional<Cpt> getCptByVersionState(String code);
    
    //for  valid records 
    @Query(value = "select * from cpt_short where versionState='Valid'",nativeQuery=true)
	public List<Cpt> findActiveAll();
    
    //for Invalid records
    @Query(value = "select * from cpt_short where versionState='InValid'",nativeQuery=true)
	public List<Cpt> findInActiveAll();

	

}
