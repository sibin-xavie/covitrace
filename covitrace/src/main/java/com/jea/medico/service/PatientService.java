package com.jea.medico.service;

import org.springframework.web.multipart.MultipartFile;

import com.jea.medico.model.User;

public interface PatientService {

	public User uploadPhoto(User user, MultipartFile file, int userId);
	public User findUserByUserName(String userName);
}
