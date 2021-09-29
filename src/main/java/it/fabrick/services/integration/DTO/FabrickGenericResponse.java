package it.fabrick.services.integration.DTO;

import java.util.ArrayList;
import java.util.List;

public class FabrickGenericResponse {
	private List<Error> errors;
	
	private String status;

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FabrickGenericResponse [errors=" + errors + ", status=" + status + "]";
	}


}
