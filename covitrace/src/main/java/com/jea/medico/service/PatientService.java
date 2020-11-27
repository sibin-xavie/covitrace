package com.jea.medico.service;

import org.springframework.web.multipart.MultipartFile;

import com.jea.medico.model.User;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;

public interface PatientService {

	public User uploadPhoto(MultipartFile file, int userId);
	public User findUserByUserName(String userName);
	public UserChildModel downloadByUserId(int userId);
}
