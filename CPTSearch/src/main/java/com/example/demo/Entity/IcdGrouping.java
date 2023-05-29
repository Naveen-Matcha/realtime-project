package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class IcdGrouping {

	@Id
	private int id;
	//private String icdOrder;
	private String icdCode;
	private Integer icdId;
	private Integer parentId;
	private String type;
	private String longDesc;
	private Integer level;
	

}
