package com.jea.medico.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "rand_qst_ans")
public class RandomQstAnswerModel {
	@Id
	@GeneratedValue
	@Column(name = "rand_qst_id")
	private int randQstId;
	
	@Column(name = "rand_qst_no_idfk", length = 100,nullable = false)
	private String randQstIdFk;
	
	@Column(name = "rand_qst_ans", length = 250,nullable = false)
	private String randQstAns;
	@Column(name = "mod_date", length = 100,nullable = false)
	private Date modDate;
	@Column(name = "created_date", length = 100,nullable = false)
	private Date createdDate;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserMasterModel userId; 

}
