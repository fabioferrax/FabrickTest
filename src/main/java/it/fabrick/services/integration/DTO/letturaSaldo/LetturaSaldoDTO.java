package it.fabrick.services.integration.DTO.letturaSaldo;

import java.util.Date;

public class LetturaSaldoDTO{
	private Date date;
	private Float balance;
	private Float availableBalance;
	private String currency;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public Float getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Float availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "LetturaSaldoIntegrationResponse [date=" + date + ", balance=" + balance + ", availableBalance="
				+ availableBalance + ", currency=" + currency + "]";
	}
}