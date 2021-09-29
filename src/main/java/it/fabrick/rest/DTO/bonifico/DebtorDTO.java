package it.fabrick.rest.DTO.bonifico;

public class DebtorDTO {

	private String name;
	private AccountDTO account;
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
	@Override
	public String toString() {
		return "DebtorDTO [name=" + name + ", account=" + account + "]";
	}
	
	
}
