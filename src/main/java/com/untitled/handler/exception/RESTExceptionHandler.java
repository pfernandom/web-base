package com.untitled.handler.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = RepositoryRestExceptionHandler.class)
public class RESTExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(RESTExceptionHandler.class);
	
	@ExceptionHandler
    ResponseEntity handle(Exception e) {
		logger.error("REST Exception",e);
		
        return new ResponseEntity("", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
