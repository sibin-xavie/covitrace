package com.jea.medico.service;


import java.util.List;
import java.util.Optional;

import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.PatientMedicationInfoModel;
import com.jea.medico.model.PatientMedictnModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
/** 
* 
* @author Sibin 
* @since 13 sep 2020 9.25 PM
* @implSpec gives the services for Health worker module
*/
public interface HealthWorkerService {
	/** 
	* @author Sibin 
	* @since 13 sep 2020 9.25 PM
	* @return {@link List}
	* @implSpec gives the state,village,taluk,district list from the StateModel
	*/
	public List<StateModel> getStateListService() ;
	/** 
	* @author Sibin 
	* @since 14 sep 2020 
	* @return {@link List}
	* @implSpec authenticates user :Healthworker,patient,zone from the UserMasterModel 
	* @param String username
	* @param String password
	*/
	public List<UserMasterModel> authenticateUserService(String username, String password);
	/** 
	* @author Sibin 
	* @since 14 sep 2020 
	* @return {@link List}
	* @implSpec retrives the list of patients from the UserChildModel 
	* @param Integer userId 
	*/
	public List<UserChildModel> getStPatientListService();
	/** 
	* @author Sibin 
	* @since 14 sep 2020 
	* @return {@link List}
	* @implSpec retrives the last login details from the userMasterModel
	* @param Integer userId 
	*/
	public List<UserMasterModel> getUserLastLogService(int userId);
	/** 
	* @author Sibin 
	* @since 14 sep 2020 
	* @return {@link Integer}
	* @implSpec update the patient in userChildModel
	* @param Integer userId 
	*/
	public int updatePatientService(boolean isolatedStatus, int userId);
	/** 
	* @author Sibin 
	* @since 14 sep 2020 
	* @return {@link List}
	* @implSpec update the patient Medical history in  PatientMedictnModel
	* @param Integer userId 
	*/
	public MedicalDtlsModel retrivePatMedQstHistService(int userId);
	/** 
	* @author Sibin 
	* @since 14 sep 2020 
	* @return {@link List}
	* @implSpec retrieve the patient Medical history in  PatientMedictnModel join PatientMedicationInfoModel
	* @param Integer userId 
	*/
	public List<MedicalDtlsModel> getPatHealthDataService(int userId);
	/** 
	* @author Sibin 
	* @since 14 sep 2020 
	* @return {@link MedicalDtlsModel}
	* @implSpec add the patient Medical history
	* @param Integer userId 
	*/
	
	public MedicalDtlsModel addPatHealthDataSaveService(MedicalDtlsModel medicalDltlsModel);
	
}