package com.mindtree.kalingahospital.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.kalingahospital.entity.Doctor;
import com.mindtree.kalingahospital.entity.Patient;

public class DoctorDto {
	private int doctorId;
	private String doctorName;
	private int yearOfExperience;
	private int salary;
	@JsonIgnoreProperties("doctorDto")
	Set<PatientDto> patientDto;

	public DoctorDto() {
		super();
	}

	public DoctorDto(int doctorId, String doctorName, int yearOfExperience, int salary, Set<PatientDto> patientDto) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.yearOfExperience = yearOfExperience;
		this.salary = salary;
		this.patientDto = patientDto;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public Set<PatientDto> getPatientDto() {
		return patientDto;
	}

	public void setPatientDto(Set<PatientDto> patientDto) {
		this.patientDto = patientDto;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "DoctorDto [doctorId=" + doctorId + ", doctorName=" + doctorName + ", yearOfExperience="
				+ yearOfExperience + ", salary=" + salary + ", patientDto=" + patientDto + "]";
	}

}
