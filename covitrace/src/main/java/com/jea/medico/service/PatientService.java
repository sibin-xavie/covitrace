package com.jea.medico.service;


import java.util.List;

import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
/** 
* 
* @author Sibin 
* @since 13 sep 2020 9.25 PM
*/
public interface PatientService {
	public List<StateModel> getStateListService() ;
	public List<UserMasterModel> authenticateUserService();
	public List<UserChildModel> getStPatientListService();
	public List<UserMasterModel> getUserLastLogService();
	public List<UserChildModel> updatePatientService();
	public List<MedicalDtlsModel> retrivePatMedQstHistService();
	public List<MedicalDtlsModel> getPatHealthDataService();
	
}
