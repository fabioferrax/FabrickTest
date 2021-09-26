package it.fabrick.rest.DTO.letturaTransazioni;

import it.fabrick.services.integration.DTO.letturaTransazioni.TransazioneDTO;

public class Transazione {

	private String transactionId;
	private String operationId;
	private String accountingDate;
	private String valueDate;
	private TransazioneType type;
	private Float amount;
	private String currency;
	private String description;
	
	public Transazione() {
		super();
	}

	public Transazione(TransazioneDTO transazioneWS) {
		super();
		this.transactionId = transazioneWS.getTransactionId();
		this.operationId = transazioneWS.getOperationId();
		this.accountingDate = transazioneWS.getAccountingDate();
		this.valueDate = transazioneWS.getValueDate();
		this.currency = transazioneWS.getCurrency();
		this.description = transazioneWS.getDescription();
		this.amount = transazioneWS.getAmount();
		
		this.type = new TransazioneType(transazioneWS.getType());
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getOperationId() {
		return operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public String getAccountingDate() {
		return accountingDate;
	}
	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public TransazioneType getType() {
		return type;
	}
	public void setType(TransazioneType type) {
		this.type = type;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Transazione [transactionId=" + transactionId + ", operationId=" + operationId + ", accountingDate="
				+ accountingDate + ", valueDate=" + valueDate + ", type=" + type + ", amount=" + amount + ", currency="
				+ currency + ", description=" + description + "]";
	}
}
