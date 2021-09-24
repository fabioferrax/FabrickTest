package it.fabrick.services.integration.DTO;

import java.util.Date;

public class LetturaSaldoIntegrationResponse extends FabrickGenericResponse{

	private LetturaSaldoDTO payload;

	public LetturaSaldoDTO getPayload() {
		return payload;
	}

	public void setPayload(LetturaSaldoDTO payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return super.toString()+" LetturaSaldoIntegrationResponse [payload=" + payload + "]";
	}
	
		
}

