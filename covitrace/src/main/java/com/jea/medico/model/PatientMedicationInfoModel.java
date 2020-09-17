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

/** 
* 
* @author Sibin 
* @since 11 sep 2020 6.20 PM
*/

@Entity
@Table(name = "medication_info")
public @Data class PatientMedicationInfoModel {
	@Id
	@GeneratedValue
	@Column(name = "med_id")
	private int medicineId;
	
	@Column(name = "quaren_start_date", length = 10,nullable = false)
	private Date quarenStartDate;
	@Column(name = "expected_end_date", length = 10,nullable = false)
	private Date expectedEndDate;
	@Column(name = "progress", length = 3,nullable = false)
	private String patProgress;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserMasterModel userId; 
	@OneToOne
	@JoinColumn(name = "pat_med_id")
	private PatientMedictnModel patMedId; 
}
