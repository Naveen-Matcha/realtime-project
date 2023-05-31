package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Medicine;
import com.example.demo.Service.MedicineService;

@RestController
public class MedicineController {
	
	@Autowired
	MedicineService medicineService;
	
	
	@GetMapping("/search/Medicine/NDC")
	public Page<Medicine> getMedicineSearch(@RequestParam String ndcAndName,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "0") Integer pageNumber){
			//@RequestParam(value = "sortBy", required = false, defaultValue = "Newest First") String sortBy) {

		return medicineService.getMedicineSearch(ndcAndName, pageSize, pageNumber); 
	}

}
