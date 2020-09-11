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
@Entity
@Table(name = "medical_details")
public class MedicalDtlsModel {
	@Id
	@GeneratedValue
	@Column(name = "medical_id")
	private int medicalDtlsId;
	@OneToOne
	@JoinColumn(name = "user_id")
	private int userId; 
	@Column(name = "covid_tested", length = 1,nullable = false)
	private boolean isCovedTested;
	@Column(name = "quaren_stat", length = 8,nullable = false)
	private String patQuarenStats;


}
