package fr.mmm.pharmaSoft.presentation;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.mmm.pharmaSoft.views.TypeMedicamentFenetre;

public class TypeMedicamentAction extends AbstractAction{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  TypeMedicamentFenetre typemedFenetre;
	private String typeAction;
	
	public TypeMedicamentAction(TypeMedicamentFenetre typemedFenetre, String typeAction){
		this.setMedFenetre(typemedFenetre);
		this.setTypeAction(typeAction);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(this.getTypeAction().equals("creer")) {
			this.creer(this.typemedFenetre);
		} else if(this.getTypeAction().equals("modifier")){
			this.modifier(this.typemedFenetre);
		}
		
	}

	private void modifier(TypeMedicamentFenetre medFenetre2) {
		// TODO Auto-generated method stub
		
	}


	private void creer(TypeMedicamentFenetre medFenetre2) {
		// TODO Auto-generated method stub
		
	}


	public TypeMedicamentFenetre getMedFenetre() {
		return typemedFenetre;
	}

	public void setMedFenetre(TypeMedicamentFenetre typemedFenetre) {
		this.typemedFenetre = typemedFenetre;
	}


	public String getTypeAction() {
		return typeAction;
	}


	public void setTypeAction(String typeAction) {
		this.typeAction = typeAction;
	}
	
	
	

}
