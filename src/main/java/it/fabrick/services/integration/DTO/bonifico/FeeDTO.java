package it.fabrick.services.integration.DTO.bonifico;

public class FeeDTO {

	private String feeCode;
	private String description;
	private String currency;
	private Float amount;
	public String getFeeCode() {
		return feeCode;
	}
	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
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
	@Override
	public String toString() {
		return "FeeDTO [feeCode=" + feeCode + ", description=" + description + ", currency=" + currency + ", amount="
				+ amount + "]";
	}
	
	
}
