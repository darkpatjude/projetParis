package fivefoot.models;


import fivefoot.entities.Article;

public class ElementPanierRestModel {
	private Article article;
	private Integer quantite;

	public ElementPanierRestModel() {

	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}



}
