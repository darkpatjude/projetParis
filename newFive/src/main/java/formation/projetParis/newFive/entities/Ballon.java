package formation.projetParis.newFive.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("B")
public class Ballon extends Marchandise {

	@JsonView(JsonViews.Base.class)
    private String couleur;
	@JsonView(JsonViews.Base.class)
    private String taille;
    
    public Ballon() {
    }
    
	public Ballon(String couleur, String taille) {
		super();
		this.couleur = couleur;
		this.taille = taille;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}
    
	
    
    

}