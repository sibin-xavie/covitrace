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
* @since 11 sep 2020 3.30 PM
*/
@Entity
@Table(name="manager_details")
public class ManagerDetailsModel {
	@Id
	@GeneratedValue
	@Column(name = "manager_id")
	private int managerId;
	@OneToOne
	@JoinColumn(name = "role_id")
	private int userRoleId; 
	@Column(name = "desination", length = 20,nullable = false)
	private String mgrDesignation;
	@Column(name = "department", length = 20,nullable = false)
	private String mgrDepartment;
	@Column(name = "ward_no", length = 20,nullable = false)
	private int mgrWardNo;
	@Column(name = "specialisation", length = 30,nullable = false)
	private String mgrSpcltn;
	@Column(name = "institution", length = 100,nullable = false)
	private String mgrInstutn;
	
	
}
