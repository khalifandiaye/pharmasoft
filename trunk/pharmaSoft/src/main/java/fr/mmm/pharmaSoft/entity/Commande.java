package fr.mmm.pharmaSoft.entity;

import java.util.Date;
import java.util.List;



/**
 * @author MBENGUE-M
 * @version 1.0
 * @created 29-oct.-2013 17:27:56
 */
public class Commande {

	private int noCommande;
	private double montantTotal;
	private boolean valide;
	private List<Medicament> medicaments;
	private Date dateCommande;
	/**
	 * vendeur effectuant la commande
	 */
	private Employe vendeur;

	public Commande(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public int getNoCommande(){
		return noCommande;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setNoCommande(int newVal){
		noCommande = newVal;
	}

	public double getMontantTotal(){
		return montantTotal;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setMontantTotal(double newVal){
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

	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

}