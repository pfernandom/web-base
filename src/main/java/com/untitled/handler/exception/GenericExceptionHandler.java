package com.untitled.handler.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages={"com.untitled.web"})
public class GenericExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(GenericExceptionHandler.class);

	@Autowired
	Environment env;

	@ExceptionHandler({ org.springframework.security.access.AccessDeniedException.class })
	public ResponseEntity handle(Exception e) {
		return new ResponseEntity("Access is denied", new HttpHeaders(), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String exception(final Throwable throwable, final Model model) {
		logger.error(throwable.toString());
		return "error";
	}
}