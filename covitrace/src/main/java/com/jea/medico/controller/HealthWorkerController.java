package com.jea.medico.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jea.medico.exception.PatientException;
import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
import com.jea.medico.service.HealthWorkerService;

/**
 * 
 * @author Sibin
 * @since 14 sep 2020 10.25 AM
 */
@Controller
public class HealthWorkerController {
	@Autowired
	HealthWorkerService healthWkrService;

	/**
	 * 
	 * @author Sibin
	 * @since 14 sep 2020 10.25 PM
	 * @return {@link List}
	 * @implSpec Method returns the list of all district,state,village,taluk
	 * @exception PatientException
	 */
	@RequestMapping(value = "/getStateListService")
	public List<StateModel> getStateListController() throws PatientException {
		List<StateModel> allStateList = new ArrayList<StateModel>();
		try {
			allStateList = healthWkrService.getStateListService();
			System.out.println(allStateList);
			PatientException.checkNull(allStateList);
		} catch (PatientException e) {
			throw new PatientException("State Empty");
		}
		return allStateList;
	}
	
	

	/**
	 * 
	 * @author Sibin
	 * @since 15 sep 2020 9.20 AM
	 * @return {@link List}
	 * @implSpec Method returns the list of patients in the Patient
	 */
	@RequestMapping(value = "/authenticateUserService")
	public List<UserMasterModel> authenticateUserController(HttpServletRequest request, HttpServletResponse response)
			throws PatientException {
		List<UserMasterModel> getLoginCredList = null;

		
		/*	getLoginCredList = healthWkrService.authenticateUserService(request.getParameter("USERNAME"),
					request.getParameter("PASSWORD"));*/
			getLoginCredList = healthWkrService.authenticateUserService("admin",
					"admin");
			System.out.println(((UserMasterModel)getLoginCredList.get(0)).getRoleId().getRoleId());
			;
		return getLoginCredList;
	}

	/**
	 * 
	 * @author Sibin
	 * @since 15 sep 2020 7.45 AM
	 * @return {@link List}
	 * @implSpec Method returns the list of patients in the UserChildModel
	 */
	@RequestMapping(value = "/patientListService")
	public List<UserChildModel> patientListController() throws PatientException {
		List<UserChildModel> allPatientList = null;
		try {
			allPatientList = healthWkrService.getStPatientListService();
			PatientException.checkNull(allPatientList);
		} catch (PatientException e) {
			throw new PatientException("Patient Details Empty");
		}
		return allPatientList;
	}

	/**
	 * 
	 * @author Sibin
	 * @since 15 sep 2020 14.45
	 * @return {@link List}
	 * @implSpec Method returns the list of patients in the UserChildModel
	 */
	@RequestMapping(value = "/updatePatientService")
	public int updatePatientController(HttpServletRequest request, HttpServletResponse response) {
		int updateRows = 0;
		boolean isolatedStatus = Boolean.parseBoolean(request.getParameter("isolatedStatus"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		updateRows = healthWkrService.updatePatientService(isolatedStatus, userId);
		return updateRows;
	}

	/**
	 * 
	 * @author Sibin
	 * @since 15 sep 2020 14.45
	 * @return {@link Boolean}
	 * @implSpec Method returns the saved status of patient medical data
	 */
	@RequestMapping(value = "/patHealthDataService")
	public boolean addPatHealthDataSaveController(HttpServletRequest request, HttpServletResponse response) {
		boolean saved = false;
		MedicalDtlsModel mdclModel = healthWkrService.addPatHealthDataSaveService(new MedicalDtlsModel());
		return mdclModel != null ? true : false;
	}

	/**
	 * 
	 * @author Sibin <<<<<<< HEAD
	 * @since 15 sep 2020 16.06 =======
	 * @since 15 sep 2020 16.05 >>>>>>> 35f94504d695e1b228dfc01c6c4a09fbe6ca543e
	 * @return {@link MedicalDtlsModel}
	 * @implSpec Method returns the patient's medical History from MedicalDtlsModel
	 */
	@RequestMapping(value = "/retrievePatMedQstHistService")
	public MedicalDtlsModel retrivePatMedQstHistController(HttpServletRequest request, HttpServletResponse response) {
		int medicalId = Integer.parseInt(request.getParameter("medicalId"));

		boolean saved = false;
		MedicalDtlsModel mdclModel = healthWkrService.retrivePatMedQstHistService(medicalId);
		return mdclModel;
	}

}
