package com.mindtree.gooddeedtrackingapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.gooddeedtrackingapplication.dto.ErrorDTO;
import com.mindtree.gooddeedtrackingapplication.exceptions.serviceException.ServiceException;

@RestControllerAdvice
public class GoodDeedTrackingApplicationExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorDTO> serviceExceptionHandler() {
		return new ResponseEntity<ErrorDTO>(new ErrorDTO("error in service"), HttpStatus.NOT_FOUND);
	}
}
