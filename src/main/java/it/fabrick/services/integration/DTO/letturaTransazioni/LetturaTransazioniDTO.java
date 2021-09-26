package it.fabrick.services.integration.DTO.letturaTransazioni;

import java.util.List;

public class LetturaTransazioniDTO{
	
	private List<TransazioneDTO> list;

	public List<TransazioneDTO> getList() {
		return list;
	}

	public void setList(List<TransazioneDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "LetturaTransazioniDTO [list=" + list + "]";
	}
	
	
}