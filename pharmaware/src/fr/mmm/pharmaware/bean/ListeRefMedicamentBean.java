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
import fr.mmm.pharmaware.entity.ListeMedicament;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="listeRefMedicamentBean")
@ViewScoped
public class ListeRefMedicamentBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GenericDao<ListeMedicament, Integer> dao = new GenericDaoImpl<ListeMedicament, Integer>(ListeMedicament.class);
	
	private ListeMedicament listeMedicament ;

	
	/**
	 * @return the listeMedicament
	 */
	public ListeMedicament getListeMedicament() {
		return listeMedicament;
	}


	/**
	 * @param listeMedicament the listeMedicament to set
	 */
	public void setListeMedicament(ListeMedicament listeMedicament) {
		this.listeMedicament = listeMedicament;
	}

	public void init(){
		
		String value=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idListeMedicament");
		
		if(listeMedicament == null) {
			listeMedicament = new ListeMedicament();
		}
		if(value != null) {
			Integer  idListemedicament =Integer.parseInt(value );
			if(idListemedicament != null)
			listeMedicament=this.dao.findByPk(idListemedicament);
		}
		
	}
	public String enregistrer(){
		
		if(listeMedicament.getNoListeMedicament()!=null && listeMedicament.getNoListeMedicament()>0) {
			this.dao.update(listeMedicament);
		} else {
			this.dao.create(listeMedicament);
		}
		
		return "listeListeMedicament?faces-redirect=true";
	}

}
