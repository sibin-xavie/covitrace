package com.jea.medico.service;

import java.io.File;
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
	
	
	
	@Override
	public UserChildModel downloadByUserId(int userId) {
		User user = new User();
		user.setMaster(userRepository.findByUserId(userId));
		
		UserChildModel childModel = userChildRepo.findUserChildByUserId(user.getMaster());
		System.out.println("childModel :::::"+childModel);
		return childModel;
	}
	/**
	 * @modified by sibin
	 * @desc health worker needs to save the profile pic of varois patients as patients do not have provision
	 */
	public User uploadPhoto(MultipartFile file, int userId) {
        Path path = null;
        User user = new User();
        if (!file.isEmpty()) {
            String filename = userId + "_" 
            		+ "PROF.jpg"; 
            try {
            	File uploadFolderFile = new File(uploadFolder + File.separator +"profile_images");
            	if(!uploadFolderFile.exists()) {
            		uploadFolderFile.mkdirs();
            	}
	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            path = Paths.get(uploadFolderFile.getAbsolutePath() +File.separator + filename);
	            
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
        	
    		user.setMaster(userRepository.findByUserId(userId));
    		user.setChild(userChildRepo.findByUserId(user.getMaster()));
        	
        	System.out.println("Saving image path to UserChild table" + user.getMaster() );
        	userChildRepo.updatePatientDProfilePic(path.toAbsolutePath().toString(),user.getMaster());
        }

        return user;
	}



}
