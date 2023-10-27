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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entity.Libro;
import com.biblioteca.serv.LibroServ;

@RestController
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private LibroServ libroService;
	
	@GetMapping
	public Collection<Libro> LibroList(){
		return libroService.getAllLibro();
	}
	
	@GetMapping("/{id}")
	public Libro getLibroByID(@PathVariable Long id) {
		return libroService.getLibroById(id);
	}
	
	@PostMapping
	public Libro addNewLibro(@RequestBody Libro libro) {		
		return libroService.addLibro(libro);
	}
	
	@PutMapping("/{id}")
	public Libro updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
		return libroService.updateLibro(id, libro);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLibro(@PathVariable Long id) {
		libroService.deleteLibro(id);
	}
	
	@GetMapping("/cerca")
	public Collection<Libro> cercaLibri(@RequestParam String genere, @RequestParam String autore) {
		return libroService.cercaLibriPerGenereOAutore(genere, autore);
		
	}
}



