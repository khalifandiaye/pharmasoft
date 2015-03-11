package fr.mmm.pharmaware.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



/**
 * medicament
 * @version 1.0
 * @created 29-oct.-2013 17:27:56
 */
@Entity
@Table(name="medicament")
public class Medicament implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "no_medicament")
	private Integer noMedicament;
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

	/**
	 * @return the principe
	 */
	public String getPrincipe() {
		return principe;
	}

	/**
	 * @param principe the principe to set
	 */
	public void setPrincipe(String principe) {
		this.principe = principe;
	}

	/**
	 * @return the expiant
	 */
	public String getExpiant() {
		return expiant;
	}

	/**
	 * @param expiant the expiant to set
	 */
	public void setExpiant(String expiant) {
		this.expiant = expiant;
	}

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
	 * @return the codeAcl
	 */
	public String getCodeAcl() {
		return codeAcl;
	}

	/**
	 * @param codeAcl the codeAcl to set
	 */
	public void setCodeAcl(String codeAcl) {
		this.codeAcl = codeAcl;
	}

	/**
	 * @return the codeCip
	 */
	public String getCodeCip() {
		return codeCip;
	}

	/**
	 * @param codeCip the codeCip to set
	 */
	public void setCodeCip(String codeCip) {
		this.codeCip = codeCip;
	}

	
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
	
	@ManyToOne
	private ListeMedicament liste;
	 
	 @ManyToOne
	private CategorieMedicament categorie;
	 
	 @ManyToOne
	private ModeAdminMedicament modeAdministration;
	 
	 @ManyToOne
	private ModeConsMedicament modeConservation;
	 
	 @ManyToOne
	private FormeMedicament formeMedicament;
	/**
	 * type de medicament
	 */
	@ManyToOne(cascade = CascadeType.DETACH ,fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
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

	/**
	 * @return the liste
	 */
	public ListeMedicament getListe() {
		return liste;
	}

	/**
	 * @param liste the liste to set
	 */
	public void setListe(ListeMedicament liste) {
		this.liste = liste;
	}

	/**
	 * @return the categorie
	 */
	public CategorieMedicament getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(CategorieMedicament categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the modeAdministration
	 */
	public ModeAdminMedicament getModeAdministration() {
		return modeAdministration;
	}

	/**
	 * @param modeAdministration the modeAdministration to set
	 */
	public void setModeAdministration(ModeAdminMedicament modeAdministration) {
		this.modeAdministration = modeAdministration;
	}

	/**
	 * @return the modeConservation
	 */
	public ModeConsMedicament getModeConservation() {
		return modeConservation;
	}

	/**
	 * @param modeConservation the modeConservation to set
	 */
	public void setModeConservation(ModeConsMedicament modeConservation) {
		this.modeConservation = modeConservation;
	}

	/**
	 * @return the formeMedicament
	 */
	public FormeMedicament getFormeMedicament() {
		return formeMedicament;
	}

	/**
	 * @param formeMedicament the formeMedicament to set
	 */
	public void setFormeMedicament(FormeMedicament formeMedicament) {
		this.formeMedicament = formeMedicament;
	}
	
	
	/**
	 * @return the commandes
	 */
	public Set<Commande> getCommandes() {
		if(this.commandes==null){
			this.setCommandes(new HashSet<Commande>());
		}
		return this.commandes;
	}

	/**
	 * @param commandes the commandes to set
	 */
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}


	/**
	 * @return the stocks
	 */
	public Set<Stock> getStocks() {
		return stocks;
	}

	/**
	 * @param stocks the stocks to set
	 */
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}


	@ManyToMany(mappedBy="medicaments" , fetch = FetchType.EAGER, cascade=CascadeType.ALL)
   private Set<Commande> commandes= new HashSet<Commande>();
	
	@OneToMany (mappedBy="medicament", cascade=CascadeType.ALL)
	private Set<Stock> stocks = new HashSet<Stock>();
	
	
	
}