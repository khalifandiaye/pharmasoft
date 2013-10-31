package fr.mmm.pharmaSoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEDICAMENT")
public class Medicament {
	
	@Id
	@GeneratedValue
	private Integer medicamentId;

	@Column(name="nom")
	private String nom;
	
	@Column(name="prix")
	private Double prix;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description")
	private String description;
	
	

	public Medicament() {
		
	}

	


	public Medicament(String nom, Double prix, String type, String description) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.type = type;
		this.description = description;
	}




	public Integer getMedicamentId() {
		return medicamentId;
	}



	public void setMedicamentId(Integer medicamentId) {
		this.medicamentId = medicamentId;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Double getPrix() {
		return prix;
	}



	public void setPrix(Double prix) {
		this.prix = prix;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}




	@Override
	public String toString() {
		return "Medicament [medicamentId=" + medicamentId + ", nom=" + nom
				+ ", prix=" + prix + ", type=" + type + ", description="
				+ description + "]";
	}
	

	}
