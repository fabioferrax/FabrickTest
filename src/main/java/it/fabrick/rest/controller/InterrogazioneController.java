package it.fabrick.rest.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.fabrick.exception.FabrickException;
import it.fabrick.rest.DTO.GenericResponse;
import it.fabrick.rest.DTO.letturaSaldo.LetturaSaldoResponse;
import it.fabrick.rest.DTO.letturaTransazioni.LetturaTransazioniRequest;
import it.fabrick.rest.DTO.letturaTransazioni.LetturaTransazioniResponse;
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
			logger.info("START getSaldo accountId[{}]",accountId);
			
			LetturaSaldoResponse resultSaldo = interrogazioniService.getSaldo(accountId);
			
			response = new GenericResponse<LetturaSaldoResponse>(Constants.HTTP_STATUS_OK, resultSaldo);

			logger.info("END getSaldo produces[{}]",response);
		}catch(FabrickException e) {
			logger.error("Errore in getSaldo API", e);
			throw e;
		}catch(Exception e) {
			logger.error("Errore in getSaldo API", e);
			throw new FabrickException(Constants.GENERIC_EXCEPTION);
		}
		return response;
	}
	

	@GetMapping(value = "/getTransazioni", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public GenericResponse<LetturaTransazioniResponse> getTransazioni(
			@RequestParam(value = "accountId", required = true) String accountId,
			@RequestParam(value = "fromAccountingDate", required = true) @DateTimeFormat(pattern="yyyy-MM-d") Date from,
			@RequestParam(value = "toAccountingDate", required = true) @DateTimeFormat(pattern="yyyy-MM-d") Date to
			
			) { 
		GenericResponse<LetturaTransazioniResponse> response = null;
		try {
			logger.info("START getTransazioni accountId[{}] from[{}] to[{}]",accountId, from, to);
			
			LetturaTransazioniRequest request = new LetturaTransazioniRequest(accountId, from, to);
			
			LetturaTransazioniResponse resultTransazioni = interrogazioniService.getTransazioni(request);
			response = new GenericResponse<LetturaTransazioniResponse>(Constants.HTTP_STATUS_OK, resultTransazioni);

			logger.info("END getTransazioni produces[{}]",response);
		}catch(FabrickException e) {
			logger.error("Errore in getTransazioni API", e);
			throw e;
		}catch(Exception e) {
			logger.error("Errore in getTransazioni API", e);
			throw new FabrickException(Constants.GENERIC_EXCEPTION);
		}
		return response;
	}
}
