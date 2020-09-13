package com.jea.medico.service;

import com.amazonaws.services.ec2.model.State;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
/** 
* 
* @author Sibin 
* @since 13 sep 2020 9.25 PM
*/
public interface PatientService {
	public State getStateListService() ;
	public State getDistrictListService();
	public State getVillageListService();
	public State getTalukListService();
	public UserMasterModel authenticateUserService();
	public UserChildModel getStPatientListService();
	public UserMasterModel getUserLastLogService();
	public UserChildModel updatePatientService();
	public State retrivePatMedQstHistService();
	public State getPatHealthDataService();
	public State rerieveNotifService();
	
}
