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
import fr.mmm.pharmaware.entity.CategorieMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="listeCategorieMedicamentBean")
@ViewScoped
public class ListeCategorieMedicamentBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GenericDao<CategorieMedicament, Integer> dao;
	private List<CategorieMedicament> categorieMedicaments;
	
	@PostConstruct
	public void init(){
		if(dao==null){
			dao = new GenericDaoImpl<CategorieMedicament, Integer>(CategorieMedicament.class);
		}
		if(categorieMedicaments==null){
			categorieMedicaments=this.dao.findAll();
		}
	}
	
	public void supprimer(Integer id){
		CategorieMedicament categorie=this.dao.findByPk(id);
		if(categorie != null){
			
			this.dao.delete(categorie);
			categorieMedicaments=this.dao.findAll();
		}
		
	}
	
	/**
	 * @return the listeCategorieMedicament
	 */
	public List<CategorieMedicament> getCategorieMedicaments() {
		return categorieMedicaments;
	}

	/**
	 * @param listeCategorieMedicament the listeCategorieMedicament to set
	 */
	public void setCategorieMedicaments(List<CategorieMedicament> listeCategorieMedicament) {
		this.categorieMedicaments = listeCategorieMedicament;
	}
	
	

}
