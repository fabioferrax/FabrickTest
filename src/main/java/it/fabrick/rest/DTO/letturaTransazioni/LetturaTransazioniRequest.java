package it.fabrick.rest.DTO.letturaTransazioni;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import it.fabrick.rest.DTO.BaseAccountRequest;

@Valid
public class LetturaTransazioniRequest extends BaseAccountRequest{

	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-d")
	private String from;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String to;
	
	
	
	public LetturaTransazioniRequest(Long accountId, String from, String to) {
		super(accountId);
		this.from = from;
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "LetturaTransazioniRequest [from=" + from + ", to=" + to + "]";
	}
	
	
	
}
