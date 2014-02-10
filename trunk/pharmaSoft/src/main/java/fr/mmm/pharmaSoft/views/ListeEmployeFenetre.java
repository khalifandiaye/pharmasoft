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
import fr.mmm.pharmaSoft.dao.EmployeDao;
import fr.mmm.pharmaSoft.entity.Employe;

public class ListeEmployeFenetre extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Employe employe;
	
	private Integer idSelected;
	
	
	
	private EmployeDao employeDao= new EmployeDao();
	

	/**
	 * Create the application.
	 */
	public ListeEmployeFenetre() {
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
		
		JLabel lblcreaMedic = new JLabel("Création d'un employé");
		lblcreaMedic.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblcreaMedic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1,BorderLayout.CENTER);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Liste des types de Employé", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		//panel_1.setBounds(27, 64, 660, 150);
		panel_1.setLayout(new BorderLayout());
		
		List<Employe> list=this.employeDao.findAll();
		
		
		if(list!=null && !list.isEmpty()) {
			
			GenericTableModel<Employe> tabModel = new GenericTableModel<Employe>(Employe.class,list);
			tabModel.addColumn(Integer.class, "NoEmploye");
			tabModel.addColumn(String.class, "Nom");
			tabModel.addColumn(String.class, "Prenom");
			final JTable tableau=new JTable(tabModel, tabModel.getColumnModel());
			tableau.getColumnModel().getColumn(0).setHeaderValue("Numéro");
			tableau.getColumnModel().getColumn(1).setHeaderValue("Nom");
			tableau.getColumnModel().getColumn(2).setHeaderValue("Prénom");
			tableau.getTableHeader().setBackground(new Color(0, 250, 154));
			tableau.setPreferredScrollableViewportSize(new Dimension(500, tableau.getRowHeight()*tableau.getRowCount()));
			
			ListSelectionModel ligneSelectionModel = tableau.getSelectionModel();
			ligneSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ligneSelectionModel.addListSelectionListener(new ListSelectionListener() {
				
				public void valueChanged(ListSelectionEvent selected) {
					int row=tableau.getSelectedRow();
					int idEmploye=(Integer)tableau.getValueAt(row, 0);
					ListeEmployeFenetre.this.idSelected=idEmploye;
				}
			});
			     
			panel_1.add(new JScrollPane(tableau));
			
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
		
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	

	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("modifier")){
			if(this.idSelected != null) {
				EmployeFenetre typeMedFenetre = new EmployeFenetre(this.idSelected);
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
					Employe type=new Employe();
					type.setNoEmploye(this.idSelected);
					this.employeDao.delete(type);
				}
				// on recharge la page
				new ListeEmployeFenetre().setVisible(true);
				this.dispose();
		    } else if (response == JOptionPane.CLOSED_OPTION) {
		      
		    }
			
		} else if(event.getActionCommand().equals("creer")){
			EmployeFenetre typeMedFenetre = new EmployeFenetre();
			typeMedFenetre.setVisible(true);
			this.dispose();
		}
		
	}
	
	
		

}
