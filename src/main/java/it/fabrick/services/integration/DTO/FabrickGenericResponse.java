package it.fabrick.services.integration.DTO;

import java.util.ArrayList;
import java.util.List;

public class FabrickGenericResponse {
	private List<Error> error;
	
	private String status;
	

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

	@Override
	public String toString() {
		return "FabrickGenericResponse [error=" + error + ", status=" + status + "]";
	}


}
