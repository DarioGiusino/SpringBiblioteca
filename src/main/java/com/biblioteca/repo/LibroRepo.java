package com.biblioteca.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.biblioteca.entity.Libro;

@Repository
public class LibroRepo {
	
	private final Map<Long, Libro> libroListMap = new HashMap<>();
	private Long currentId = 1L;
	
	public Libro addLibro(Libro libro) {
		libro.setId(currentId++);
		libroListMap.put(libro.getId(), libro);
		return libro;
	}

	public Collection<Libro> getAllLibro() {
		return libroListMap.values();
	}

	public Libro getLibroById(Long id) {
		return libroListMap.get(id);
	}

	public Libro updateLibro(Long id, Libro libro) {
		if (libroListMap.containsKey(id)) {
			libro.setId(id);
			libroListMap.put(id, libro);
			return libro;
		}
		return null;
	}

	public void deleteLibro(Long id) {
		libroListMap.remove(id);
	}

}

