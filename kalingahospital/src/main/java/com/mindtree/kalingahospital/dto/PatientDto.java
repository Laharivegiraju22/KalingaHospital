package com.mindtree.kalingahospital.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.kalingahospital.entity.Doctor;
import com.mindtree.kalingahospital.entity.Patient;

public class PatientDto {

	private int patientId;
	private String patientName;
	private int billAmount;

	private DoctorDto doctorDto;

	public PatientDto() {
		super();
	}

	public PatientDto(int patientId, String patientName, int billAmount, DoctorDto doctorDto) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.billAmount = billAmount;
		this.doctorDto = doctorDto;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public DoctorDto getDoctorDto() {
		return doctorDto;
	}

	public void setDoctorDto(DoctorDto doctorDto) {
		this.doctorDto = doctorDto;
	}

	@Override
	public String toString() {
		return "PatientDto [patientId=" + patientId + ", patientName=" + patientName + ", billAmount=" + billAmount
				+ ", doctorDto=" + doctorDto + "]";
	}

}
