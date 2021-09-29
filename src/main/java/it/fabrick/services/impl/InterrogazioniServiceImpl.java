package it.fabrick.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.fabrick.dao.repository.TransazioneRepository;
import it.fabrick.exception.FabrickException;
import it.fabrick.rest.DTO.BaseAccountRequest;
import it.fabrick.rest.DTO.letturaSaldo.LetturaSaldoResponse;
import it.fabrick.rest.DTO.letturaTransazioni.LetturaTransazioniRequest;
import it.fabrick.rest.DTO.letturaTransazioni.LetturaTransazioniResponse;
import it.fabrick.rest.DTO.letturaTransazioni.Transazione;
import it.fabrick.services.InterrogazioniService;
import it.fabrick.services.integration.ServiceIntegrationUtils;
import it.fabrick.services.integration.DTO.letturaSaldo.LetturaSaldoIntegrationResponse;
import it.fabrick.services.integration.DTO.letturaTransazioni.LetturaTransazioniIntegrationResponse;
import it.fabrick.utils.Constants;
import it.fabrick.utils.Mapper;


@Service
public class InterrogazioniServiceImpl implements InterrogazioniService{

	private static final Logger logger = LoggerFactory.getLogger(InterrogazioniServiceImpl.class);
	
	@Autowired
	private RestTemplate defaultRestTemplate;

	@Autowired
	private ServiceIntegrationUtils serviceIntegrationUtils;
	
	@Autowired
	private TransazioneRepository transazioneRepository;

	@Override
	public LetturaSaldoResponse getSaldo(Long accountId) {
		logger.info("START - getSaldo accountId[{}]",accountId);
		LetturaSaldoResponse result = null;
		try {
			
			HttpHeaders headers = serviceIntegrationUtils.createFabrickHeaders();
			
	        HttpEntity entity = new HttpEntity(headers);
			
	        BaseAccountRequest baseReq = new BaseAccountRequest(accountId);
			String uriLetturaSaldo = serviceIntegrationUtils.createLetturaSaldoRequestUri(baseReq);
			
			ResponseEntity<LetturaSaldoIntegrationResponse> responseWS = defaultRestTemplate.exchange(uriLetturaSaldo,
                    HttpMethod.GET,
                    entity, LetturaSaldoIntegrationResponse.class);
			
			if(serviceIntegrationUtils.isValidResponse(responseWS)) {
				LetturaSaldoIntegrationResponse reponseBody = responseWS.getBody();
				if(reponseBody.getPayload() != null) {
					result = new LetturaSaldoResponse();
					result.setAggiornatoAl(reponseBody.getPayload().getDate());
					result.setSaldo(reponseBody.getPayload().getAvailableBalance());
					result.setSaldoContabile(reponseBody.getPayload().getBalance());
					result.setCurrency(reponseBody.getPayload().getCurrency());
				}else {
					throw new FabrickException(Constants.INTEGRATION_EXCEPTION, "Payload assente");
				}
			}else {
				serviceIntegrationUtils.manageErrorResponse(responseWS);
			}

			
		}catch(FabrickException e) {
			logger.error("Errore durante la lettura delle transazioni",e);
			throw e;
		}catch(Exception e) {
			logger.error("Errore durante la lettura del saldo",e);
			throw new FabrickException(Constants.INTEGRATION_EXCEPTION, e.getMessage());
		}
		logger.info("END - getSaldo produces [{}]",result);
		return result;
	}

	@Override
	public LetturaTransazioniResponse getTransazioni(LetturaTransazioniRequest request) {
		logger.info("START - getTransazioni request[{}] ",request);
		LetturaTransazioniResponse result = null;
		try {
			
			HttpHeaders headers = serviceIntegrationUtils.createFabrickHeaders();
			
	        HttpEntity entity = new HttpEntity(headers);
			
			String uriLetturaTransazioni = serviceIntegrationUtils.createLetturaTransazioniUri(request);
			
			ResponseEntity<LetturaTransazioniIntegrationResponse> responseWS = defaultRestTemplate.exchange(uriLetturaTransazioni,
                    HttpMethod.GET,
                    entity, LetturaTransazioniIntegrationResponse.class);
			
			if(serviceIntegrationUtils.isValidResponse(responseWS)) {
				LetturaTransazioniIntegrationResponse reponseBody = responseWS.getBody();
				if(reponseBody.getPayload() != null) {
					result = new LetturaTransazioniResponse();
					result.setTransazioni(Mapper.mapTransazioni(reponseBody.getPayload().getList()));
					persistTransazioni(result.getTransazioni());
				}else {
					throw new FabrickException(Constants.INTEGRATION_EXCEPTION, "Payload assente");
				}
			}else {
				serviceIntegrationUtils.manageErrorResponse(responseWS);
			}

			
		}catch(FabrickException e) {
			logger.error("Errore durante la lettura delle transazioni",e);
			throw e;
		}catch(Exception e) {
			logger.error("Errore durante la lettura delle transazioni",e);
			throw new FabrickException(Constants.INTEGRATION_EXCEPTION, e.getMessage());
		}
		logger.info("END - getTransazioni produces [{}]",result);
		return result;
	}

	private void persistTransazioni(List<Transazione> transazioni) {
		logger.info("START - persistTransazioni transazioni.size [{}]",transazioni != null ? transazioni.size() : 0);
		try {
			if(transazioni != null) {
				List<it.fabrick.dao.entity.Transazione> listToPersist = Mapper.mapTransazioniDAO(transazioni);
				
				transazioneRepository.saveAll(listToPersist);
			}
		}catch(Exception e) {
			logger.error("Errore durante il salvataggio delle transazioni",e);
		}
		logger.info("END - persistTransazioni");
	}

	

}
