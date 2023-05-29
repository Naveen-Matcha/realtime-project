package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Icd;
import com.example.demo.Entity.IcdGrouping;
import com.example.demo.Repository.IcdGroupingRepository;
import com.example.demo.Repository.IcdRepository;

@Service
public class IcdServiceImpl implements IcdService {

	@Autowired
	IcdRepository icdRepository;

	@Autowired
	IcdGroupingRepository icdGroupingRepository;

	@Override
	public Page<Icd> getIcdSearchSorting(String icdcode, Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
        if(icdcode.length() >= 3) {
		// Search for exact matches of code or short name
		return icdRepository.findByCodeOrShortName(icdcode, pageable);
		} else {
		// Search for related codes based on code or short name using wildcard search
		String searchQuery = "*" + icdcode.toLowerCase() + "*";
		return icdRepository.findByCodeOrShortNameLike(searchQuery, pageable);
		}
	}

	@Override
	public Page<IcdGrouping> icdGroupingSearch(Integer icdIdSearch, Pageable pageable) {
		List<IcdGrouping> icdList = icdGroupingRepository.icdGroupingSearch(icdIdSearch);
		int startIndex = pageable.getPageNumber() * pageable.getPageSize();
		int endIndex = Math.min(startIndex + pageable.getPageSize(), icdList.size());
		List<IcdGrouping> pageOfItems = icdList.subList(startIndex, endIndex);
		return new PageImpl<>(pageOfItems, pageable, icdList.size());
	}

}
