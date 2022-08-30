package fivefoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fivefoot.entities.Article;
import fivefoot.Exception.ArticleException;
import fivefoot.repositories.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepo;


	public Article create(Article article) {

		return articleRepo.save(article);
	}

	public Article getById(Long id) {
		return articleRepo.findById(id).orElseThrow(ArticleException::new);
	}

	public Article update(Article article) {
		Article articleEnBase = getById(article.getId());
		articleEnBase.setPrix(article.getPrix());


		return articleRepo.save(articleEnBase);
	}

	public List<Article> getAll() {
		return articleRepo.findAll();
	}

	public void delete(Article article) {
		articleRepo.delete(article);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

}
