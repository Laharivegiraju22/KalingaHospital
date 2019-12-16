package com.mindtree.kalingahospital.controller;

import java.util.Comparator;

import com.mindtree.kalingahospital.entity.Doctor;

public class sortBySalary implements Comparator<Doctor>{

	@Override
	public int compare(Doctor d1, Doctor d2) {
		
		return d1.getSalary()-d2.getSalary();
	}

}
