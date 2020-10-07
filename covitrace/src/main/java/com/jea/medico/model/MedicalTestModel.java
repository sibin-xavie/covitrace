package com.jea.medico.model;

import java.util.Date;

import javax.persistence.Column;
/** 
* 
* @author Sibin 
* @since 06 oct 2020 2.45 PM
*/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "medical_test_info")
public class MedicalTestModel {
	@Id
	@GeneratedValue
	@Column(name = "med_test_id")
	private int medTestId;
	@Column(name = "med_name", length = 100,nullable = false)
	private String medicineName;
	@Column(name = "test_date", length = 10,nullable = false)
	private Date medTestDate;
	@Column(name = "test_result", length = 100,nullable = false)
	private String medTestResult;
	@Column(name = "test_remark", length = 100,nullable = false)
	private String medTestRemark;
	
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserMasterModel userId; 

}
