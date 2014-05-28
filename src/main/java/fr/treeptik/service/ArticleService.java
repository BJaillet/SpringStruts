package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ArticleDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Article;
import fr.treeptik.model.Livre;

@Service
public class ArticleService extends GenericService<Article, Integer> {

	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public ArticleDAO getDao() {
		return articleDAO;
	}

	public List<Livre> listAllLivres() throws ServiceException {
		try {
			return articleDAO.listAllLivres();
		} catch (DAOException e) {
			throw new ServiceException("erreur findall livres", e);
		}
	}
	
	@Transactional
	public void deleteArticle(Article article)
			throws ServiceException {
		try {
			article = articleDAO.findById(article.getId());
			articleDAO.remove(article);
		} catch (DAOException e) {
			throw new ServiceException("erreur remove article", e);
		}
	}

}
