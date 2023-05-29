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

import com.example.demo.Entity.Icd;
import com.example.demo.Entity.IcdGrouping;
import com.example.demo.Service.IcdService;

@RestController
public class IcdController {
	
	@Autowired
	IcdService icdService;
	
	@GetMapping("/icd/search")
	public Page<Icd> getIcdSearchSorting(@RequestParam String icdcode, @RequestParam(defaultValue = "5") Integer pageSize,
			@RequestParam(defaultValue ="0") Integer pageNumber ){
		return icdService.getIcdSearchSorting(icdcode,pageNumber,pageSize);
	}
	
	@GetMapping("/icd/search/grouping")
    public ResponseEntity<Page<IcdGrouping>> icdGroupingSearch(@RequestParam Integer icdIdSearch , @RequestParam(defaultValue = "5") Integer pageSize,
    		@RequestParam(defaultValue ="0") Integer pageNumber	){
        HttpHeaders headers = new HttpHeaders();
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<IcdGrouping> icdRes = icdService.icdGroupingSearch(icdIdSearch,pageable);
        return new ResponseEntity<Page<IcdGrouping>>(icdRes,headers,HttpStatus.OK);
    }

}
