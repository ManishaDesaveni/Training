package com.example.first_rest_api.survey;

import java.util.List;

public class Questtion {

	public Questtion() {
	}

	public Questtion(String id, String qstn, String answer, List<String> options) {
		super();
		this.id = id;
		this.qstn = qstn;
		this.answer = answer;
		this.options = options;
	}

	private String id;
	private String qstn;
	private String answer;
	private List<String> options;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQstn() {
		return qstn;
	}

	public String getAnswer() {
		return answer;
	}

	public List<String> getOptions() {
		return options;
	}

	@Override
	public String toString() {
		return "Questtion [id=" + id + ", qstn=" + qstn + ", answer=" + answer + ", options=" + options + "]";
	}

}
