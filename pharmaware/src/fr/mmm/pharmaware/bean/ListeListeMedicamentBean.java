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
import fr.mmm.pharmaware.entity.ListeMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="listeListeMedicamentBean")
@ViewScoped

public class ListeListeMedicamentBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericDao<ListeMedicament, Integer> dao;
	private List<ListeMedicament> listeMedicaments;
	
	@PostConstruct
	public void init(){
		if(dao==null){
			dao = new GenericDaoImpl<ListeMedicament, Integer>(ListeMedicament.class);
		}
		if(listeMedicaments==null){
			listeMedicaments=this.dao.findAll();
		}
	}
	
	public void supprimer(Integer id){
		ListeMedicament liste=this.dao.findByPk(id);
		if(liste != null){
			
			this.dao.delete(liste);
			listeMedicaments=this.dao.findAll();
		}
		
	}
	
	/**
	 * @return the listeListeMedicament
	 */
	public List<ListeMedicament> getListeMedicaments() {
		return listeMedicaments;
	}

	/**
	 * @param listeListeMedicament the listeListeMedicament to set
	 */
	public void setListeMedicaments(List<ListeMedicament> listeListeMedicament) {
		this.listeMedicaments = listeListeMedicament;
	}
	
	

}
