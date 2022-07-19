package fivefoot.entities;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Embeddable
public class LigneCommandeKey {
	@ManyToOne
	@JoinColumn(name="ligne_commande_commande_id",foreignKey = @ForeignKey(name="ligne_commande_ligne_commande_commande_id_fk"))
	private Commande commande;
	@ManyToOne
	@JoinColumn(name="ligne_commande_article_id",foreignKey = @ForeignKey(name="ligne_commande_ligne_commande_article_id_fk"))
	private Article article;
	
}
