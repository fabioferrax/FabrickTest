package it.fabrick.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import it.fabrick.rest.DTO.GenericResponse;
import it.fabrick.utils.Constants;

@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@Autowired
	private ExceptionUtils exceptionUtils;
	
	@ExceptionHandler(FabrickException.class)
	@ResponseBody
    public GenericResponse handleException(FabrickException ex) {
		logger.info("HANDLE FabrickException [{}]", ex.toString());
		GenericResponse response = new GenericResponse(Constants.HTTP_STATUS_KO, exceptionUtils.convertError(ex.getCode(), ex.getMsg()));
		return response;
    }
}
