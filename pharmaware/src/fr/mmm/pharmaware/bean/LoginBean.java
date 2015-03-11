package fr.mmm.pharmaware.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.mmm.pharmaware.dao.EmployeDao;
import fr.mmm.pharmaware.entity.Employe;


/**
 * Simple login bean.
 * 
 * @author itcuties
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 7765876811740798583L;

	
	
	private String username;
	private String password;
	private Employe employeConnecte;
	
	private boolean loggedIn;

	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
	
	/**
	 * Login operation.
	 * @return
	 */
	public String doLogin() {
		// Get every user from our sample database :)
		
			
			EmployeDao employeDao=new EmployeDao();
			employeConnecte=employeDao.findByIdentifiants(username, password);
			// Successful login
			if (employeConnecte != null) {
				loggedIn = true;
				return navigationBean.redirectToWelcome();
			}
		// Set login ERROR
		FacesMessage msg = new FacesMessage("Erreur de connexion!", "Erreur de connexion");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
		// To to login page
		return navigationBean.toLogin();
		
	}
	
	/**
	 * Logout operation.
	 * @return
	 */
	public String doLogout() {
		// Set the paremeter indicating that user is logged in to false
		loggedIn = false;
		employeConnecte=null;
		// Set logout message
		FacesMessage msg = new FacesMessage("Déconnexion avec succés!", "Message d'information");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return navigationBean.toLogin();
	}

	// ------------------------------
	// Getters & Setters 
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	/**
	 * @return the employeConnecte
	 */
	public Employe getEmployeConnecte() {
		return employeConnecte;
	}

	/**
	 * @param employeConnecte the employeConnecte to set
	 */
	public void setEmployeConnecte(Employe employeConnecte) {
		this.employeConnecte = employeConnecte;
	}
	
}
