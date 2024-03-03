package com.epam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.db.AdminAndUserDao;
import com.epam.entity.AdminAndUser;

@Service
public class AdminAndUserValidationService {
	@Autowired
	AdminAndUserDao au;
	
	public boolean validateAdminAndUser(AdminAndUser role) {
		boolean result=false;
		System.out.println(role);
			if(au.findMatchingUser(role.getUserType(), role.getUserName(), role.getPassword())!=null)
			{
				result=true;
			}
			return result;
		}

	public boolean userSignUp(AdminAndUser user) {
			au.saveUsers(user);
			return true;
		}
	}

