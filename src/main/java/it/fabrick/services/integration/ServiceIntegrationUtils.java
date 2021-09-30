package it.fabrick.services.integration;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import it.fabrick.exception.FabrickException;
import it.fabrick.rest.DTO.BaseAccountRequest;
import it.fabrick.rest.DTO.Error;
import it.fabrick.rest.DTO.letturaTransazioni.LetturaTransazioniRequest;
import it.fabrick.services.integration.DTO.FabrickGenericResponse;
import it.fabrick.services.integration.DTO.letturaSaldo.LetturaSaldoIntegrationResponse;
import it.fabrick.utils.Constants;
import it.fabrick.utils.Utils;


@Configuration
public class ServiceIntegrationUtils {

	private static final Logger logger = LoggerFactory.getLogger(ServiceIntegrationUtils.class);


	@Value("${fabrick.api.baseUrl}")
	private String fabrickBaseUrl;

	@Value("${fabrick.api.port}")
	private String fabrickPort;

	@Value("${fabrick.api.letturaSaldo.endpoint}")
	private String letturaSaldoEndpoint;

	@Value("${fabrick.api.letturaTransazioni.endpoint}")
	private String letturaTransazioniEndpoint;

	@Value("${fabrick.api.bonifico.endpoint}")
	private String bonificoEndpoint;

	@Value("${fabrick.api.key}")
	private String apiKey;

	@Value("${fabrick.api.authSchema}")
	private String authSchema;

	public String getFabrickBaseUrl() {
		return fabrickBaseUrl;
	}

	public String getFabrickPort() {
		return fabrickPort;
	}

	public String getLetturaSaldoEndpoint() {
		return letturaSaldoEndpoint;
	}

	public String getLetturaTransazioniEndpoint() {
		return letturaTransazioniEndpoint;
	}

	public String getBonificoEndpoint() {
		return bonificoEndpoint;
	}

	public boolean isValidResponse(ResponseEntity response) {
		return response!= null && response.getBody() != null && Constants.HTTP_STATUS_OK.equalsIgnoreCase(((FabrickGenericResponse)response.getBody()).getStatus());
	}

	public void manageErrorResponse(ResponseEntity response) {
		String code = Constants.INTEGRATION_EXCEPTION;
		String msg = "Ricevuta response non valida";
		List<Error> errors = new ArrayList<Error>();
		if(response!= null && response.getBody() != null && Constants.HTTP_STATUS_KO.equalsIgnoreCase(((FabrickGenericResponse)response.getBody()).getStatus())) {
			logger.debug("response [{}]",response);
			List<it.fabrick.services.integration.DTO.Error> errorsWS = ((FabrickGenericResponse)response.getBody()).getErrors();
			logger.debug("errorsWS [{}]",errorsWS);
			if(errorsWS != null) {
				for(it.fabrick.services.integration.DTO.Error e: errorsWS) {
					errors.add(new Error(e.getCode(), e.getMessage() != null ? e.getMessage() : e.getDescription()));
				}
			}
		}
		throw new FabrickException(code, msg, errors);
	}

	public HttpHeaders createFabrickHeaders() {
		logger.info("START - createFabrickHeaders");
		HttpHeaders headers = new HttpHeaders();

		headers.add	(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		headers.add("Accept", "application/json");
		if(authSchema != null) {
			headers.add("Auth-Schema", authSchema);
		}
		if(apiKey != null) {
			headers.add("Api-Key", apiKey);
		}
		logger.info("END - createFabrickHeaders produces [{}]",headers);
		return headers;
	}

	private String createBaseUri() {
		String baseUri =  fabrickBaseUrl +( fabrickPort != null && !fabrickPort.isEmpty() ? ":"+fabrickPort : "");
		return baseUri;
	}

	public String createLetturaSaldoRequestUri(BaseAccountRequest baseRequest) {
		logger.info("START - createLetturaSaldoRequestUri accountId[{}]",baseRequest.getAccountId());
		String uri =  createBaseUri() + letturaSaldoEndpoint;
		uri = uri.replace(Constants.ACCOUNT_ID_INTEGRATION_PARAMS_KEY, String.valueOf(baseRequest.getAccountId()));
		logger.info("END - createLetturaSaldoRequestUri produces[{}]",uri);
		return uri;
	}

	public String createLetturaTransazioniUri(LetturaTransazioniRequest request) {
		logger.info("START - createLetturaTransazioniUri request[{}]",request);
		String uri =  createBaseUri() + letturaTransazioniEndpoint;
		uri = uri.replace(Constants.ACCOUNT_ID_INTEGRATION_PARAMS_KEY, String.valueOf(request.getAccountId()));
		if(request.getFrom() != null) {
			uri = uri.replace(Constants.FROM_DATE_INTEGRATION_PARAMS_KEY, request.getFrom());
		}
		if(request.getTo() != null) {
			uri = uri.replace(Constants.TO_DATE_INTEGRATION_PARAMS_KEY, request.getTo());
		}
		logger.info("END - createLetturaSaldoTransazioniUri produces[{}]",uri);
		return uri;
	}

	public String createMoneyTransferRequestUri(BaseAccountRequest baseRequest) {
		logger.info("START - createMoneyTransferRequestUri accountId[{}]",baseRequest.getAccountId());
		String uri =  createBaseUri() + bonificoEndpoint;
		uri = uri.replace(Constants.ACCOUNT_ID_INTEGRATION_PARAMS_KEY, String.valueOf(baseRequest.getAccountId()));
		logger.info("END - createMoneyTransferRequestUri produces[{}]",uri);
		return uri;
	}

}
