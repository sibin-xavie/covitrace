package com.jea.medico.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.MedicalTestModel;
import com.jea.medico.model.PatQuestionsModel;
import com.jea.medico.model.PatientMedictnModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.User;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
import com.jea.medico.repository.MedicalDtlsRepository;
import com.jea.medico.repository.MedicalTestDtlsRepo;
import com.jea.medico.repository.PatQuestionsRepo;
import com.jea.medico.repository.PatientDtlsRepository;
import com.jea.medico.repository.PatientMedictnRepo;
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
	
	@Autowired
	PatientMedictnRepo patientMedictnRepo;
	

	@Autowired
	MedicalTestDtlsRepo medicalTestDtlsRepo;
	

	@Autowired
	PatQuestionsRepo patQuestionsRepo;
	
	

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
	
	@Override
	@Transactional
	public PatientMedictnModel addMedicalDtlsService(PatientMedictnModel PatientMedictnModel) {
		return patientMedictnRepo.save(PatientMedictnModel);
	}
	 
	
	@Override
	@Transactional
	public MedicalTestModel addMedicalTestDtlsService(MedicalTestModel medicalTestModel) {
		return medicalTestDtlsRepo.save(medicalTestModel);
	}
	
	@Override
	public List<MedicalTestModel>  listMedicalTestDtlsService(UserMasterModel userId) {
		return medicalTestDtlsRepo.listMedicalTestUserDtls(userId);
	} 
	
	@Override
	@Transactional
	public int  deleteMedicalTestDtlsService(int medTestId) {
		return medicalTestDtlsRepo.deleteBymedTestId(medTestId);
	} 
	
	@Override
	@Transactional
	public MedicalTestModel  updateMedicalTestDtlsService(MedicalTestModel medicalTestModel) {
		return medicalTestDtlsRepo.save(medicalTestModel);
	} 
	
	//***********ZOne
	@Override
	@Transactional
	public StateModel addZoneDtlsService(StateModel stateModel) {
		return stateRepo.save(stateModel);
	}
	
	@Override
	public List<StateModel>  listZoneDtlsService(){
		return stateRepo.findAll();
	} 
	
	@Override
	@Transactional
	public int  deleteZoneDtlsService(int stateId) {
		return stateRepo.deleteBystateId(stateId);
	} 
	
	@Override
	@Transactional
	public StateModel  updateZoneDtlsService(StateModel stateModel) {
		return stateRepo.save(stateModel);
	}
	
	//***************Question add/edit/delete*************
	
	
	@Override
	@Transactional
	public PatQuestionsModel addQstDtlsService(PatQuestionsModel patQuestionsModel) {
		return patQuestionsRepo.save(patQuestionsModel);
	}
	
	@Override
	@Transactional
	public PatQuestionsModel updateQstDtlsService(PatQuestionsModel patQuestionsModel) {
		return patQuestionsRepo.save(patQuestionsModel);
	}
	
	@Override
	@Transactional
	public int deleteQstDtlsService(PatQuestionsModel patQuestionsModel) {
		return patQuestionsRepo.deleteByPatMedId(patQuestionsModel.getQuestionId());
	}
	
	
	@Override
	@Transactional
	public List<PatQuestionsModel>  randomQstDtlsService() {
		List<PatQuestionsModel> qstList = null;
		int count = patQuestionsRepo.randomQstDtlsServiceCount();
		System.out.println("count" + count);
		if(count > 0) {
		Set<PatQuestionsModel> set = new LinkedHashSet<PatQuestionsModel>();
		Random generator = new Random();
		for (int i = 0; i <= count; i++) {
			
			PatQuestionsModel patm = patQuestionsRepo.randomQstDtlsService(generator.nextInt(count)) ;
			if(patm != null && !patm.equals(null)) {
				set.add(patQuestionsRepo.randomQstDtlsService(generator.nextInt(count)));
			}
			
			if(set.size() >= 4 &&  !set.contains(null)) 
				break;
		}
		 qstList=	new ArrayList<PatQuestionsModel>(set);
		}
		return qstList;
	}

	@Override
	public int createUserMaster(UserMasterModel user) {
		// TODO Auto-generated method stub
		
		int result = 1;
		
		UserMasterModel userMaster = user;
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		userMaster.setUserLastLog(date);
		userMaster = userMasterRepo.save(userMaster);
		
		System.out.print(userMaster.getUserPassword());
		if(userMaster == null) {
			result = 0;
		}
		return result;
	
	}

	@Override
	public List<PatientMedictnModel> listMedicineDtlsService(UserMasterModel userId) {
		// TODO Auto-generated method stub
		return patientMedictnRepo.listMedicineUserDtls(userId);
	}
	

	
}


