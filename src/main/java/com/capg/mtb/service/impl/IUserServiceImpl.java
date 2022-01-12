package com.capg.mtb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.mtb.model.User;
import com.capg.mtb.repository.IUserRepository;
import com.capg.mtb.service.IUserService;

@Component
public class IUserServiceImpl implements IUserService {

	@Autowired
	IUserRepository iUserRepository;



	@Override
	public User addUser(User user)	 {

		user = iUserRepository.save(user);
		return iUserRepository.save(user);
	}

}
