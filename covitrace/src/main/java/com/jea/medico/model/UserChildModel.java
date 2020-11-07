package com.jea.medico.model;

import java.util.Date;

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
	
	@Column(name = "f_name", length = 18,nullable = false)
	private String userFirstName;
	@Column(name = "l_name", length = 18,nullable = false)
	private String userLastName;
	/**
	 * modifiedby Sibin Xavier
	 * Desc changed "userFromAddress","userToAddress" and removed userAddress
	 * modifiedOn 04 Nov 2020
	 */
	@Column(name = "adress_line1", length = 150,nullable = false)
	private String userAddressLine1;
	@Column(name = "adress_line2", length = 150,nullable = false)
	private String userAddressLine2;
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
	@Column(name = "user_lat", length = 50,nullable = false)
	private double userLat;
	@Column(name = "user_lng", length = 50,nullable = false)
	private double userLong;
	@Column(name = "isolated_in", length = 50,nullable = false)
	private boolean userIsolatedStatus;
	@Column(name = "user_image_path", length = 500)
	private String userImagePath;
	/**
	 * modifiedby Sibin Xavier
	 * Desc added for some more condition
	 * modifiedOn 30 oct 2020
	 */
	@Column(name = "is_asympt", length = 2,nullable = false)
	private boolean asymptomatic;
	@Column(name = "is_sympt", length = 2,nullable = false)
	private boolean symptomatic;
	@Column(name = "is_cov_testd", length = 2,nullable = false)
	private boolean covidTested;
	/**
	 * modifiedby Sibin Xavier
	 * Desc nullable true to false
	 * modifiedOn 04 Nov 2020
	 */
	@OneToOne
	@JoinColumn(name = "user_id",nullable = false)
	private UserMasterModel userId; 
	/*Risk category*/
	
	
	/**
	 * modifiedby Sibin Xavier
	 * Desc added phone number
	 * modifiedOn 04 Nov 2020
	 */
	@Column(name = "contact_no", length = 150,nullable = false)
	private String userContactNumber;
	
	/**
	 * modifiedby Sibin Xavier
	 * Desc added dob and gender
	 * modifiedOn 06 Nov 2020
	 */
	@Column(name = "pat_dob", length = 10,nullable = false)
	private Date patDob;
	@Column(name = "gender", length = 150,nullable = false)
	private String gender;
}
