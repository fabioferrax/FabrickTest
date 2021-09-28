package it.fabrick.rest.DTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class BaseAccountRequest {

	@NotNull
	private Long accountId;
	

	public BaseAccountRequest() {
		super();
	}
	

	public BaseAccountRequest(@NotNull Long accountId) {
		super();
		this.accountId = accountId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "BaseAccountRequest [accountId=" + accountId + "]";
	}
	
	
}
