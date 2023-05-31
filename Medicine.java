package com.example.demo.Entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "medicines")
@Data
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aiid")
	private int aiid;
	@Column(name = "id")
	private int id;
	@Column(name = "ndc")
	private String ndc;
	@Column(name = "name")
	private String name;
	@Column(name = "dea")
	private int dea;
	@Column(name = "obsdtec")
	private String obsdtec;
	@Column(name = "repack")
	private int repack;
	@Column(name = "is_compounded")
	private String isCompounded;
	@Column(name = "data_source")
	private String dataSource;
	@Column(name = "version_state")
	private String versionState;
	@Column(name = "retired")
	private String retired;
	@Column(name = "is_controlled_substance")
	private Boolean isControlledSubstance;
	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "last_modified_by")
	private Integer lastModifiedBy;
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	@Column(name = "ref_id")
	private Integer refId;
	@Column(name = "original_ref_id")
	private Integer originalRefId;
	@Column(name = "retired_on")
	private String retiredOn;
	@Column(name = "retired_reason")
	private String retiredReason;
}










