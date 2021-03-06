package com.jea.medico.service;

import java.sql.Date;
import java.sql.SQLException;
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
import com.jea.medico.model.PatientMedicationInfoModel;
import com.jea.medico.model.PatientMedictnModel;
import com.jea.medico.model.RandomQstAnswerModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.User;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
import com.jea.medico.repository.MedicalDtlsRepository;
import com.jea.medico.repository.MedicalTestDtlsRepo;
import com.jea.medico.repository.PatQuestionsRepo;
import com.jea.medico.repository.PatientDtlsRepository;
import com.jea.medico.repository.PatientMedicationInfoRepo;
import com.jea.medico.repository.PatientMedictnRepo;
import com.jea.medico.repository.RandomQstAnswerRepo;
import com.jea.medico.repository.StateRepository;
import com.jea.medico.repository.UserChildRepository;
import com.jea.medico.repository.UserMasterRepository;
import com.jea.medico.util.TrippleDes;

/**
 * 
 * @author Sibin
 * @since 13 sep 2020 9.30 PM
 */
@Service
@Transactional
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
	
	public int updatePatientService(boolean isolatedStatus, int userId) {

		return userChildRepo.updatePatientDetails(isolatedStatus, userId);
	}

	@Override
	public MedicalDtlsModel retrivePatMedQstHistService(UserMasterModel medicalDtlsId) {

		return medDtlsRepo.findByMedicalDtlsIdAndUserId(medicalDtlsId);
	}

	@Override
	public List<MedicalDtlsModel> getPatHealthDataService(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalDtlsModel addPatHealthDataSaveService(MedicalDtlsModel medicalDltlsModel) {

		return medDtlsRepo.save(medicalDltlsModel);
	}

	@Override
	public UserChildModel updateUserService(UserChildModel user) {

		return userChildRepo.save(user);
	}
	
	@Autowired
	TrippleDes tripleDes;
	
	@Override
	public UserChildModel createUserService(User user) throws Exception{
		
		UserChildModel userChild = null;
		try {
		UserMasterModel userMaster = user.getMaster();
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		userMaster.setUserLastLog(date);
		userMaster.setUserPassword(tripleDes.encrypt( user.getMaster().getUserPassword()));
		userMaster = userMasterRepo.save(userMaster);
		 userChild = user.getChild();
		userChild.setUserId(userMaster);
		}catch(Exception ed) {
			
		}
		
		return userChildRepo.save(userChild);
	}
	
	@Override
	
	public PatientMedictnModel addMedicalDtlsService(PatientMedictnModel PatientMedictnModel) {
		return patientMedictnRepo.save(PatientMedictnModel);
	}
	 
	
	@Override
	
	public MedicalTestModel addMedicalTestDtlsService(MedicalTestModel medicalTestModel) {
		return medicalTestDtlsRepo.save(medicalTestModel);
	}
	
	@Override
	public List<MedicalTestModel>  listMedicalTestDtlsService(UserMasterModel userId) {
		return medicalTestDtlsRepo.listMedicalTestUserDtls(userId);
	} 
	
	@Override
	
	public int  deleteMedicalTestDtlsService(int medTestId) {
		return medicalTestDtlsRepo.deleteBymedTestId(medTestId);
	} 
	
	@Override
	
	public MedicalTestModel  updateMedicalTestDtlsService(MedicalTestModel medicalTestModel) {
		return medicalTestDtlsRepo.save(medicalTestModel);
	} 
	
	//***********ZOne
	@Override
	
	public StateModel addZoneDtlsService(StateModel stateModel) {
		return stateRepo.save(stateModel);
	}
	
	@Override
	public List<StateModel>  listZoneDtlsService(){
		return stateRepo.findAll();
	} 
	
	@Override
	
	public int  deleteZoneDtlsService(int stateId) {
		return stateRepo.deleteBystateId(stateId);
	} 
	
	@Override
	
	public StateModel  updateZoneDtlsService(StateModel stateModel) {
		return stateRepo.save(stateModel);
	}
	
	//***************Question add/edit/delete*************
	
	
	@Override
	
	public PatQuestionsModel addQstDtlsService(PatQuestionsModel patQuestionsModel) {
		return patQuestionsRepo.save(patQuestionsModel);
	}
	
	@Override
	
	public PatQuestionsModel updateQstDtlsService(PatQuestionsModel patQuestionsModel) {
		return patQuestionsRepo.save(patQuestionsModel);
	}
	
	@Override
	
	public int deleteQstDtlsService(PatQuestionsModel patQuestionsModel) {
		return patQuestionsRepo.deleteByPatMedId(patQuestionsModel.getQuestionId());
	}
	
	
	@Override
	
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
	@Autowired
	RandomQstAnswerRepo randomQstRepo;
	@Override
	public RandomQstAnswerModel randomQstAnswerSaveService(RandomQstAnswerModel randomQstAnswerModel) {
		return randomQstRepo.save(randomQstAnswerModel);
	}
	@Autowired
	PatientMedicationInfoRepo infoRepo;



	@Override
	public List<PatientMedicationInfoModel> listPatMediTstUserDtlsService(UserMasterModel usrModel) {
	return infoRepo.listPatMediTstUserDtls(usrModel);
		
	}
	
	
	@Override
	
	public int updateFCMService(String fcmKey, UserMasterModel userId) {
System.out.println("fcmKey::"+ fcmKey);
		return userChildRepo.updateFCMToken(fcmKey, userId);
	}
	
}


