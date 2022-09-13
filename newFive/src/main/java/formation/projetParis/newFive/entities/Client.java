package formation.projetParis.newFive.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="clients")
@SequenceGenerator(sequenceName = "seq_client", name = "seqClient", initialValue = 100, allocationSize = 1)


@NamedQueries({
	@NamedQuery(name = "Client.findByKeyWithCommandes", query = "select c from Client c left join fetch c.commandes where c.id=:id"), //@param id dans clientrepository
	@NamedQuery(name = "Client.findByIdWithCommandesDetails", query = "select c from Client c left join fetch c.commandes as commande left join fetch commande.lignes where c.id=:id"),
	})

public class Client extends Utilisateur {
	
	@JsonView(JsonViews.Base.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "client_id")
    private Long id;
	@OneToMany(mappedBy ="client")
	@JsonView(JsonViews.ClientWithCommandes.class) //uniqument s'affiche le json s'il y a de commandes a afficher??
    private Set<Commande> commandes;

    public Client() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id_client) {
		this.id = id_client;
	}

	public Set<Commande> getCommande() {
		return commandes;
	}

	public void setCommande(Set<Commande> commande) {
		this.commandes = commande;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
    
}