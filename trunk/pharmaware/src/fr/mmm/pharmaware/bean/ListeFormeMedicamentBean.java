/**
 * 
 */
package fr.mmm.pharmaware.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.mmm.pharmaware.dao.GenericDao;
import fr.mmm.pharmaware.dao.GenericDaoImpl;
import fr.mmm.pharmaware.entity.FormeMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="listeFormeMedicamentBean")
@ViewScoped
public class ListeFormeMedicamentBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericDao<FormeMedicament, Integer> dao;
	private List<FormeMedicament> formeMedicaments;
	
	@PostConstruct
	public void init(){
		if(dao==null){
			dao = new GenericDaoImpl<FormeMedicament, Integer>(FormeMedicament.class);
		}
		if(formeMedicaments==null){
			formeMedicaments=this.dao.findAll();
		}
	}
	
	public void supprimer(Integer id){
		FormeMedicament forme=this.dao.findByPk(id);
		if(forme != null){
			
			this.dao.delete(forme);
			formeMedicaments=this.dao.findAll();
		}
		
	}
	
	/**
	 * @return the listeFormeMedicament
	 */
	public List<FormeMedicament> getFormeMedicaments() {
		return formeMedicaments;
	}

	/**
	 * @param listeFormeMedicament the listeFormeMedicament to set
	 */
	public void setFormeMedicaments(List<FormeMedicament> listeFormeMedicament) {
		this.formeMedicaments = listeFormeMedicament;
	}
	
	

}
