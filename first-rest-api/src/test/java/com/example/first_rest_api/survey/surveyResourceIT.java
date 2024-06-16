package com.example.first_rest_api.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class surveyResourceIT {

	@Autowired
	private TestRestTemplate template;

	@Test
	void retrieveSpecificQuestion_basicScenario() throws IOException {
		String specificURL = "/surveys/survey1/questions/Question1";
		ResponseEntity<String> responseEntity = template.getForEntity(specificURL, String.class);

		String expected = """
				{
				    "id": "Question1",
				    "qstn": "Most Popular Cloud Platform Today",
				    "answer": "AWS",
				    "options": [
				        "AWS",
				        "Azure",
				        "Google Cloud",
				        "Oracle Cloud"
				    ]
				} """;

		// Printing both JSON strings to identify differences
		System.out.println("Expected: " + expected.trim());
		System.out.println("Actual: " + responseEntity.getBody().trim());

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> expectedMap = mapper.readValue(expected, Map.class);
		Map<String, Object> actualMap = mapper.readValue(responseEntity.getBody(), Map.class);

		// Compare the maps to ensure JSON content is the same
		assertEquals(expectedMap, actualMap);
	}
}
