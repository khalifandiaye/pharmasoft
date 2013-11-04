package fr.mmm.pharmaSoft.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import fr.mmm.pharmaSoft.dao.TypeMedicamentDao;
import fr.mmm.pharmaSoft.entity.TypeMedicament;

public class ConsulterTypeMedicamentFenetre extends JFrame implements ActionListener{

	
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
	public ConsulterTypeMedicamentFenetre() {
		initialize();
	}
	
	/**
	 * Create the application.
	 */
	public ConsulterTypeMedicamentFenetre(Integer idTypeMed) {
		initialize();
		if(idTypeMed !=null) {
			this.setTypeMedicament(typeMedicamentDao.findByPk(idTypeMed));
		}
		
		if(this.getTypeMedicament()!=null) {
			libelleTypeMed.setText(this.getTypeMedicament().getLibelle());
		}else {
			libelleTypeMed.setText("Erreur de chargement du type de medicament ");
		}
		
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
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cr\u00E9ation / Modification d'un type de M\u00E9dicament", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(27, 64, 660, 150);
		panel_1.setLayout(null);
		
		JLabel lblTypeMdicament = new JLabel("Libellé");
		lblTypeMdicament.setBounds(43, 50, 119, 14);
		panel_1.add(lblTypeMdicament);
		
		libelleTypeMed = new JLabel("");
		libelleTypeMed.setBounds(263, 50, 150, 20);
		panel_1.add(libelleTypeMed);
		
		JButton btnEnregistrer = new JButton("Modifier");
		btnEnregistrer.setBackground(Color.WHITE);
		btnEnregistrer.setBounds(27, 220, 112, 23);
		btnEnregistrer.setActionCommand("modifier");
		btnEnregistrer.addActionListener(this);
		this.getContentPane().add(btnEnregistrer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(Color.WHITE);
		btnSupprimer.setBounds(150, 220, 112, 23);
		btnSupprimer.setActionCommand("supprimer");
		btnSupprimer.addActionListener(this);
		this.getContentPane().add(btnSupprimer);
		
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
		System.out.println("aa");
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
