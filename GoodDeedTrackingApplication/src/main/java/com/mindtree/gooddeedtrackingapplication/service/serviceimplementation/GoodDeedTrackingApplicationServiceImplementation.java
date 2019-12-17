package com.mindtree.gooddeedtrackingapplication.service.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.gooddeedtrackingapplication.entity.CampusMind;
import com.mindtree.gooddeedtrackingapplication.entity.GoodDeed;
import com.mindtree.gooddeedtrackingapplication.entity.Supervisor;
import com.mindtree.gooddeedtrackingapplication.exceptions.serviceException.GoodNeedNotPresentException;
import com.mindtree.gooddeedtrackingapplication.exceptions.serviceException.NoGoodDeedException;
import com.mindtree.gooddeedtrackingapplication.exceptions.serviceException.noSupervisorPresentWithIdException;
import com.mindtree.gooddeedtrackingapplication.repository.CampusMindRepository;
import com.mindtree.gooddeedtrackingapplication.repository.GoodDeedRepository;
import com.mindtree.gooddeedtrackingapplication.repository.SupervisorRepository;
import com.mindtree.gooddeedtrackingapplication.service.GoodDeedTrackingApplicationService;

@Service
public class GoodDeedTrackingApplicationServiceImplementation implements GoodDeedTrackingApplicationService {
	@Autowired
	GoodDeedRepository goodDeedRepository;

	@Autowired
	CampusMindRepository campusMindRepository;

	@Autowired
	SupervisorRepository supervisorRepository;

	// @Override
	// public void addGoodDeedToMind(GoodDeed goodDeed) {
	// Good
	// campusMindRepository.save(campusmind);
	//

	@Override
	public void addGoodDeeds(GoodDeed goodDeed) {

		GoodDeed newGd = goodDeed;
		newGd.getSupervisor().setGoodDeed(goodDeed);
		newGd.getCampusminds().forEach(c -> c.setGoodDeed1(goodDeed));
		goodDeedRepository.save(newGd);

	}

	@Override
	public List<CampusMind> displayAllCampusMindsWithGoodDeed(int goodDeedId, CampusMind campusmind) throws GoodNeedNotPresentException {
        if(goodDeedRepository.existsById(goodDeedId))
        {
		List<CampusMind> campusMinds = new ArrayList<CampusMind>();
		return campusMinds = goodDeedRepository.getOne(goodDeedId).getCampusminds();

        }
        else
        	throw new GoodNeedNotPresentException("good deed is not present with this id");
		
	}

	@Override
	public GoodDeed displaySupervisor(int sid) throws noSupervisorPresentWithIdException {
		if(supervisorRepository.existsById(sid))
		{
		GoodDeed g = supervisorRepository.getOne(sid).getGoodDeed();
		return g;
		}
		else
		throw new noSupervisorPresentWithIdException("no supervisor with that id");
	}

	@Override
	public List<GoodDeed> showDeedWithLessMinds() {
		List<GoodDeed> tempGDeed = new ArrayList<>();

		tempGDeed = goodDeedRepository.findAll();

		List<GoodDeed> resultDeed = new ArrayList<>();
		for (GoodDeed gd : tempGDeed) {
			if (gd.getCampusminds().size() < 3) {
				resultDeed.add(gd);
			}
		}
		return resultDeed;
	}

	@Override
	public List<GoodDeed> getAllGoodDeeds() throws NoGoodDeedException {
		if(goodDeedRepository.count()>0)
		{
			return goodDeedRepository.findAll();
		}
		else
			throw new NoGoodDeedException("no good deeds are present");
	}

}
