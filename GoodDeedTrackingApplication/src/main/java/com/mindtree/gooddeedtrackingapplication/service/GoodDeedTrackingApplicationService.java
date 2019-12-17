package com.mindtree.gooddeedtrackingapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.gooddeedtrackingapplication.entity.CampusMind;
import com.mindtree.gooddeedtrackingapplication.entity.GoodDeed;
import com.mindtree.gooddeedtrackingapplication.exceptions.serviceException.GoodNeedNotPresentException;
import com.mindtree.gooddeedtrackingapplication.exceptions.serviceException.NoGoodDeedException;
import com.mindtree.gooddeedtrackingapplication.exceptions.serviceException.noSupervisorPresentWithIdException;

@Service
public interface GoodDeedTrackingApplicationService {

//	void addGoodDeedToMind(CampusMind campusmind);

	void addGoodDeeds(GoodDeed goodDeed);

	List<CampusMind> displayAllCampusMindsWithGoodDeed(int goodDeedId, CampusMind campusmind) throws GoodNeedNotPresentException;

	GoodDeed displaySupervisor(int sid) throws noSupervisorPresentWithIdException;

	List<GoodDeed> showDeedWithLessMinds();

	List<GoodDeed> getAllGoodDeeds() throws NoGoodDeedException;

	//GoodDeed displaySupervisor(int sid, GoodDeed gooddeed);

}
