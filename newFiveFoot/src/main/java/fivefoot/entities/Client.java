package fivefoot.entities;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="clients")
@SequenceGenerator(sequenceName = "seq_client", name = "seqClient", initialValue = 1, allocationSize = 100)

public class Client extends Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
    private Long id_client;
	@OneToMany(mappedBy ="client")
    private Set<Commande> commandes;

    public Client() {
    }

	public Long getId_client() {
		return id_client;
	}

	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}

	public Set<Commande> getCommande() {
		return commandes;
	}

	public void setCommande(Set<Commande> commande) {
		this.commandes = commande;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_client);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id_client, other.id_client);
	}
    
}