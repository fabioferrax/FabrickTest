package it.fabrick.exception;

public class FabrickException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String code;
	private String msg;
	
	public FabrickException(String code) {
		super();
		this.code = code;
	}
	
	public FabrickException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "FabrickException [code=" + code + ", msg=" + msg + "]";
	}
	
	
}
