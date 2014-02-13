package fr.mmm.pharmaSoft.commun;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fr.mmm.pharmaSoft.views.MedicamentFenetre;

public class MenuUtils implements ActionListener, ItemListener{

	public MenuUtils() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JPanel createContentPane()
    {
        JPanel totalGUI = new JPanel();
        totalGUI.setBackground(Color.white);
        totalGUI.setMinimumSize(new Dimension(300, 200));
        totalGUI.setPreferredSize(new Dimension(300, 200));
        totalGUI.setMaximumSize(new Dimension(300, 200));
        
        totalGUI.setOpaque(true);
        return totalGUI;
    }

	
	 public JMenuBar createMenuBar()
	    {
	        //Create the menu bar.
	        JMenuBar menuBar = new JMenuBar();

	        //Add a JMenu
	        JMenu medicaments = new JMenu("Gestion des Medicaments");
	        JMenu ventes = new JMenu("Gestion des ventes");
	        JMenu stocks = new JMenu("Gestion du stock"); 
	        JMenu employes = new JMenu("Gestion des employés"); 

	        menuBar.add(medicaments);
	        menuBar.add(ventes);
	        menuBar.add(stocks);
	        menuBar.add(employes);

	        
	        // Now we want to fill each of the menus.
	        // Starters. This is a simple Menu, with three MenuItems.
	        
	        JMenuItem ajoutMedicament = new JMenuItem("Ajout d'un médicament");
	        JMenuItem listeMedicament = new JMenuItem("Liste des médicaments");
	        JMenuItem suppressionMedicament = new JMenuItem("Suppression d'un médicament");
	        
	        ajoutMedicament.setActionCommand("ajoutMedicament");
	        ajoutMedicament.addActionListener(this);
	        medicaments.add(ajoutMedicament);
	        medicaments.add(listeMedicament);
	        medicaments.add(suppressionMedicament);
	        
	        
	        JMenuItem ajoutStock = new JMenuItem("Ajout d'un stock");
	        JMenuItem listeStock = new JMenuItem("Liste des stocks");
	        JMenuItem suppressionStock = new JMenuItem("Suppression d'un stock");
	        
	        stocks.add(ajoutStock);
	        stocks.add(listeStock);
	        stocks.add(suppressionStock);
	        
	        JMenuItem ajoutEmploye = new JMenuItem("Ajout d'un employé");
	        JMenuItem listeEmploye = new JMenuItem("Liste des employés");
	        JMenuItem suppressionEmploye = new JMenuItem("Suppression d'un employé");
	        
	        employes.add(ajoutEmploye);
	        employes.add(listeEmploye);
	        employes.add(suppressionEmploye);
	        
	        JMenuItem ajoutCommande = new JMenuItem("Ajout d'une commande");
	        JMenuItem listeCommande = new JMenuItem("Liste des commandes");
	        JMenuItem suppressionCommande = new JMenuItem("Suppression d'une commande");
	        
	        ventes.add(ajoutCommande);
	        ventes.add(listeCommande);
	        ventes.add(suppressionCommande);
	      
			
		   
	        return menuBar;
	    }

	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ajoutMedicament")){
			MedicamentFenetre medFenetre = new MedicamentFenetre();
			medFenetre.setVisible(true);
			System.out.println("gg");
			
		}else if(e.getActionCommand().equals("listeMedicament")){
			
		}else if(e.getActionCommand().equals("suppressionMedicament")){
			
		}else if(e.getActionCommand().equals("ajoutCommande")){
			
		}else if(e.getActionCommand().equals("listeCommande")){
			
		}else if(e.getActionCommand().equals("ajoutEmploye")){
			
		}else if(e.getActionCommand().equals("listeEmploye")){
			
		}else if(e.getActionCommand().equals("suppressionEmploye")){
			
		}else if(e.getActionCommand().equals("ajoutStock")){
			
		}else if(e.getActionCommand().equals("listeStock")){
			
		}else if(e.getActionCommand().equals("suppressionStock")){
			
		}
		
	}


}
