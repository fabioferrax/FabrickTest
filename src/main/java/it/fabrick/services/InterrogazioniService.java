package it.fabrick.services;

import it.fabrick.rest.DTO.letturaSaldo.LetturaSaldoResponse;

public interface InterrogazioniService {

	
	public LetturaSaldoResponse getSaldo(String accountId);
	
}
