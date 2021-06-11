package com.ttech.customermanager.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestErrorHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(RestErrorHandler.class);
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorObject handleError(final MethodArgumentNotValidException exceptionParam) {
		
		logger.error("[RestErrorHandler][handleException]-> *MethodArgumentNotValidException Error* : " + exceptionParam.getMessage(),
                                      exceptionParam);
		
		ErrorObject errObj = new ErrorObject();
		errObj.setMessage("Validation Error: "+ exceptionParam.getMessage());	
		errObj.setErrorCause(400);
	
		 List<ObjectError> allErrorsLoc = exceptionParam.getAllErrors();
			for (ObjectError objectErrorLoc : allErrorsLoc) {
				errObj.addErrorObjects(new ErrorObject().setMessage(objectErrorLoc.toString())
                        .setErrorCause(300));
			}
		
		
		return errObj;
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorObject handleError(final Exception exceptionParam) {
		
		logger.error("[RestErrorHandler][handleException]-> *Error* : " + exceptionParam.getMessage(),
                                      exceptionParam);
		
		ErrorObject errObj = new ErrorObject();
		errObj.setMessage("Error Occurred: "+ exceptionParam.getMessage());	
		errObj.setErrorCause(500);
		return errObj;
	}
}
