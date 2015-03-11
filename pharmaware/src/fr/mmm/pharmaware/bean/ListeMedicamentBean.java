/**
 * 
 */
package fr.mmm.pharmaware.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import fr.mmm.pharmaware.dao.MedicamentDao;
import fr.mmm.pharmaware.dto.MedicamentDTO;
import fr.mmm.pharmaware.entity.Medicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="listeMedicamentBean")
@ViewScoped
public class ListeMedicamentBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MedicamentDao medicamentDao;
	private List<MedicamentDTO> medicaments;
	
	@PostConstruct
	public void init(){
		if(medicamentDao==null){
			medicamentDao = new MedicamentDao();
		}
		if(medicaments==null){
			medicaments=this.medicamentDao.findAll();
		}
	}
	
	public void supprimer(Integer id){
		Medicament emp=this.medicamentDao.findByPk(id);
		if(emp != null){
			
			this.medicamentDao.delete(emp);
			medicaments=this.medicamentDao.findAll();
		}
		
	}
	
	/**
	 * @return the listeMedicament
	 */
	public List<MedicamentDTO> getMedicaments() {
		return medicaments;
	}

	/**
	 * @param listeMedicament the listeMedicament to set
	 */
	public void setMedicaments(List<MedicamentDTO> listeMedicament) {
		this.medicaments = listeMedicament;
	}
	
	

}
