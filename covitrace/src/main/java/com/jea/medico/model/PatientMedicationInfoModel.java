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
@Table(name = "medication_info")
public class PatientMedicationInfoModel {
	@Id
	@GeneratedValue
	@Column(name = "med_id")
	public int medicineId;
	@OneToOne
	@JoinColumn(name = "user_id")
	public int userId; 
	@OneToOne
	@JoinColumn(name = "pat_med_id")
	public int patMedicalId; 
	@Column(name = "quaren_start_date", length = 10,nullable = false)
	public boolean quarenStartDate;
	@Column(name = "expected_end_date", length = 10,nullable = false)
	public String expectedEndDate;
	@Column(name = "progress", length = 3,nullable = false)
	public String patProgress;
}