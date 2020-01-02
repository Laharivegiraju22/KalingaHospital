package com.mindtree.kalingahospital.exceptions.serviceexcption;

public class DoctorNotFoundException extends KalingaHospitalServiceException {

	private static final long serialVersionUID = 1L;

	public DoctorNotFoundException() {
		super();
		
	}

	public DoctorNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public DoctorNotFoundException(String arg0) {
		super(arg0);
		
	}

	public DoctorNotFoundException(Throwable arg0) {
		super(arg0);
		
	}

}
