package com.jea.medico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
* 
* @author Sibin 
* @since 11 sep 2020 1.15 PM
*/
@Entity
@Table(name="state_info")
public class StateModel {
	@Id
	@GeneratedValue
	@Column(name="state_id")
	public int stateId;
	@Column(name="state",length = 35 ,nullable = false)
	public String stateName;
	@Column(name="district" ,length = 80 ,nullable = false)
	public String districtName;
	@Column(name="taluk" ,length = 70 , unique = true,nullable = false)
	public String talukName; 
	@Column(name="country" ,length = 40 ,nullable = false)
	public String countryName; 
	@Column(name="iso_code" ,length = 3 , unique = true,nullable = false)
	public String CountryISOCode; 

}