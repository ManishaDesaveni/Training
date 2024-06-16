package com.example.first_rest_api.survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class surveyService {

	private List<Survey> surveys;

	public surveyService() {
		// Initialize surveys
		List<Questtion> questions1 = Arrays.asList(
				new Questtion("Question1", "Most Popular Cloud Platform Today", "AWS",
						Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud")),
				new Questtion("Question2", "Fastest Growing Cloud Platform", "Google Cloud",
						Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud")),
				new Questtion("Question3", "Most Popular DevOps Tool", "Kubernetes",
						Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps")));

		// Create Survey object
		Survey survey1 = new Survey("survey1", "My Favorite Survey", "description of survey", questions1);

		// Add Survey to the list
		surveys = new ArrayList<>();
		surveys.add(survey1);
	}

	public List<Survey> retrieveall() {
		return this.surveys;
	}

	public Survey retrieveSurvey(String id) {
		Optional<Survey> optionalSurvey = surveys.stream().filter(survey -> survey.getId().equals(id)).findFirst();
		return optionalSurvey.orElse(null); // Return null if no survey is found
	}

	public List<Questtion> retrieveQuestions(String id) {
		Survey surr = retrieveSurvey(id);
		return surr.getQstns();
	}

	public Questtion retrievespecificQuestions(String id, String qstn) {
		List<Questtion> qstns = retrieveQuestions(id);

		Optional<Questtion> qq = qstns.stream().filter(q -> q.getId().equalsIgnoreCase(qstn)).findFirst();
		return qq.orElse(null);
	}

}
