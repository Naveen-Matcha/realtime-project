package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cpt;
import com.example.demo.Entity.CptCategory;
import com.example.demo.Repository.CptCategoryRepository;
import com.example.demo.Repository.CptRepository;

@Service
public class CptServiceImpl implements CptService {

	@Autowired
	CptRepository cptRepository;

	@Autowired
	CptCategoryRepository cptCategoryRepository;

	@Override
	public Page<Cpt> getCptBycodeOrShortName(String codeOrShortName, Integer pageSize, Integer pageNumber,
			String sortBy) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize,
				Sort.by(sortBy.equals("") ? Sort.Direction.DESC : Sort.Direction.ASC, "id"));
		if (codeOrShortName.length() >= 3) {
			// Search for exact matches of code or short name
			return cptRepository.findByCodeOrShortName(codeOrShortName, pageable);
		} else {
			// Search for related codes based on code or short name using wildcard search
			String searchQuery = "*" + codeOrShortName.toLowerCase() + "*";
			return cptRepository.findByCodeOrShortNameLike(searchQuery, pageable);
		}
	}

	@Override
	public Page<CptCategory> getCptCategorySearch(String searchCode, Pageable pageable) {
		// TODO Auto-generated method stub
		List<CptCategory> cptList = cptCategoryRepository.getCptCategorySearch(searchCode);
		int startIndex = pageable.getPageNumber() * pageable.getPageSize();
		int endIndex = Math.min(startIndex + pageable.getPageSize(), cptList.size());
		List<CptCategory> pageOfItems = cptList.subList(startIndex, endIndex);
		return new PageImpl<>(pageOfItems, pageable, cptList.size());
	}
	

}
