package fr.mmm.pharmaSoft.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.sf.jga.swing.GenericTableModel;
import fr.mmm.pharmaSoft.dao.TypeMedicamentDao;
import fr.mmm.pharmaSoft.entity.TypeMedicament;
import fr.mmm.pharmaSoft.presentation.LanceurMenuMulticolore;

public class ListeTypeMedicamentFenetre extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TypeMedicament typeMedicament;
	
	private Integer idSelected;
	
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
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel,BorderLayout.NORTH);
		panel.setBounds(225, 11, 300, 30);
		//panel_1.setSize(420, 420);
		//panel.setLayout(null);
		
		JLabel lblcreaMedic = new JLabel("Création d'un type de médicament");
		lblcreaMedic.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblcreaMedic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1,BorderLayout.CENTER);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Liste des types de M\u00E9dicament", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		//panel_1.setBounds(27, 64, 660, 150);
		panel_1.setLayout(new BorderLayout());
		
		List<TypeMedicament> list=this.typeMedicamentDao.findAll();
		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(Color.WHITE);
		getContentPane().add(panelBtn,BorderLayout.SOUTH);
		
		panelBtn.setLayout(new FlowLayout());
		JButton btnCreer = new JButton("Nouveau");
		btnCreer.setBackground(Color.WHITE);
		//btnCreer.setBounds(150, 50, 112, 23);
		btnCreer.setActionCommand("creer");
		btnCreer.addActionListener(this);
		panelBtn.add(btnCreer);
		
		if(list!=null && !list.isEmpty()) {
			
			GenericTableModel<TypeMedicament> tabModel = new GenericTableModel<TypeMedicament>(TypeMedicament.class,list);
			tabModel.addColumn(Integer.class, "NoTypeMedicament");
			tabModel.addColumn(String.class, "Libelle");
			final JTable tableau=new JTable(tabModel, tabModel.getColumnModel());
			tableau.getColumnModel().getColumn(0).setHeaderValue("Numéro");
			tableau.getColumnModel().getColumn(1).setHeaderValue("Libellé");
			tableau.getTableHeader().setBackground(new Color(0, 250, 154));
			tableau.setPreferredScrollableViewportSize(new Dimension(500, tableau.getRowHeight()*tableau.getRowCount()));
			
			ListSelectionModel ligneSelectionModel = tableau.getSelectionModel();
			ligneSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ligneSelectionModel.addListSelectionListener(new ListSelectionListener() {
				
				public void valueChanged(ListSelectionEvent selected) {
					int row=tableau.getSelectedRow();
					int idTypeMedicament=(Integer)tableau.getValueAt(row, 0);
					ListeTypeMedicamentFenetre.this.idSelected=idTypeMedicament;
				}
			});
			     
			panel_1.add(new JScrollPane(tableau));
			JButton btnModifier = new JButton("Modifier");
			btnModifier.setBackground(Color.WHITE);
			//btnModifier.setBounds(150, 100, 112, 23);
			btnModifier.setActionCommand("modifier");
			btnModifier.addActionListener(this);
			panelBtn.add(btnModifier);
			
			JButton btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setBackground(Color.WHITE);
			//btnSupprimer.setBounds(150, 150, 112, 23);
			btnSupprimer.setActionCommand("supprimer");
			btnSupprimer.addActionListener(this);
			panelBtn.add(btnSupprimer);
			
			
		}
		
		
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setBackground(Color.WHITE);
		//btnSupprimer.setBounds(150, 150, 112, 23);
		btnMenuPrincipal.setActionCommand("menuPrincipal");
		btnMenuPrincipal.addActionListener(this);
		panelBtn.add(btnMenuPrincipal);
		
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
			if(this.idSelected != null) {
				TypeMedicamentFenetre typeMedFenetre = new TypeMedicamentFenetre(this.idSelected);
				typeMedFenetre.setVisible(true);
				this.dispose();
			}
		}else if(event.getActionCommand().equals("supprimer")){
			//JDialog.setDefaultLookAndFeelDecorated(true);
		    int response = JOptionPane.showConfirmDialog(null, "Voulez vous supprimer cet type de medicament?", "Confirmation",
		        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		    if (response == JOptionPane.NO_OPTION) {
		     
		    	
		    } else if (response == JOptionPane.YES_OPTION) {
		    	if(this.idSelected != null) {
					TypeMedicament type=new TypeMedicament();
					type.setNoTypeMedicament(this.idSelected);
					this.typeMedicamentDao.delete(type);
				}
				// on recharge la page
				new ListeTypeMedicamentFenetre().setVisible(true);
				this.dispose();
		    } else if (response == JOptionPane.CLOSED_OPTION) {
		      
		    }
			
		} else if(event.getActionCommand().equals("creer")){
			TypeMedicamentFenetre typeMedFenetre = new TypeMedicamentFenetre();
			typeMedFenetre.setVisible(true);
			this.dispose();
		}else if(event.getActionCommand().equals("menuPrincipal")){
			LanceurMenuMulticolore menuPrincipalFenetre = new LanceurMenuMulticolore();
			menuPrincipalFenetre.setVisible(true);
			this.dispose();
		}
		
	}
	
	
		

}
