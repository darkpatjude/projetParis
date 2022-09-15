package formation.projetParis.newFive.entities;


import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;


@MappedSuperclass
public abstract class Utilisateur implements UserDetails{
	@JsonView(JsonViews.Base.class)
    private String prenom;
	@JsonView(JsonViews.Base.class)
    private String nom;
	@JsonView(JsonViews.Base.class)
    private Civilite civilite;
	@JsonView(JsonViews.Base.class)
    private String email;
	@JsonView(JsonViews.Base.class)
    private String telephone;
	@JsonView(JsonViews.Base.class)
    @Embedded
	private Adresse adresse;
	
	@JsonView(JsonViews.Base.class)
	@Column(name="login",nullable=false,unique=true)
	private String login;
	@JsonView(JsonViews.Base.class)
	@Column(name="password",nullable=false, length=255)
	private String password;
	
	@JsonView(JsonViews.Base.class)
	private String role;
    
    public Utilisateur() {
    }
    

	public Utilisateur(String prenom, String nom, String email, String motDePasse, String telephone, Adresse adresse) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = motDePasse;
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

	public String getPassword() {
		return password;
	}


	public void setPassword(String motDePasse) {
		this.password = motDePasse;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("*****GrantedAuthority dans la class Utilisateur******");
		System.out.println(Arrays.asList(new SimpleGrantedAuthority(role)));
		return Arrays.asList(new SimpleGrantedAuthority(role));
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