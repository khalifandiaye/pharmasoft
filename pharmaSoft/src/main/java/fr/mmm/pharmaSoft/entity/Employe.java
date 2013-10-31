package fr.mmm.pharmaSoft.entity;



/**
 * employe
 * @version 1.0
 * @created 29-oct.-2013 17:27:56
 */
public class Employe {

	private int noEmploye;
	private String nom;
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

}