package fr.mmm.pharmaSoft.dto;



public class MedicamentDTO {

	
	private Integer noMedicament;

	private String libelle;
	
	
	private String code;
	
	private String description;
	
	
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
				+ ", prix=" + prix + ",]";
	}

	public String getLibelleTypeMedicament() {
		return libelleTypeMedicament;
	}

	public void setLibelleTypeMedicament(String libelleTypeMedicament) {
		this.libelleTypeMedicament = libelleTypeMedicament;
	}
	
	
}