package fr.mmm.pharmaware.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * @author MBENGUE-M
 * @version 1.0
 * @created 29-oct.-2013 17:28:05
 */

@Entity
@Table(name="type_medicament")
public class TypeMedicament implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer noTypeMedicament;
	@Column(name="libelle")
	private String libelle;
	
	
	public TypeMedicament(){

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

	public Integer getNoTypeMedicament(){
		return noTypeMedicament;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setNoTypeMedicament(Integer newVal){
		noTypeMedicament = newVal;
	}
	
	

	@Override
	public String toString() {
		return "TypeMedicament [noTypeMedicament=" + noTypeMedicament
				+ ", libelle=" + libelle + "]";
	}	/**
	 * @return the medicaments
	 */
	
}