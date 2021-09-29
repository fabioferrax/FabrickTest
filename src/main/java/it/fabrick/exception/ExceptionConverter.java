package it.fabrick.exception;

import it.fabrick.rest.DTO.Error;

public interface ExceptionConverter {

	public Error convertError(String code, String msg);
}
