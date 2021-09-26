package it.fabrick.services;

import it.fabrick.rest.DTO.letturaSaldo.LetturaSaldoResponse;
import it.fabrick.rest.DTO.letturaTransazioni.LetturaTransazioniRequest;
import it.fabrick.rest.DTO.letturaTransazioni.LetturaTransazioniResponse;

public interface InterrogazioniService {

	
	public LetturaSaldoResponse getSaldo(String accountId);
	
	public LetturaTransazioniResponse  getTransazioni(LetturaTransazioniRequest request);
	
}
