package it.fabrick.services.integration.DTO.letturaTransazioni;

import it.fabrick.services.integration.DTO.FabrickGenericResponse;

public class LetturaTransazioniIntegrationResponse extends FabrickGenericResponse{

	private LetturaTransazioniDTO payload;

	public LetturaTransazioniDTO getPayload() {
		return payload;
	}

	public void setPayload(LetturaTransazioniDTO payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return super.toString()+" LetturaTransazioniIntegrationResponse [payload=" + payload + "]";
	}
	
		
}

