package com.biblioteca.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.biblioteca.entity.Prenotazione;

@Repository
public class PrenotazioneRepo {

	private final Map<Long, Prenotazione> prenotazioneListMap = new HashMap<>();
	private Long currentId = 1L;

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		prenotazione.setId(currentId++);		
		prenotazioneListMap.put(prenotazione.getId(), prenotazione);
		return prenotazione;
	}

	public Collection<Prenotazione> getAllPrenotazione() {
		return prenotazioneListMap.values();
	}

	public Prenotazione getPrenotazioneById(Long id) {
		return prenotazioneListMap.get(id);
	}

	public Prenotazione updatePrenotazione(Long id, Prenotazione prenotazione) {
		if (prenotazioneListMap.containsKey(id)) {
			prenotazione.setId(id);
			prenotazioneListMap.put(id, prenotazione);
			return prenotazione;
		}
		return null;
	}

	public void deletePrenotazione(Long id) {
		prenotazioneListMap.remove(id);
	}

}
