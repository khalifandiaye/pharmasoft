/**
 * 
 */
package fr.mmm.pharmaware.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.mmm.pharmaware.dao.GenericDao;
import fr.mmm.pharmaware.dao.GenericDaoImpl;
import fr.mmm.pharmaware.entity.CategorieMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="categorieMedicamentBean")
@ViewScoped
public class CategorieMedicamentBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private GenericDao<CategorieMedicament, Integer> dao = new GenericDaoImpl<CategorieMedicament, Integer>(CategorieMedicament.class);
	
	private CategorieMedicament categorieMedicament ;

	
	/**
	 * @return the categorieMedicament
	 */
	public CategorieMedicament getCategorieMedicament() {
		return categorieMedicament;
	}


	/**
	 * @param categorieMedicament the categorieMedicament to set
	 */
	public void setCategorieMedicament(CategorieMedicament categorieMedicament) {
		this.categorieMedicament = categorieMedicament;
	}

	public void init(){
		
		String value=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCategorieMedicament");
		
		if(categorieMedicament == null) {
			categorieMedicament = new CategorieMedicament();
		}
		if(value != null) {
			Integer  idCategoriemedicament =Integer.parseInt(value );
			if(idCategoriemedicament != null)
			categorieMedicament=this.dao.findByPk(idCategoriemedicament);
		}
		
	}
	public String enregistrer(){
		
		if(categorieMedicament.getNoCategorieMedicament()!=null && categorieMedicament.getNoCategorieMedicament()<=0) {
			this.dao.update(categorieMedicament);
		} else {
			this.dao.create(categorieMedicament);
		}
		
		return "listeCategorieMedicament?faces-redirect=true";
	}

}
