package fr.treeptik.model;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;

@Entity
public class CD extends Article implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
//	@Length(min=2, max=10)
	private String auteur;

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "CD [Id=" + getId() + ", auteur=" + auteur + ", Prix="
				+ getPrix() + ", Titre=" + getTitre() + "]";
	}

	

}
