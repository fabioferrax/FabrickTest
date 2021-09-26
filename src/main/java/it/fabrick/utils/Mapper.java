package it.fabrick.utils;

import java.util.ArrayList;
import java.util.List;

import it.fabrick.rest.DTO.letturaTransazioni.Transazione;
import it.fabrick.services.integration.DTO.letturaTransazioni.TransazioneDTO;

public class Mapper {

	
	public static List<Transazione> mapTransazioni(List<TransazioneDTO> listWs){
		List<Transazione> list = new ArrayList<Transazione>();
		if(listWs != null) {
			for(TransazioneDTO transWs : listWs) {
				list.add(new Transazione(transWs));
			}
		}
		return list;
	}
}
