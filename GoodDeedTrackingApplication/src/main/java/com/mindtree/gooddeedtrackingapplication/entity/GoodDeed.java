package com.mindtree.gooddeedtrackingapplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "goodDeedId")
// @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class GoodDeed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int goodDeedId;
	private String goodDeedName;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "goodDeed")
	Supervisor supervisor;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "goodDeed")
	List<CampusMind> campusminds;

	public GoodDeed() {
		super();
	}

	public GoodDeed(String goodDeedName, Supervisor supervisor, List<CampusMind> campusminds) {
		super();
		this.goodDeedName = goodDeedName;
		this.supervisor = supervisor;
		this.campusminds = campusminds;
	}

	public int getGoodDeedId() {
		return goodDeedId;
	}

	public String getGoodDeedName() {
		return goodDeedName;
	}

	public void setGoodDeedName(String goodDeedName) {
		this.goodDeedName = goodDeedName;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public List<CampusMind> getCampusminds() {
		return campusminds;
	}

	public void setCampusminds(List<CampusMind> campusminds) {
		this.campusminds = campusminds;
	}

	@Override
	public String toString() {
		return "GoodDeed [goodDeedId=" + goodDeedId + ", goodDeedName=" + goodDeedName + ", supervisor=" + supervisor
				+ ", campusminds=" + campusminds + "]";
	}

}
