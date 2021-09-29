package it.fabrick.services.integration.DTO.bonifico;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MoneyTransfersRequestDTO {

	private CreditorDTO creditor;
	private String uri;
	private String executionDate;
	private String description;
	private String currency;
	private Float amount;
	private boolean isUrgent;
	private boolean isInstant;
	private String feeType;
	private String feeAccountId;
	private TaxReliefDTO taxRelief;
	
	public CreditorDTO getCreditor() {
		return creditor;
	}
	public void setCreditor(CreditorDTO creditor) {
		this.creditor = creditor;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public boolean isUrgent() {
		return isUrgent;
	}
	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}
	public boolean isInstant() {
		return isInstant;
	}
	public void setInstant(boolean isInstant) {
		this.isInstant = isInstant;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeAccountId() {
		return feeAccountId;
	}
	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}
	public TaxReliefDTO getTaxRelief() {
		return taxRelief;
	}
	public void setTaxRelief(TaxReliefDTO taxRelief) {
		this.taxRelief = taxRelief;
	}
	@Override
	public String toString() {
		return "MoneyTransfersRequest [creditor=" + creditor + ", uri=" + uri + ", executionDate=" + executionDate
				+ ", description=" + description + ", currency=" + currency + ", amount=" + amount + ", isUrgent="
				+ isUrgent + ", isInstant=" + isInstant + ", feeType=" + feeType + ", feeAccountId=" + feeAccountId
				+ ", taxRelief=" + taxRelief + "]";
	}
	
	
}
