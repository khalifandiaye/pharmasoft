package fr.mmm.pharmaware.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Simple navigation bean
 * @author itcuties
 *
 */
@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 1520318172495977648L;

	/**
	 * Redirect to login page.
	 * @return Login page name.
	 */
	public String redirectToLogin() {
		return "/login.xhtml?faces-redirect=true";
	}
	
	/**
	 * Go to login page.
	 * @return Login page name.
	 */
	public String toLogin() {
		return "/login.xhtml";
	}
	
	/**
	 * Redirect to info page.
	 * @return Info page name.
	 */
	public String redirectToInfo() {
		return "/info.xhtml?faces-redirect=true";
	}
	
	/**
	 * Go to info page.
	 * @return Info page name.
	 */
	public String toInfo() {
		return "/info.xhtml";
	}
	
	/**
	 * Redirect to welcome page.
	 * @return Welcome page name.
	 */
	public String redirectToWelcome() {
		return "/pages/medicament/listeMedicament.xhtml?faces-redirect=true";
	}
	
	/**
	 * Go to welcome page.
	 * @return Welcome page name.
	 */
	public String toWelcome() {
		return "/pages/medicament/listeMedicament.xhtml";
	}
	
}
