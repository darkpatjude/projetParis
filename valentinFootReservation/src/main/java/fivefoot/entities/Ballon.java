package fivefoot.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ballons")
@SequenceGenerator(name = "seqMarchandise", sequenceName = "seq_ballon", allocationSize = 1, initialValue = 100)
@DiscriminatorValue("B")
public class Ballon extends Marchandise {


    private String couleur;
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