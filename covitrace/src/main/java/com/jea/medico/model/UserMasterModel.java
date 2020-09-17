package com.jea.medico.model;

import java.sql.Date;

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
* @since 11 sep 2020 12.15 PM
*/
@Entity
@Table(name="user_master")
public @Data class UserMasterModel {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	@OneToOne
	@JoinColumn(name = "role_id")
	private RoleModel roleId;
	@Column(name = "username",length = 150,nullable = false, unique = true)
	private String username;
	@Column(name = "password",length = 200,nullable = false, unique = true)
	private String userPassword;
	@Column(name = "user_log",length = 200,nullable = false, unique = true)
	private Date userLastLog;
	
	

}
