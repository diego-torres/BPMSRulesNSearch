package org.acme.cloud_solution_projects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CloudSolution implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private Long projectId;
	private String cloudProvider;
	private String locationCountry;
	private Boolean hasDataVisualization;
	private Boolean hasDataIngestion;

	private Project project;

	public CloudSolution() {
	}

	@Id
	@Column(name = "project_id", unique = true, nullable = false)
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@Column
	public String getCloudProvider() {
		return this.cloudProvider;
	}

	public void setCloudProvider(String cloudProvider) {
		this.cloudProvider = cloudProvider;
	}

	@Column
	public String getLocationCountry() {
		return this.locationCountry;
	}

	public void setLocationCountry(String locationCountry) {
		this.locationCountry = locationCountry;
	}

	@Column
	public Boolean getHasDataVisualization() {
		return this.hasDataVisualization;
	}

	public void setHasDataVisualization(Boolean hasDataVisualization) {
		this.hasDataVisualization = hasDataVisualization;
	}

	@Column
	public Boolean getHasDataIngestion() {
		return this.hasDataIngestion;
	}

	public void setHasDataIngestion(Boolean hasDataIngestion) {
		this.hasDataIngestion = hasDataIngestion;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonIgnore
	public Project getProject() {
		Project clone = new Project();
		clone.setId(project == null ? 0 : project.getId());
		return clone;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public CloudSolution(java.lang.Long projectId, java.lang.String cloudProvider, java.lang.String locationCountry,
			java.lang.Boolean hasDataVisualization, java.lang.Boolean hasDataIngestion) {
		this.projectId = projectId;
		this.cloudProvider = cloudProvider;
		this.locationCountry = locationCountry;
		this.hasDataVisualization = hasDataVisualization;
		this.hasDataIngestion = hasDataIngestion;
	}

	@Override
	public String toString() {
		return "CloudSolution [projectId=" + projectId + ", cloudProvider=" + cloudProvider + ", locationCountry="
				+ locationCountry + ", hasDataVisualization=" + hasDataVisualization + ", hasDataIngestion="
				+ hasDataIngestion + "]";
	}

}