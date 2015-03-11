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
@Table(name="forme_medicament")
public class FormeMedicament implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer noFormeMedicament;
	@Column(name="libelle")
	private String libelle;
	
	
	public FormeMedicament(){

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

	public Integer getNoFormeMedicament(){
		return noFormeMedicament;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setNoFormeMedicament(Integer newVal){
		noFormeMedicament = newVal;
	}

	@Override
	public String toString() {
		return "FormeMedicament [noFormeMedicament=" + noFormeMedicament
				+ ", libelle=" + libelle + "]";
	}
	

}