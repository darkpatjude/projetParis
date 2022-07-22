package fivefoot.entities;

public enum Civilite {
	
	M("monsieur"),MME("madame"),MMLE("mademoiselle");
	
	private String titre;
	
	private Civilite(String titre) {
		this.titre=titre;
	}
	
	public String getTitre() {
		return titre;
	}

}
