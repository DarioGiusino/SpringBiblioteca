package com.biblioteca.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entity.Prenotazione;
import com.biblioteca.serv.PrenotazioneServ;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneServ prenotazioneService;

	@GetMapping
	public Collection<Prenotazione> PrenotazioneList() {
		return prenotazioneService.getAllPrenotazione();
	}

	@GetMapping("/{id}")
	public Prenotazione getPrenotazioneByID(@PathVariable Long id) {
		return prenotazioneService.getPrenotazioneById(id);
	}
	
	@PostMapping
	public Prenotazione addNewPrenotazione(@RequestBody Prenotazione prenotazione) {
		return prenotazioneService.addPrenotazione(prenotazione);

	}

	@PostMapping("/membro/{id}")
	public String addNewPrenotazione(@RequestBody Prenotazione prenotazione, @PathVariable Long id) {
		
		String s = prenotazioneService.addPrenotazione(prenotazione, id) ? "Prenotazione aggiunta con successo" : "Qualcosa è andato storto";
		return s;

	}

	@PutMapping("/{id}")
	public Prenotazione updatePrenotazione(@PathVariable Long id, @RequestBody Prenotazione prenotazione) {
		return prenotazioneService.updatePrenotazione(id, prenotazione);
	}

	@DeleteMapping("/{id}")
	public void deletePrenotazione(@PathVariable Long id) {
		prenotazioneService.deletePrenotazione(id);
	}
}
