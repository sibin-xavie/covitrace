package com.jea.medico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "pat_qst_info")
public class PatQuestionsModel {
	
	@Id
	@GeneratedValue
	@Column(name="qst_id")
	private int questionId;
	
	@Column(name="question" , length = 400, unique = true, nullable = false)
	private String question;

}
