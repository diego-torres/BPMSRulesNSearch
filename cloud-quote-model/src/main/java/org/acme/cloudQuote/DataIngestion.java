package org.acme.cloudQuote;

import java.io.Serializable;

public class DataIngestion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean requiresLicense;
	private String apiLicenseNumber;
	private Boolean requiresDataQuality;
	private String etlTool;
	private String developersQuantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getRequiresDataQuality() {
		return requiresDataQuality;
	}

	public void setRequiresDataQuality(Boolean requiresDataQuality) {
		this.requiresDataQuality = requiresDataQuality;
	}

	public String getEtlTool() {
		return etlTool;
	}

	public void setEtlTool(String etlTool) {
		this.etlTool = etlTool;
	}

	public String getDevelopersQuantity() {
		return developersQuantity;
	}

	public void setDevelopersQuantity(String developersQuantity) {
		this.developersQuantity = developersQuantity;
	}

	public Boolean getRequiresLicense() {
		return requiresLicense;
	}

	public void setRequiresLicense(Boolean requiresLicense) {
		this.requiresLicense = requiresLicense;
	}

	public String getApiLicenseNumber() {
		return apiLicenseNumber;
	}

	public void setApiLicenseNumber(String apiLicenseNumber) {
		this.apiLicenseNumber = apiLicenseNumber;
	}
}
