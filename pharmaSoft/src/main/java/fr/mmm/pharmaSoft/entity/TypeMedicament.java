package fr.mmm.pharmaSoft.entity;



/**
 * @author MBENGUE-M
 * @version 1.0
 * @created 29-oct.-2013 17:28:05
 */
public class TypeMedicament {

	private int noTypeMedicament;
	private int libelle;

	public TypeMedicament(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public int getLibelle(){
		return libelle;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setLibelle(int newVal){
		libelle = newVal;
	}

	public int getNoTypeMedicament(){
		return noTypeMedicament;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setNoTypeMedicament(int newVal){
		noTypeMedicament = newVal;
	}

}