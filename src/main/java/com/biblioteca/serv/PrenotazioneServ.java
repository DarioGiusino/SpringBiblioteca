package com.biblioteca.serv;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.entity.Libro;
import com.biblioteca.entity.Membro;
import com.biblioteca.entity.Prenotazione;
import com.biblioteca.repo.PrenotazioneRepo;

@Service
public class PrenotazioneServ {

	@Autowired
	private PrenotazioneRepo prenotazioneRepo;

	@Autowired
	private LibroServ libroServ;
	
	@Autowired
	private MembroServ membroServ;
	
	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		return prenotazioneRepo.addPrenotazione(prenotazione);
	}
	
	public boolean addPrenotazione(Prenotazione prenotazione, Long id) {
		Libro libro = prenotazione.getLibro();
		Membro membro = membroServ.getMembroById(id);
		
		if(libro.getQuantitaDisponibile() > 0 && libro != null && membro.getPrenotazioni().size() < 3 && membro != null) {
			prenotazione.setDataInizio(LocalDate.now());
			prenotazione.setDataFine(prenotazione.getDataInizio().plusDays(3));
			
			libroServ.decrementaQuantitaDisponibile(libro.getId());
			membro.getPrenotazioni().add(prenotazione);
			
//			prenotazioneRepo.addPrenotazione(prenotazione);
			
			return true;
		}
		
		return false;
	}

	public Collection<Prenotazione> getAllPrenotazione() {
		return prenotazioneRepo.getAllPrenotazione();
	}

	public Prenotazione getPrenotazioneById(Long id) {
		return prenotazioneRepo.getPrenotazioneById(id);
	}

	public Prenotazione updatePrenotazione(Long id, Prenotazione prenotazione) {
		return prenotazioneRepo.updatePrenotazione(id, prenotazione);
	}

	public void deletePrenotazione(Long id) {
		prenotazioneRepo.deletePrenotazione(id);
	}
}
