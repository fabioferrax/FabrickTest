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

	public static List<it.fabrick.dao.entity.Transazione> mapTransazioniDAO(List<Transazione> transazioni) {
		List<it.fabrick.dao.entity.Transazione> list = new ArrayList<it.fabrick.dao.entity.Transazione>();
		if(transazioni != null) {
			it.fabrick.dao.entity.Transazione tDB = null;
			for(Transazione t: transazioni) {
				tDB = new it.fabrick.dao.entity.Transazione();
				tDB.setTransactionId(t.getTransactionId());
				tDB.setOperationId(t.getOperationId());
				tDB.setAccountingDate(t.getAccountingDate());
				tDB.setAmount(t.getAmount());
				tDB.setCurrency(t.getCurrency());
				tDB.setDescription(t.getDescription());
				tDB.setValueDate(t.getValueDate());
				tDB.setType_enum(t.getType().getEnumeration());
				tDB.setType_value(t.getType().getValue());
				list.add(tDB);
			}
		}
		
		return list;
	}
}
