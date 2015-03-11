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
import fr.mmm.pharmaware.entity.ModeConsMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="modeConsMedicamentBean")
@ViewScoped
public class ModeConsMedicamentBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GenericDao<ModeConsMedicament, Integer> dao = new GenericDaoImpl<ModeConsMedicament, Integer>(ModeConsMedicament.class);
	
	private ModeConsMedicament modeConsMedicament ;

	
	/**
	 * @return the modeConsMedicament
	 */
	public ModeConsMedicament getModeConsMedicament() {
		return modeConsMedicament;
	}


	/**
	 * @param modeConsMedicament the modeConsMedicament to set
	 */
	public void setModeConsMedicament(ModeConsMedicament modeConsMedicament) {
		this.modeConsMedicament = modeConsMedicament;
	}

	public void init(){
		
		String value=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idModeConsMedicament");
		
		if(modeConsMedicament == null) {
			modeConsMedicament = new ModeConsMedicament();
		}
		if(value != null) {
			Integer  idModeConsmedicament =Integer.parseInt(value );
			if(idModeConsmedicament != null)
			modeConsMedicament=this.dao.findByPk(idModeConsmedicament);
		}
		
	}
	public String enregistrer(){
		
		if(modeConsMedicament.getNoModeConsMedicament()!=null && modeConsMedicament.getNoModeConsMedicament()>0) {
			this.dao.update(modeConsMedicament);
		} else {
			this.dao.create(modeConsMedicament);
		}
		
		return "listeModeConsMedicament?faces-redirect=true";
	}

}
