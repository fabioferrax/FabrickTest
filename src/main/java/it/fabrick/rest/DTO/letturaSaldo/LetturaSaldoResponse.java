package it.fabrick.rest.DTO.letturaSaldo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LetturaSaldoResponse {

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date aggiornatoAl;
	private Float saldoContabile; // balance
	private Float saldo; 			//availableBalance
	private String currency;
	
	
	public Date getAggiornatoAl() {
		return aggiornatoAl;
	}
	public void setAggiornatoAl(Date aggiornatoAl) {
		this.aggiornatoAl = aggiornatoAl;
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
	@Override
	public String toString() {
		return "LetturaSaldoResponse [aggiornatoAl=" + aggiornatoAl + ", saldoContabile=" + saldoContabile + ", saldo="
				+ saldo + ", currency=" + currency + "]";
	}
	
	
	
}
