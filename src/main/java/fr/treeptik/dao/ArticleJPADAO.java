package fr.treeptik.dao;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Article;
import fr.treeptik.model.CD;
import fr.treeptik.model.DVD;
import fr.treeptik.model.Livre;

@Repository
public class ArticleJPADAO extends GenericJPADAO<Article, Integer> implements ArticleDAO {

	public ArticleJPADAO() {
		super(Article.class);
	}
	
	public List<CD> listAllCD() throws DAOException {
		try {
			TypedQuery<CD> query = entityManager.createQuery("select c from CD c", CD.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur find all CD", e);
		}
	}
	
	public List<DVD> listAllDVD() throws DAOException {
		try {
			TypedQuery<DVD> query = entityManager.createQuery("select c from DVD c", DVD.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur find all DVD", e);
		}
	}
	
	public List<Livre> listAllLivres() throws DAOException {
		try {
			TypedQuery<Livre> query = entityManager.createQuery("select c from Livre c", Livre.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur find all livres", e);
		}
	}
}
