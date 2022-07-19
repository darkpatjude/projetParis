package fivefoot.entities;


import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;


@MappedSuperclass

public abstract class Utilisateur {

    private String prenom;
    private String nom;
    private String email;
    private String motDePasse;
    private String telephone;
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