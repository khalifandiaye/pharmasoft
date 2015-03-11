/**
 * 
 */
package fr.mmm.pharmaware.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.mmm.pharmaware.dao.GenericDao;
import fr.mmm.pharmaware.dao.GenericDaoImpl;
import fr.mmm.pharmaware.entity.FormeMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="formeMedicamentBean")
@ViewScoped
public class FormeMedicamentBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private GenericDao<FormeMedicament, Integer> dao = new GenericDaoImpl<FormeMedicament, Integer>(FormeMedicament.class);
	
	private FormeMedicament formeMedicament ;

	
	/**
	 * @return the formeMedicament
	 */
	public FormeMedicament getFormeMedicament() {
		return formeMedicament;
	}


	/**
	 * @param formeMedicament the formeMedicament to set
	 */
	public void setFormeMedicament(FormeMedicament formeMedicament) {
		this.formeMedicament = formeMedicament;
	}

	public void init(){
		
		String value=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFormeMedicament");
		
		if(formeMedicament == null) {
			formeMedicament = new FormeMedicament();
		}
		if(value != null) {
			Integer  idFormemedicament =Integer.parseInt(value );
			if(idFormemedicament != null)
			formeMedicament=this.dao.findByPk(idFormemedicament);
		}
		
	}
	public String enregistrer(){
		
		if(formeMedicament.getNoFormeMedicament()!=null && formeMedicament.getNoFormeMedicament()>0) {
			this.dao.update(formeMedicament);
		} else {
			this.dao.create(formeMedicament);
		}
		
		return "listeFormeMedicament?faces-redirect=true";
	}

}
