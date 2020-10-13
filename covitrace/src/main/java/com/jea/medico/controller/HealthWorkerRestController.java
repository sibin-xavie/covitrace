package com.jea.medico.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jea.medico.exception.PatientException;
import com.jea.medico.model.MedicalTestModel;
import com.jea.medico.model.PatQuestionsModel;
import com.jea.medico.model.PatientMedictnModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.User;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.service.HealthWorkerService;

/**
 * 
 * @author Vikas
 *
 */
@RestController
@RequestMapping("/api/v1")
public class HealthWorkerRestController {
	@Autowired
	HealthWorkerService healthWkrService;

	@RequestMapping(value = "/patientRegisterService", method = RequestMethod.POST)
	public UserChildModel patientListService(@RequestBody User user) throws PatientException {
		healthWkrService.createUserService(user);
		System.out.println("Address: " + user.getChild().getUserAddress());

		return user.getChild();
	}
	
	

	@RequestMapping(value = "/updatePatientService", method = RequestMethod.POST)
	public int updatePatientService(@RequestBody UserChildModel userDetails) {
		int updateRows = 0;
		UserChildModel user = healthWkrService.updateUserService(userDetails);
		
		if(user != null)
			updateRows = 1;
		return updateRows;
	}

	
	/**
	 * 
	 * @author Sibin
	 * @since 30 Sep 2020
	 */
	
	@RequestMapping(value = "/getStateListServices", method = RequestMethod.POST)
	public List<StateModel> getStateListController() {
		List<StateModel> allStateList = new ArrayList<StateModel>();
		
			allStateList = healthWkrService.getStateListService();
			System.out.println("sibin:::"+allStateList);
			
		
		return allStateList;
	}
	
	
	/**
	 * 
	 * @author Sibin
	 * @since 30 Sep 2020
	 */
	
	
	@RequestMapping(value = "/patientListService", method = RequestMethod.POST)
	public List<UserChildModel> patientListController(){
		List<UserChildModel> allPatientList = null;
		
			allPatientList = healthWkrService.getStPatientListService();
		
		
		return allPatientList;
	}
	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */
	
	@RequestMapping(value = "/addMedDtlsService", method = RequestMethod.POST)
	public int patientMedDtlsController(@RequestBody PatientMedictnModel patientMedictnModel){
		
		int updateRows = 0;
		PatientMedictnModel patMedModel =  healthWkrService.addMedicalDtlsService(patientMedictnModel);
		if(patMedModel != null)
			updateRows = 1;
		return updateRows;
	}
	
	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */
	//****************Med Test Crud 6********************
	@RequestMapping(value = "/addMedTestDtlsService", method = RequestMethod.POST)
	public int patientMedTestDtlsController(@RequestBody MedicalTestModel medicalTestModel){
		
		int updateRows = 0;
		MedicalTestModel medicalTest =  healthWkrService.addMedicalTestDtlsService(medicalTestModel);
		if(medicalTest != null)
			updateRows = 1;
		return updateRows;
	}
	

	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */
	
	@RequestMapping(value = "/listMedTestDtlsService", method = RequestMethod.POST)
	public  List<MedicalTestModel> listPatientMedTestDtlsController(@RequestBody MedicalTestModel medicalTestModel){
		List<MedicalTestModel> medicalTestList =  healthWkrService.listMedicalTestDtlsService(medicalTestModel.getUserId());
		return medicalTestList;
	}
	
	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */
	
	@RequestMapping(value = "/deleteMedTestDtlsService", method = RequestMethod.POST)
	public  int deletePatientMedTestDtlsController(@RequestBody MedicalTestModel medicalTestModel){
		int deleted =  healthWkrService.deleteMedicalTestDtlsService(medicalTestModel.getMedTestId());
		return deleted;
	}
	
	
	@RequestMapping(value = "/updateMedTestDtlsService", method = RequestMethod.POST)
	public  int updatePatientMedTestDtlsController(@RequestBody MedicalTestModel medicalTestModel){
		int updateRows = 0;
		MedicalTestModel medicalTest =  healthWkrService.updateMedicalTestDtlsService(medicalTestModel);
		
		if(medicalTest != null)
			updateRows = 1;
		return updateRows;
	}
	
	
	//***************ZONE CRUD**********************
	
	
	@RequestMapping(value = "/addZoneDtlService", method = RequestMethod.POST)
	public int addZoneController(@RequestBody StateModel stateModel){
		
		int updateRows = 0;
		StateModel state =  healthWkrService.addZoneDtlsService(stateModel);
		if(state != null)
			updateRows = 1;
		return updateRows;
	}
	

	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */
	
	@RequestMapping(value = "/listZoneDtlsService", method = RequestMethod.POST)
	public  List<StateModel> listZoneDtlsController(@RequestBody StateModel stateModel){
		List<StateModel> stateList =  healthWkrService.listZoneDtlsService(stateModel.getStateId());
		return stateList;
	}
	
	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */
	
	@RequestMapping(value = "/deleteZoneDtlsService", method = RequestMethod.POST)
	public  int deletePatientMedTestDtlsController(@RequestBody StateModel stateModel){
		int deleted =  healthWkrService.deleteZoneDtlsService(stateModel.getStateId());
		return deleted;
	}
	
	
	@RequestMapping(value = "/updateZoneDtlsService", method = RequestMethod.POST)
	public  int updatePatientMedTestDtlsController(@RequestBody StateModel stateModel){
		int updateRows = 0;
		StateModel state =  healthWkrService.updateZoneDtlsService(stateModel);
		
		if(state != null)
			updateRows = 1;
		return updateRows;
	}
	
	//********************Questions add/dlete/edit
	

	@RequestMapping(value = "/addQuestionService", method = RequestMethod.POST)
	public int addQuestionController(@RequestBody PatQuestionsModel patQuestionsModel){
		
		int updateRows = 0;
		PatQuestionsModel patQuestion =  healthWkrService.addQstDtlsService(patQuestionsModel);
		if(patQuestion != null)
			updateRows = 1;
		return updateRows;
	}
	
	@RequestMapping(value = "/updateQuestionDtlsService", method = RequestMethod.POST)
	public  int updateQuestionDtlsController(@RequestBody PatQuestionsModel patQuestionsModel){
		int updateRows = 0;
		PatQuestionsModel patQuestions =  healthWkrService.updateQstDtlsService(patQuestionsModel);
		
		if(patQuestions != null)
			updateRows = 1;
		return updateRows;
	}
	
	@RequestMapping(value = "/deleteQuestionDtlsService", method = RequestMethod.POST)
	public  int deleteQuestionDtlsController(@RequestBody PatQuestionsModel patQuestionsModel){
		int deleted =  healthWkrService.deleteQstDtlsService(patQuestionsModel);
		return deleted;
	}
	
	//****************4 random  question generator
	
	
	@RequestMapping(value = "/randomQuestionDtlsService", method = RequestMethod.POST)
	public  List<PatQuestionsModel> randomQuestionDtlsController(){
		List<PatQuestionsModel> questionList =  healthWkrService.randomQstDtlsService();
		return questionList;
	}
	
	

}
