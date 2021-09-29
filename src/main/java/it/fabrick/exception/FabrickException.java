package it.fabrick.exception;

import java.util.List;

import it.fabrick.rest.DTO.Error;

public class FabrickException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String code;
	private String externalCode;
	private String msg;
	private List<Error> errors;

	public FabrickException(String code) {
		super(code);
		this.code = code;
	}

	public FabrickException(String code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public FabrickException(String code, String msg, String externalCode) {
		super(msg);
		this.code = code;
		this.msg = msg;
		this.externalCode = externalCode;
	}

	public FabrickException(String code, String msg, List<Error> errors) {
		super(msg);
		this.code = code;
		this.msg = msg;
		this.errors = errors;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getExternalCode() {
		return externalCode;
	}

	public void setExternalCode(String externalCode) {
		this.externalCode = externalCode;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "FabrickException [code=" + code + ", externalCode=" + externalCode + ", msg=" + msg + ", errors="
				+ errors + "]";
	}

	
	
}
