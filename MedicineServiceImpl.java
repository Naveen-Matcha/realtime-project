package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Medicine;
import com.example.demo.Repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	MedicineRepository medicineRepository;

	@Override
	public Page<Medicine> getMedicineSearch(String ndcAndName, Integer pageSize, Integer pageNumber) {
		if (ndcAndName.length() >= 3) {
	        throw new IllegalArgumentException("Search query must have at least 3 characters.");
	    }

	    List<Medicine> searchResults = medicineRepository.searchMedicine(ndcAndName);

	    int totalResults = searchResults.size();

	    // Calculate the number of total pages based on the pageSize
	    int totalPages = (int) Math.ceil((double) totalResults / pageSize);

	    // Create a pageable object with the pageNumber and pageSize
	    Pageable pageable = PageRequest.of(pageNumber, pageSize);

	    // Create a sublist of searchResults based on the pageable
	    int startIndex = pageable.getPageNumber() * pageable.getPageSize();
	    int endIndex = Math.min(startIndex + pageable.getPageSize(), totalResults);
	    List<Medicine> paginatedResults = searchResults.subList(startIndex, endIndex);

	    // Create a Page object using the PageImpl implementation
	    Page<Medicine> page = new PageImpl<>(paginatedResults, pageable, totalResults);

	    return page;
	}
		
		
		
		
		
		/*Pageable pageable = PageRequest.of(pageNumber, pageSize);
		if (ndcAndName.length() >= 3) {
			// Search for exact matches of code or short name
			return medicineRepository.findByndcAndName(ndcAndName, pageable);
		} else {
			// Search for related codes based on code or short name using wildcard search
			String searchQuery = "*" + ndcAndName.toLowerCase() + "*";
			return medicineRepository.findByndcAndNameLike(searchQuery, pageable);
		}*/
		
		
	
}
