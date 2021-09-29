package it.fabrick.rest.DTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Validated
public class BaseAccountRequest {

	@NotNull
	@NotBlank
	private String accountId;
	

	public BaseAccountRequest() {
		super();
	}
	

	public BaseAccountRequest(@NotNull String accountId) {
		super();
		this.accountId = accountId;
	}

	public BaseAccountRequest(@NotNull Long accountId) {
		super();
		this.accountId = String.valueOf(accountId);
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "BaseAccountRequest [accountId=" + accountId + "]";
	}
	
	
}
