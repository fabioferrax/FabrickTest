package it.fabrick.rest.DTO.bonifico;

public class AmountDTO {

	private Float debtorAmount; 
	private Float creditorAmount; 
	private int exchangeRate; 
	private String debtorCurrency; 
	private String creditorCurrency; 
	private String creditorCurrencyDate;
	public Float getDebtorAmount() {
		return debtorAmount;
	}
	public void setDebtorAmount(Float debtorAmount) {
		this.debtorAmount = debtorAmount;
	}
	public Float getCreditorAmount() {
		return creditorAmount;
	}
	public void setCreditorAmount(Float creditorAmount) {
		this.creditorAmount = creditorAmount;
	}
	public int getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(int exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getDebtorCurrency() {
		return debtorCurrency;
	}
	public void setDebtorCurrency(String debtorCurrency) {
		this.debtorCurrency = debtorCurrency;
	}
	public String getCreditorCurrency() {
		return creditorCurrency;
	}
	public void setCreditorCurrency(String creditorCurrency) {
		this.creditorCurrency = creditorCurrency;
	}
	public String getCreditorCurrencyDate() {
		return creditorCurrencyDate;
	}
	public void setCreditorCurrencyDate(String creditorCurrencyDate) {
		this.creditorCurrencyDate = creditorCurrencyDate;
	}
	@Override
	public String toString() {
		return "AmountDTO [debtorAmount=" + debtorAmount + ", creditorAmount=" + creditorAmount + ", exchangeRate="
				+ exchangeRate + ", debtorCurrency=" + debtorCurrency + ", creditorCurrency=" + creditorCurrency
				+ ", creditorCurrencyDate=" + creditorCurrencyDate + "]";
	} 
	
	
}
