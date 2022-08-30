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


	public Article create(Article Article) {
		Fournisseur fournisseur = article.getFournisseur();
		if (fournisseur != null) {
			fournisseur = fournisseurService.getById(fournisseur.getId());
			article.setFournisseur(fournisseur);
		}
		return articleRepo.save(article);
	}

	public Article getById(Long id) {
		return articleRepo.findById(id).orElseThrow(ArticleException::new);
	}

	public Article update(Article article) {
		Article articleEnBase = getById(article.getId());
		articleEnBase.setLibelle(article.getLibelle());
		articleEnBase.setPrixUnitaire(article.getPrixUnitaire());
		articleEnBase.setDescription(article.getDescription());


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
