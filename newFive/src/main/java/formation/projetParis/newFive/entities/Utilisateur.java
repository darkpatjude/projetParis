package formation.projetParis.newFive.entities;


import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;


@MappedSuperclass

public abstract class Utilisateur {
	@JsonView(JsonViews.Base.class)
    private String prenom;
	@JsonView(JsonViews.Base.class)
    private String nom;
	@JsonView(JsonViews.Base.class)
    private Civilite civilite;
	@JsonView(JsonViews.Base.class)
    private String email;
	@JsonView(JsonViews.Base.class)
    private String motDePasse;
	@JsonView(JsonViews.Base.class)
    private String telephone;
	@JsonView(JsonViews.Base.class)
    @Embedded
	private Adresse adresse;
    
    public Utilisateur() {
    }
    

	public Utilisateur(String prenom, String nom, String email, String motDePasse, String telephone, Adresse adresse) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.telephone = telephone;
		this.adresse = adresse;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
    
    
 

}