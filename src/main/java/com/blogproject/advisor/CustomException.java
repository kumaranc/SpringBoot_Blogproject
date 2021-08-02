package com.blogproject.advisor;

public class CustomException extends RuntimeException {

	private String errorCode = "";
	private String errorMessage = "";
	private String date = "";
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public CustomException(String errorCode, String errorMessage, String date) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.date = date;
	}
	public CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
