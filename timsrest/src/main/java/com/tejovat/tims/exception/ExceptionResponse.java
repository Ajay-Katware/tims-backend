package com.tejovat.tims.exception;

/**
*
* @author YogeshL
*/
public class ExceptionResponse {

    private Integer errorCode;
    private String errorMessage;

    public ExceptionResponse() {
    }

    public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}