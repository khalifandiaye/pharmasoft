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
import fr.mmm.pharmaware.entity.ModeAdminMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="modeAdminMedicamentBean")
@ViewScoped
public class ModeAdminMedicamentBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GenericDao<ModeAdminMedicament, Integer> dao = new GenericDaoImpl<ModeAdminMedicament, Integer>(ModeAdminMedicament.class);
	
	private ModeAdminMedicament modeAdminMedicament ;

	
	/**
	 * @return the modeAdminMedicament
	 */
	public ModeAdminMedicament getModeAdminMedicament() {
		return modeAdminMedicament;
	}


	/**
	 * @param modeAdminMedicament the modeAdminMedicament to set
	 */
	public void setModeAdminMedicament(ModeAdminMedicament modeAdminMedicament) {
		this.modeAdminMedicament = modeAdminMedicament;
	}

	public void init(){
		
		String value=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idModeAdminMedicament");
		
		if(modeAdminMedicament == null) {
			modeAdminMedicament = new ModeAdminMedicament();
		}
		if(value != null) {
			Integer  idModeAdminmedicament =Integer.parseInt(value );
			if(idModeAdminmedicament != null)
			modeAdminMedicament=this.dao.findByPk(idModeAdminmedicament);
		}
		
	}
	public String enregistrer(){
		
		if(modeAdminMedicament.getNoModeAdminMedicament()!=null && modeAdminMedicament.getNoModeAdminMedicament()>0) {
			this.dao.update(modeAdminMedicament);
		} else {
			this.dao.create(modeAdminMedicament);
		}
		
		return "listeModeAdminMedicament?faces-redirect=true";
	}

}
