package com.jea.medico.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
import com.jea.medico.repository.UserRepository;

/**
 * 
 * @author Sibin
 * @since 13 sep 2020 9.30 PM
 */
@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	UserChildRepository userChildRepo;
	@Autowired
	UserMasterRepository userMasterRepo;
	@Autowired
	UserRepository userRepository;

    @Value( "${path.upload.file.image}" )
    private String uploadFolder;
    
    /**
     * 
     */
	@Override
	public User findUserByUserName(String userName) {
		User user = new User();
		user.setMaster(userRepository.findByUsername(userName));
		user.setChild(userChildRepo.findByUserId(user.getMaster()));
		
		return user;
	}
	
	/**
	 * 
	 */
	public User uploadPhoto(User user, MultipartFile file) {
        Path path = null;

        if (!file.isEmpty()) {
            String filename = user.getMaster().getUserId() + "_" + Math.random() + "_" 
            		+ file.getOriginalFilename();
            try {
	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            path = Paths.get(uploadFolder + filename);
	            Files.write(path, bytes);
	            System.out.println(path.toAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
        	System.out.println("File is empty");
        }
        if(path.toAbsolutePath() != null && !path.toAbsolutePath().toString().equals("")) {
        	// Store the path in DB table
        	user.getChild().setUserImagePath(path.toAbsolutePath().toString());
        	System.out.println("Saving image path to UserChild table");
        	userChildRepo.save(user.getChild());
        }

        return user;
	}


}
