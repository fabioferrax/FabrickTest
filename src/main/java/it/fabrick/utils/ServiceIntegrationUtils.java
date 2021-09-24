package it.fabrick.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import it.fabrick.services.integration.DTO.FabrickGenericResponse;
import it.fabrick.services.integration.DTO.LetturaSaldoIntegrationResponse;


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

	public String createLetturaSaldoRequestUri(String accountId) {
		logger.info("START - createLetturaSaldoRequestUri accountId[{}]",accountId);
		String uri =  createBaseUri() + letturaSaldoEndpoint;
		uri = uri.replace(Constants.ACCOUNT_ID_INTEGRATION_PARAMS_KEY, accountId);
		logger.info("END - createLetturaSaldoRequestUri produces[{}]",uri);
		return uri;
	}

}
