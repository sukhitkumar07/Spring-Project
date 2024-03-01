package org.jsp.adminHospital.exception;

public class InvalidCredentialsException extends RuntimeException {
	@Override
	public String getMessage() {
		return "invalid phone/email/password";
		
	}

}