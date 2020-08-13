package com.docker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker.entity.Users;


public interface UsersDao extends JpaRepository<Users, Integer>  {

}
