package fivefoot.entities;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "commandes")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 100, allocationSize = 1)


public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	
    private Long id_commande;
    private LocalDate date;
    private double prix;
    private Set<LigneDeCommande> lignes;

    public Commande() {
    }

	public Commande(Long id_commande, LocalDate date, double prix, Set<LigneDeCommande> lignes) {
		super();
		this.id_commande = id_commande;
		this.date = date;
		this.prix = prix;
		this.lignes = lignes;
	}

	public Long getId_commande() {
		return id_commande;
	}

	public void setId_commande(Long id_commande) {
		this.id_commande = id_commande;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Set<LigneDeCommande> getLignes() {
		return lignes;
	}

	public void setLignes(Set<LigneDeCommande> lignes) {
		this.lignes = lignes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_commande);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		return Objects.equals(id_commande, other.id_commande);
	}
    
	


    


}