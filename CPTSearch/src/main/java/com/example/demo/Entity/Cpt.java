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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cpt_short")
public class Cpt {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="code")
	private String code;
	@Column(name="short_name")
	private String shortName;
	@Column(name="description")
	private  String description;
	@Column(name="is_hcpcs")
	private Boolean isHCPCS;
	@Column(name="modified_by")
	private String modifiedby;
	@Column(name="created_by")
	private String createdby;
	@UpdateTimestamp
	@Column(name="modified_date")
	private Date modifieddate;
	@CreationTimestamp
	@Column(name="created_date")
	private Date createddate;
	@Column(name="ref_id")
	private Integer refId;
	@Column(name="retired")
	private String retired;
	@Column(name="version_state")
	private String versionState="Valid";
	@Column(name="original_ref_id")
	private Integer originalRefId;
	@Column(name="retired_reason")
	private String retiredReason; 
	@Column(name="retired_on")
	private Integer retiredOn ;

}
