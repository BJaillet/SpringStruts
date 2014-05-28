package fr.treeptik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

//	@NotNull(message = "Pas de prix")
	private Integer prix;

	private String titre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", prix=" + prix + ", titre=" + titre
				+ "]";
	}
	
	public boolean equals(Object article) {
		if (! (article instanceof Article)) return false;
		Article articleTest = (Article) article;
		if (this.id == articleTest.getId() && this.prix == articleTest.getPrix() && this.titre.equalsIgnoreCase(articleTest.getTitre())) {
			return true;
		} else {
			return false;
		}
	}
	
}
