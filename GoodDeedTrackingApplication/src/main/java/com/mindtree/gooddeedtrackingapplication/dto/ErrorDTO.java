package com.mindtree.gooddeedtrackingapplication.dto;

public class ErrorDTO {

	private String message;

	public ErrorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDTO(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
