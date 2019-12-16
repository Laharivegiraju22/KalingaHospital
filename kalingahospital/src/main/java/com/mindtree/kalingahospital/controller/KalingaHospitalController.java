package com.mindtree.kalingahospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingahospital.dto.DoctorDto;
import com.mindtree.kalingahospital.dto.PatientDto;
import com.mindtree.kalingahospital.entity.Patient;
import com.mindtree.kalingahospital.exceptions.serviceexcption.KalingaHospitalServiceException;
import com.mindtree.kalingahospital.service.KalingaHospitalService;

@RestController
public class KalingaHospitalController {
	@Autowired
	KalingaHospitalService kalingaHospitalimpl;

	@RequestMapping("/addPatient")
	public ResponseEntity<PatientDto> addPatient(@RequestBody Patient patient) throws KalingaHospitalServiceException {
		// return kalingaHospitalimpl.addPatient(patient);
		return ResponseEntity.status(HttpStatus.OK).body(kalingaHospitalimpl.addPatient(patient));
	}

	@RequestMapping("/sortDoctor")
	public List<DoctorDto> sortDoctor() {
		return kalingaHospitalimpl.sortDoctorBySalary();
	}

	@RequestMapping("/sortDoctorByPatientCount")
	public List<DoctorDto> sortDoctorByPatientCount() {
		return kalingaHospitalimpl.sortDoctorByPatientCount();
	}

	@RequestMapping("/addToFile")
	public ResponseEntity<String> addToFile() throws KalingaHospitalServiceException {

		// String str=kalingaHospitalimpl.addToFile();
		return ResponseEntity.status(HttpStatus.OK).body(kalingaHospitalimpl.addToFile());

	}
}
