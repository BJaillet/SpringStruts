package fr.treeptik.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Article;
import fr.treeptik.service.ArticleService;

@Namespace("/article")
@Component
@InterceptorRefs({
	@InterceptorRef(value="defaultStack"),
	@InterceptorRef(value="logger"),
	@InterceptorRef(value="customInterceptor"),
	@InterceptorRef(value="timer")})
public class ArticleAction extends ActionSupport implements ModelDriven<Article> {

	private static final long serialVersionUID = 1L;
	
	private Article article = new Article();
	private List<Article> articles = new ArrayList<>();
	
	@Autowired
	private ArticleService articleService;
	
	@Override
	public Article getModel() {
		return article;
	}

	@Action(value = "add", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "list.action"),
			@Result(name = INPUT, location = "/article/add.jsp")
			})
	public String saveArticle() throws ServiceException {	
		articleService.update(article);
		return SUCCESS;
	}
	
	@Action(value = "list", results = {@Result(name = SUCCESS, location="/article/list.jsp")})
	@SkipValidation
	public String listArticles() throws ServiceException {	
		setArticles(articleService.findAll());
		return SUCCESS;
	}
	
	@Action(value = "delete", results = {@Result(name = SUCCESS, type = "redirectAction", location = "list.action")})
	@SkipValidation
	public String deleteArticle() throws ServiceException {	
		articleService.deleteArticle(article);
		return SUCCESS;
	}
	
	@Action(value = "update", results = {@Result(name = SUCCESS, location = "/article/add.jsp")})
	@SkipValidation
	public String updateArticle() throws ServiceException {	
		article = (Article) articleService.findById(article.getId());
		return SUCCESS;
	}
	
//	@Action(value = "update", results = {@Result(name = SUCCESS, location = "/article/add.jsp")})
//	@SkipValidation
//	public String buyArticle() throws ServiceException {	
//		article = (Article) articleService.findById(article.getId());
//		return SUCCESS;
//	}

	@Override
	public void validate() {
		if (article.getTitre() == null || article.getTitre().equals("")) {
			this.addFieldError("titre", "titre vide");
		}	
	}
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
}
