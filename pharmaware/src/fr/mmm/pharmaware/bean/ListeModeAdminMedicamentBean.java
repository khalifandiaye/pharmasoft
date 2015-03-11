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

import fr.mmm.pharmaware.dao.GenericDao;
import fr.mmm.pharmaware.dao.GenericDaoImpl;
import fr.mmm.pharmaware.entity.ModeAdminMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="listeModeAdminMedicamentBean")
@ViewScoped
public class ListeModeAdminMedicamentBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericDao<ModeAdminMedicament, Integer> dao;
	private List<ModeAdminMedicament> modeAdminMedicaments;
	
	@PostConstruct
	public void init(){
		if(dao==null){
			dao = new GenericDaoImpl<ModeAdminMedicament, Integer>(ModeAdminMedicament.class);
		}
		if(modeAdminMedicaments==null){
			modeAdminMedicaments=this.dao.findAll();
		}
	}
	
	public void supprimer(Integer id){
		ModeAdminMedicament modeAdmin=this.dao.findByPk(id);
		if(modeAdmin != null){
			
			this.dao.delete(modeAdmin);
			modeAdminMedicaments=this.dao.findAll();
		}
		
	}
	
	/**
	 * @return the listeModeAdminMedicament
	 */
	public List<ModeAdminMedicament> getModeAdminMedicaments() {
		return modeAdminMedicaments;
	}

	/**
	 * @param listeModeAdminMedicament the listeModeAdminMedicament to set
	 */
	public void setModeAdminMedicaments(List<ModeAdminMedicament> listeModeAdminMedicament) {
		this.modeAdminMedicaments = listeModeAdminMedicament;
	}
	
	

}
