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
import fr.mmm.pharmaSoft.dao.TypeMedicamentDao;
import fr.mmm.pharmaSoft.entity.TypeMedicament;

public class TypeMedicamentFenetre extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private TypeMedicament typeMedicament;
	private TypeMedicamentDao typeMedicamentDao= new TypeMedicamentDao();
	private Daos pharmaDao;
	private Integer idTypeMed;


	/**
	 * Create the application.
	 */
	public TypeMedicamentFenetre() {
		initialize();
	}
	
	/**
	 * Create the application.
	 */
	public TypeMedicamentFenetre(Integer idTypeMed) {
		this.idTypeMed=idTypeMed;
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
		
		textField = new JTextField();
		textField.setBounds(263, 50, 150, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(Color.WHITE);
		btnEnregistrer.setBounds(27, 220, 112, 23);
		btnEnregistrer.addActionListener(this);
		
		
		
		
		if(this.getIdTypeMed()==null || this.getIdTypeMed()==0){
		btnEnregistrer.setActionCommand("creer");
		} else {
			if(idTypeMed !=null) {
				this.setTypeMedicament(typeMedicamentDao.findByPk(this.getIdTypeMed()));
			}
			
			if(this.getTypeMedicament()!=null) {
				textField.setText(this.getTypeMedicament().getLibelle());
			}else {
				textField.setText("Erreur de chargement du type de medicament ");
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

	public TypeMedicament getTypeMedicament() {
		return typeMedicament;
	}

	public void setTypeMedicament(TypeMedicament typeMedicament) {
		this.typeMedicament = typeMedicament;
	}
	
	public void actionPerformed(ActionEvent e) {
		String foward="";
		TypeMedicament typeMed= this.getTypeMedicament();
		if(e.getActionCommand().equals("creer")) {
			typeMed=new TypeMedicament();
			typeMed.setLibelle(textField.getText());
			typeMed=this.creer(typeMed);
			foward="creerSucces";
			
		} else if(e.getActionCommand().equals("modifier")){
			
			typeMed.setLibelle(textField.getText());
			typeMed=this.modifier(typeMed);
			foward="modifierSucces";
		}
		if(foward.equals("creerSucces")){
			ListeTypeMedicamentFenetre frameListes=new ListeTypeMedicamentFenetre();
			frameListes.setVisible(true);
			this.dispose();
		}else if (foward.equals("modifierSucces")) {
			ListeTypeMedicamentFenetre frameListes=new ListeTypeMedicamentFenetre();
			frameListes.setVisible(true);
			this.dispose();
		}else if(e.getActionCommand().equals("annuler")){
			ListeTypeMedicamentFenetre frameListes=new ListeTypeMedicamentFenetre();
			frameListes.setVisible(true);
			this.dispose();
		}
		
		
	}
	
	private TypeMedicament modifier(TypeMedicament typeMed) {
		return this.typeMedicamentDao.update(typeMed);
	}


	private TypeMedicament creer(TypeMedicament typeMed) {
		
		return this.typeMedicamentDao.create(typeMed);
	}

	public Integer getIdTypeMed() {
		return idTypeMed;
	}

	public void setIdTypeMed(Integer idTypeMed) {
		this.idTypeMed = idTypeMed;
	}
}
