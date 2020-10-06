package com.jea.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
@Repository
public interface UserChildRepository extends JpaRepository<UserChildModel, Integer>{
	
@Modifying
@Query("update UserChildModel u set u.userIsolatedStatus = ?1 where u.userChildId = ?2")
int updatePatientDetails(boolean isolated_in, int userChildId);

UserChildModel findByuserChildId(int userChildId);
	
}
