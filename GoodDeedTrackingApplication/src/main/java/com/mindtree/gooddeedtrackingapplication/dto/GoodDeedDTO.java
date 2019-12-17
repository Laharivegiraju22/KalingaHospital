package com.mindtree.gooddeedtrackingapplication.dto;

import java.util.List;

public class GoodDeedDTO {
private int goodDeedId;
private String goodDeedName;
private String supervisorName;
private List<CampusMindDTO> minds;
public GoodDeedDTO() {
	super();
}
public GoodDeedDTO(int goodDeedId, String goodDeedName, String supervisorName, List<CampusMindDTO> minds) {
	super();
	this.goodDeedId = goodDeedId;
	this.goodDeedName = goodDeedName;
	this.supervisorName = supervisorName;
	this.minds = minds;
}
public int getGoodDeedId() {
	return goodDeedId;
}
public void setGoodDeedId(int goodDeedId) {
	this.goodDeedId = goodDeedId;
}
public String getGoodDeedName() {
	return goodDeedName;
}
public void setGoodDeedName(String goodDeedName) {
	this.goodDeedName = goodDeedName;
}
public String getSupervisorName() {
	return supervisorName;
}
public void setSupervisorName(String supervisorName) {
	this.supervisorName = supervisorName;
}
public List<CampusMindDTO> getMinds() {
	return minds;
}
public void setMinds(List<CampusMindDTO> minds) {
	this.minds = minds;
}

}
