package it.fabrick.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transazioni", schema="gbs_schema")
public class Transazione {

	@Id
	@Column(name="transaction_id")
	private String transactionId;
	@Column(name="operation_id")
	private String operationId;
	@Column(name="accounting_date")
	private String accountingDate;
	@Column(name="value_date")
	private String valueDate;
	@Column(name="type_enum")
	private String type_enum;
	@Column(name="type_value")
	private String type_value;
	@Column(name="amount")
	private Float amount;
	@Column(name="currency")
	private String currency;
	@Column(name="description")
	private String description;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getOperationId() {
		return operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public String getAccountingDate() {
		return accountingDate;
	}
	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public String getType_enum() {
		return type_enum;
	}
	public void setType_enum(String type_enum) {
		this.type_enum = type_enum;
	}
	public String getType_value() {
		return type_value;
	}
	public void setType_value(String type_value) {
		this.type_value = type_value;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
