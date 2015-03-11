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
import fr.mmm.pharmaware.entity.ModeConsMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="listeModeConsMedicamentBean")
@ViewScoped
public class ListeModeConsMedicamentBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GenericDao<ModeConsMedicament, Integer> dao;
	private List<ModeConsMedicament> modeConsMedicaments;
	
	@PostConstruct
	public void init(){
		if(dao==null){
			dao = new GenericDaoImpl<ModeConsMedicament, Integer>(ModeConsMedicament.class);
		}
		if(modeConsMedicaments==null){
			modeConsMedicaments=this.dao.findAll();
		}
	}
	
	public void supprimer(Integer id){
		ModeConsMedicament modeCons=this.dao.findByPk(id);
		if(modeCons != null){
			
			this.dao.delete(modeCons);
			modeConsMedicaments=this.dao.findAll();
		}
		
	}
	
	/**
	 * @return the listeModeConsMedicament
	 */
	public List<ModeConsMedicament> getModeConsMedicaments() {
		return modeConsMedicaments;
	}

	/**
	 * @param listeModeConsMedicament the listeModeConsMedicament to set
	 */
	public void setModeConsMedicaments(List<ModeConsMedicament> listeModeConsMedicament) {
		this.modeConsMedicaments = listeModeConsMedicament;
	}
	
	

}
