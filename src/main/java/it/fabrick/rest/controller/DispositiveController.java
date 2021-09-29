package it.fabrick.rest.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.fabrick.BEApplication;
import it.fabrick.exception.FabrickException;
import it.fabrick.rest.DTO.GenericResponse;
import it.fabrick.rest.DTO.bonifico.BonificoRequest;
import it.fabrick.rest.DTO.bonifico.BonificoResponse;
import it.fabrick.services.DispositiveService;
import it.fabrick.utils.Constants;

@Controller
@RequestMapping("/dispositive")
public class DispositiveController {

	private static final Logger logger = LoggerFactory.getLogger(BEApplication.class);
	
	@Autowired
	private DispositiveService dispositiveService;
	
	@GetMapping(value = "/testState", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public GenericResponse<String> testState() { 
		GenericResponse<String> response = null;
		try {
			logger.info("START testState");
			
			
			response = new GenericResponse<String>(Constants.HTTP_STATUS_OK, "API-ON");

			logger.info("END testState produces[{}]",response);
		}catch(FabrickException e) {
			logger.error("Errore in testState API", e);
			throw e;
		}catch(Exception e) {
			logger.error("Errore in testState API", e);
			throw new FabrickException(Constants.GENERIC_EXCEPTION);
		}
		return response;
	}
	
	@PostMapping(value = "/eseguiBonifico", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public GenericResponse<BonificoResponse> eseguiBonifico(@Valid @RequestBody BonificoRequest request) { 
		GenericResponse<BonificoResponse> response = null;
		try {
			logger.info("START eseguiBonifico request[{}]",request);
			
			
			BonificoResponse resultBonifico = dispositiveService.eseguiBonifico(request);
			
			response = new GenericResponse<BonificoResponse>(Constants.HTTP_STATUS_OK, resultBonifico);

			logger.info("END eseguiBonifico produces[{}]",response);
		}catch(FabrickException e) {
			logger.error("Errore in eseguiBonifico API", e);
			throw e;
		}catch(Exception e) {
			logger.error("Errore in eseguiBonifico API", e);
			throw new FabrickException(Constants.GENERIC_EXCEPTION);
		}
		return response;
	}
	
}
