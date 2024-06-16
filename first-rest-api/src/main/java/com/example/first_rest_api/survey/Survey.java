package com.example.first_rest_api.survey;

import java.util.List;

public class Survey {

	public Survey() {
	}

	public Survey(String id, String title, String description, List<Questtion> qstns) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.qstns = qstns;
	}

	private String id;
	private String title;
	private String description;
	private List<Questtion> qstns;

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public void setQstns(List<Questtion> qstns) {
		this.qstns = qstns;
	}

	public List<Questtion> getQstns() {
		return qstns;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", title=" + title + ", description=" + description + ", qstns=" + qstns + "]";
	}

}
