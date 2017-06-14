package org.acme.cloudQuote;

import java.io.Serializable;

public class DataVisualization implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean requiresLicense;
	private String aipLicenseNumber;
	private Integer endUsers;
	private Integer developers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getRequiresLicense() {
		return requiresLicense;
	}

	public void setRequiresLicense(Boolean requiresLicense) {
		this.requiresLicense = requiresLicense;
	}

	public String getAipLicenseNumber() {
		return aipLicenseNumber;
	}

	public void setAipLicenseNumber(String aipLicenseNumber) {
		this.aipLicenseNumber = aipLicenseNumber;
	}

	public Integer getEndUsers() {
		return endUsers;
	}

	public void setEndUsers(Integer endUsers) {
		this.endUsers = endUsers;
	}

	public Integer getDevelopers() {
		return developers;
	}

	public void setDevelopers(Integer developers) {
		this.developers = developers;
	}

}
