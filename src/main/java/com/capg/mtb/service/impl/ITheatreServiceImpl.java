package com.capg.mtb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.mtb.model.Theatre;
import com.capg.mtb.repository.ITheatreRepository;
import com.capg.mtb.service.ITheatreService;

@Component
public class ITheatreServiceImpl implements ITheatreService{
	
	@Autowired  //	Autowiring feature of spring framework enables you to inject the object dependency
	ITheatreRepository iTheatreRepository;

	@Override
	public Theatre addtheatre(Theatre theatre) {
		return iTheatreRepository.save(theatre);
	}
}
