package fr.mmm.pharmaSoft.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * stock
 * @version 1.0
 * @created 29-oct.-2013 17:28:05
 */
@Entity
@Table(name="stock")
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer noStock;
	@Column(name="quantite")
	private Integer quantite;
	
	@ManyToOne
	private Medicament medicament;
	
	@Column(name="dateperemption")
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

	public Integer getNoStock(){
		return noStock;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNoStock(Integer newVal){
		noStock = newVal;
	}

	public Integer getQuantite(){
		return quantite;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantite(Integer newVal){
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

	@Override
	public String toString() {
		return "Stock [noStock=" + noStock + ", quantite=" + quantite
				+ ", medicament=" + medicament + ", datePeremption="
				+ datePeremption + "]";
	}

}