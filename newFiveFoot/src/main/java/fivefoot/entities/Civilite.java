package fivefoot.entities;

import com.fasterxml.jackson.annotation.JsonView;

public enum Civilite {
	
	M("monsieur"),MME("madame"),MMLE("mademoiselle");
	@JsonView(JsonViews.Base.class)
	private String titre;
	
	private Civilite(String titre) {
		this.titre=titre;
	}
	
	public String getTitre() {
		return titre;
	}

}
