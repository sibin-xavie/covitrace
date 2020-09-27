package com.jea.medico.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jea.medico.exception.PatientException;
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

	@RequestMapping(value = "/getStateListServices", method = RequestMethod.POST)
	public List<StateModel> getStateListController() {
		List<StateModel> allStateList = new ArrayList<StateModel>();
		
			allStateList = healthWkrService.getStateListService();
			System.out.println("sibin:::"+allStateList);
			
		
		return allStateList;
	}
	
	@RequestMapping(value = "/patientListService", method = RequestMethod.POST)
	public List<UserChildModel> patientListController(){
		List<UserChildModel> allPatientList = null;
		
			allPatientList = healthWkrService.getStPatientListService();
		
		
		return allPatientList;
	}

}
