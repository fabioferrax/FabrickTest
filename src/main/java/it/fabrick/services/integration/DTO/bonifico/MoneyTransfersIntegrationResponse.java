package it.fabrick.services.integration.DTO.bonifico;

import it.fabrick.services.integration.DTO.FabrickGenericResponse;

public class MoneyTransfersIntegrationResponse extends FabrickGenericResponse{

	private MoneyTransfersResponseDTO payload;

	public MoneyTransfersResponseDTO getPayload() {
		return payload;
	}

	public void setPayload(MoneyTransfersResponseDTO payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return super.toString()+" MoneyTransfersIntegrationResponse [payload=" + payload + "]";
	}
	
		
}