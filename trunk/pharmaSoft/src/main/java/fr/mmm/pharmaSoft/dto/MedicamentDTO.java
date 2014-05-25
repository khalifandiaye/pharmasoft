package fr.mmm.pharmaSoft.dto;

import fr.mmm.pharmaSoft.entity.EnumCategorie;
import fr.mmm.pharmaSoft.entity.EnumListe;



public class MedicamentDTO {

	
	private Integer noMedicament;

	private String libelle;
	
	
	private String code;
	
	private String description;
	
	private EnumListe liste;
	
	private EnumCategorie categorie;
	

	public EnumListe getListe() {
		return liste;
	}



	public void setListe(EnumListe liste) {
		this.liste = liste;
	}

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

	

	@Override
	public String toString() {
		return "Medicament [noMedicament=" + noMedicament + ", libelle="
				+ libelle + ", code=" + code + ", description=" + description
				+ ", prix=" + prix +", liste=" + liste + "]";
	}

	public String getLibelleTypeMedicament() {
		return libelleTypeMedicament;
	}

	public void setLibelleTypeMedicament(String libelleTypeMedicament) {
		this.libelleTypeMedicament = libelleTypeMedicament;
	}
	
	
}