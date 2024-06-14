package com.spring.survey.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.survey.entity.Survey;
import com.spring.survey.exception.ResourceNotFoundException;
import com.spring.survey.repository.SurveyRepository;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
	@Autowired
	private SurveyRepository surveyRepository;

	@GetMapping("/get")
	public List<Survey> getAllSurveys() {
		return surveyRepository.findAll();
	}

	@PostMapping("/create")
	public Survey createSurvey(@RequestBody Survey survey) {
		return surveyRepository.save(survey);
	}

	@GetMapping("/{id}")
	public Survey getSurveyById(@PathVariable Long id) {
		return surveyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));
	}

	@PutMapping("/{id}")
	public Survey updateSurvey(@PathVariable Long id, @RequestBody Survey surveyDetails) {
		Survey survey = surveyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));

		survey.setTitle(surveyDetails.getTitle());
		// Update other fields as needed

		return surveyRepository.save(survey);
	}

	@DeleteMapping("/{id}")
	public void deleteSurvey(@PathVariable Long id) {
		Survey survey = surveyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));

		surveyRepository.delete(survey);
	}
}
