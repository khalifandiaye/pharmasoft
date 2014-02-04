package fr.mmm.pharmaSoft.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;




public class LanceurMenuBleu {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		List<ElementMenu> items = new ArrayList<ElementMenu>();
		items.add(new ElementMenu("Médicament", new Color(19, 73, 140), new Color(162, 198, 232), 100, "medicament"));
		items.add(new ElementMenu("Employé", new Color(19, 73, 140), new Color(162, 198, 232), 100,"employe"));
		items.add(new ElementMenu("Stock", new Color(19, 73, 140), new Color(162, 198, 232), 100, "stock"));
		items.add(new ElementMenu("Menu4", new Color(19, 73, 140), new Color(162, 198, 232), 100,""));
		items.add(new ElementMenu("Menu5", new Color(19, 73, 140), new Color(162, 198, 232), 100,""));
		items.add(new ElementMenu("Menu6", new Color(19, 73, 140), new Color(162, 198, 232), 100,""));
		items.add(new ElementMenu("Menu7", new Color(19, 73, 140), new Color(162, 198, 232), 100, ""));
		f.setSize(600, 600);
		f.add(new MenuCirculaire(new Color(66, 139, 230), 2*292, 2*266, 100, 100, items), BorderLayout.CENTER);
		
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
