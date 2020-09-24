package com.jea.medico.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.User;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
import com.jea.medico.repository.MedicalDtlsRepository;
import com.jea.medico.repository.PatientDtlsRepository;
import com.jea.medico.repository.StateRepository;
import com.jea.medico.repository.UserChildRepository;
import com.jea.medico.repository.UserMasterRepository;

/**
 * 
 * @author Sibin
 * @since 13 sep 2020 9.30 PM
 */
@Service
public class HealthWorkerServiceImpl implements HealthWorkerService {
	@Autowired
	StateRepository stateRepo;
	@Autowired
	PatientDtlsRepository patRepo;
	@Autowired
	UserChildRepository userChildRepo;
	@Autowired
	UserMasterRepository userMasterRepo;
	@Autowired
	MedicalDtlsRepository medDtlsRepo;

	@Override
	public List<StateModel> getStateListService() {
		// TODO Auto-generated method stub
		return stateRepo.findAll();
	}

	@Override
	public List<UserMasterModel> authenticateUserService(String username, String password) {

		List<UserMasterModel> userMasterModel = userMasterRepo.findByUsernameAndUserPassword(username, password);
		return userMasterModel;
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
	@Transactional
	public int updatePatientService(boolean isolatedStatus, int userId) {

		return userChildRepo.updatePatientDetails(isolatedStatus, userId);
	}

	@Override
	public MedicalDtlsModel retrivePatMedQstHistService(int medicalDtlsId) {

		return medDtlsRepo.findByMedicalDtlsIdAndUserId(medicalDtlsId);
	}

	@Override
	public List<MedicalDtlsModel> getPatHealthDataService(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public MedicalDtlsModel addPatHealthDataSaveService(MedicalDtlsModel medicalDltlsModel) {

		return medDtlsRepo.save(medicalDltlsModel);
	}

	@Override
	@Transactional
	public UserChildModel updateUserService(UserChildModel user) {

		return userChildRepo.save(user);
	}
	
	@Override
	@Transactional
	public UserChildModel createUserService(User user) {
		UserMasterModel userMaster = user.getMaster();
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		userMaster.setUserLastLog(date);
		userMaster = userMasterRepo.save(userMaster);
		
		UserChildModel userChild = user.getChild();
		userChild.setUserId(userMaster);
		
		return userChildRepo.save(userChild);
	}
}
