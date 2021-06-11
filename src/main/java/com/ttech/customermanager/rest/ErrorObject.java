package com.ttech.customermanager.rest;

import java.util.ArrayList;
import java.util.List;



public class ErrorObject {

	private List<ErrorObject> errorObjects;
    private String         message;
    private int            errorCause;
    
	public List<ErrorObject> getErrorObjects() {
		return errorObjects;
	}
	public ErrorObject addErrorObjects(final ErrorObject errorObject) {
        if (this.errorObjects == null) {
            this.errorObjects = new ArrayList<>();
        }
		errorObjects.add(errorObject);
	    return this;
		
	}
	public String getMessage() {
		return message;
	}
	public ErrorObject setMessage(final String message) {
		this.message = message;
	    return this;
	}
	public int getErrorCause() {
		return errorCause;
	}
	public ErrorObject setErrorCause(final int errorCause) {
		this.errorCause = errorCause;
	    return this;
	}
	
}
