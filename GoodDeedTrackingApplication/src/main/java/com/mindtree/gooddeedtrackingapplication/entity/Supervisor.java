package com.mindtree.gooddeedtrackingapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "supervisorId")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Supervisor {

	@Id
	private int supervisorId;
	private String supervisorName;
	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	GoodDeed goodDeed;

	public Supervisor() {
		super();
	}

	public Supervisor(int supervisorId, String supervisorName, GoodDeed goodDeed) {
		super();
		this.supervisorId = supervisorId;
		this.supervisorName = supervisorName;
		this.goodDeed = goodDeed;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public GoodDeed getGoodDeed() {
		return goodDeed;
	}

	public void setGoodDeed(GoodDeed goodDeed) {
		this.goodDeed = goodDeed;
	}

	@Override
	public String toString() {
		return "Supervisor [supervisorId=" + supervisorId + ", supervisorName=" + supervisorName + ", goodDeed="
				+ goodDeed + "]";
	}

}
