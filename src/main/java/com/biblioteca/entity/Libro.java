package com.biblioteca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//@Entity
public class Libro {

//	@Id
//	@GeneratedValue
	private Long id;

	private String titolo;
	private String autore;
	private String genere;
	private Integer annoPubblicazione;
	private Integer quantitaDisponibile;

	public Libro() {
	}

	public Libro(Long id, String titolo, String autore, String genere, Integer annoPubblicazione,
			Integer quantitaDisponibile) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.annoPubblicazione = annoPubblicazione;
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public Integer getQuantitaDisponibile() {
		return quantitaDisponibile;
	}

	public void setQuantitaDisponibile(Integer quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	};

}
