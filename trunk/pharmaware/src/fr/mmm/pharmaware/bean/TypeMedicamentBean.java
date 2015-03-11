/**
 * 
 */
package fr.mmm.pharmaware.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.mmm.pharmaware.dao.TypeMedicamentDao;
import fr.mmm.pharmaware.entity.TypeMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="typeMedicamentBean")
@ViewScoped
public class TypeMedicamentBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TypeMedicamentDao typeMedicamentDao = new TypeMedicamentDao();
	
	private TypeMedicament typeMedicament ;

	
	/**
	 * @return the typeMedicament
	 */
	public TypeMedicament getTypeMedicament() {
		return typeMedicament;
	}


	/**
	 * @param typeMedicament the typeMedicament to set
	 */
	public void setTypeMedicament(TypeMedicament typeMedicament) {
		this.typeMedicament = typeMedicament;
	}

	public void init(){
		
		String value=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTypeMedicament");
		
		if(typeMedicament == null) {
			typeMedicament = new TypeMedicament();
		}
		if(value != null) {
			Integer  idTypemedicament =Integer.parseInt(value );
			if(idTypemedicament != null)
			typeMedicament=this.typeMedicamentDao.findByPk(idTypemedicament);
		}
		
	}
	public String enregistrer(){
		
		if(typeMedicament.getNoTypeMedicament()!=null && typeMedicament.getNoTypeMedicament()>0) {
			this.typeMedicamentDao.update(typeMedicament);
		} else {
			this.typeMedicamentDao.create(typeMedicament);
		}
		
		return "listeTypeMedicament?faces-redirect=true";
	}

}
