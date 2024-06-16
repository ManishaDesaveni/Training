package com.example.first_rest_api.survey;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class surveyResource {

	private surveyService surveyservice;

	public surveyResource(surveyService surveyservice) {
		super();
		this.surveyservice = surveyservice;
	}

	@RequestMapping("/surveys")
	public List<Survey> retrieveAll() {
		return surveyservice.retrieveall();
	}

	@RequestMapping("/surveys/{surveyId}")
	public Survey retrieveSurvey(@PathVariable String surveyId) {
		Survey survey = surveyservice.retrieveSurvey(surveyId);
		if (survey == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found");
		}
		return survey;
	}

	@RequestMapping("/surveys/{surveyId}/questions/")
	public List<Questtion> retrieveQuestions(@PathVariable String surveyId) {
		List<Questtion> qstns = surveyservice.retrieveQuestions(surveyId);
		if (qstns == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found");
		}
		return qstns;
	}

	@RequestMapping("/surveys/{surveyId}/questions/{qstnid}")
	public Questtion retrievespecificQuestion(@PathVariable String surveyId, @PathVariable String qstnid) {
		Questtion qstns = surveyservice.retrievespecificQuestions(surveyId, qstnid);
		if (qstns == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found");
		}
		return qstns;
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions/", method = RequestMethod.POST)
	public ResponseEntity<String> addNewQstns(@PathVariable String surveyId, @RequestBody Questtion qstnn) {
		try {
			Survey survey = retrieveSurvey(surveyId);
			if (survey != null) {

				List<Questtion> questions = new ArrayList<>(survey.getQstns());
				// Create a mutable copy of the list
				SecureRandom randomsecure = new SecureRandom();
				String randomid = new BigInteger(32, randomsecure).toString();
				qstnn.setId(randomid);
				questions.add(qstnn);
				survey.setQstns(questions); // Set the modified list back to the survey
				return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Survey not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			// Log the exception for debugging purposes
			ex.printStackTrace();
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/surveys/{surveyId}/questions/{qstnid}")
	public ResponseEntity<String> deleteQuestion(@PathVariable String surveyId, @PathVariable String qstnid) {
		Survey survey = retrieveSurvey(surveyId);
		if (survey != null) {
			List<Questtion> questions = new ArrayList<>(survey.getQstns());
			Optional<Questtion> questionToRemove = questions.stream().filter(q -> q.getId().equals(qstnid)).findFirst();
			if (questionToRemove.isPresent()) {
				questions.remove(questionToRemove.get());
				survey.setQstns(questions);
				return ResponseEntity.ok("Question deleted successfully");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Survey not found");
		}
	}

	@PutMapping(value = "/surveys/{surveyId}/questions/{qstnid}")
	public ResponseEntity<String> updateQuestion(@PathVariable String surveyId, @PathVariable String qstnid,
			@RequestBody String qstn) {
		Survey survey = retrieveSurvey(surveyId);
		if (survey != null) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				Questtion updatedQuestion = objectMapper.readValue(qstn, Questtion.class);

				List<Questtion> questions = new ArrayList<>(survey.getQstns());
				Optional<Questtion> questionToRemove = questions.stream().filter(q -> q.getId().equals(qstnid))
						.findFirst();
				if (questionToRemove.isPresent()) {
					questions.remove(questionToRemove.get());
					questions.add(updatedQuestion);
					survey.setQstns(questions);
					return ResponseEntity.ok("Question updated successfully");
				} else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
				}
			} catch (IOException e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request body");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Survey not found");
		}
	}

}
