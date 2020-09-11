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
* @since 11 sep 2020 5.45 PM
*/
@Entity
@Table(name = "patient_medication")
public class PatientMedictnModel {
	@Id
	@GeneratedValue
	@Column(name = "pat_med_id")
	public int patMedId;
	@OneToOne
	@JoinColumn(name = "user_id")
	public int userId; 
	@Column(name = "med_name", length = 100,nullable = false)
	public String medicineName;
	@Column(name = "med_type", length = 50,nullable = false)
	public String medicineType;
	@Column(name = "severity", length = 3,nullable = false)
	public int medsverity;
	@Column(name = "dosage", length = 3,nullable = false)
	public String medDosage;
	
}