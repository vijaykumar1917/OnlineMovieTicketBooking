package com.capg.mtb.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mtb.exceptions.ShowNotFoundException;
import com.capg.mtb.model.Show;
import com.capg.mtb.service.IShowService;

@RestController               // It will take care of http protocal and requests from browser
public class ShowController {

	@Autowired                 //	Autowiring feature of spring framework enables you to inject the object dependency
	private IShowService iShowService;

	@PostMapping("/addShow")   //Add Show
	public ResponseEntity<Show> addShow(@RequestBody Show show) throws Exception {
		return ResponseEntity.ok(iShowService.addShow(show));
	}

	@PostMapping("/updateShow")     //Update Show
	public ResponseEntity<Show> updateShow(@RequestBody Show show) throws ShowNotFoundException {
		return ResponseEntity.ok(iShowService.updateShow(show));
	}

	@DeleteMapping("/removeShow/{id}")  //Remove Show by id
	public String removeShow(@PathVariable("id") int id) throws ShowNotFoundException {
		iShowService.removeShow(id);
		return "Success";
	}

	@GetMapping("/showById/{id}")    // Search Show by id
	public ResponseEntity<Show> viewShow(@PathVariable("id") int id) throws ShowNotFoundException {
		return ResponseEntity.ok(iShowService.viewShow(id));
	}

	@GetMapping("/showBytheatreId/{theatreId}")  // View Shows by Theatre id 
	public List<Show> viewShowList(@PathVariable("theatreId") int theatreId) {
		return iShowService.viewShowList(theatreId);
	}

	@GetMapping("/showByDate/{date}")       // View Show by date
	public List<Show> viewShowList(@PathVariable("date") LocalDate date) {
		return iShowService.viewShowList(date);
	}

	@GetMapping("/viewAllShows")     // View Show by date
	public List<Show> viewAllShows() {
		return iShowService.viewAllShows();
	}

}
