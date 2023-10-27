package com.biblioteca.serv;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.entity.Libro;
import com.biblioteca.repo.LibroRepo;

@Service
public class LibroServ {

	@Autowired
	private LibroRepo libroRepo;

	public Libro addLibro(Libro libro) {
		return libroRepo.addLibro(libro);
	}

	public Collection<Libro> getAllLibro() {
		return libroRepo.getAllLibro();
	}

	public Libro getLibroById(Long id) {
		return libroRepo.getLibroById(id);
	}

	public Libro updateLibro(Long id, Libro libro) {
		return libroRepo.updateLibro(id, libro);
	}

	public void deleteLibro(Long id) {
		libroRepo.deleteLibro(id);
	}
	
	public void decrementaQuantitaDisponibile(Long libroId) {
        Libro libro = libroRepo.getLibroById(libroId);
        if (libro != null && libro.getQuantitaDisponibile() > 0) {
            libro.setQuantitaDisponibile(libro.getQuantitaDisponibile() - 1);
        }
    }

    public void incrementaQuantitaDisponibile(Long libroId) {
        Libro libro = libroRepo.getLibroById(libroId);
        if (libro != null) {
            libro.setQuantitaDisponibile(libro.getQuantitaDisponibile() + 1);
        }
    }
    
    public Collection<Libro> cercaLibriPerGenereOAutore(String genere, String autore) {
        Collection<Libro> tuttiLibri = libroRepo.getAllLibro();

        if (genere != null && autore != null) {
            return tuttiLibri.stream()
                .filter(libro -> libro.getGenere().equalsIgnoreCase(genere) && libro.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
            
        } else if (genere != null) {
            return tuttiLibri.stream()
                .filter(libro -> libro.getGenere().equalsIgnoreCase(genere))
                .collect(Collectors.toList());
            
        } else if (autore != null) {
            return tuttiLibri.stream()
                .filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
            
        } else {
            return tuttiLibri;
        }
    }
}
