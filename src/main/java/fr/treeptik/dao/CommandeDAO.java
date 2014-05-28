package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Article;
import fr.treeptik.model.Commande;

public interface CommandeDAO extends GenericDAO<Commande, Integer> {

	List<Commande> findByClientId(Integer clientId) throws DAOException;
	void addArticle(Commande commande, Article article) throws DAOException;
	List<Article> listArticles(Commande commande) throws DAOException;
}
