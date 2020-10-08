package com.jea.medico.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jea.medico.service.JwtUserDetailsService;


import com.jea.medico.config.JwtTokenUtil;
import com.jea.medico.model.JwtRequest;
import com.jea.medico.model.JwtResponse;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
import com.jea.medico.repository.UserChildRepository;
import com.jea.medico.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	UserChildRepository userChildRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/authenticateUserService", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		UserMasterModel user = userRepository.findByUsername(authenticationRequest.getUsername());
		UserChildModel userChildModel = userChildRepository.findByUserId(user);
		

JwtResponse response = new JwtResponse(token,userChildModel.getUserLat(),userChildModel.getUserLong(),user.getRoleId().getRoleId());




		return ResponseEntity.ok(response);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}