/**
 * 
 */
package fr.mmm.pharmaware.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.mmm.pharmaware.dao.GenericDaoImpl;
import fr.mmm.pharmaware.dao.MedicamentDao;
import fr.mmm.pharmaware.dao.TypeMedicamentDao;
import fr.mmm.pharmaware.entity.CategorieMedicament;
import fr.mmm.pharmaware.entity.FormeMedicament;
import fr.mmm.pharmaware.entity.ListeMedicament;
import fr.mmm.pharmaware.entity.Medicament;
import fr.mmm.pharmaware.entity.ModeAdminMedicament;
import fr.mmm.pharmaware.entity.ModeConsMedicament;
import fr.mmm.pharmaware.entity.TypeMedicament;

/**
 * @author mmbengue
 * 
 */
@ManagedBean(name = "medicamentBean")
@ViewScoped
public class MedicamentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	

	private MedicamentDao medicamentDao = new MedicamentDao();
	
	private TypeMedicamentDao typeMedicamentDao = new TypeMedicamentDao();

	private Medicament medicament ;
	
	private List<TypeMedicament> listeTypeMedicaments;
	/**
	 * @return the listeTypeMedicaments
	 */
	public List<TypeMedicament> getListeTypeMedicaments() {
		return listeTypeMedicaments;
	}

	/**
	 * @param listeTypeMedicaments the listeTypeMedicaments to set
	 */
	public void setListeTypeMedicaments(List<TypeMedicament> listeTypeMedicaments) {
		this.listeTypeMedicaments = listeTypeMedicaments;
	}

	/**
	 * @return the listeListeMedicament
	 */
	public List<ListeMedicament> getListeListeMedicament() {
		return listeListeMedicament;
	}

	/**
	 * @param listeListeMedicament the listeListeMedicament to set
	 */
	public void setListeListeMedicament(List<ListeMedicament> listeListeMedicament) {
		this.listeListeMedicament = listeListeMedicament;
	}

	/**
	 * @return the listeCategorie
	 */
	public List<CategorieMedicament> getListeCategorie() {
		return listeCategorie;
	}

	/**
	 * @param listeCategorie the listeCategorie to set
	 */
	public void setListeCategorie(List<CategorieMedicament> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	/**
	 * @return the listeForme
	 */
	public List<FormeMedicament> getListeForme() {
		return listeForme;
	}

	/**
	 * @param listeForme the listeForme to set
	 */
	public void setListeForme(List<FormeMedicament> listeForme) {
		this.listeForme = listeForme;
	}

	/**
	 * @return the listeModeAdmin
	 */
	public List<ModeAdminMedicament> getListeModeAdmin() {
		return listeModeAdmin;
	}

	/**
	 * @param listeModeAdmin the listeModeAdmin to set
	 */
	public void setListeModeAdmin(List<ModeAdminMedicament> listeModeAdmin) {
		this.listeModeAdmin = listeModeAdmin;
	}

	/**
	 * @return the listeModeConserv
	 */
	public List<ModeConsMedicament> getListeModeConserv() {
		return listeModeConserv;
	}

	/**
	 * @param listeModeConserv the listeModeConserv to set
	 */
	public void setListeModeConserv(List<ModeConsMedicament> listeModeConserv) {
		this.listeModeConserv = listeModeConserv;
	}

	private List<ListeMedicament> listeListeMedicament;
	private List<CategorieMedicament> listeCategorie;
	private List<FormeMedicament> listeForme;
	private List<ModeAdminMedicament> listeModeAdmin;
	private List<ModeConsMedicament> listeModeConserv;
	

	public void init() {

		String value = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("idMedicament");
		
		
		
		listeTypeMedicaments= (new GenericDaoImpl<TypeMedicament, Integer>(TypeMedicament.class)).findAll();
		listeCategorie= (new GenericDaoImpl<CategorieMedicament, Integer>(CategorieMedicament.class)).findAll();
		listeForme= (new GenericDaoImpl<FormeMedicament, Integer>(FormeMedicament.class)).findAll();
		listeModeAdmin= (new GenericDaoImpl<ModeAdminMedicament, Integer>(ModeAdminMedicament.class)).findAll();
		listeModeConserv= (new GenericDaoImpl<ModeConsMedicament, Integer>(ModeConsMedicament.class)).findAll();
		listeListeMedicament= (new GenericDaoImpl<ListeMedicament, Integer>(ListeMedicament.class)).findAll();
		
		
		if(value != null){
			Integer idMedicament = Integer.parseInt(value);
			if (idMedicament != null) {
				
				medicament = this.medicamentDao.findByPk(idMedicament);
			}	
		}
		
		if (medicament == null) {
			medicament = new Medicament();
		}
		if(medicament.getListe()==null) {
			medicament.setListe(new ListeMedicament());
		}
		if(medicament.getCategorie()==null) {
			medicament.setCategorie(new CategorieMedicament());
		}
		if(medicament.getFormeMedicament()==null) {
			medicament.setFormeMedicament(new FormeMedicament());
		}
		if(medicament.getModeAdministration()==null) {
			medicament.setModeAdministration(new ModeAdminMedicament());
		}
		if(medicament.getModeConservation()==null) {
			medicament.setModeConservation(new ModeConsMedicament());
		}
		if(medicament.getType()==null) {
			medicament.setType(new TypeMedicament());
		}
		

	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public String enregistrer() {
		if(medicament.getListe().getNoListeMedicament()==null || medicament.getListe().getNoListeMedicament() <= 0) {
			medicament.setListe(null);
		}
		if(medicament.getCategorie().getNoCategorieMedicament()==null || medicament.getCategorie().getNoCategorieMedicament() <=0) {
			medicament.setCategorie(null);
		}
		if(medicament.getFormeMedicament().getNoFormeMedicament()==null || medicament.getFormeMedicament().getNoFormeMedicament() <=0) {
			medicament.setFormeMedicament(null);
		}
		if(medicament.getModeAdministration().getNoModeAdminMedicament()==null || medicament.getModeAdministration().getNoModeAdminMedicament() <= 0) {
			medicament.setModeAdministration(null);
		}
		if(medicament.getModeConservation().getNoModeConsMedicament()==null || medicament.getModeConservation().getNoModeConsMedicament() <= 0) {
			medicament.setModeConservation(null);
		}
		if(medicament.getType().getNoTypeMedicament()==null || medicament.getType().getNoTypeMedicament() <= 0) {
			medicament.setType(null);
		}
		
		
		if(medicament.getNoMedicament()!=null && medicament.getNoMedicament()>0) {
			this.medicamentDao.update(medicament);
		} else {
			this.medicamentDao.create(medicament);
		}
		
		return "listeMedicament?faces-redirect=true";
	}

	
}
