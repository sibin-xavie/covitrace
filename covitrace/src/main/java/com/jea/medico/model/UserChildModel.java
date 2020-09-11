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
* @since 11 sep 2020 1.20 PM
*/

@Entity
@Table(name="user_child")
public class UserChildModel {
	@Id
	@GeneratedValue
	@Column(name = "user_child_id")
	public int userChildId;
	@OneToOne
	@JoinColumn(name = "user_id")
	public int userId; 
	@Column(name = "f_name", length = 18,nullable = false)
	public String userFirstName;
	@Column(name = "l_name", length = 18,nullable = false)
	public String userLastName;
	@Column(name = "address", length = 150,nullable = false)
	public String userAddress;
	@Column(name = "from_address", length = 150,nullable = false)
	public String userFromAddress;
	@Column(name = "to_address", length = 150,nullable = false)
	public String userToAddress;
	@Column(name = "state", length = 30,nullable = false)
	public String userState;
	@Column(name = "city", length = 40,nullable = false)
	public String userCity;
	@Column(name = "village", length = 50,nullable = false)
	public String userVillage;
	@Column(name = "taluk", length = 50,nullable = false)
	public String userTaluk;
	@Column(name = "email", length = 50,nullable = false)
	public String userEmail;
	@Column(name = "isolated_in", length = 50,nullable = false)
	public boolean userIsolatedStatus;
	
	
	
}
