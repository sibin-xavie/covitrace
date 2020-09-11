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
* @since 11 sep 2020 12.15 PM
*/
@Entity
@Table(name="user_master")
public class UserMasterModel {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	public int userId;
	
	@OneToOne
	@JoinColumn(name = "role_id")
	public int roleId;
	@Column(name = "username",length = 150,nullable = false, unique = true)
	public String username;
	@Column(name = "password",length = 200,nullable = false, unique = true)
	public String userPassword;
	
	

}
