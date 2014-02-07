package fr.mmm.pharmaSoft.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;




public class LanceurMenuMulticolore extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LanceurMenuMulticolore() {
		
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		List<ElementMenu> items = new ArrayList<ElementMenu>();
		items.add(new ElementMenu("Médicament", new Color(244, 70, 97), new Color(162, 198, 232), 100,"medicament"));
		items.add(new ElementMenu("Employé", new Color(40, 40, 40), new Color(162, 198, 232), 100, "employe"));
		items.add(new ElementMenu("Type Médicament", new Color(245, 124, 3), new Color(162, 198, 232), 100, "typeMedicament"));
		items.add(new ElementMenu("Stock", new Color(90, 37, 180), new Color(162, 198, 232), 100, "stock"));
		items.add(new ElementMenu("Commandes", new Color(194, 186, 18), new Color(162, 198, 232), 100, "commandes"));
		//items.add(new ElementMenu("Contacts", new Color(15, 88, 149), new Color(162, 198, 232), 100, ""));
		//items.add(new ElementMenu("Journal", new Color(84, 170, 47), new Color(162, 198, 232), 100, ""));
		setSize(600, 600);
		add(new MenuCirculaire(Color.BLACK, 2*292, 2*266, 150, 100, items), BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
