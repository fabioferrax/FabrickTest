package it.fabrick.services;

import it.fabrick.rest.DTO.bonifico.BonificoRequest;
import it.fabrick.rest.DTO.bonifico.BonificoResponse;

public interface DispositiveService {

	
	public BonificoResponse eseguiBonifico(BonificoRequest request);	
	
}
