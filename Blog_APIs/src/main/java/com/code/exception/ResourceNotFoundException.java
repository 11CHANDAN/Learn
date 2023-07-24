package com.code.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(resourceName+" not found with "+fieldName+" : "+fieldValue);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFeildName() {
		return fieldName;
	}
	public void setFeildName(String feildName) {
		this.fieldName = feildName;
	}
	public Object getFeildValue() {
		return fieldValue;
	}
	public void setFeildValue(Object feildValue) {
		this.fieldValue = feildValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
