package com.tejovat.tims.exception;

/**
*
* @author YogeshL
* @author Pravin Tumasre
*/
public class TIMSException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
	public TIMSException() {
	}
	
//	public ExperienceException(String errorCode, String errorMessage) {
//		super();
//		this.errorCode = errorCode;
//		this.errorMessage = errorMessage;
//	}

	public TIMSException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
