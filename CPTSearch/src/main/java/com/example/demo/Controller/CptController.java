package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cpt;
import com.example.demo.Entity.CptCategory;
import com.example.demo.Service.CptService;

@RestController
public class CptController {

	@Autowired
	CptService cptService;

	@GetMapping("/search/cptcode")
	public Page<Cpt> getCptBycodeOrShortName(@RequestParam(value = "searchstring") String codeOrShortName,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "sortBy", required = false, defaultValue = "Newest First") String sortBy) {

		return cptService.getCptBycodeOrShortName(codeOrShortName, pageSize, pageNumber, sortBy);
	}

	@GetMapping("/search/cptcategory")
	public ResponseEntity<Page<CptCategory>> getCptCategorySearch(@RequestParam String searchCode,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "0") Integer pageNumber) {
		HttpHeaders headers = new HttpHeaders();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<CptCategory> cptCodeResponse = cptService.getCptCategorySearch(searchCode, pageable);
		return new ResponseEntity<>(cptCodeResponse, headers, HttpStatus.OK);

	}

}
