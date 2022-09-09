package formation.projetParis.newFive.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("M")
public class Maillot extends Marchandise {

	@JsonView(JsonViews.Base.class)
    private String equipe;
	@JsonView(JsonViews.Base.class)
    private String taille;

    public Maillot() {
    }

	public Maillot(String equipe, String taille) {
		super();
		this.equipe = equipe;
		this.taille = taille;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}
    
    

}