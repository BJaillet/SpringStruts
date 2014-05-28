package fr.treeptik.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Article;
import fr.treeptik.model.Commande;
import fr.treeptik.service.ArticleService;
import fr.treeptik.service.CommandeService;

@Namespace("/commande")
@Component
public class CommandeAction extends ActionSupport implements ModelDriven<Commande> {

	private static final long serialVersionUID = 1L;
	
	private Article article = new Article();
	private List<Article> articlesCommande = new ArrayList<>();
	private Commande commande = new Commande();
	private List<Commande> commandes = new ArrayList<>();
	
	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ArticleService articleService;
	
	@Override
	public Commande getModel() {
		return commande;
	}

	@Action(value = "create", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "../article/list.action"),
			@Result(name = INPUT, location = "/commande/init.jsp")
			})
	public String createCommande() throws ServiceException {	
		commande = commandeService.update(commande);
		SessionManager.setCommande(commande);
		return SUCCESS;
	}
	
	@Action(value = "find", results = {@Result(name = SUCCESS, location="/commande/detail.jsp")})
	@SkipValidation
	public String findCommande() throws ServiceException {	
		setCommandes(commandeService.findAll());
		return SUCCESS;
	}
	
	@Action(value = "removeArticle", results = {@Result(name = SUCCESS, type = "redirectAction", location = "show.action")})
	@SkipValidation
	public String removeArticle() throws ServiceException {	
		setCommande(SessionManager.getCommande());
//		articlesCommande = commande.getArticles();
//		article = articleService.findById(article.getId());
		
		commande.getArticles().remove(articleService.findById(article.getId()));
//		commande.setArticles(articlesCommande);
		
		SessionManager.setCommande(commande);
		commandeService.update(commande);
		return SUCCESS;
	}
	
	@Action(value = "show", results = {@Result(name = SUCCESS, location = "/commande/detail.jsp")})
	@SkipValidation
	public String showCommande() throws ServiceException {	
		setCommande(SessionManager.getCommande());
		setArticlesCommande(commande.getArticles());
		SessionManager.setCommande(commande);
		return SUCCESS;
	}
	
	@Action(value = "addArticle", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "show.action"),
			@Result(name = ERROR, type = "redirectAction", location = "../article/list.action")
			})
	@SkipValidation
	public String addArticle() throws ServiceException {
		setCommande(SessionManager.getCommande());
		System.out.println(commande);
		setArticle(articleService.findById(article.getId()));
		System.out.println(article);
		commande.getArticles().add(article);
		commandeService.update(commande);
		SessionManager.setCommande(commande);
		return SUCCESS;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getArticlesCommande() {
		return articlesCommande;
	}

	public void setArticlesCommande(List<Article> articles) {
		this.articlesCommande = articles;
	}
	
}
