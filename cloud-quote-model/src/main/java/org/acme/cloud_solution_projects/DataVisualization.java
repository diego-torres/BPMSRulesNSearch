package org.acme.cloud_solution_projects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * This class was automatically generated by the data modeler tool.
 */

@Entity
public class DataVisualization implements java.io.Serializable {
	static final long serialVersionUID = 1L;

	private Long projectId;
	private Boolean requiresLicense;
	private String licenseNumber;
	private Integer endUsersQuantity;
	private Integer developersQuantity;
	private String preferredVisualizationTool;

	private Project project;

	public DataVisualization() {
	}

	@Id
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
		Project clone = new Project();
		clone.setId(project == null ? 0 : project.getId());
		return clone;
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
	public Integer getEndUsersQuantity() {
		return this.endUsersQuantity;
	}

	public void setEndUsersQuantity(Integer endUsersQuantity) {
		this.endUsersQuantity = endUsersQuantity;
	}

	@Column
	public Integer getDevelopersQuantity() {
		return this.developersQuantity;
	}

	public void setDevelopersQuantity(Integer developersQuantity) {
		this.developersQuantity = developersQuantity;
	}

	@Column
	public String getPreferredVisualizationTool() {
		return this.preferredVisualizationTool;
	}

	public void setPreferredVisualizationTool(String preferredVisualizationTool) {
		this.preferredVisualizationTool = preferredVisualizationTool;
	}

	public DataVisualization(java.lang.Long id, java.lang.Boolean requiresLicense, java.lang.String licenseNumber,
			java.lang.Integer endUsersQuantity, java.lang.Integer developersQuantity,
			java.lang.String preferredVisualizationTool) {
		this.projectId = id;
		this.requiresLicense = requiresLicense;
		this.licenseNumber = licenseNumber;
		this.endUsersQuantity = endUsersQuantity;
		this.developersQuantity = developersQuantity;
		this.preferredVisualizationTool = preferredVisualizationTool;
	}

	@Override
	public String toString() {
		return "DataVisualization [id=" + projectId + ", requiresLicense=" + requiresLicense + ", licenseNumber="
				+ licenseNumber + ", endUsersQuantity=" + endUsersQuantity + ", developersQuantity="
				+ developersQuantity + ", preferredVisualizationTool=" + preferredVisualizationTool + "]";
	}

}