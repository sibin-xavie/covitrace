package com.jea.medico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.ec2.model.State;
import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
import com.jea.medico.repository.StateRepository;
/** 
* 
* @author Sibin 
* @since 13 sep 2020 9.30 PM
*/
public class PatientServiceImpl implements PatientService{

	StateRepository stateRepo;
	
	 @Autowired
     public PatientServiceImpl(StateRepository stateRepo) {
         this.stateRepo = stateRepo;
     }

	@Override
	public List<StateModel> getStateListService() {
		// TODO Auto-generated method stub
		return stateRepo.findAll();
	}

	

	@Override
	public List<UserMasterModel> authenticateUserService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserChildModel> getStPatientListService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserMasterModel> getUserLastLogService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserChildModel> updatePatientService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalDtlsModel> retrivePatMedQstHistService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalDtlsModel> getPatHealthDataService() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
