package com.spring.survey.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.spring.survey.entity.Survey;
import com.spring.survey.repository.SurveyRepository;

@Service
public class SurveyService {

	@Autowired
	SurveyRepository surveyRepository;

	

	public List<Survey> getAllSurveys() {
		return surveyRepository.findAll();
	}

	public Optional<Survey> getSurveyById(Long id) {
		return surveyRepository.findById(id);

	}

	public Survey creatSurvey(Survey survey) {
		return surveyRepository.save(survey);

	}

	 public Survey updateSurvey(Long id, Survey surveyDetails) {
	        Survey survey = surveyRepository.findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found with id " + id));
	        survey.setTitle(surveyDetails.getTitle());
	        return surveyRepository.save(survey);
	    }

	    public void deleteSurvey(Long id) {
	        Survey survey = surveyRepository.findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found with id " + id));
	        surveyRepository.delete(survey);
	    }

}
