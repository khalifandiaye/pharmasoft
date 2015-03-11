package fr.mmm.pharmaware.dto;

import java.io.Serializable;

/**
 * Permet l'affichage des listes de valeurs dans les IHM.
 */
public class ComboBoxDTO implements Serializable {

    // Start of user code : emplacement de definition des attributs non generes du dto
    // End of user code

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Label a afficher.
     */
    private String label;

    /**
     * Identifiant.
     */
    private Integer value;

    /**
     * Retourne la valeur de label.
     * 
     * @return valeur de label.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Definit la valeur de label.
     * 
     * @param label
     *            valeur de label a definir.
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /**
     * Retourne la valeur de value.
     * 
     * @return valeur de value.
     */
    public Integer getValue() {
        return this.value;
    }

    /**
     * Definit la valeur de value.
     * 
     * @param value
     *            valeur de value a definir.
     */
    public void setValue(final Integer value) {
        this.value = value;
    }

    @Override
	public String toString() {
		return this.label;
	}

	// Start of user code : emplacement de definition des methodes non generees du dto
    public ComboBoxDTO(final String label, final Integer value) {
        this.label = label;
        this.value = value;
    }

    public ComboBoxDTO() {
        super();
    }
    // End of user code
}
