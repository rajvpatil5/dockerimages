package com.docker.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.docker.entity.Users;
import com.docker.entity.UsersProfile;


public interface UsersDao extends JpaRepository<Users, Integer>  {

	
	

}
