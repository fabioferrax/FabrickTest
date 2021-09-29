package it.fabrick.services.integration.DTO.bonifico;

import java.util.Date;
import java.util.List;

public class MoneyTransfersResponseDTO {

	private String moneyTransferId;
	private String status;
	private String direction;
	private CreditorDTO creditor;
	private DebtorDTO debtor;
	private String cro;
	private String uri;
	private String trn;
	private String description;
	private Date createdDatetime;
	private Date accountedDatetime;
	private String debtorValueDate;
	private String creditorValueDate;
	private AmountDTO amount;
	private boolean isUrgent;
	private boolean isInstant;
	private boolean hasTaxRelief;
	private String feeType;
	private String feeAccountId;
	private List<FeeDTO> fees;
	
	public String getMoneyTransferId() {
		return moneyTransferId;
	}
	public void setMoneyTransferId(String moneyTransferId) {
		this.moneyTransferId = moneyTransferId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public CreditorDTO getCreditor() {
		return creditor;
	}
	public void setCreditor(CreditorDTO creditor) {
		this.creditor = creditor;
	}
	public DebtorDTO getDebtor() {
		return debtor;
	}
	public void setDebtor(DebtorDTO debtor) {
		this.debtor = debtor;
	}
	public String getCro() {
		return cro;
	}
	public void setCro(String cro) {
		this.cro = cro;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getTrn() {
		return trn;
	}
	public void setTrn(String trn) {
		this.trn = trn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public Date getAccountedDatetime() {
		return accountedDatetime;
	}
	public void setAccountedDatetime(Date accountedDatetime) {
		this.accountedDatetime = accountedDatetime;
	}
	public String getDebtorValueDate() {
		return debtorValueDate;
	}
	public void setDebtorValueDate(String debtorValueDate) {
		this.debtorValueDate = debtorValueDate;
	}
	public String getCreditorValueDate() {
		return creditorValueDate;
	}
	public void setCreditorValueDate(String creditorValueDate) {
		this.creditorValueDate = creditorValueDate;
	}
	public AmountDTO getAmount() {
		return amount;
	}
	public void setAmount(AmountDTO amount) {
		this.amount = amount;
	}
	public boolean isUrgent() {
		return isUrgent;
	}
	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}
	public boolean isInstant() {
		return isInstant;
	}
	public void setInstant(boolean isInstant) {
		this.isInstant = isInstant;
	}
	public boolean isHasTaxRelief() {
		return hasTaxRelief;
	}
	public void setHasTaxRelief(boolean hasTaxRelief) {
		this.hasTaxRelief = hasTaxRelief;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeAccountId() {
		return feeAccountId;
	}
	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}
	public List<FeeDTO> getFees() {
		return fees;
	}
	public void setFees(List<FeeDTO> fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "MoneyTransfersResponse [moneyTransferId=" + moneyTransferId + ", status=" + status + ", direction="
				+ direction + ", creditor=" + creditor + ", debtor=" + debtor + ", cro=" + cro + ", uri=" + uri
				+ ", trn=" + trn + ", description=" + description + ", createdDatetime=" + createdDatetime
				+ ", accountedDatetime=" + accountedDatetime + ", debtorValueDate=" + debtorValueDate
				+ ", creditorValueDate=" + creditorValueDate + ", amount=" + amount + ", isUrgent=" + isUrgent
				+ ", isInstant=" + isInstant + ", hasTaxRelief=" + hasTaxRelief + ", feeType=" + feeType
				+ ", feeAccountId=" + feeAccountId + ", fees=" + fees + "]";
	}
	
	
}
