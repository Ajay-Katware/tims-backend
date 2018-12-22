package com.tejovat.tims.exception;

/**
*
* @author YogeshL
*/
@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{

	private Integer resourceId;
	 
    public ResourceNotFoundException(Integer id, String message) {
        super(message);
        this.setResourceId(id);
    }

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
}
