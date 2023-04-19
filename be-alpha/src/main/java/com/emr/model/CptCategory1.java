package com.emr.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CptCategory1 {

	@Id
	private int id;
	private String code;
	private String shortName;
	private String description;

	private Boolean isHCPCS;
	private String modifiedby;
	private String createdby;
	private Date modifieddate;
	private Date createddate;
	private Integer refId;
	private Boolean retired;
	private String versionState;
	private Integer originalRefId;
	private String retiredReason;
	private Integer retiredOn;

	private String CPTMajorCategory;
	private String CPTMinorCategory;

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

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
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

	public String getCPTMajorCategory() {
		return CPTMajorCategory;
	}

	public void setCPTMajorCategory(String cPTMajorCategory) {
		CPTMajorCategory = cPTMajorCategory;
	}

	public String getCPTMinorCategory() {
		return CPTMinorCategory;
	}

	public void setCPTMinorCategory(String cPTMinorCategory) {
		CPTMinorCategory = cPTMinorCategory;
	}

}
