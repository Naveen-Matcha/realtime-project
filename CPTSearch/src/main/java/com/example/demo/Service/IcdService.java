package com.example.demo.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Icd;
import com.example.demo.Entity.IcdGrouping;

@Service
public interface IcdService {

	Page<Icd> getIcdSearchSorting(String icdcode, Integer pageNumber, Integer pageSize);

	Page<IcdGrouping> icdGroupingSearch(Integer icdIdSearch, Pageable pageable);

}
