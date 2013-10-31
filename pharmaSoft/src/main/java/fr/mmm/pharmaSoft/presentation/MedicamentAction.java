package fr.mmm.pharmaSoft.presentation;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.mmm.pharmaSoft.views.MedicamentFenetre;

public class MedicamentAction extends AbstractAction{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  MedicamentFenetre medFenetre;
	private String typeAction;
	
	public MedicamentAction(MedicamentFenetre medFenetre, String typeAction){
		this.setMedFenetre(medFenetre);
		this.setTypeAction(typeAction);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(this.getTypeAction().equals("creer")) {
			this.creer(this.medFenetre);
		} else if(this.getTypeAction().equals("modifier")){
			this.modifier(this.medFenetre);
		}
		
	}

	private void modifier(MedicamentFenetre medFenetre2) {
		// TODO Auto-generated method stub
		
	}


	private void creer(MedicamentFenetre medFenetre2) {
		// TODO Auto-generated method stub
		
	}


	public MedicamentFenetre getMedFenetre() {
		return medFenetre;
	}

	public void setMedFenetre(MedicamentFenetre medFenetre) {
		this.medFenetre = medFenetre;
	}


	public String getTypeAction() {
		return typeAction;
	}


	public void setTypeAction(String typeAction) {
		this.typeAction = typeAction;
	}
	
	
	

}
