package com.jea.medico.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
import com.jea.medico.repository.UserChildRepository;
import com.jea.medico.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserMasterModel user = userRepository.findByUsername(username);
		if (user != null) {
		    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		    authorities.add(new SimpleGrantedAuthority(user.getRoleId().getRole()));
		
		    
			return new User(user.getUsername(), user.getUserPassword(),
					authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}