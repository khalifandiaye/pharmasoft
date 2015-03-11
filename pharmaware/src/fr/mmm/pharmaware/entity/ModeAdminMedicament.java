package fr.mmm.pharmaware.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author MBENGUE-M
 * @version 1.0
 * @created 29-oct.-2013 17:28:05
 */

@Entity
@Table(name="mode_admin_medicament")
public class ModeAdminMedicament implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer noModeAdminMedicament;
	@Column(name="libelle")
	private String libelle;
	
	
	public ModeAdminMedicament(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public String getLibelle(){
		return libelle;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setLibelle(String newVal){
		libelle = newVal;
	}

	public Integer getNoModeAdminMedicament(){
		return noModeAdminMedicament;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setNoModeAdminMedicament(Integer newVal){
		noModeAdminMedicament = newVal;
	}

	@Override
	public String toString() {
		return "ModeAdminMedicament [noModeAdminMedicament=" + noModeAdminMedicament
				+ ", libelle=" + libelle + "]";
	}
	

}