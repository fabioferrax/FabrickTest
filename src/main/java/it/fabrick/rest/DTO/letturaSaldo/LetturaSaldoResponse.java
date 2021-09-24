package it.fabrick.rest.DTO.letturaSaldo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LetturaSaldoResponse {

	@DateTimeFormat(pattern =  "dd/MM/yyyy" )
	private Date aggiornatoA;
	private Float saldoContabile; // balance
	private Float saldo; 			//availableBalance
	private String currency;
	
	
	public Date getAggiornatoA() {
		return aggiornatoA;
	}
	public void setAggiornatoA(Date aggiornatoA) {
		this.aggiornatoA = aggiornatoA;
	}
	public Float getSaldoContabile() {
		return saldoContabile;
	}
	public void setSaldoContabile(Float saldoContabile) {
		this.saldoContabile = saldoContabile;
	}
	public Float getSaldo() {
		return saldo;
	}
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
