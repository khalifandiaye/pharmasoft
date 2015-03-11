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
@Table(name="mode_cons_medicament")
public class ModeConsMedicament implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer noModeConsMedicament;
	@Column(name="libelle")
	private String libelle;
	
	
	public ModeConsMedicament(){

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

	public Integer getNoModeConsMedicament(){
		return noModeConsMedicament;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setNoModeConsMedicament(Integer newVal){
		noModeConsMedicament = newVal;
	}

	@Override
	public String toString() {
		return "ModeConsMedicament [noModeConsMedicament=" + noModeConsMedicament
				+ ", libelle=" + libelle + "]";
	}
	

}