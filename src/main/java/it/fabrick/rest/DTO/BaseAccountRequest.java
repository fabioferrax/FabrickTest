package it.fabrick.rest.DTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class BaseAccountRequest {

	@NotNull
	private String accountId;
	

	public BaseAccountRequest() {
		super();
	}
	

	public BaseAccountRequest(@NotNull String accountId) {
		super();
		this.accountId = accountId;
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
