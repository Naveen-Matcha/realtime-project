package com.example.demo.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cpt;
import com.example.demo.Entity.CptCategory;

@Service
public interface CptService {

	Page<Cpt> getCptBycodeOrShortName(String codeOrShortName, Integer pageSize, Integer pageNumber, String sortBy);

	Page<CptCategory> getCptCategorySearch(String searchCode, Pageable pageable);

	
	

	
}
