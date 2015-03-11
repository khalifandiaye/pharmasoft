package fr.mmm.pharmaware.entity;

import java.io.Serializable;

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
public class Employe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer noEmploye;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="profil")
	private String profil;

	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the profil
	 */
	public String getProfil() {
		return profil;
	}

	/**
	 * @param profil the profil to set
	 */
	public void setProfil(String profil) {
		this.profil = profil;
	}

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