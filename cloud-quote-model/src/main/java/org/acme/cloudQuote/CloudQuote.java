package org.acme.cloudQuote;

import java.io.Serializable;
import java.math.BigDecimal;

public class CloudQuote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String cloudProvider;
	private String clientLocation;
	private Integer processInstanceId;
	private BigDecimal price = new BigDecimal(0.0);
	private DataIngestion dataIngestion;
	private String recommendations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCloudProvider() {
		return cloudProvider;
	}

	public void setCloudProvider(String cloudProvider) {
		this.cloudProvider = cloudProvider;
	}

	public String getClientLocation() {
		return clientLocation;
	}

	public void setClientLocation(String clientLocation) {
		this.clientLocation = clientLocation;
	}

	public Integer getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(Integer processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public DataIngestion getDataIngestion() {
		return dataIngestion;
	}

	public void setDataIngestion(DataIngestion dataIngestion) {
		this.dataIngestion = dataIngestion;
	}

	public String getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

}
