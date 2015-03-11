/**
 * 
 */
package fr.mmm.pharmaware.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.mmm.pharmaware.dao.EmployeDao;
import fr.mmm.pharmaware.entity.Employe;

/**
 * @author mmbengue
 * 
 */
@ManagedBean(name = "employeBean")
@ViewScoped
public class EmployeBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	private EmployeDao employeDao = new EmployeDao();

	private Employe employe = new Employe();

	public void init() {

		String value = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("idEmploye");
		if (employe == null) {
			employe = new Employe();
		}
		if(value != null){
			Integer idEmploye = Integer.parseInt(value);
			if (idEmploye != null) {
				employe = this.employeDao.findByPk(idEmploye);
			}	
		}
		

	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String enregistrer() {
		if(employe.getNoEmploye()!=null && employe.getNoEmploye()>0) {
			this.employeDao.update(employe);
		} else {
			this.employeDao.create(employe);
		}
		
		return "listeEmploye?faces-redirect=true";
	}

}
