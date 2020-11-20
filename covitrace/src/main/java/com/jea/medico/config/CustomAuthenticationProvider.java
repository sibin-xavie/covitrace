package com.jea.medico.config;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.jea.medico.model.UserMasterModel;
import com.jea.medico.repository.UserRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	UserRepository userRepository;
	
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
      String username = authentication.getName();
      String password = authentication.getCredentials().toString();
      
      List<UserMasterModel> userList = userRepository.findByUsernameAndUserPassword(username, password);
      if (!userList.isEmpty()) {
            return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
       } else {
            throw new BadCredentialsException("Authentication failed");
       }
    }
    
    @Override
    public boolean supports(Class<?>aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}