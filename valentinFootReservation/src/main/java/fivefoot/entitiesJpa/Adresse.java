package formationJpaJulian.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable //embarquer la classe
public class Adresse {
	
	//para poner las columnas con el nombre que queramos se hace aquí
	@Column(name="number",length=1000) //aqui definimos los nombres pero si hay un @overrideattributes, tomará los otros
	private String numero;
	private String rue;
	private String codePostal;
	private String ville;
	
	public Adresse() {
		
	}

	public Adresse(String numero, String rue, String codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumeo(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
