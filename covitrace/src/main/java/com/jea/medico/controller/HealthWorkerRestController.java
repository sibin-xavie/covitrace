package com.jea.medico.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.jea.medico.exception.PatientException;
import com.jea.medico.model.FaceUploadJsonBean;
import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.MedicalTestModel;
import com.jea.medico.model.PatQuestionsModel;
import com.jea.medico.model.PatientMedictnModel;
import com.jea.medico.model.RandomQstAnswerModel;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.User;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
import com.jea.medico.service.HealthWorkerService;
import com.jea.medico.util.MultipartInputStreamFileResource;


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

	

	/**
	 * @author Vikas
	 * @param User class
	 * @return {@link UserChildModel}
	 * @implNote registers the pateints in the application
	 * @since 27 September 2020
	 * */
	
	@RequestMapping(value = "/patientRegisterService", method = RequestMethod.POST)
	public UserChildModel patientListService(@RequestBody User user) {
		healthWkrService.createUserService(user);
		return user.getChild();
	}

	/**
	 * @author linoy
	 * @param UserMasterModel
	 * @implSpec used to insert values only to the UserMasterModel
	 * @return {@link Integer}
	 * @throws PatientException
	 *
	 */
	@RequestMapping(value = "/registerService", method = RequestMethod.POST)
	public int registerService(@RequestBody UserMasterModel user) throws PatientException {
		// System.out.println("UserSibin:::::" + user);
		int result = healthWkrService.createUserMaster(user);

		return result;
	}
	
	/**
	 * @author Sibin
	 * @param UserChildModel
	 * @implSpec used to update patient details 
	 * @return {@link Integer}
	 *
	 */

	@RequestMapping(value = "/updatePatientService", method = RequestMethod.POST)
	public int updatePatientService(@RequestBody UserChildModel userDetails) {
		int updateRows = 0;
		UserChildModel user = healthWkrService.updateUserService(userDetails);
		if (user != null)
			updateRows = 1;
		return updateRows;
	}

	/**
	 * 
	 * @author Sibin
	 * @since 30 Sep 2020
	 * @return {@link List}
	 * @r
	 */

	@RequestMapping(value = "/getStateListServices", method = RequestMethod.POST)
	public List<StateModel> getStateListController() {
		List<StateModel> allStateList = new ArrayList<StateModel>();
		allStateList = healthWkrService.getStateListService();
		return allStateList;
	}

	/**
	 * 
	 * @author Sibin
	 * @since 30 Sep 2020
	 */

	@RequestMapping(value = "/patientListService", method = RequestMethod.POST)
	public List<UserChildModel> patientListController() {
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
	public int patientMedDtlsController(@RequestBody PatientMedictnModel patientMedictnModel) {

		int updateRows = 0;
		PatientMedictnModel patMedModel = healthWkrService.addMedicalDtlsService(patientMedictnModel);
		if (patMedModel != null)
			updateRows = 1;
		return updateRows;
	}

	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */
	// ****************Med Test Crud 6********************
	@RequestMapping(value = "/addMedTestDtlsService", method = RequestMethod.POST)
	public int patientMedTestDtlsController(@RequestBody MedicalTestModel medicalTestModel) {
		int updateRows = 0;
		MedicalTestModel medicalTest = healthWkrService.addMedicalTestDtlsService(medicalTestModel);
		if (medicalTest != null)
			updateRows = 1;
		return updateRows;
	}

	/**
	 * @author sibin
	 * @since 06 oct 2020
	 * @modifiedOn 23-10-2020
	 * @param UserMasterModel
	 * @return
	 */
	@RequestMapping(value = "/listMedDtlsService", method = RequestMethod.POST)
	public List<PatientMedictnModel> listPatientMedDtlsController(@RequestBody UserMasterModel patientMedictnModel) {
		List<PatientMedictnModel> medicalTestList = healthWkrService.listMedicineDtlsService(patientMedictnModel);
		return medicalTestList;
	}

	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */

	@RequestMapping(value = "/listMedTestDtlsService", method = RequestMethod.POST)
	public List<MedicalTestModel> listPatientMedTestDtlsController(@RequestBody MedicalTestModel medicalTestModel) {
		List<MedicalTestModel> medicalTestList = healthWkrService
				.listMedicalTestDtlsService(medicalTestModel.getUserId());
		return medicalTestList;
	}

	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */

	@RequestMapping(value = "/deleteMedTestDtlsService", method = RequestMethod.POST)
	public int deletePatientMedTestDtlsController(@RequestBody MedicalTestModel medicalTestModel) {
		int deleted = healthWkrService.deleteMedicalTestDtlsService(medicalTestModel.getMedTestId());
		return deleted;
	}

	@RequestMapping(value = "/updateMedTestDtlsService", method = RequestMethod.POST)
	public int updatePatientMedTestDtlsController(@RequestBody MedicalTestModel medicalTestModel) {
		int updateRows = 0;
		MedicalTestModel medicalTest = healthWkrService.updateMedicalTestDtlsService(medicalTestModel);

		if (medicalTest != null)
			updateRows = 1;
		return updateRows;
	}

	// ***************ZONE CRUD**********************

	@RequestMapping(value = "/addZoneDtlService", method = RequestMethod.POST)
	public int addZoneController(@RequestBody StateModel stateModel) {

		int updateRows = 0;
		StateModel state = healthWkrService.addZoneDtlsService(stateModel);
		if (state != null)
			updateRows = 1;
		return updateRows;
	}

	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */

	@RequestMapping(value = "/listZoneDtlsService", method = RequestMethod.POST)
	public List<StateModel> listZoneDtlsController() {
		List<StateModel> stateList = healthWkrService.listZoneDtlsService();
		return stateList;
	}

	/**
	 * 
	 * @author Sibin
	 * @since 06 oct 2020
	 */

	@RequestMapping(value = "/deleteZoneDtlsService", method = RequestMethod.POST)
	public int deletePatientMedTestDtlsController(@RequestBody StateModel stateModel) {
		int deleted = healthWkrService.deleteZoneDtlsService(stateModel.getStateId());
		return deleted;
	}

	@RequestMapping(value = "/updateZoneDtlsService", method = RequestMethod.POST)
	public int updatePatientMedTestDtlsController(@RequestBody StateModel stateModel) {
		int updateRows = 0;
		StateModel state = healthWkrService.updateZoneDtlsService(stateModel);

		if (state != null)
			updateRows = 1;
		return updateRows;
	}

	// ********************Questions add/dlete/edit

	@RequestMapping(value = "/addQuestionService", method = RequestMethod.POST)
	public int addQuestionController(@RequestBody PatQuestionsModel patQuestionsModel) {

		int updateRows = 0;
		PatQuestionsModel patQuestion = healthWkrService.addQstDtlsService(patQuestionsModel);
		if (patQuestion != null)
			updateRows = 1;
		return updateRows;
	}

	@RequestMapping(value = "/updateQuestionDtlsService", method = RequestMethod.POST)
	public int updateQuestionDtlsController(@RequestBody PatQuestionsModel patQuestionsModel) {
		int updateRows = 0;
		PatQuestionsModel patQuestions = healthWkrService.updateQstDtlsService(patQuestionsModel);

		if (patQuestions != null)
			updateRows = 1;
		return updateRows;
	}

	// ****************4 random question generator

	@RequestMapping(value = "/randomQuestionDtlsService", method = RequestMethod.POST)
	public List<PatQuestionsModel> randomQuestionDtlsController() {
		List<PatQuestionsModel> questionList = healthWkrService.randomQstDtlsService();
		return questionList;
	}

	@RequestMapping(value = "/deleteQuestionDtlsService", method = RequestMethod.POST)
	public int deleteQuestionDtlsController(@RequestBody PatQuestionsModel patQuestionsModel) {
		int deleted = healthWkrService.deleteQstDtlsService(patQuestionsModel);
		return deleted;
	}

	/**
	 * @author sibin xavier
	 * @since 23 oct 2020
	 * 
	 */
	@RequestMapping(value = "/listPatMedDtlsService", method = RequestMethod.POST)
	public MedicalDtlsModel listMedDtlsController(@RequestBody UserMasterModel userMasterUserId) {
		MedicalDtlsModel medicalDtlsMode = null;
		medicalDtlsMode = healthWkrService.retrivePatMedQstHistService(userMasterUserId);

		return medicalDtlsMode;
	}

	/**
	 * @author sibin xavier
	 * @since 23 oct 2020
	 * 
	 */
	@RequestMapping(value = "/randomQstAnswerSaveService", method = RequestMethod.POST)
	public int randomQstAnswerSaveController(@RequestBody RandomQstAnswerModel randomQstAnswerModel) {
		RandomQstAnswerModel randomQstAnswer = null;
		int insertRows = 0;
		randomQstAnswer = healthWkrService.randomQstAnswerSaveService(randomQstAnswerModel);
		if (randomQstAnswer != null) {
			insertRows = 1;
		}
		return insertRows;
	}

	/**
	 * @author sibin xavier
	 * @since 12 Nov 2020 10:19 AM
	 * 
	 */
	@RequestMapping(value = "/updateFCMToken", method = RequestMethod.POST)
	public int updateFCMToken(@RequestBody UserChildModel userChildModel) {
		System.out.println("sibisninsa" + userChildModel);
		return healthWkrService.updateFCMService(userChildModel.getPatientFCMKey(), userChildModel.getUserId());
	}

	/**
	 * 
	 * 
	 * @createdon 20 nov 2020
	 * @mcreatedBy Sibin Xavier
	 * @desc : for facial recognition uploading of photo
	 */

	@RequestMapping(value = "/uploadFacePhoto", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFacePhotoOfPatient(@RequestParam("uploadImage") MultipartFile uploadImagePat) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		String url = "http://13.234.35.105:8080/api/v1/faces/image/upload";

		HttpStatus httpStatus = HttpStatus.CREATED;
		try {
			map.add("imageFile", new MultipartInputStreamFileResource(uploadImagePat.getInputStream(),
					uploadImagePat.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
		FaceUploadJsonBean fb = restTemplate.postForObject(url, requestEntity, FaceUploadJsonBean.class);
		return new ResponseEntity<>(fb, httpStatus);
	}

	/**
	 * 
	 * 
	 * @createdon 20 nov 2020
	 * @mcreatedBy Sibin Xavier
	 * @desc : for getting face
	 */

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public FaceUploadJsonBean getFacePhoto(@RequestParam("get") String getName) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		String url = "http://13.234.35.105:8080/api/v1/faces/image/get/" + getName;
		RestTemplate restTemplate = new RestTemplate();
		FaceUploadJsonBean fb = restTemplate.getForObject(url, FaceUploadJsonBean.class);
		return fb;
	}

	/**
	 * 
	 * 
	 * @createdon 20 nov 2020
	 * @createdBy Sibin Xavier
	 * @desc : for MATCHING 2 face
	 */

	@RequestMapping(value = "/matchParam", method = RequestMethod.POST)
	public ResponseEntity<?> matchFacePhotoOfPatient(@RequestParam("file1") String matchImagePat1,
			@RequestParam("file2") MultipartFile matchImagePat2) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		String url = "http://13.234.35.105:8080/api/v1/faces/match";

		try {
			map.add("file1", matchImagePat1);
			map.add("file2", new MultipartInputStreamFileResource(matchImagePat2.getInputStream(),
					matchImagePat2.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
		Object listObj = restTemplate.postForObject(url, requestEntity, Object.class);
		if (listObj instanceof LinkedHashMap) {
			LinkedHashMap nomatch = (LinkedHashMap) listObj;
			String nomatchResponse = nomatch.get("result").toString();
			if (nomatchResponse.equalsIgnoreCase("NO Match")) {
				listObj = 0;
			}
		}
		if (listObj instanceof ArrayList) {

			ArrayList al = (ArrayList) listObj;
			String similarity = "";
			for (Object alObk : al) {
				similarity = ((LinkedHashMap) alObk).get("similarity").toString();
			}

			Double match = Double.parseDouble(similarity);
			if (match > 85) {
				listObj = "1";
			} else {
				listObj = 0;
			}

		}

		return new ResponseEntity<>(listObj, HttpStatus.OK);
	}

	
}
