package it.fabrick.services.integration.DTO.letturaSaldo;

import it.fabrick.services.integration.DTO.FabrickGenericResponse;

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

