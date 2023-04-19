package com.emr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.emr.CodeSystem.Util.ListUtils;
import com.emr.model.Cpt;
import com.emr.model.CptCategory1;
import com.emr.repository.CptCategoryRepository;
import com.emr.repository.CptRepository;

import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;

@Service
public class CptServiceImp implements CptService {
	
	@Autowired
	CptRepository cptRepository;
	@Autowired
	CptCategoryRepository cptCategoryRepository;

	@Override
	public Cpt createCpt(Cpt cptReq) {
		// TODO Auto-generated method stub
		Optional<Cpt> existingCode = cptRepository.getCptByVersionState(cptReq.getCode());
		if(existingCode.isPresent()) {
			return existingCode.get();
		}else {
			Cpt cpt = cptRepository.save(cptReq);
			cpt.setRefId(cpt.getId());
			cpt.setOriginalRefId(cpt.getId());
			
		}
		
		return cptRepository.save(cptReq);
	}

	@Override
	public List<Cpt> getCpt() {
		// TODO Auto-generated method stub
		return cptRepository.findInActiveAll();
	}

	
	  /*@Override public Cpt updateCpt(int id, Cpt cptReq) { 
		  //TODO Auto-generated method stub
	 Cpt cpt = cptRepository.getById(id); cpt.setId(cptReq.getId());
	  cpt.setCode(cptReq.getCode()); cpt.setShortName(cptReq.getShortName());
	  cpt.setDescription(cptReq.getDescription());
	  cpt.setIsHCPCS(cptReq.getIsHCPCS());
	  cpt.setModifiedby(cptReq.getModifiedby());
	  cpt.setCreatedby(cptReq.getCreatedby());
	  cpt.setModifieddate(cptReq.getModifieddate());
	  cpt.setCreateddate(cptReq.getCreateddate()); return
	  cptRepository.save(cptReq); }*/
	 

	@Override
	public void deleteCptById(int id) {
		// TODO Auto-generated method stub
		cptRepository.deleteById(id);
	}

	@Override
	public Cpt getCptById(int id) {
		// TODO Auto-generated method stub
		return cptRepository.findById(id).get();
	}

	@Override
	public Page<Cpt> getCptPaginationById(Pageable pageable) {
		// TODO Auto-generated method stub
		return cptRepository.findAll(pageable);
	}

	@Override
	public List<Cpt> getCptSearchById(String shortName, Pageable pageable) {
		// TODO Auto-generated method stub
		return cptRepository.getCptSearchById(shortName,pageable).getContent();
	}

	@Override
	public Cpt updateCpt(int id, Cpt cptReq) {
		// TODO Auto-generated method stub
		
		Optional<Cpt> existingCode = cptRepository.findById(cptReq.getId());
		existingCode.ifPresent(existingcode ->{
			// Updating Existing Code
			existingcode.setVersionState("InValid");
			// existingCptCode.setRetired("Y");
			cptRepository.save(existingcode);
			// Inserting Modified Code As New One
			cptReq.setRefId(existingcode.getId());
			cptReq.setOriginalRefId(existingcode.getOriginalRefId());
			cptReq.setVersionState("Valid");
			cptReq.setId(0);
			cptRepository.save(cptReq);
		});
		return cptReq;
	}

	/*@Override
	public List<CptCategory1> getCptCategorySearchCodeOrDesc(String codeOrdesc, Pageable pageable) {
		// TODO Auto-generated method stub
		List<CptCategory1> cptList = cptCategoryRepository.getCptCategorySearchCodeOrDesc(codeOrdesc);
		return ListUtils.getPage(cptList,pageable.getPageNumber()+1 ,pageable.getPageSize() );
	}*/

	
	//Without headers in cptcategory in search
	@Override
	public List<CptCategory1> getCptCategory1CodeOrShortName(String codeOrShortName, Pageable pageable) {
		// TODO Auto-generated method stub
		List<CptCategory1> cpt = cptCategoryRepository.getCptCategory1CodeOrShortName(codeOrShortName);
		return ListUtils.getPage(cpt,pageable.getPageNumber()+1 ,pageable.getPageSize());
	}

	@Override
	public List<Cpt> getCptSorting(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize,Direction.ASC,"Id");
		return cptRepository.findAll(pageable).getContent();
	}

	
	

	
	
	
	
} 
	 


