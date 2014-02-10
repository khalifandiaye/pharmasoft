package fr.mmm.pharmaSoft.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import fr.mmm.pharmaSoft.dao.Daos;
import fr.mmm.pharmaSoft.dao.EmployeDao;
import fr.mmm.pharmaSoft.entity.Employe;

public class EmployeFenetre extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private Employe employe;
	private EmployeDao employeDao= new EmployeDao();
	private Daos pharmaDao;
	private Integer idEmploye;


	/**
	 * Create the application.
	 */
	public EmployeFenetre() {
		initialize();
	}
	
	/**
	 * Create the application.
	 */
	public EmployeFenetre(Integer idTypeMed) {
		this.idEmploye=idTypeMed;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.getContentPane().setBackground(new Color(0, 250, 154));
		this.setBounds(100, 100,800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.getContentPane().add(panel);
		panel.setBounds(225, 11, 300, 30);
		//panel_1.setSize(420, 420);
		//panel.setLayout(null);
		
		JLabel lblcreaMedic = new JLabel("Création d'un type de médicament");
		lblcreaMedic.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblcreaMedic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		this.getContentPane().add(panel_1);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cr\u00E9ation / Modification d'un type de M\u00E9dicament", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(27, 64, 660, 150);
		panel_1.setLayout(null);
		
		JLabel lblTypeMdicament = new JLabel("Libellé");
		lblTypeMdicament.setBounds(43, 50, 119, 14);
		panel_1.add(lblTypeMdicament);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(263, 50, 150, 20);
		panel_1.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Nom");
		lblTypeMdicament.setBounds(43, 100, 119, 14);
		panel_1.add(lblTypeMdicament);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(263, 100, 150, 20);
		panel_1.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(Color.WHITE);
		btnEnregistrer.setBounds(27, 220, 112, 23);
		btnEnregistrer.addActionListener(this);
		
		
		
		
		if(this.getIdEmploye()==null || this.getIdEmploye()==0){
		btnEnregistrer.setActionCommand("creer");
		} else {
			if(idEmploye !=null) {
				this.setEmploye(employeDao.findByPk(this.getIdEmploye()));
			}
			
			if(this.getEmploye()!=null) {
				textFieldNom.setText(this.getEmploye().getNom());
				textFieldPrenom.setText(this.getEmploye().getPrenom());
				
			}else {
				textFieldNom.setText("Erreur de chargement de l'employé ");
			}
			
			btnEnregistrer.setActionCommand("modifier");
		}
		JButton btnAnnuler = new JButton("Retour");
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(150, 220, 112, 23);
		btnAnnuler.addActionListener(this);
		btnAnnuler.setActionCommand("annuler");
		this.getContentPane().add(btnAnnuler);
		
		
		
		this.getContentPane().add(btnEnregistrer);
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	public void actionPerformed(ActionEvent e) {
		String foward="";
		Employe employe= this.getEmploye();
		if(e.getActionCommand().equals("creer")) {
			employe=new Employe();
			employe.setNom(textFieldNom.getText());
			employe.setPrenom(textFieldPrenom.getText());
			employe=this.creer(employe);
			foward="creerSucces";
			
		} else if(e.getActionCommand().equals("modifier")){
			
			employe.setNom(textFieldNom.getText());
			employe.setPrenom(textFieldPrenom.getText());
			employe=this.modifier(employe);
			foward="modifierSucces";
		}
		if(foward.equals("creerSucces")){
			ListeEmployeFenetre frameListes=new ListeEmployeFenetre();
			frameListes.setVisible(true);
			this.dispose();
		}else if (foward.equals("modifierSucces")) {
			ListeEmployeFenetre frameListes=new ListeEmployeFenetre();
			frameListes.setVisible(true);
			this.dispose();
		}else if(e.getActionCommand().equals("annuler")){
			ListeEmployeFenetre frameListes=new ListeEmployeFenetre();
			frameListes.setVisible(true);
			this.dispose();
		}
		
		
	}
	
	private Employe modifier(Employe typeMed) {
		return this.employeDao.update(typeMed);
	}


	private Employe creer(Employe typeMed) {
		
		return this.employeDao.create(typeMed);
	}

	public Integer getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
	}
}
