package fr.mmm.pharmaSoft.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * @author MBENGUE-M
 * @version 1.0
 * @created 29-oct.-2013 17:27:56
 */
@Entity
@Table(name="commande")
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "no_commande")
	private Integer noCommande;
	@Column(name="montantTotal")
	private Double montantTotal;
	@Column(name="valide")
	private boolean valide;
	
	
	
	@Column(name="dateCommande")
	private Date dateCommande;
	
	/**
	 * vendeur effectuant la commande
	 */
	@ManyToOne
	private Employe vendeur;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	 @JoinTable(name = "commande_medicament", joinColumns = { @JoinColumn(name = "no_commande", referencedColumnName = "no_commande") }, 
	 inverseJoinColumns = { @JoinColumn(name = "no_medicament", referencedColumnName = "no_medicament") })
    private Set<Medicament> medicaments= new HashSet<Medicament>();

	public Commande(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public Integer getNoCommande(){
		return noCommande;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setNoCommande(Integer newVal){
		noCommande = newVal;
	}

	public Double getMontantTotal(){
		return montantTotal;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setMontantTotal(Double newVal){
		montantTotal = newVal;
	}

	public boolean isValide(){
		return valide;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setValide(boolean newVal){
		valide = newVal;
	}

	/**
	 * vendeur effectuant la commande
	 */
	public Employe getVendeur(){
		return vendeur;
	}

	/**
	 * vendeur effectuant la commande
	 * 
	 * @param newVal
	 */ 
	public void setVendeur(Employe newVal){
		vendeur = newVal;
	}

	public Set<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(Set<Medicament> medicaments) {
		this.medicaments = medicaments;
	}
	
	public void addMedicament(Medicament medicament) {
		if (this.medicaments == null) {
            this.medicaments = new HashSet<Medicament>();
        }
        
        this.medicaments.add(medicament);
	  }

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	@Override
	public String toString() {
		return "Commande [noCommande=" + noCommande + ", montantTotal="
				+ montantTotal + ", valide=" + valide + ", dateCommande="
				+ dateCommande + ", vendeur=" + vendeur + ", medicaments="
				+ medicaments + "]";
	}
	
}