package it.fabrick.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentTypeMismatchException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import it.fabrick.rest.DTO.GenericResponse;
import it.fabrick.utils.Constants;

@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@Autowired
	private ExceptionConverter exceptionConverter;

	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
    public ResponseEntity<GenericResponse> handleException(MethodArgumentNotValidException ex) {
		logger.info("HANDLE MethodArgumentNotValidException [{}]", ex.toString());
		List<it.fabrick.rest.DTO.Error> errors = new ArrayList<>();
		BindingResult result = ex.getBindingResult();
		for (org.springframework.validation.FieldError fieldError: result.getFieldErrors()) {
			//fieldError.getField()
			errors.add(new it.fabrick.rest.DTO.Error("VALIDATION_ERROR", "Field "+fieldError.getField()+":"+fieldError.getDefaultMessage()));
        }
		GenericResponse response = new GenericResponse(Constants.HTTP_STATUS_KO, errors);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.BAD_REQUEST);
    }
	
	
	@ExceptionHandler(FabrickException.class)
	@ResponseBody
    public GenericResponse handleException(FabrickException ex) {
		logger.info("HANDLE FabrickException [{}]", ex.toString());
		GenericResponse response = new GenericResponse(Constants.HTTP_STATUS_KO, exceptionConverter.convertError(ex.getCode(), ex.getMsg()));
		if(ex.getErrors() != null) {
			response = new GenericResponse<>(Constants.HTTP_STATUS_KO, ex.getErrors());

		}
		return response;
    }

	@ExceptionHandler(ConversionFailedException.class)
	@ResponseBody
    public ResponseEntity<GenericResponse> handleException(ConversionFailedException ex) {
		logger.info("HANDLE ConversionFailedException [{}]", ex.toString());
		List<it.fabrick.rest.DTO.Error> errors = new ArrayList<>();
		String srcType = ex.getSourceType().getName();
	    String trgtype = ex.getTargetType().getName();
	    String value = (String)ex.getValue();
	    errors.add(new it.fabrick.rest.DTO.Error("VALIDATION_ERROR", "Impossibile convertire '"+value+"' ["+srcType+"] in ["+trgtype+"]"));
        
		GenericResponse response = new GenericResponse(Constants.HTTP_STATUS_KO, errors);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody
    public ResponseEntity<GenericResponse> handleException(MissingServletRequestParameterException ex) {
		logger.info("HANDLE MissingServletRequestParameterException [{}]", ex.toString());
		List<it.fabrick.rest.DTO.Error> errors = new ArrayList<>();
		String name = ex.getParameterName();
	    String type = ex.getParameterType();
	    errors.add(new it.fabrick.rest.DTO.Error("VALIDATION_ERROR", "Field "+name+"["+type+"]: is required "));
        
		GenericResponse response = new GenericResponse(Constants.HTTP_STATUS_KO, errors);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.BAD_REQUEST);
    }
	
	
	
}
