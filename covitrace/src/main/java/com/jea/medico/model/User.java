package com.jea.medico.model;

import lombok.Data;

@Data
public class User {

	private UserMasterModel master;
	private UserChildModel child;
	
}
