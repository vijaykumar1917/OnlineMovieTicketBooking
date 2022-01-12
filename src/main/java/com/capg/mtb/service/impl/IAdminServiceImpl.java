package com.capg.mtb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.mtb.model.Admin;
import com.capg.mtb.repository.IAdminRepository;
import com.capg.mtb.service.IAdminService;
@Component
public class IAdminServiceImpl implements IAdminService{
	@Autowired
	IAdminRepository iAdminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		admin = iAdminRepository.save(admin);
		return iAdminRepository.save(admin);
		
	}

}
