package it.fabrick.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.fabrick.dao.entity.Transazione;

@Repository
public interface TransazioneRepository extends JpaRepository<Transazione, String>{

	
}
