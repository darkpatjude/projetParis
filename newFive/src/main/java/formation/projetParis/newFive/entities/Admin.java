package formation.projetParis.newFive.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name="admins")
@SequenceGenerator(sequenceName = "seq_admin", name = "seqAdmin", initialValue = 100, allocationSize = 1)


public class Admin extends Utilisateur implements UserDetails{

	@JsonView(JsonViews.Base.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAdmin")
    private Long id;
	
    public Admin() {
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id_admin) {
		this.id = id_admin;
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
		Admin other = (Admin) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


    
 

}