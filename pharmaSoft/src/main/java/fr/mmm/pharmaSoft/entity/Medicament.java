package fr.mmm.pharmaSoft.entity;



/**
 * medicament
 * @version 1.0
 * @created 29-oct.-2013 17:27:56
 */
public class Medicament {

	private int noMedicament;
	private String libelle;
	private String code;
	private String description;
	private double prix;
	/**
	 * type de medicament
	 */
	private TypeMedicament type;

	public Medicament(){

	}

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public int getNoMedicament(){
		return noMedicament;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNoMedicament(int newVal){
		noMedicament = newVal;
	}

	public String getLibelle(){
		return libelle;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLibelle(String newVal){
		libelle = newVal;
	}

	public String getCode(){
		return code;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCode(String newVal){
		code = newVal;
	}

	public String getDescription(){
		return description;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		description = newVal;
	}

	public double getPrix(){
		return prix;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrix(double newVal){
		prix = newVal;
	}

	/**
	 * type de medicament
	 */
	public TypeMedicament getType(){
		return type;
	}

	/**
	 * type de medicament
	 * 
	 * @param newVal
	 */
	public void setType(TypeMedicament newVal){
		type = newVal;
	}

}