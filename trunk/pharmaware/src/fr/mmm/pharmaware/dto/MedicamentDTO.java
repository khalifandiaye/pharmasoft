package fr.mmm.pharmaware.dto;

import java.io.Serializable;




public class MedicamentDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer noMedicament;

	private String libelle;
	
	
	private String code;
	
	private String description;
	
	private String liste;
	
	private String categorie;
	
	private String type;
	
	private String modeAdmin;
	
	private String modeCons;
	
	private String forme;
	
	

	/**
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}



	/**
	 * @param dosage the dosage to set
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}



	/**
	 * @return the posologie
	 */
	public String getPosologie() {
		return posologie;
	}



	/**
	 * @param posologie the posologie to set
	 */
	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	
	private String dosage;
	
	
	
	
	private String posologie;
	

	



	

	private Double prix;
	
	private String libelleTypeMedicament ;

	public MedicamentDTO(){

	}

	

	public Integer getNoMedicament(){
		return noMedicament;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNoMedicament(Integer newVal){
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

	public Double getPrix(){
		return prix;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrix(Double newVal){
		prix = newVal;
	}



	/**
	 * @return the liste
	 */
	public String getListe() {
		return liste;
	}



	/**
	 * @param liste the liste to set
	 */
	public void setListe(String liste) {
		this.liste = liste;
	}



	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}



	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}



	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	/**
	 * @return the modeAdmin
	 */
	public String getModeAdmin() {
		return modeAdmin;
	}



	/**
	 * @param modeAdmin the modeAdmin to set
	 */
	public void setModeAdmin(String modeAdmin) {
		this.modeAdmin = modeAdmin;
	}



	/**
	 * @return the modeCons
	 */
	public String getModeCons() {
		return modeCons;
	}



	/**
	 * @param modeCons the modeCons to set
	 */
	public void setModeCons(String modeCons) {
		this.modeCons = modeCons;
	}



	/**
	 * @return the forme
	 */
	public String getForme() {
		return forme;
	}



	/**
	 * @param forme the forme to set
	 */
	public void setForme(String forme) {
		this.forme = forme;
	}



	/**
	 * @return the libelleTypeMedicament
	 */
	public String getLibelleTypeMedicament() {
		return libelleTypeMedicament;
	}



	/**
	 * @param libelleTypeMedicament the libelleTypeMedicament to set
	 */
	public void setLibelleTypeMedicament(String libelleTypeMedicament) {
		this.libelleTypeMedicament = libelleTypeMedicament;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MedicamentDTO [noMedicament=" + noMedicament + ", libelle="
				+ libelle + ", code=" + code + ", description=" + description
				+ ", liste=" + liste + ", categorie=" + categorie + ", type="
				+ type + ", modeAdmin=" + modeAdmin + ", modeCons=" + modeCons
				+ ", forme=" + forme + ", dosage=" + dosage + ", posologie="
				+ posologie + ", prix=" + prix + ", libelleTypeMedicament="
				+ libelleTypeMedicament + "]";
	}

	

	
	


	
	
	
}