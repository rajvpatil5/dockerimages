package com.docker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker.entity.Message;

public interface MessageDAO extends JpaRepository<Message, Integer>{

	List<Message> findAll();
}
