package it.fabrick.rest.DTO.letturaTransazioni;


import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import it.fabrick.rest.DTO.BaseAccountRequest;

@Valid
public class LetturaTransazioniRequest extends BaseAccountRequest{

	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-d")
	private Date from;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date to;
	
	
	
	public LetturaTransazioniRequest(Long accountId, Date from, Date to) {
		super(accountId);
		this.from = from;
		this.to = to;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "LetturaTransazioniRequest [from=" + from + ", to=" + to + "]";
	}
	
	
	
}
