package it.fabrick.rest.DTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "status", "error", "data" })
public class GenericResponse<T> {

	private List<Error> error = new ArrayList<>();
	
	private String status;
	
	private Object data;
	
	public GenericResponse(String status, Object data) {
		this.setStatus(status);
		this.setData(data);
	}
	public GenericResponse(String status, Error error) {
		this.setStatus(status);
		this.getError().add(error);
	}
	public GenericResponse(String status, List<Error> error) {
		this.setStatus(status);
		this.getError().addAll(error);
	}

	public List<Error> getError() {
		return error;
	}

	public void setError(List<Error> error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "GenericResponse [error=" + error + ", status=" + status + ", data=" + data + "]";
	}
	
	
}
