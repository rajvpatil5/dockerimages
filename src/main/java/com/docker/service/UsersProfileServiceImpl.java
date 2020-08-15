package com.docker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.dao.UsersDao;
import com.docker.dao.UsersProfileDao;
import com.docker.entity.Authorities;
import com.docker.entity.Users;
import com.docker.entity.UsersProfile;

@Service
public class UsersProfileServiceImpl implements UserProfileService {

	@Autowired
	private UsersProfileDao usersProfileDao;

	@Autowired
	private UsersDao userDao;

	public List<UsersProfile> findbyEmailId(String email) {
		return usersProfileDao.findemailId(email);
	}

	public void saveUserProfile(UsersProfile userProfile) {

		String email = userProfile.getEmailId();
		String pass = userProfile.getPassword();
		Users users = new Users();
		users.setUsername(email);
		users.setPassword(pass);
		users.setEnable(1);

		Authorities authorities = new Authorities();
		authorities.setAuthority("ROLE_WEBUSER");
		authorities.setUsername(email);

		List<Authorities> listAuthotities = new ArrayList<Authorities>();
		listAuthotities.add(authorities);
		users.setAuthorities(listAuthotities);
		usersProfileDao.save(userProfile);

		userDao.save(users);

	}

	@Override
	public UsersProfile findById(int theId) {
		Optional<UsersProfile> result = usersProfileDao.findById(theId);
		UsersProfile usersProfile = null;

		if (result.isPresent()) {
			usersProfile = result.get();
		} else {
			throw new RuntimeException("Client Id not found" + theId);
		}
		return usersProfile;
	}

}
