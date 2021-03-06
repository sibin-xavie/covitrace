package com.jea.medico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/** 
* 
* @author Sibin 
* @since 11 sep 2020 6.20 PM
*/

import lombok.Data;
@Entity
@Data
@Table(name = "medical_details")
public  class MedicalDtlsModel {
	@Id
	@GeneratedValue
	@Column(name = "medical_id")
	private int medicalDtlsId;

	@Column(name = "covid_tested", length = 1,nullable = false)
	private boolean isCovedTested;
	@Column(name = "quaren_stat", length = 8,nullable = false)
	private String patQuarenStats;
	@Column(name = "comments", length = 100,nullable = true)
	private String comments;
	
	@Column(name = "further_obs", length = 100,nullable = true)
	private String further_obser;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserMasterModel userId;



}
