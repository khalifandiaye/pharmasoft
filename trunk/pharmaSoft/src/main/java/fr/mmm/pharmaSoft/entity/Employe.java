package fr.mmm.pharmaSoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * employe
 * @version 1.0
 * @created 29-oct.-2013 17:27:56
 */
@Entity
@Table(name="employe")
public class Employe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer noEmploye;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;

	public Employe(){

	}

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public String getNom(){
		return nom;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setNom(String newVal){
		nom = newVal;
	}

	public String getPrenom(){
		return prenom;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrenom(String newVal){
		prenom = newVal;
	}

	public Integer getNoEmploye() {
		return noEmploye;
	}

	public void setNoEmploye(Integer noEmploye) {
		this.noEmploye = noEmploye;
	}

	@Override
	public String toString() {
		return "Employe [noEmploye=" + noEmploye + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}
	
}