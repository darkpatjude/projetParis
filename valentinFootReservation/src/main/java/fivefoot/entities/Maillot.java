package fivefoot.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="maillots")
@SequenceGenerator(name = "seqMarchandise", sequenceName = "seq_maillot", allocationSize = 1, initialValue = 100)
@DiscriminatorValue("M")
public class Maillot extends Marchandise {

    private String equipe;
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