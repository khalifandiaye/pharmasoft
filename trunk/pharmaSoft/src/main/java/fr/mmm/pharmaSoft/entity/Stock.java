package fr.mmm.pharmaSoft.entity;

import java.util.Date;



/**
 * stock
 * @version 1.0
 * @created 29-oct.-2013 17:28:05
 */
public class Stock {

	private int noStock;
	private int quantite;
	private Medicament medicament;
	private Date datePeremption;

	public Stock(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public int getNoStock(){
		return noStock;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNoStock(int newVal){
		noStock = newVal;
	}

	public int getQuantite(){
		return quantite;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantite(int newVal){
		quantite = newVal;
	}

	public Medicament getMedicament(){
		return medicament;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMedicament(Medicament newVal){
		medicament = newVal;
	}

	public Date getDatePeremption(){
		return datePeremption;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDatePeremption(Date newVal){
		datePeremption = newVal;
	}

}