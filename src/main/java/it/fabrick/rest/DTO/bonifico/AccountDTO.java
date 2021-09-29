package it.fabrick.rest.DTO.bonifico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Validated
public class AccountDTO {


	@NotNull
	@NotBlank
	private String accountCode;

	@NotNull
	@NotBlank
	private String bicCode;
	

	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getBicCode() {
		return bicCode;
	}
	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}
	
}
