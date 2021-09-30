package it.fabrick.rest.DTO.bonifico;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import it.fabrick.rest.DTO.BaseAccountRequest;

@Validated
public class BonificoRequest extends BaseAccountRequest {

	@NotNull
	@Valid
	private CreditorDTO creditor;
	private String uri;
	@DateTimeFormat(pattern="yyyy-MM-d")
	private Date executionDate = new Date();
	@NotNull
	@NotBlank
	private String description;
	@NotNull
	@NotBlank
	private String currency;
	@NotNull
	private Float amount;
	private boolean isUrgent;
	private boolean isInstant;
	private String feeType;
	private String feeAccountId;
	@Valid
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
	public Date getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(Date executionDate) {
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
