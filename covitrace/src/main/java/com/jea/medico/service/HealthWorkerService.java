package com.jea.medico.service;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.MedicalTestModel;
import com.jea.medico.model.PatQuestionsModel;
import com.jea.medico.model.PatientMedicationInfoModel;
import com.jea.medico.model.PatientMedictnModel;
import com.jea.medico.model.RandomQstAnswerModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.User;
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
	public MedicalDtlsModel retrivePatMedQstHistService(UserMasterModel userId);
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
	/** 
	* @author Sibin 
	* @since 15 sep 2020 
	* @return {@link UserChildModel}
	* @implSpec update patient : updating patient information 
	* @param  {@link UserChildModel}
	*/
	public UserChildModel updateUserService(UserChildModel userChildModel);
	
	/** 
	* @author Sibin 
	* @since 15 sep 2020 
	* @return {@link User}
	* @implSpec update patient : updating patient information 
	* @param  {@link UserChildModel}
	*/
	public UserChildModel createUserService(User user)  throws Exception;
	/**
	 * @author sibin
	 * @param PatientMedictnModel
	 * @return PatientMedictnModel
	 * @since 06 oct 2020
	 */
	public PatientMedictnModel addMedicalDtlsService(PatientMedictnModel PatientMedictnModel) ;
	
	public MedicalTestModel addMedicalTestDtlsService(MedicalTestModel medicalTestModel);
	
	public List<MedicalTestModel>  listMedicalTestDtlsService(UserMasterModel userId);
	public int  deleteMedicalTestDtlsService(int medTestId);
	public MedicalTestModel  updateMedicalTestDtlsService(MedicalTestModel medicalTestModel);
	public StateModel addZoneDtlsService(StateModel stateModel);
	public  List<StateModel>  listZoneDtlsService() ;
	public StateModel  updateZoneDtlsService(StateModel stateModel);
	public int  deleteZoneDtlsService(int stateId);
	public PatQuestionsModel addQstDtlsService(PatQuestionsModel patQuestionsModel);
	public PatQuestionsModel updateQstDtlsService(PatQuestionsModel patQuestionsModel);
	public int deleteQstDtlsService(PatQuestionsModel patQuestionsModel);
	public List<PatQuestionsModel>  randomQstDtlsService();
	/**
	 * @author sibin
	 * @since 06 oct 2020
	 * @modifiedOn 23-10-2020
	 * @param UserMasterModel
	 * @return List
	 * @implSpec get the list of medical details like medical count,temp count by user id
	 */
	public List<PatientMedictnModel> listMedicineDtlsService(UserMasterModel userId);
	/**
	 * @author Linoy
	 * @since  20 oct 2020
	 * @param UserMasterModel
	 * @return int
	 * @implSpec save the userrmaster model only like username,password etc in model(No userchild mapped)
	 */
	public int createUserMaster(UserMasterModel user);
	
	public RandomQstAnswerModel randomQstAnswerSaveService(RandomQstAnswerModel randomQstAnswerModel);
	
	public List<PatientMedicationInfoModel>  listPatMediTstUserDtlsService(UserMasterModel usrModel);
	
	public int updateFCMService(String fcmKey, UserMasterModel userId);
}
