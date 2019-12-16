package com.mindtree.kalingahospital.dto;

public class ErrorDto {
	private String message;

	public ErrorDto() {
		super();
	}

	public ErrorDto(String message) {
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
