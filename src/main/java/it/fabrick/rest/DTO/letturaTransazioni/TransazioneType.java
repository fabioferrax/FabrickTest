package it.fabrick.rest.DTO.letturaTransazioni;

import it.fabrick.services.integration.DTO.letturaTransazioni.TransazioneTypeDTO;

public class TransazioneType {

	private String enumeration;
    private String value;

	public TransazioneType() {
	}

	public TransazioneType(TransazioneTypeDTO type) {
		this.enumeration = type.getEnumeration();
		this.value = type.getValue();
	}
	public String getEnumeration() {
		return enumeration;
	}
	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "TransazioneType [enumeration=" + enumeration + ", value=" + value + "]";
	}
    
}
