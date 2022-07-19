package fivefoot.entities;

import java.util.*;

public class Client extends Utilisateur {

    private Long id_client;
    private Set<Commande> commande;

    public Client() {
    }

	public Long getId_client() {
		return id_client;
	}

	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}

	public Set<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Set<Commande> commande) {
		this.commande = commande;
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