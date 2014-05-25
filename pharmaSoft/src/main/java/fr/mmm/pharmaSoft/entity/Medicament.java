package fr.mmm.pharmaSoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * medicament
 * @version 1.0
 * @created 29-oct.-2013 17:27:56
 */
@Entity
@Table(name="medicament")
public class Medicament {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "no_medicament")
	private Integer noMedicament;
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="code")
	private String code;
	
	@Column(name="description")
	private String description;
	
	@Column(name="prix")
	private Double prix;
	
	@Column(name="posologie")
	private String posologie;
	
	@Column(name="principe")
	private String principe;
	
	@Column(name="expiant")
	private String expiant;
	
	@Column(name="dosage")
	private String dosage;
	
	@Column(name="code_acl")
	private String codeAcl;
	
	@Column(name="code_cip")
	private String codeCip;
	
	 @Enumerated(EnumType.STRING)
	private EnumListe liste;
	 
	 @Enumerated(EnumType.STRING)
	private EnumCategorie categorie;
	 
	 @Enumerated(EnumType.STRING)
	private EnumModeAdministration modeAdministration;
	 
	 @Enumerated(EnumType.STRING)
	private EnumModeConservation modeConservation;
	 
	 @Enumerated(EnumType.STRING)
	private EnumFormeMedicament formeMedicament;
	/**
	 * type de medicament
	 */
	@ManyToOne
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

	@Override
	public String toString() {
		return "Medicament [noMedicament=" + noMedicament + ", libelle="
				+ libelle + ", code=" + code + ", description=" + description
				+ ", prix=" + prix + ", type=" + type + "]";
	}

	public EnumCategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(EnumCategorie categorie) {
		this.categorie = categorie;
	}
	
	
}