package it.fabrick.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.fabrick.exception.FabrickException;
import it.fabrick.rest.DTO.bonifico.BonificoRequest;
import it.fabrick.rest.DTO.bonifico.BonificoResponse;
import it.fabrick.services.DispositiveService;
import it.fabrick.services.integration.DTO.letturaSaldo.LetturaSaldoIntegrationResponse;
import it.fabrick.utils.Constants;
import it.fabrick.utils.ServiceIntegrationUtils;

@Service
public class DispositiveServiceImpl implements DispositiveService{

	private static final Logger logger = LoggerFactory.getLogger(DispositiveServiceImpl.class);
	
	@Autowired
	private RestTemplate defaultRestTemplate;

	@Autowired
	private ServiceIntegrationUtils serviceIntegrationUtils;
	
	@Override
	public BonificoResponse eseguiBonifico(BonificoRequest request) {
		logger.info("START - eseguiBonifico request[{}]",request);
		BonificoResponse result = null;
		try {
			
			HttpHeaders headers = serviceIntegrationUtils.createFabrickHeaders();
			
	        HttpEntity entity = new HttpEntity(headers);
			
			String uriEseguiBonifico = serviceIntegrationUtils.createMoneyTransferRequestUri(request);
			
			/*ResponseEntity<LetturaSaldoIntegrationResponse> responseWS = defaultRestTemplate.exchange(uriEseguiBonifico,
                    HttpMethod.POST,
                    entity, LetturaSaldoIntegrationResponse.class);
			
			if(serviceIntegrationUtils.isValidResponse(responseWS)) {
				LetturaSaldoIntegrationResponse reponseBody = responseWS.getBody();
				if(reponseBody.getPayload() != null) {
					
				}else {
					throw new FabrickException(Constants.INTEGRATION_EXCEPTION, "Payload assente");
				}
			}else {
				throw new FabrickException(Constants.INTEGRATION_EXCEPTION, "Ricevuto response non valida");
			}*/

			
		}catch(Exception e) {
			logger.error("Errore durante l'esecuzione del bonifico",e);
			throw new FabrickException(Constants.INTEGRATION_EXCEPTION);
		}
		logger.info("END - eseguiBonifico produces [{}]",result);
		return result;
	}



}
