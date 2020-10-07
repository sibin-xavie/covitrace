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
import org.springframework.web.bind.annotation.RequestBody;
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
import com.jea.medico.service.HealthWorkerService;
import com.jea.medico.service.PatientService;

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

    @RequestMapping(value="/uploadPatientPhoto", method = RequestMethod.POST)
    public User uploadPhoto(@RequestParam("photo") MultipartFile file){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = patientService.findUserByUserName(auth.getName());
    	
        user = patientService.uploadPhoto(user, file);
    	
		return user;
    }

    @RequestMapping(value="/downloadPatientPhoto", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody FileSystemResource downloadPhoto() throws IOException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = patientService.findUserByUserName(auth.getName());
        
        System.out.println("FileName: " + user.getChild().getUserImagePath());
        String filename = user.getChild().getUserImagePath();
        Path path = Paths.get(filename);

        System.out.println("Downloading...");
    	return new FileSystemResource(path.toFile());
    }
    	
}
