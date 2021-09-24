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
import it.fabrick.rest.DTO.letturaSaldo.LetturaSaldoResponse;
import it.fabrick.services.InterrogazioniService;
import it.fabrick.services.integration.DTO.FabrickGenericResponse;
import it.fabrick.services.integration.DTO.LetturaSaldoIntegrationResponse;
import it.fabrick.utils.Constants;
import it.fabrick.utils.ServiceIntegrationUtils;


@Service
public class InterrogazioniServiceImpl implements InterrogazioniService{

	private static final Logger logger = LoggerFactory.getLogger(InterrogazioniServiceImpl.class);
	
	@Autowired
	private RestTemplate defaultRestTemplate;

	@Autowired
	private ServiceIntegrationUtils serviceIntegrationUtils;
	
	@Override
	public LetturaSaldoResponse getSaldo(String accountId) {
		logger.info("START - getSaldo accountId[{}]",accountId);
		LetturaSaldoResponse result = null;
		try {
			
			HttpHeaders headers = serviceIntegrationUtils.createFabrickHeaders();
			
	        HttpEntity entity = new HttpEntity(headers);
			
			String uriLetturaSaldo = serviceIntegrationUtils.createLetturaSaldoRequestUri(accountId);
			
			ResponseEntity<LetturaSaldoIntegrationResponse> responseWS = defaultRestTemplate.exchange(uriLetturaSaldo,
                    HttpMethod.GET,
                    entity, LetturaSaldoIntegrationResponse.class);
			
			if(serviceIntegrationUtils.isValidResponse(responseWS)) {
				LetturaSaldoIntegrationResponse reponseBody = responseWS.getBody();
				result = new LetturaSaldoResponse();
				result.setAggiornatoAl(reponseBody.getPayload().getDate());
				result.setSaldo(reponseBody.getPayload().getAvailableBalance());
				result.setSaldoContabile(reponseBody.getPayload().getBalance());
				result.setCurrency(reponseBody.getPayload().getCurrency());
			}else {
				throw new FabrickException(Constants.INTEGRATION_EXCEPTION, "Ricevuto response non valida");
			}

			
		}catch(Exception e) {
			logger.error("Errore durante la lettura del saldo",e);
			throw new FabrickException(Constants.INTEGRATION_EXCEPTION);
		}
		logger.info("END - getSaldo produces [{}]",result);
		return result;
	}

	

}
