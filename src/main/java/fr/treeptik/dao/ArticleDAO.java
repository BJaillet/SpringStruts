package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Article;
import fr.treeptik.model.Livre;

public interface ArticleDAO extends GenericDAO<Article, Integer> {

	List<Livre> listAllLivres() throws DAOException;

}
