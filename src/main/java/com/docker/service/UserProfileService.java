package com.docker.service;

import java.util.List;

import com.docker.entity.UsersProfile;

public interface UserProfileService {
	public void saveUserProfile(UsersProfile userProfile);
	public List<UsersProfile> findbyEmailId(String email);
	UsersProfile findById(int theId);

}
