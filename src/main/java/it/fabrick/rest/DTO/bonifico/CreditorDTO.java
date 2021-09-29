package it.fabrick.rest.DTO.bonifico;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Valid
public class CreditorDTO {

	@NotNull
	@NotBlank
	private String name;

	@NotNull
	@Valid
	private AccountDTO account;
	private AddressDTO address;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AccountDTO getAccount() {
		return account;
	}
	public void setAccount(AccountDTO account) {
		this.account = account;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CreditorDTO [name=" + name + ", account=" + account + ", address=" + address + "]";
	}
	
	
}
