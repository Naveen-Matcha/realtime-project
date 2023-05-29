package com.example.demo.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CptCategory {

	@Id
	private int id;
	private String code;
	private String shortName;
	private String description;
    private Boolean isHcpcs;
	private Date modifiedDate;
	private Date createdDate;
	private Integer refId;
	private Boolean retired;
	private String versionState;
	private Integer originalRefId;
	private String cptMajorCategory;
	private String cptMinorCategory;
}
