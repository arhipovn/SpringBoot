package com.nikolayarkhipov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.nikolayarkhipov.model.Profile;
import com.nikolayarkhipov.model.ProfileDao;
import com.nikolayarkhipov.model.SiteUser;


@Service
public class ProfileService {
	
	@Autowired
	ProfileDao profileDao;
	
	@PreAuthorize("isAuthenticated()")
	public void save(Profile profile) {
		profileDao.save(profile);
	}
	
	@PreAuthorize("isAuthenticated()")
	public Profile getUserProfile(SiteUser user) {
		return profileDao.findByUser(user);
	}
}