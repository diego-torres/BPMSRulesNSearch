package org.acme.cloud_solution_projects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Project implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String email;
	private Double price;
	private Boolean informationCompleted = false;

	private CloudSolution cloudSolution;
	private DataIngestion dataIngestion;
	private DataVisualization dataVisualization;
	private ViewRecommendation viewRecommendation = new ViewRecommendation();

	public Project() {
	}

	@Id
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column
	public Boolean getInformationCompleted() {
		return this.informationCompleted;
	}

	public void setInformationCompleted(Boolean informationCompleted) {
		this.informationCompleted = informationCompleted;
	}

	@OneToOne(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public CloudSolution getCloudSolution() {
		return cloudSolution;
	}

	public void setCloudSolution(CloudSolution cloudSolution) {
		this.cloudSolution = cloudSolution;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL)
	public DataIngestion getDataIngestion() {
		return dataIngestion;
	}

	public void setDataIngestion(DataIngestion dataIngestion) {
		this.dataIngestion = dataIngestion;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL)
	public DataVisualization getDataVisualization() {
		return dataVisualization;
	}

	public void setDataVisualization(DataVisualization dataVisualization) {
		this.dataVisualization = dataVisualization;
	}

	public ViewRecommendation getViewRecommendation() {
		return viewRecommendation;
	}

	public void setViewRecommendation(ViewRecommendation viewRecommendation) {
		this.viewRecommendation = viewRecommendation;
	}

	public Project(java.lang.Long id, java.lang.String title, java.lang.String email, java.lang.Double price,
			java.lang.Boolean informationCompleted) {
		this.id = id;
		this.title = title;
		this.email = email;
		this.price = price;
		this.informationCompleted = informationCompleted;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", email=" + email + ", price=" + price
				+ ", informationCompleted=" + informationCompleted + ", cloudSolution=" + cloudSolution
				+ ", dataIngestion=" + dataIngestion + ", dataVisualization=" + dataVisualization
				+ ", viewRecommendation=" + viewRecommendation + "]";
	}

}