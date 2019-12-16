package com.mindtree.kalingahospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.kalingahospital.dto.DoctorDto;
import com.mindtree.kalingahospital.dto.PatientDto;
import com.mindtree.kalingahospital.entity.Patient;
import com.mindtree.kalingahospital.exceptions.serviceexcption.KalingaHospitalServiceException;

@Service
public interface KalingaHospitalService {

	PatientDto addPatient(Patient patient) throws KalingaHospitalServiceException;

	List<DoctorDto> sortDoctorBySalary();

	List<DoctorDto> sortDoctorByPatientCount();

	String addToFile() throws KalingaHospitalServiceException;

}
