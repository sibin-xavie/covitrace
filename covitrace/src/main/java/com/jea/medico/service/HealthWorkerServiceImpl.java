package com.jea.medico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.ec2.model.State;
import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
import com.jea.medico.repository.PatientDtlsRepository;
import com.jea.medico.repository.StateRepository;
import com.jea.medico.repository.UserChildRepository;
/** 
* 
* @author Sibin 
* @since 13 sep 2020 9.30 PM
*/
public class HealthWorkerServiceImpl implements HealthWorkerService{

	StateRepository stateRepo;
	PatientDtlsRepository patRepo;
	UserChildRepository userChildRepo;
	
	
	 @Autowired
     public HealthWorkerServiceImpl(StateRepository stateRepo) {
         this.stateRepo = stateRepo;
     }
	 
	 @Autowired
     public HealthWorkerServiceImpl(PatientDtlsRepository patRepo) {
         this.patRepo = patRepo;
     }

	@Override
	public List<StateModel> getStateListService() {
		// TODO Auto-generated method stub
		return stateRepo.findAll();
	}

	@Override
	public List<UserMasterModel> authenticateUserService(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserChildModel> getStPatientListService() {
		return userChildRepo.findAll();
	}

	@Override
	public List<UserMasterModel> getUserLastLogService(int userId) {
	
		return null;
	}

	@Override
	public List<UserChildModel> updatePatientService(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalDtlsModel> retrivePatMedQstHistService(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalDtlsModel> getPatHealthDataService(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
