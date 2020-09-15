package com.jea.medico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jea.medico.exception.PatientException;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.UserChildModel;
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
    public List<StateModel> getStateList() throws PatientException {
		List<StateModel> allStateList = null;
       try {
    	   allStateList =  healthWkrService.getStateListService();
		PatientException.checkNull(allStateList) ;
	} catch (PatientException e) {
	throw new PatientException("State Empty");
	}
    	return allStateList;
    }
	
	/** 
	* 
	* @author Sibin 
	* @since 15 sep 2020 7.45 AM
	* @return {@link List}
	* @implSpec Method returns the list of patients in the Patient
	
	*/
		@RequestMapping(value = "/patientListService")
	    public List<UserChildModel> patientListService() throws PatientException {
			List<UserChildModel> allPatientList = null;
	       try {
	    	   allPatientList =  healthWkrService.getStPatientListService();
			PatientException.checkNull(allPatientList) ;
		} catch (PatientException e) {
		throw new PatientException("Patient Details Empty");
		}
	    	return allPatientList;
	    }
	
	
	
	
}
