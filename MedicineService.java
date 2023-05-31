package com.example.demo.Service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Medicine;

@Service
public interface MedicineService {

	Page<Medicine> getMedicineSearch(String ndcAndName, Integer pageSize, Integer pageNumber);

}
