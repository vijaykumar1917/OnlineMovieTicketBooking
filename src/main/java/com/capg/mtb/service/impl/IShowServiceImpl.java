package com.capg.mtb.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.mtb.exceptions.MovieNotFoundException;
import com.capg.mtb.exceptions.ShowNotFoundException;
import com.capg.mtb.model.Show;
import com.capg.mtb.model.Theatre;
import com.capg.mtb.repository.IMovieRepository;
import com.capg.mtb.repository.IShowRepository;
import com.capg.mtb.repository.ITheatreRepository;
import com.capg.mtb.service.IShowService;

@Component
public class IShowServiceImpl implements IShowService {

	@Autowired        //	Autowiring feature of spring framework enables you to inject the object dependency
	IShowRepository iShowRepository;
	
	@Autowired        //	Autowiring feature of spring framework enables you to inject the object dependency
	IMovieRepository iMovieRepository;
	
	@Autowired        //	Autowiring feature of spring framework enables you to inject the object dependency
	ITheatreRepository iTheatreRepository;
	

	@Override
	public Show addShow(Show show) throws Exception {
		//if there is no movie with given movieid it will throw MovieNotFoundException
		if(!iMovieRepository.existsById(show.getMovieId())){
			throw new MovieNotFoundException("No movie id is found:" + show.getMovieId());
			
		} else {
			
			Theatre theatre = iTheatreRepository.getById(show.getTheatreId());
			// if there is no theatre with given  theatre id it will throw MovieNotFoundException
			if(theatre==null) {
				throw new MovieNotFoundException("No theatre id is found:" + show.getTheatreId());
			}
			
			if(theatre.getListOfScreens().stream().filter(e->e.getScreenId()==show.getScreenId()).findAny().isEmpty()) {
				throw new MovieNotFoundException("Screen Id and Theatre Id are not matching");	
			}
			
		}
		
		return iShowRepository.save(show);
	}

	@Override
	public Show updateShow(Show show) throws ShowNotFoundException {
		iShowRepository.findById(show.getShowId())
				.orElseThrow(() -> new ShowNotFoundException("No show id is found:" + show.getShowId()));
		return iShowRepository.save(show);
	}

	@Override
	public void removeShow(int id) throws ShowNotFoundException {
		Show show = iShowRepository.findById(id)
				.orElseThrow(() -> new ShowNotFoundException("No show id is found:" + id));
		iShowRepository.delete(show);
	}

	@Override
	public Show viewShow(int id) throws ShowNotFoundException {
		return iShowRepository.findById(id).orElseThrow(() -> new ShowNotFoundException("No movie id is found:" + id));
	}

	@Override
	public List<Show> viewShowList(int theatreId) {
		return iShowRepository.findByTheatreId(theatreId);
	}

	@Override
	public List<Show> viewShowList(LocalDate date) {
		return iShowRepository.findByLocalDate(date);
	}

	@Override
	public List<Show> viewAllShows() {
		return iShowRepository.findAll();
	}

}
