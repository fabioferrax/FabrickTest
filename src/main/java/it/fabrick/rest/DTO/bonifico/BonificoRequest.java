package it.fabrick.rest.DTO.bonifico;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import it.fabrick.rest.DTO.BaseAccountRequest;

public class BonificoRequest extends BaseAccountRequest{

	@NotNull
	private String receiverName;
	@NotNull
	private String description;
	@NotNull
	private String currency;
	@NotNull
	private String amount;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date executionDate;
	
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	@Override
	public String toString() {
		return "BonificoRequest [receiverName=" + receiverName + ", description=" + description + ", currency="
				+ currency + ", amount=" + amount + ", executionDate=" + executionDate + "]";
	}
	
	
	
}
