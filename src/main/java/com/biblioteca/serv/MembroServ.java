package com.biblioteca.serv;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.entity.Membro;
import com.biblioteca.entity.Prenotazione;
import com.biblioteca.repo.MembroRepo;

@Service
public class MembroServ {

	@Autowired
	private MembroRepo membroRepo;

	public Membro addMembro(Membro membro) {
		return membroRepo.addMembro(membro);
	}

	public Collection<Membro> getAllMembro() {
		return membroRepo.getAllMembro();
	}

	public Membro getMembroById(Long id) {
		return membroRepo.getMembroById(id);
	}

	public Membro updateMembro(Long id, Membro membro) {
		return membroRepo.updateMembro(id, membro);
	}

	public void deleteMembro(Long id) {
		membroRepo.deleteMembro(id);
	}
	
	public List<Prenotazione> getAllMembroPrenotazione(Long id){
		return membroRepo.getMembroById(id).getPrenotazioni();
	}
}
