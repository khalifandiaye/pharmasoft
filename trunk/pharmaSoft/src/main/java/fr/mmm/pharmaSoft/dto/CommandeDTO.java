package fr.mmm.pharmaSoft.dto;

import java.util.Date;
import java.util.Set;

import fr.mmm.pharmaSoft.dao.CommandeDao;
import fr.mmm.pharmaSoft.entity.Commande;
import fr.mmm.pharmaSoft.entity.Medicament;



public class CommandeDTO {

	
	private Integer noCommande;

	private Date dateCommande;
	
	
	private String libelleMedicaments;
	
	private Double montantCommande;
	
	 private Set<Medicament> medicaments;
	

	public CommandeDTO(){

	}




	public Integer getNoCommande() {
		return noCommande;
	}




	public void setNoCommande(Integer noCommande) {
		this.noCommande = noCommande;
	}




	public Date getDateCommande() {
		return dateCommande;
	}




	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}




	public String getLibelleMedicaments() {
		String result="";
		CommandeDao commandeDao=new CommandeDao();
		Commande commande=commandeDao.findByPk(noCommande);
		if(commande.getMedicaments()!=null){
			for(Medicament medicament : commande.getMedicaments()){
				result=result+medicament.getLibelle()+"\n";
			}
		}
		return result;
		
	}




	public void setLibelleMedicaments(String libelleMedicaments) {
		this.libelleMedicaments = libelleMedicaments;
	}




	public Double getMontantCommande() {
		return montantCommande;
	}




	public void setMontantCommande(Double montantCommande) {
		this.montantCommande = montantCommande;
	}




	@Override
	public String toString() {
		return "CommandeDTO [noCommande=" + noCommande + ", dateCommande="
				+ dateCommande + ", libelleMedicaments=" + libelleMedicaments
				+ ", montantCommande=" + montantCommande + "]";
	}




	public Set<Medicament> getMedicaments() {
		return medicaments;
	}




	public void setMedicaments(Set<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	

	
	
	
}