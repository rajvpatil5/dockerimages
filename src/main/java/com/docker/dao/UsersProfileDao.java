package com.docker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.docker.entity.UsersProfile;


public interface UsersProfileDao extends JpaRepository<UsersProfile, Integer>{

	@Query("from UsersProfile where lower(emailid) =lower(:email)")
	List<UsersProfile> findemailId(@Param ("email") String email);
	
}
