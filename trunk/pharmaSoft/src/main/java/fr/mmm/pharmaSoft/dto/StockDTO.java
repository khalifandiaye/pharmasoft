package fr.mmm.pharmaSoft.dto;

import java.util.Date;



public class StockDTO {

	
	private Integer noStock;

	private String libelleMedicament;
	
	
	private Date datePeremption;
	
	
	
	
	private Integer quantite;
	
	

	public StockDTO(){

	}



	public Integer getNoStock() {
		return noStock;
	}



	public void setNoStock(Integer noStock) {
		this.noStock = noStock;
	}



	public String getLibelleMedicament() {
		return libelleMedicament;
	}



	public void setLibelleMedicament(String libelleMedicament) {
		this.libelleMedicament = libelleMedicament;
	}



	public Date getDatePeremption() {
		return datePeremption;
	}



	public void setDatePeremption(Date datePeremption) {
		this.datePeremption = datePeremption;
	}



	public Integer getQuantite() {
		return quantite;
	}



	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}



	@Override
	public String toString() {
		return "StockDTO [noStock=" + noStock + ", libelleMedicament="
				+ libelleMedicament + ", datePeremption=" + datePeremption
				+ ", quantite=" + quantite + "]";
	}

	


	
	
}