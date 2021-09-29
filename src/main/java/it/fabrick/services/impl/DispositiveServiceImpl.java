package it.fabrick.services.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import it.fabrick.exception.FabrickException;
import it.fabrick.rest.DTO.bonifico.AmountDTO;
import it.fabrick.rest.DTO.bonifico.BonificoRequest;
import it.fabrick.rest.DTO.bonifico.BonificoResponse;
import it.fabrick.rest.DTO.bonifico.FeeDTO;
import it.fabrick.services.DispositiveService;
import it.fabrick.services.integration.ServiceIntegrationUtils;
import it.fabrick.services.integration.DTO.bonifico.AccountDTO;
import it.fabrick.services.integration.DTO.bonifico.CreditorDTO;
import it.fabrick.services.integration.DTO.bonifico.LegalPersonBeneficiaryDTO;
import it.fabrick.services.integration.DTO.bonifico.MoneyTransfersIntegrationResponse;
import it.fabrick.services.integration.DTO.bonifico.MoneyTransfersRequestDTO;
import it.fabrick.services.integration.DTO.bonifico.MoneyTransfersResponseDTO;
import it.fabrick.services.integration.DTO.bonifico.NaturalPersonBeneficiary;
import it.fabrick.services.integration.DTO.bonifico.TaxReliefDTO;
import it.fabrick.utils.Constants;
import it.fabrick.utils.Utils;

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
		ResponseEntity<MoneyTransfersIntegrationResponse> responseWS = null;
		try {
			
			HttpHeaders headers = serviceIntegrationUtils.createFabrickHeaders();
			MoneyTransfersRequestDTO requestWS = generateMoneyTransfersRequest(request);
			
	        HttpEntity<MoneyTransfersRequestDTO> entity = new HttpEntity<MoneyTransfersRequestDTO>(requestWS, headers);
			
			String uriEseguiBonifico = serviceIntegrationUtils.createMoneyTransferRequestUri(request);
			
			/*responseWS = defaultRestTemplate.exchange(uriEseguiBonifico,
                    HttpMethod.POST,
                    entity, MoneyTransfersIntegrationResponse.class);*/
			responseWS = defaultRestTemplate.postForEntity(uriEseguiBonifico, entity, MoneyTransfersIntegrationResponse.class); 
			
			if(serviceIntegrationUtils.isValidResponse(responseWS)) {
				MoneyTransfersIntegrationResponse reponseBody = responseWS.getBody();
				if(reponseBody.getPayload() != null) {
					result = generateMoneyTransfersResponse(reponseBody.getPayload());
				}else {
					throw new FabrickException(Constants.INTEGRATION_EXCEPTION, "Payload assente");
				}
			}else {
				throw new FabrickException(Constants.INTEGRATION_EXCEPTION, "Ricevuto response non valida");
			}

			
		}catch(FabrickException e) {
			logger.error("Errore durante la lettura delle transazioni",e);
			throw e;
		}catch(ResourceAccessException e) {
			logger.error("Errore durante l'esecuzione del bonifico",e);
			throw new FabrickException("API000", "Errore tecnico La condizione BP049 non e' prevista per il conto id "+request.getAccountId());
		}catch(Exception e) {
			logger.error("Errore durante l'esecuzione del bonifico",e);
			throw new FabrickException(Constants.INTEGRATION_EXCEPTION);
		}
		logger.info("END - eseguiBonifico produces [{}]",result);
		return result;
	}

	private MoneyTransfersRequestDTO generateMoneyTransfersRequest(BonificoRequest request) {
		MoneyTransfersRequestDTO requestWS = new MoneyTransfersRequestDTO();
		
		CreditorDTO creditorWS = new CreditorDTO();
		creditorWS.setName(request.getCreditor().getName());
		creditorWS.setAccount(new AccountDTO());
		creditorWS.getAccount().setAccountCode(request.getCreditor().getAccount().getAccountCode());
		creditorWS.getAccount().setBicCode(request.getCreditor().getAccount().getBicCode());
		
		requestWS.setCreditor(creditorWS);

		requestWS.setExecutionDate(Utils.formatDate(Constants.DATE_FORMAT_yyyy_MM_dd, request.getExecutionDate()));
		requestWS.setUri(request.getUri());
		requestWS.setDescription(request.getDescription());
		requestWS.setAmount(request.getAmount());
		requestWS.setCurrency(request.getCurrency());
		requestWS.setUrgent(request.isUrgent());
		requestWS.setInstant(request.isInstant());
		requestWS.setFeeType(request.getFeeType());
		requestWS.setFeeAccountId(request.getFeeAccountId());
		
		if(request.getTaxRelief() != null) {
			TaxReliefDTO taxRelief = new TaxReliefDTO();
			taxRelief.setTaxReliefId(request.getTaxRelief().getTaxReliefId());
			taxRelief.setCondoUpgrade(request.getTaxRelief().isCondoUpgrade());
			taxRelief.setCreditorFiscalCode(request.getTaxRelief().getCreditorFiscalCode());
			taxRelief.setBeneficiaryType(request.getTaxRelief().getBeneficiaryType());
			if(request.getTaxRelief().getNaturalPersonBeneficiary() != null) {
				NaturalPersonBeneficiary naturalPersonBeneficiary = new NaturalPersonBeneficiary();
				naturalPersonBeneficiary.setFiscalCode1(request.getTaxRelief().getNaturalPersonBeneficiary().getFiscalCode1());
				naturalPersonBeneficiary.setFiscalCode2(request.getTaxRelief().getNaturalPersonBeneficiary().getFiscalCode2());
				naturalPersonBeneficiary.setFiscalCode3(request.getTaxRelief().getNaturalPersonBeneficiary().getFiscalCode3());
				naturalPersonBeneficiary.setFiscalCode4(request.getTaxRelief().getNaturalPersonBeneficiary().getFiscalCode4());
				naturalPersonBeneficiary.setFiscalCode5(request.getTaxRelief().getNaturalPersonBeneficiary().getFiscalCode5());
				taxRelief.setNaturalPersonBeneficiary(naturalPersonBeneficiary);
			}
			if(request.getTaxRelief().getLegalPersonBeneficiary() != null) {
				LegalPersonBeneficiaryDTO legalPersonBeneficiary = new LegalPersonBeneficiaryDTO();
				legalPersonBeneficiary.setFiscalCode(request.getTaxRelief().getLegalPersonBeneficiary().getFiscalCode());
				legalPersonBeneficiary.setLegalRepresentativeFiscalCode(request.getTaxRelief().getLegalPersonBeneficiary().getLegalRepresentativeFiscalCode());
				taxRelief.setLegalPersonBeneficiary(legalPersonBeneficiary);
			}
			requestWS.setTaxRelief(taxRelief);
		}
		
		return requestWS;
	}

	private BonificoResponse generateMoneyTransfersResponse(MoneyTransfersResponseDTO responseWS) {
		BonificoResponse response = new BonificoResponse();
		
		response.setMoneyTransferId(responseWS.getMoneyTransferId());
		response.setStatus(responseWS.getStatus());
		response.setDescription(responseWS.getDescription());
		response.setCreatedDatetime(responseWS.getCreatedDatetime());
		response.setAccountedDatetime(responseWS.getAccountedDatetime());
		AmountDTO amount = new AmountDTO();
		amount.setDebtorAmount(responseWS.getAmount().getDebtorAmount());
		amount.setDebtorCurrency(responseWS.getAmount().getDebtorCurrency());
		amount.setCreditorAmount(responseWS.getAmount().getCreditorAmount());
		amount.setCreditorCurrency(responseWS.getAmount().getCreditorCurrency());
		amount.setCreditorCurrencyDate(responseWS.getAmount().getCreditorCurrencyDate());
		amount.setExchangeRate(responseWS.getAmount().getExchangeRate());
		response.setAmount(amount);

		response.setFeeAccountId(responseWS.getFeeAccountId());
		response.setFeeType(responseWS.getFeeType());
		
		if(responseWS.getFees() != null) {
			response.setFees(new ArrayList<FeeDTO>());
			for(it.fabrick.services.integration.DTO.bonifico.FeeDTO fee: responseWS.getFees()) {
				response.getFees().add(new FeeDTO(fee.getFeeCode(), fee.getDescription(), fee.getAmount(), fee.getCurrency()));
			}
		}
		return response;
	}



}
