package com.mindtree.gooddeedtrackingapplication.dto;

public class CampusMindDTO {
	private int mid;
	private String name;

	
	public CampusMindDTO(int mid, String name) {
		super();
		this.mid = mid;
		this.name = name;
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

	@Override
	public String toString() {
		return "CampusMindDTO [mid=" + mid + ", name=" + name + "]";
	}

}
