package fr.treeptik.dao;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Article;
import fr.treeptik.model.Commande;

@Repository
public class CommandeJPADAO extends GenericJPADAO<Commande, Integer> implements CommandeDAO {
	
	public CommandeJPADAO() {
		super(Commande.class);
	}
	
	public List<Commande> findByClientId(Integer clientId) throws DAOException {
		TypedQuery<Commande> query = entityManager.createQuery("select c from Commande c where c.client.id = :id", Commande.class);
		query.setParameter("id", clientId);
		try {
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur find by client id", e);
		}
	}
	
	public void addArticle(Commande commande, Article article) throws DAOException {
		Query query = entityManager.createNativeQuery("insert into Commande_Article (Commande_id, articles_id) values (:idCommande, :idArticle)");
		query.setParameter("idCommande", commande.getId());
		query.setParameter("idArticle", article.getId());
		try {
			query.executeUpdate();
		} catch (PersistenceException e) {
			throw new DAOException("erreur ajout article", e);
		}
	}

	@Override
	public List<Article> listArticles(Commande commande) throws DAOException {
//		TypedQuery<Article> query = entityManager.createQuery(
//				"select a from Article c join fetch commande.articles",
//				Employee.class);
//		List<Employee> resultList = query.getResultList();
		return null;
	}
}
