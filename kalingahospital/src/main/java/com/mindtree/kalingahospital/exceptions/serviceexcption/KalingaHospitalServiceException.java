package com.mindtree.kalingahospital.exceptions.serviceexcption;

import com.mindtree.kalingahospital.exceptions.KalingaHospitalAppException;

public class KalingaHospitalServiceException extends KalingaHospitalAppException {

	private static final long serialVersionUID = 1L;

	public KalingaHospitalServiceException() {
		super();
		
	}

	public KalingaHospitalServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public KalingaHospitalServiceException(String arg0) {
		super(arg0);
		
	}

	public KalingaHospitalServiceException(Throwable arg0) {
		super(arg0);
		
	}

}
