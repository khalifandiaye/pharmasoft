package fr.mmm.pharmaware.bean;

public class ResumeVente {

	
	private String libelleMedicament;
	private Double prix;
	
	public ResumeVente(String libelleMedicament, Double prix, Integer nombre) {
		super();
		this.libelleMedicament = libelleMedicament;
		this.prix = prix;
		this.nombre = nombre;
	}
	/**
	 * @return the libelleMedicament
	 */
	public String getLibelleMedicament() {
		return libelleMedicament;
	}
	/**
	 * @param libelleMedicament the libelleMedicament to set
	 */
	public void setLibelleMedicament(String libelleMedicament) {
		this.libelleMedicament = libelleMedicament;
	}
	/**
	 * @return the prix
	 */
	public Double getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	/**
	 * @return the nombre
	 */
	public Integer getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}
	private Integer nombre;
}
