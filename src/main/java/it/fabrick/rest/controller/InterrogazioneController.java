package it.fabrick.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.fabrick.exception.FabrickException;
import it.fabrick.rest.DTO.GenericResponse;
import it.fabrick.rest.DTO.letturaSaldo.LetturaSaldoResponse;
import it.fabrick.services.InterrogazioniService;
import it.fabrick.utils.Constants;

@Controller
@RequestMapping("/interrogation")
public class InterrogazioneController {

	private static final Logger logger = LoggerFactory.getLogger(InterrogazioneController.class);
	
	@Autowired
	private InterrogazioniService interrogazioniService;

	@GetMapping(value = "/getSaldo", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public GenericResponse<LetturaSaldoResponse> getSaldo(@RequestParam(value = "accountId", required = true) String accountId) { 
		GenericResponse<LetturaSaldoResponse> response = null;
		try {
			
			LetturaSaldoResponse resultSaldo = interrogazioniService.getSaldo(accountId);
			response = new GenericResponse<LetturaSaldoResponse>(Constants.HTTP_STATUS_OK, resultSaldo);
			
		}catch(FabrickException e) {
			throw e;
		}catch(Exception e) {
			throw new FabrickException(Constants.GENERIC_EXCEPTION);
		}
		return response;
	}
}
