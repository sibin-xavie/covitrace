package com.jea.medico.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;
@Repository
public interface UserChildRepository extends JpaRepository<UserChildModel, Integer>{
	
@Modifying
@Query("update UserChildModel u set u.userIsolatedStatus = ?1 where u.userChildId = ?2")
int updatePatientDetails(boolean isolated_in, int userChildId);

UserChildModel findByuserChildId(int userChildId);
UserChildModel findByUserId(UserMasterModel userMaster);


@Modifying
@Transactional
@Query("update UserChildModel u set u.patientFCMKey = ?1 where u.userId = ?2")
int updateFCMToken(String patientFCMKey, UserMasterModel userId);


@Modifying
@Transactional
@Query("update UserChildModel u set u.userImagePath = ?1 where u.userId = ?2")
int updatePatientDProfilePic(String userImagePath, UserMasterModel userId);


@Query("select u from UserChildModel u where u.userId = ?1 ")
UserChildModel findUserChildByUserId(UserMasterModel userId);
}
