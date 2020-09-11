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
	public int medicalDtlsId;
	@OneToOne
	@JoinColumn(name = "user_id")
	public int userId; 
	@Column(name = "covid_tested", length = 1,nullable = false)
	public boolean isCovedTested;
	@Column(name = "quaren_stat", length = 8,nullable = false)
	public String patQuarenStats;


}
