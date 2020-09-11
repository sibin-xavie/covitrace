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
* @since 11 sep 2020 3.22 PM
*/
@Entity
@Table(name = "config_info")
public @Data class ConfigModel {
	@Id
	@GeneratedValue
	@Column(name="config_id")
	private int configId;
	
	@Column(name="key" , length = 40, unique = true, nullable = false)
	private String key;
	
	

}
