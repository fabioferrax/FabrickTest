package it.fabrick.rest.DTO.letturaTransazioni;

import java.util.List;

public class LetturaTransazioniResponse {

	private List<Transazione> transazioni;

	public List<Transazione> getTransazioni() {
		return transazioni;
	}

	public void setTransazioni(List<Transazione> transazioni) {
		this.transazioni = transazioni;
	}
	
	
}
