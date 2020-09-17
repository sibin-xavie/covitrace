package com.jea.medico.model;

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
* @since 11 sep 2020 5.45 PM
*/
@Entity
@Data
@Table(name = "patient_medication")
public  class PatientMedictnModel {
	@Id
	@GeneratedValue
	@Column(name = "pat_med_id")
	private int patMedId;
	
	@Column(name = "med_name", length = 100,nullable = false)
	private String medicineName;
	@Column(name = "med_type", length = 50,nullable = false)
	private String medicineType;
	@Column(name = "severity", length = 3,nullable = false)
	private int medsverity;
	@Column(name = "dosage", length = 3,nullable = false)
	private String medDosage;
	@Column(name = "blood_sugar_count",nullable = false)
	private boolean bloodSugarCount;
	@Column(name = "temp_count", length = 3,nullable = false)
	private int temperatureCount;
	@Column(name = "heart_rate_count", length = 3,nullable = false)
	private int heartRateCount;
	@Column(name = "blood_pressure_count_sys", length = 3,nullable = false)
	private int bloodPressureCountSys;
	@Column(name = "blood_pressure_count_dia", length = 3,nullable = false)
	private int bloodPressureCountDia;

	
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserMasterModel userId; 
}
