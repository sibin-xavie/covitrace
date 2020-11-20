package com.jea.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.PatQuestionsModel;
@Repository
public interface PatQuestionsRepo extends JpaRepository<PatQuestionsModel, Integer> {
	@Modifying
	@Query("delete from PatQuestionsModel p where p.questionId=?1")
	int deleteByPatMedId(Integer questionId);
	@Query("select q from PatQuestionsModel q where q.questionId = ?1 ")
	PatQuestionsModel randomQstDtlsService(int questionId);
	
	@Query("select count(questionId) from PatQuestionsModel ")
	int randomQstDtlsServiceCount();
	
	
}
