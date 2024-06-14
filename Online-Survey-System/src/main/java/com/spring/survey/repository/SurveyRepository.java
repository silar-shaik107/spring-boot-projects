package com.spring.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.survey.entity.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

	List<Survey> findAll();

}
