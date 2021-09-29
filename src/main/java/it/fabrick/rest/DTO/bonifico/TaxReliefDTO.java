package it.fabrick.rest.DTO.bonifico;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Validated
public class TaxReliefDTO {

	@NotNull
	@NotBlank
	private String taxReliefId;
	@NotNull
	private boolean isCondoUpgrade;
	@NotNull
	@NotBlank
	private String creditorFiscalCode;
	@NotNull
	@NotBlank
	private String beneficiaryType;
	
	@Valid
	private NaturalPersonBeneficiary naturalPersonBeneficiary;
	
	@Valid
	private LegalPersonBeneficiary legalPersonBeneficiary;
	
	public String getTaxReliefId() {
		return taxReliefId;
	}
	public void setTaxReliefId(String taxReliefId) {
		this.taxReliefId = taxReliefId;
	}
	public boolean isCondoUpgrade() {
		return isCondoUpgrade;
	}
	public void setCondoUpgrade(boolean isCondoUpgrade) {
		this.isCondoUpgrade = isCondoUpgrade;
	}
	public String getCreditorFiscalCode() {
		return creditorFiscalCode;
	}
	public void setCreditorFiscalCode(String creditorFiscalCode) {
		this.creditorFiscalCode = creditorFiscalCode;
	}
	public String getBeneficiaryType() {
		return beneficiaryType;
	}
	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}
	public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
		return naturalPersonBeneficiary;
	}
	public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
		this.naturalPersonBeneficiary = naturalPersonBeneficiary;
	}
	public LegalPersonBeneficiary getLegalPersonBeneficiary() {
		return legalPersonBeneficiary;
	}
	public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
		this.legalPersonBeneficiary = legalPersonBeneficiary;
	}
	@Override
	public String toString() {
		return "TaxReliefDTO [taxReliefId=" + taxReliefId + ", isCondoUpgrade=" + isCondoUpgrade
				+ ", creditorFiscalCode=" + creditorFiscalCode + ", beneficiaryType=" + beneficiaryType
				+ ", naturalPersonBeneficiary=" + naturalPersonBeneficiary + ", legalPersonBeneficiary="
				+ legalPersonBeneficiary + "]";
	}
	
	
}
