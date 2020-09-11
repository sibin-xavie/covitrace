package com.jea.medico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/** 
* 
* @author Sibin 
* @since 11 sep 2020 12.15 PM
*/
import lombok.Data;
@Entity
@Data
@Table(name = "role_info")
public class RoleModel {
	@Id
	@GeneratedValue
	@Column(name = "role_id" )
	private int roleId;
	@Column(name = "role" ,length = 24, unique = true ,nullable = false)
	private String role;

}
