package fivefoot.entities;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name="admins")
@SequenceGenerator(sequenceName = "seq_admin", name = "seqAdmin", initialValue = 1, allocationSize = 100)


public class Admin extends Utilisateur {

	@JsonView(JsonViews.Base.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAdmin")
    private Long id_admin;
	
    public Admin() {
    }
	
	public Long getId_admin() {
		return id_admin;
	}

	public void setId_admin(Long id_admin) {
		this.id_admin = id_admin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_admin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(id_admin, other.id_admin);
	}
    
 

}