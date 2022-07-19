package fivefoot.entities;

import java.util.*;

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