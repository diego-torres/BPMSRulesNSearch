package org.acme.cloud_solution_projects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class DataIngestion implements java.io.Serializable {
	static final long serialVersionUID = 1L;

	private Long projectId;
	private Boolean requiresLicense;
	private String licenseNumber;
	private String etlToolPreference;
	private Integer developersQuantity;
	
	private Project project;

	public DataIngestion() {
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "project"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "project_id", unique = true, nullable = false)
	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(java.lang.Long projectId) {
		this.projectId = projectId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column
	public Boolean getRequiresLicense() {
		return this.requiresLicense;
	}

	public void setRequiresLicense(Boolean requiresLicense) {
		this.requiresLicense = requiresLicense;
	}

	@Column
	public String getLicenseNumber() {
		return this.licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	@Column
	public String getEtlToolPreference() {
		return this.etlToolPreference;
	}

	public void setEtlToolPreference(String etlToolPreference) {
		this.etlToolPreference = etlToolPreference;
	}

	@Column
	public Integer getDevelopersQuantity() {
		return this.developersQuantity;
	}

	public void setDevelopersQuantity(Integer developersQuantity) {
		this.developersQuantity = developersQuantity;
	}

	public DataIngestion(java.lang.Long id, java.lang.Boolean requiresLicense, java.lang.String licenseNumber,
			java.lang.String etlToolPreference, java.lang.Integer developersQuantity) {
		this.projectId = id;
		this.requiresLicense = requiresLicense;
		this.licenseNumber = licenseNumber;
		this.etlToolPreference = etlToolPreference;
		this.developersQuantity = developersQuantity;
	}

	@Override
	public String toString() {
		return "DataIngestion [id=" + projectId + ", requiresLicense=" + requiresLicense + ", licenseNumber=" + licenseNumber
				+ ", etlToolPreference=" + etlToolPreference + ", developersQuantity=" + developersQuantity + "]";
	}

}