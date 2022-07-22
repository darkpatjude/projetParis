package fivefoot.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="ligne_de_commande")
public class LigneDeCommande {
	@EmbeddedId
	private LigneCommandeKey id;
	private int quantite;
	
	

    public LigneDeCommande() {
    }

	public LigneDeCommande(fivefoot.entities.LigneCommandeKey id, int quantite) {
		super();
		this.id = id;
		this.quantite = quantite;
	}


	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public LigneCommandeKey getId() {
		return id;
	}

	public void setId(LigneCommandeKey id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneDeCommande other = (LigneDeCommande) obj;
		return Objects.equals(id, other.id);
	}
	
    






    

    

}