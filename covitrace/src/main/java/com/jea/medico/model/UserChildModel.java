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
* @since 11 sep 2020 1.20 PM
*/

@Entity
@Table(name="user_child")
public @Data class UserChildModel {
	@Id
	@GeneratedValue
	@Column(name = "user_child_id")
	private int userChildId;
	@OneToOne
	@JoinColumn(name = "user_id")
	private int userId; 
	@Column(name = "f_name", length = 18,nullable = false)
	private String userFirstName;
	@Column(name = "l_name", length = 18,nullable = false)
	private String userLastName;
	@Column(name = "address", length = 150,nullable = false)
	private String userAddress;
	@Column(name = "from_address", length = 150,nullable = false)
	private String userFromAddress;
	@Column(name = "to_address", length = 150,nullable = false)
	private String userToAddress;
	@Column(name = "state", length = 30,nullable = false)
	private String userState;
	@Column(name = "city", length = 40,nullable = false)
	private String userCity;
	@Column(name = "village", length = 50,nullable = false)
	private String userVillage;
	@Column(name = "taluk", length = 50,nullable = false)
	private String userTaluk;
	@Column(name = "email", length = 50,nullable = false)
	private String userEmail;
	@Column(name = "isolated_in", length = 50,nullable = false)
	private boolean userIsolatedStatus;
	
	
	
}
