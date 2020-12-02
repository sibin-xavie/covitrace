package com.jea.medico.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private  double userLat;
	private  double userLng;
	private int roleId;
	private String success;
	private String errorMsg;
	
	
	

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public double getUserLat() {
		return this.userLat;
	}

	public void setUserLat(double userLat) {
		this.userLat = userLat;
	}

	public double getUserLng() {
		return this.userLng;
	}

	public void setUserLng(double userLng) {
		this.userLng = userLng;
	}

	public JwtResponse(String jwttoken,double userLat,double userLng,int roleId,String successMsg,String erorMsg) {
		this.jwttoken = jwttoken;
		this.userLat = userLat;
		this.userLng = userLng;
		this.roleId = roleId;
		this.success = successMsg;
		this.errorMsg = erorMsg;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	
}