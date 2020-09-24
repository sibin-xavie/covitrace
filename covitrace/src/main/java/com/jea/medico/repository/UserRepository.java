package com.jea.medico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.UserMasterModel;
@Repository
public interface UserRepository extends JpaRepository<UserMasterModel, Integer> {
	List<UserMasterModel> findByUsernameAndUserPassword(String username, String userPassword);
	UserMasterModel findByUsername(String username);
}
