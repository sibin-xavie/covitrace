package com.jea.medico.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

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
	/**
	 * @modifiedBy Sibin Xavier
	 * @date 27 oct 2020
	 * @desc changed from boolean to double
	 */
	@Column(name = "blood_sugar_count",length = 3,nullable = false)
	private double bloodSugarCount;
	/**
	 * @modifiedBy Sibin Xavier
	 * @date 27 oct 2020 10:35 am
	 * @desc changed from int to double
	 * Start
	 */
	@Column(name = "temp_count", length = 3,nullable = false)
	private double temperatureCount;
	@Column(name = "heart_rate_count", length = 3,nullable = false)
	private double heartRateCount;
	@Column(name = "blood_pressure_count_sys", length = 3,nullable = false)
	private double bloodPressureCountSys;
	@Column(name = "blood_pressure_count_dia", length = 3,nullable = false)
	private double bloodPressureCountDia;
		/*End*/
	/**
	 * @modifiedBy Sibin Xavier
	 * @date 27 oct 2020 10:35 am
	 * @desc added date and time
	 * Start
	 */
	@GeneratedValue
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "created_date", length = 100,nullable = false)
	private Date createdDate = new Date();
	@GeneratedValue
	@Temporal(javax.persistence.TemporalType.TIME)
	@Column(name = "created_time", length = 100,nullable = false)
	private Date createdTime = new java.sql.Date(new java.util.Date().getTime());
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserMasterModel userId; 
}
