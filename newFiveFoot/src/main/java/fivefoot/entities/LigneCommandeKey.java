package fivefoot.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;



@Embeddable
public class LigneCommandeKey implements Serializable{
	@ManyToOne
	@JoinColumn(name="ligne_commande_commande_id",foreignKey = @ForeignKey(name="ligne_commande_ligne_commande_commande_id_fk"))
	private Commande commande;
	@ManyToOne
	@JoinColumn(name="ligne_commande_article_id",foreignKey = @ForeignKey(name="ligne_commande_ligne_commande_article_id_fk"))
	@JsonView(JsonViews.CommandeDetails.class)
	private Article article; // le meme nom utilise dans classe Article dans OneToMany(mappedBy = "id.article")
	
	public LigneCommandeKey(Commande commande, Article article) {
		this.commande = commande;
		this.article = article;
	}
	public LigneCommandeKey() {
	
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	@Override
	public int hashCode() {
		return Objects.hash(article, commande);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneCommandeKey other = (LigneCommandeKey) obj;
		return Objects.equals(article, other.article) && Objects.equals(commande, other.commande);
	}
	
	
	
}
