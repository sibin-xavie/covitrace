package com.jea.medico.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jea.medico.exception.PatientException;
import com.jea.medico.model.StateModel;
import com.jea.medico.model.User;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
import com.jea.medico.service.HealthWorkerService;
import com.jea.medico.service.PatientService;
import com.jea.medico.util.ImageBean;

/**
 * 
 * @author Vikas
 *
 */
@RestController
@RequestMapping("/api/v1")
public class PatientRestController {
	@Autowired
	PatientService patientService;
	/**
	 * @author Vikas
	 * @param userId
	 * @param photo
	 * @return patient details if successfull uploading is done
	 * @implNote uploading of patient profile photo .
	 * @since 27 November 2020
	 * */
	
	/*
	  
	 * @modifiedby Sibin 
	 * @desc added userId for uploading the patients profile pics,removed the auth
	  */
	@RequestMapping(value = "/uploadPatientPhoto", method = RequestMethod.POST)
	public User uploadPhoto(@RequestParam("photo") MultipartFile file, @RequestParam("userId") int userId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// User user = patientService.findUserByUserName(auth.getName());

		User user = patientService.uploadPhoto(file, userId);

		return user;
	}
	
	/**
	 * @author Vikas
	 * @param userId
	 * @return path to file in server
	 * @implNote retrives the profile photo uploaded of patient uploaded.
	 * @since 27 November 2020
	 * */
	
	/*
	  
	 * @modifiedby Sibin
	 * @desc added userId for getting the patients profile pics
	 */

	@RequestMapping(value = "/downloadPatientPhoto", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	//public @ResponseBody FileSystemResource downloadPhoto(@RequestParam("userId") int userId) throws IOException {
	public  String downloadPhoto(@RequestParam("userId") int userId) throws IOException {
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// User user = patientService.findUserByUserName(auth.getName());

		// System.out.println("FileName: " + user.getChild().getUserImagePath());
		// String filename = user.getChild().getUserImagePath();

		Path path = Paths.get(patientService.downloadByUserId(userId).getUserImagePath());

	
		ImageBean bean = new ImageBean();
		bean.setUserId(userId);
		bean.setUserFilePath(path.toFile().getAbsolutePath());
		System.out.println("Downloading..." + bean.getUserFilePath());
		//return new FileSystemResource(path.toFile());
		return path.toFile().getAbsolutePath();
	}

}
