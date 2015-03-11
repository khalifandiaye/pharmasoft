/**
 * 
 */
package fr.mmm.pharmaware.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.mmm.pharmaware.dao.CommandeDao;
import fr.mmm.pharmaware.dao.MedicamentDao;
import fr.mmm.pharmaware.dto.MedicamentDTO;
import fr.mmm.pharmaware.entity.Commande;
import fr.mmm.pharmaware.entity.Medicament;

/**
 * @author mmbengue
 * 
 */
@ManagedBean(name = "venteBean")
@ViewScoped
public class VenteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	

	private CommandeDao venteDao = new CommandeDao();
	

	private Commande vente ;
	
	private List<MedicamentDTO> listeMedicament;
	private Map<String, Integer> mapMedic;
	
	private MedicamentDTO medicament ;

	/**
	 * @return the vente
	 */
	public Commande getVente() {
		return vente;
	}

	/**
	 * @param vente the vente to set
	 */
	public void setVente(Commande vente) {
		this.vente = vente;
	}

	
	@PostConstruct
	public void init() {

		String value = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("idCommande");
		
		if(value != null){
			Integer idCommande = Integer.parseInt(value);
			if (idCommande != null) {
				
				vente = this.venteDao.findByPk(idCommande);
			}	
		}
		
		if (vente == null) {
			vente = new Commande();
		}
		if(mapMedic==null) {
			mapMedic=new HashMap<String, Integer>();
			for(Medicament med :vente.getMedicaments()){
				if(!mapMedic.containsKey(med.getNoMedicament()+" "+med.getLibelle()+" "+med.getPrix())){
					mapMedic.put(med.getNoMedicament()+" "+med.getLibelle()+" "+med.getPrix(), 1);
				} else {
					mapMedic.put(med.getNoMedicament()+" "+med.getLibelle()+" "+med.getPrix(), mapMedic.get(med.getNoMedicament()+"+"+med.getLibelle()+" "+med.getPrix()));
				}
			}
		}
		
		

	}

	
	public List<MedicamentDTO> completeMethod(String query) {
		List<MedicamentDTO> results = (new MedicamentDao()).findByLibelle(query);
        
        return results;
    }
	

	public String enregistrer() {
		this.getMedicament();
		if(vente.getNoCommande()!=null && vente.getNoCommande()>0) {
			//this.venteDao.update(vente);
		} else {
			//this.venteDao.create(vente);
		}
		
		return "listeVente?faces-redirect=true";
	}
	
	
	public void ajouterMedicament( Integer id, String libelle,Double prix) {
		if(!mapMedic.containsKey(id+" "+libelle+" "+prix)){
			mapMedic.put(id+" "+libelle+" "+prix, 1);
		} else {
			mapMedic.put(id+" "+libelle+" "+prix, mapMedic.get(id+" "+libelle+" "+prix)+1);
		}
		if(this.getVente().getMontantTotal()==null){
			this.getVente().setMontantTotal(prix);
		} else {
			this.getVente().setMontantTotal(this.getVente().getMontantTotal()+prix);
		}
		
	}

	/**
	 * @return the mapMedic
	 */
	public Map<String, Integer> getMapMedic() {
		return mapMedic;
	}

	/**
	 * @param mapMedic the mapMedic to set
	 */
	public void setMapMedic(Map<String, Integer> mapMedic) {
		this.mapMedic = mapMedic;
	}

	/**
	 * @return the medicament
	 */
	public MedicamentDTO getMedicament() {
		return medicament;
	}

	/**
	 * @param medicament the medicament to set
	 */
	public void setMedicament(MedicamentDTO medicament) {
		this.medicament = medicament;
	}

	/**
	 * @return the listeMedicament
	 */
	public List<MedicamentDTO> getListeMedicament() {
		return listeMedicament;
	}

	/**
	 * @param listeMedicament the listeMedicament to set
	 */
	public void setListeMedicament(List<MedicamentDTO> listeMedicament) {
		this.listeMedicament = listeMedicament;
	}

	
}
