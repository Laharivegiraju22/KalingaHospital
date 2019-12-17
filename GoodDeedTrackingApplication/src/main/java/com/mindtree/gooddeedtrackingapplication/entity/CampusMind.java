package com.mindtree.gooddeedtrackingapplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mindtree.gooddeedtrackingapplication.entity.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "mid")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CampusMind {

	@Id
	private int mid;
	private String name;
	@ManyToOne
	GoodDeed goodDeed;

	public CampusMind() {
		super();
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GoodDeed getGoodDeed() {
		return goodDeed;
	}

	public void setGoodDeed1(GoodDeed goodDeed) {
		this.goodDeed = goodDeed;
	}

}
