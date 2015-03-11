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

import fr.mmm.pharmaware.dao.EmployeDao;
import fr.mmm.pharmaware.entity.Employe;

/**
 * @author mmbengue
 *
 */
@ManagedBean(name="listeEmployeBean")
@ViewScoped
public class ListeEmployeBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeDao employeDao;
	private List<Employe> employes;
	
	@PostConstruct
	public void init(){
		if(employeDao==null){
			employeDao = new EmployeDao();
		}
		if(employes==null){
			employes=this.employeDao.findAll();
		}
	}
	
	public void supprimer(Integer id){
		Employe emp=this.employeDao.findByPk(id);
		if(emp != null){
			
			this.employeDao.delete(emp);
			employes=this.employeDao.findAll();
		}
		
	}
	
	/**
	 * @return the listeEmploye
	 */
	public List<Employe> getEmployes() {
		return employes;
	}

	/**
	 * @param listeEmploye the listeEmploye to set
	 */
	public void setEmployes(List<Employe> listeEmploye) {
		this.employes = listeEmploye;
	}
	
	

}
