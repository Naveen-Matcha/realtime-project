package com.example.demo.Entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="icd10codes")
public class Icd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="icd_order")
	private String icdOrder;
	@Column(name="icd_code")
	private String icdCode;
	@Column(name="icd_id")
	private Integer icdId;
	@Column(name="type")
	private String type;
	@Column(name="short_desc")
	private String shortDesc;
	@Column(name="med_desc")
	private String medDesc;
	@Column(name="long_desc")
	private String longDesc;
	@Column(name="created_by")
	private String createdBy;
	@CreationTimestamp
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="modified_by")
	private String modifiedBy;
	@UpdateTimestamp
	@Column(name="modified_date")
	private Date modifiedDate;
	@Column(name="original_ref_id")
	private Integer originalRefId;
	@Column(name="ref_id")
	private Integer refId;
	@Column(name="retired")
	private String retired;
	@Column(name="retired_reason")
	private String retiredReason;
	@Column(name="version_state")
	private String versionState="Valid";
	@Column(name="retired_on")
	private Integer retiredOn;

}
