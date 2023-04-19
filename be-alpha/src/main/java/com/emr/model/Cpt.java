package com.emr.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cpt_short")
public class Cpt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Column(name="Code")
	private String code;
	@Column(name="ShortName")
	private String shortName;
	@Column(name="Description")
	private  String description;
	@Column(name="IsHCPCS")
	private Boolean isHCPCS;
	@Column(name="modifiedby")
	private String modifiedby;
	@Column(name="createdby")
	private String createdby;
	@Column(name="modifieddate")
	private Date modifieddate;
	@Column(name="createddate")
	private Date createddate;
	@Column(name="refId")
	private Integer refId;
	@Column(name="retired")
	private Boolean retired;
	@Column(name="versionState")
	private String versionState;
	@Column(name="originalRefId")
	private Integer originalRefId;
	@Column(name="retiredReason")
	private String retiredReason; 
	@Column(name="retiredOn")
	private Integer retiredOn ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsHCPCS() {
		return isHCPCS;
	}
	public void setIsHCPCS(Boolean isHCPCS) {
		this.isHCPCS = isHCPCS;
	}
	
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	
	public Boolean getRetired() {
		return retired;
	}
	public void setRetired(Boolean retired) {
		this.retired = retired;
	}
	public String getVersionState() {
		return versionState;
	}
	public void setVersionState(String versionState) {
		this.versionState = versionState;
	}
	
	public Integer getRefId() {
		return refId;
	}
	public void setRefId(Integer refId) {
		this.refId = refId;
	}
	public Integer getOriginalRefId() {
		return originalRefId;
	}
	public void setOriginalRefId(Integer originalRefId) {
		this.originalRefId = originalRefId;
	}
	public String getRetiredReason() {
		return retiredReason;
	}
	public void setRetiredReason(String retiredReason) {
		this.retiredReason = retiredReason;
	}
	public Integer getRetiredOn() {
		return retiredOn;
	}
	public void setRetiredOn(Integer retiredOn) {
		this.retiredOn = retiredOn;
	}
	
	
	
	

}
