package fr.mmm.pharmaSoft.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

import net.sf.jga.swing.GenericTableColumn;
import net.sf.jga.swing.GenericTableModel;
import fr.mmm.pharmaSoft.dao.TypeMedicamentDao;
import fr.mmm.pharmaSoft.entity.TypeMedicament;

public class ListeTypeMedicamentFenetre extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TypeMedicament typeMedicament;
	
	private JLabel libelleTypeMed;
	
	private TypeMedicamentDao typeMedicamentDao= new TypeMedicamentDao();
	

	/**
	 * Create the application.
	 */
	public ListeTypeMedicamentFenetre() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		getContentPane().setBackground(new Color(0, 250, 154));
		setBounds(100, 100,800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		panel.setBounds(225, 11, 300, 30);
		//panel_1.setSize(420, 420);
		//panel.setLayout(null);
		
		JLabel lblcreaMedic = new JLabel("Création d'un type de médicament");
		lblcreaMedic.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblcreaMedic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Liste des types de M\u00E9dicament", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(27, 64, 660, 150);
		//panel_1.setLayout(null);
		String[] entetes = {"Numéro", "Libellé"};
		List<TypeMedicament> list=this.typeMedicamentDao.findAll();
		TypeMedicament type=new TypeMedicament();
		type.setNoTypeMedicament(1);
		type.setLibelle("fff");
		list.add(type);
		
		if(list!=null && !list.isEmpty()) {
			System.out.println("aa");
			GenericTableModel<TypeMedicament> tabModel = new GenericTableModel<TypeMedicament>(TypeMedicament.class,list);
			
			tabModel.addColumn(Integer.class, "NoTypeMedicament");
			
			tabModel.addColumn(String.class, "Libelle");
			
			JTable tableau=new JTable(tabModel, tabModel.getColumnModel());
			
			tableau.getColumnModel().getColumn(0).setHeaderValue("Numéro");
			tableau.getColumnModel().getColumn(1).setHeaderValue("Libellé");
			tableau.getTableHeader().setBackground(new Color(0, 250, 154));
			tableau.setPreferredScrollableViewportSize(new Dimension(500, tableau.getRowHeight()*tableau.getRowCount()));
			panel_1.add(new JScrollPane(tableau), BorderLayout.AFTER_LAST_LINE);
		}
		
	}

	public TypeMedicament getTypeMedicament() {
		return typeMedicament;
	}

	public void setTypeMedicament(TypeMedicament typeMedicament) {
		this.typeMedicament = typeMedicament;
	}

	public JLabel getLibelleTypeMed() {
		return libelleTypeMed;
	}

	public void setLibelleTypeMed(JLabel libelleTypeMed) {
		this.libelleTypeMed = libelleTypeMed;
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("modifier")){
			TypeMedicamentFenetre typeMedFenetre = new TypeMedicamentFenetre(this.getTypeMedicament().getNoTypeMedicament());
			typeMedFenetre.setVisible(true);
			this.dispose();
		}else if(event.getActionCommand().equals("supprimer")){
			
			this.typeMedicamentDao.delete(this.getTypeMedicament());
			TypeMedicamentFenetre frame = new TypeMedicamentFenetre();
	    	frame.setVisible(true);
		}
		
	}
	
	
		

}
