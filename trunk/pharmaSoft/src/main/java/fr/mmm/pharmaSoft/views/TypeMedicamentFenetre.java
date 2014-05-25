package fr.mmm.pharmaSoft.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import net.java.dev.designgridlayout.DesignGridLayout;

import fr.mmm.pharmaSoft.commun.ImagePanel;
import fr.mmm.pharmaSoft.commun.LoadProperties;
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
		
//		this.getContentPane().setBackground(new Color(0, 250, 154));
//		this.setBounds(100, 100,800, 600);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.getContentPane().setLayout(null);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.WHITE);
//		this.getContentPane().add(panel);
//		panel.setBounds(225, 11, 300, 30);
		//panel_1.setSize(420, 420);
		//panel.setLayout(null);
		
		
		setSize(1200, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pnlWest=new ImagePanel(new ImageIcon("images/logo-pharmacie.jpg").getImage());
		JPanel pnlEast=new ImagePanel(new ImageIcon("images/logo-pharmacie.jpg").getImage());
		JPanel pnlSouth=new JPanel();
		JPanel pnlNorth=new ImagePanel(new ImageIcon("images/pharmacienne3.jpg").getImage());
		
		 //Au nord
	    this.getContentPane().add(pnlNorth, BorderLayout.NORTH);
	    //Au sud
	    this.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
	    //À l'ouest
	    this.getContentPane().add(pnlWest, BorderLayout.WEST);
	    //À l'est
	    this.getContentPane().add(pnlEast, BorderLayout.EAST);
		
		JPanel pnlcentral=new JPanel();
	    pnlcentral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cr\u00E9ation / Modification de M\u00E9dicament", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	    DesignGridLayout layout = new DesignGridLayout(pnlcentral);
		
		JLabel lblcreaMedic = new JLabel("Création d'un type de médicament");
		lblcreaMedic.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		pnlNorth.add(lblcreaMedic, BorderLayout.CENTER);
		
		JLabel lblTypeMdicament = new JLabel(LoadProperties.getProperty("typeMedicament.label.libelle"));
		textField = new JTextField();
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(Color.WHITE);
		btnEnregistrer.setActionCommand("creer");
		btnEnregistrer.addActionListener(this);
		
		JButton btnAnnuler = new JButton("Retour");
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.addActionListener(this);
		btnAnnuler.setActionCommand("annuler");
		
		layout.row().grid().empty();
		layout.row().grid().empty();

		layout.row().grid().empty().add(lblTypeMdicament).add(textField,2);
		layout.row().grid().empty();
		layout.row().right().add(btnEnregistrer).add(btnAnnuler);
		this.getContentPane().add(pnlcentral, BorderLayout.CENTER);
		
		pnlSouth.setLayout(new BorderLayout());
		pnlSouth.add(new ImagePanel(new ImageIcon("images/logo-pharmacie2.jpg").getImage()), BorderLayout.WEST);
		pnlSouth.add(new ImagePanel(new ImageIcon("images/logo-pharmacie2.jpg").getImage()), BorderLayout.EAST);
		
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
