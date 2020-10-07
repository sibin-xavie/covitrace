package com.jea.medico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/** 
* 
* @author Sibin 
* @since 11 sep 2020 1.15 PM
*/
@Entity
@Table(name="state_info")
public @Data class StateModel {
	@Id
	@GeneratedValue
	@Column(name="state_id")
	private int stateId;
	@Column(name="state",length = 35 ,nullable = false)
	private String stateName;
	@Column(name="district" ,length = 80 ,nullable = false)
	private String districtName;
	@Column(name="taluk" ,length = 70 , unique = true,nullable = false)
	private String talukName; 
	@Column(name="country" ,length = 40 ,nullable = false)
	private String countryName; 
	@Column(name="iso_code" ,length = 3 ,nullable = false)
	private String CountryISOCode; 
	
	
	@Column(name="contmnt_zone" ,length = 100 ,nullable = false)
	private String containmentZone; 
	

}
