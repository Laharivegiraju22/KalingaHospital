package com.mindtree.gooddeedtrackingapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.gooddeedtrackingapplication.dto.CampusMindDTO;
import com.mindtree.gooddeedtrackingapplication.dto.GoodDeedDTO;
import com.mindtree.gooddeedtrackingapplication.entity.CampusMind;
import com.mindtree.gooddeedtrackingapplication.entity.GoodDeed;
import com.mindtree.gooddeedtrackingapplication.entity.Supervisor;
import com.mindtree.gooddeedtrackingapplication.exceptions.serviceException.GoodNeedNotPresentException;
import com.mindtree.gooddeedtrackingapplication.exceptions.serviceException.ServiceException;
import com.mindtree.gooddeedtrackingapplication.exceptions.serviceException.noSupervisorPresentWithIdException;
import com.mindtree.gooddeedtrackingapplication.repository.CampusMindRepository;
import com.mindtree.gooddeedtrackingapplication.repository.GoodDeedRepository;
import com.mindtree.gooddeedtrackingapplication.repository.SupervisorRepository;
import com.mindtree.gooddeedtrackingapplication.service.GoodDeedTrackingApplicationService;

@RestController
public class GoodDeedTrackingApplicationController {

	@Autowired
	GoodDeedTrackingApplicationService gdtservice;

	@RequestMapping("/addgooddeeds")
	public String addGooddeeds(@RequestBody GoodDeed goodDeed) {
		gdtservice.addGoodDeeds(goodDeed);
		return "added goodDeed";
	}

	// @RequestMapping("/assigngoodDeed")
	// public String addGoodDeedToMind(@RequestBody CampusMind campusmind)
	// {
	// gdtservice.addGoodDeedToMind(campusmind);
	// return "good deed added to campus mind successfully";
	// }

	@RequestMapping("/displayAllCampusMindsWithGoodDeed/{goodDeedId}")
	public List<CampusMind> displayCampusMindWithGoodDeed(@PathVariable int goodDeedId,
			@RequestBody CampusMind campusmind) throws ServiceException {
		return gdtservice.displayAllCampusMindsWithGoodDeed(goodDeedId, campusmind);
	}

	@RequestMapping("/displaySupervisor/{sid}")
	public GoodDeed displaySupervisor(@PathVariable int sid) throws ServiceException {
		return gdtservice.displaySupervisor(sid);
	}

	@RequestMapping("/showDeedWithLessMinds")
	public List<GoodDeed> showDeedWithLessMinds() {
		return gdtservice.showDeedWithLessMinds();
	}

	@GetMapping("/getalldeeds")
	public ResponseEntity<List<GoodDeedDTO>> getAllGoodDeeds() throws ServiceException{
		List<GoodDeedDTO> deedsDTO = new ArrayList<GoodDeedDTO>();
		
		for(GoodDeed gd:gdtservice.getAllGoodDeeds())
		{
			List<CampusMindDTO> mind=new ArrayList<CampusMindDTO>();
			gd.getCampusminds().forEach(i -> mind.add(new CampusMindDTO(i.getMid(),i.getName())));
			deedsDTO.add(new GoodDeedDTO(gd.getGoodDeedId(),gd.getGoodDeedName(),gd.getSupervisor().getSupervisorName(),mind));
		}
		return (ResponseEntity<List<GoodDeedDTO>>) deedsDTO;
		

	}

}
