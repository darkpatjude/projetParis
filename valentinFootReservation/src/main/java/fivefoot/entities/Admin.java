package fivefoot.entities;

import java.util.*;


public class Admin extends Utilisateur {

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