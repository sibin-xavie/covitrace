package com.jea.medico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.UserMasterModel;
@Repository
public interface UserMasterRepository extends JpaRepository<UserMasterModel, Integer> {
	/**
	* @author Sibin 
	* @since 15 sep 2020 10.10 AM
	* @implSpec retrives the list<UserMasterModel> from username and password supplied
	*/
	//@Query("select u from UserMasterModel u where u.username = ?1 and u.userPassword = ?2")
	List<UserMasterModel> findByUsernameAndUserPassword(String username, String userPassword);
}
