package org.acme.cloud_solution_projects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@OneToOne(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	@JsonManagedReference
	public CloudSolution getCloudSolution() {
		return cloudSolution;
	}

	public void setCloudSolution(CloudSolution cloudSolution) {
		this.cloudSolution = cloudSolution;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval=true)
	public DataIngestion getDataIngestion() {
		return dataIngestion;
	}

	public void setDataIngestion(DataIngestion dataIngestion) {
		if (dataIngestion != null)
			dataIngestion.setProject(this);
		this.dataIngestion = dataIngestion;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval=true)
	public DataVisualization getDataVisualization() {
		return dataVisualization;
	}

	public void setDataVisualization(DataVisualization dataVisualization) {
		if (dataVisualization != null)
			dataVisualization.setProject(this);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Project)) {
			return false;
		}
		Project other = (Project) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}