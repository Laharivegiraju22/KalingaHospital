package com.mindtree.kalingahospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.kalingahospital.dto.ErrorDto;
import com.mindtree.kalingahospital.exceptions.serviceexcption.DoctorNotFoundException;
import com.mindtree.kalingahospital.exceptions.serviceexcption.PatientsNotFoundException;

@RestControllerAdvice
public class KalingaHospitalAdviceController {
	@ExceptionHandler(PatientsNotFoundException.class)
	public ResponseEntity<ErrorDto> NoPatientExceptionHandler(PatientsNotFoundException e, Throwable cause) {
		return new ResponseEntity<ErrorDto>(new ErrorDto(e.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<ErrorDto> NoDoctorExceptionHandler(DoctorNotFoundException e, Throwable cause) {
		return new ResponseEntity<ErrorDto>(new ErrorDto(e.getMessage()), HttpStatus.NOT_FOUND);
	}
}
