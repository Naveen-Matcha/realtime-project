package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Icd;

@Repository
public interface IcdRepository extends JpaRepository<Icd, Integer>{

	@Query("select t from Icd t where t.shortDesc like %:icdcode% or t.icdCode like %:icdcode%")
	Page<Icd> findByCodeOrShortName(String icdcode, Pageable pageable);

	@Query("select t from Icd t where t.shortDesc like %:searchQuery% or t.icdCode like %:searchQuery%")
	Page<Icd> findByCodeOrShortNameLike(String searchQuery, Pageable pageable);

}
