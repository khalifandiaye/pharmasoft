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

import fr.mmm.pharmaware.dao.TypeMedicamentDao;
import fr.mmm.pharmaware.entity.TypeMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="listeTypeMedicamentBean")
@ViewScoped
public class ListeTypeMedicamentBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TypeMedicamentDao typeMedicamentDao;
	private List<TypeMedicament> typeMedicaments;
	
	@PostConstruct
	public void init(){
		if(typeMedicamentDao==null){
			typeMedicamentDao = new TypeMedicamentDao();
		}
		if(typeMedicaments==null){
			typeMedicaments=this.typeMedicamentDao.findAll();
		}
	}
	
	public void supprimer(Integer id){
		TypeMedicament type=this.typeMedicamentDao.findByPk(id);
		if(type != null){
			
			this.typeMedicamentDao.delete(type);
			typeMedicaments=this.typeMedicamentDao.findAll();
		}
		
	}
	
	/**
	 * @return the listeTypeMedicament
	 */
	public List<TypeMedicament> getTypeMedicaments() {
		return typeMedicaments;
	}

	/**
	 * @param listeTypeMedicament the listeTypeMedicament to set
	 */
	public void setTypeMedicaments(List<TypeMedicament> listeTypeMedicament) {
		this.typeMedicaments = listeTypeMedicament;
	}
	
	

}
