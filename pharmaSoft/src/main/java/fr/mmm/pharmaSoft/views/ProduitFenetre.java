package fr.mmm.pharmaSoft.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import net.java.dev.designgridlayout.DesignGridLayout;

import org.apache.commons.validator.GenericValidator;

import fr.mmm.pharmaSoft.commun.ImagePanel;
import fr.mmm.pharmaSoft.commun.LoadProperties;
import fr.mmm.pharmaSoft.dao.MedicamentDao;
import fr.mmm.pharmaSoft.dao.TypeMedicamentDao;
import fr.mmm.pharmaSoft.dto.ComboBoxDTO;
import fr.mmm.pharmaSoft.entity.Medicament;
import fr.mmm.pharmaSoft.entity.TypeMedicament;

public class ProduitFenetre extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomMedicament;
	
	private JTextField txtPrix;
	private JTextField txtCodeCIP;
	private JTextField txtCodeACL;
	private JComboBox comboTypeMedicament;
	private JTextArea txtDescription;
	private TypeMedicamentDao typeMedicamentDao= new TypeMedicamentDao();
	private MedicamentDao medicamentDao=new MedicamentDao();
	private Integer id;
	private JTextField txtDosage;
	private JTextField txtPosologie;
	private JTextField txtPrincipe;
	private JTextField txtExpiant;
	private JComboBox comboListe;
	private JComboBox comboCategorie;
	private JComboBox comboModeAdministration;
	private JComboBox comboModeConservation;
	private JComboBox comboFormeMedicament;
	
	/**
	 * Create the application.
	 */
	public ProduitFenetre() {
		initialize();
	}
	
	/**
	 * Create the application.
	 */
	public ProduitFenetre(Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/*getContentPane().setBackground(new Color(0, 250, 154));
		setBounds(100, 100,800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		panel.setBounds(225, 11, 300, 30);
		//panel_1.setSize(420, 420);
		//panel.setLayout(null);
		
		JLabel lblcreaMedic = new JLabel("Création d'un médicament");
		lblcreaMedic.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblcreaMedic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cr\u00E9ation / Modification de M\u00E9dicament", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		//panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.setBounds(27, 64, 660, 335);
		//panel_1.setSize(420, 420);
		panel_1.setLayout(null);
		
		JLabel lblNomDuMdicament = new JLabel(LoadProperties.getProperty("medicament.label.nom"));
		lblNomDuMdicament.setBounds(43, 50, 125, 14);
		panel_1.add(lblNomDuMdicament);
		
		txtNomMedicament = new JTextField();
		txtNomMedicament.setBounds(263, 50, 150, 20);
		panel_1.add(txtNomMedicament);
		txtNomMedicament.setColumns(10);
		
		JLabel lblPrix = new JLabel(LoadProperties.getProperty("medicament.label.prix"));
		lblPrix.setBounds(43, 200, 125, 14);
		panel_1.add(lblPrix);
		
		txtPrix = new JTextField();
		txtPrix.setBounds(263, 200, 150, 20);
		panel_1.add(txtPrix);
		txtPrix.setColumns(10);
		
		JLabel lblTypeDeMdicament = new JLabel(LoadProperties.getProperty("medicament.label.typeMedicament"));
		lblTypeDeMdicament.setBounds(43, 100, 125, 14);
		panel_1.add(lblTypeDeMdicament);
		
		List<TypeMedicament> list=this.typeMedicamentDao.findAll();
		List<ComboBoxDTO> listCombo=new ArrayList<ComboBoxDTO>();
		for (TypeMedicament typeMedicament : list) {
			listCombo.add(new ComboBoxDTO(typeMedicament.getLibelle(), typeMedicament.getNoTypeMedicament()));
		}
		
		comboTypeMedicament = new JComboBox();
		if(listCombo !=null && !listCombo.isEmpty()){
			comboTypeMedicament = new JComboBox(listCombo.toArray(new ComboBoxDTO[]{}));
			
		}
		
		
		comboTypeMedicament.setBounds(263, 100, 150, 20);
		panel_1.add(comboTypeMedicament);
		
		JLabel lblCode = new JLabel(LoadProperties.getProperty("medicament.label.codeMedicament"));
		lblCode.setBounds(43, 150, 125, 14);
		panel_1.add(lblCode);
		
		txtCode = new JTextField();
		txtCode.setBounds(263, 150, 150, 20);
		panel_1.add(txtCode);
		txtCode.setColumns(10);
		
		JLabel lblDescription = new JLabel(LoadProperties.getProperty("medicament.label.descriptionMedicament"));
		lblDescription.setBounds(43, 250, 125, 14);
		panel_1.add(lblDescription);
		
		txtDescription = new JTextArea();
		txtDescription.setRows(8);
		txtDescription.setText("décrire ");
		txtDescription.setBounds(263, 250, 321, 68);
		txtDescription.setBorder(BorderFactory.createLineBorder(null));
		panel_1.add(txtDescription);
		
		
		//Cas Modification
		if(this.getId()!=null) {
			Medicament med= this.medicamentDao.findByPk(this.getId());
			txtNomMedicament.setText(med.getLibelle());
			txtDescription.setText(med.getDescription());
			txtPrix.setText(med.getPrix().toString());
			txtCode.setText(med.getCode());
			if(med.getType()!=null){
				comboTypeMedicament.setEditable(true);
				comboTypeMedicament.setSelectedItem(new ComboBoxDTO(med.getType().getLibelle(), med.getType().getNoTypeMedicament()));
			}
		}
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(Color.WHITE);
		btnEnregistrer.setBounds(27, 420, 112, 23);
		btnEnregistrer.setActionCommand("creer");
		btnEnregistrer.addActionListener(this);
		getContentPane().add(btnEnregistrer);
		System.out.println(LoadProperties.getProperty("medicament.label.nom"));*/
		setSize(1200, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pnlWest=new ImagePanel(new ImageIcon("images/logo-pharmacie.jpg").getImage());
		JPanel pnlEast=new ImagePanel(new ImageIcon("images/logo-pharmacie.jpg").getImage());
		JPanel pnlSouth=new JPanel();
		JPanel pnlNorth=new ImagePanel(new ImageIcon("images/pharmacienne3.jpg").getImage());
		
		JLabel lblcreaMedic = new JLabel("Création d'un médicament");
		lblcreaMedic.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		
		
//		pnlNorth.setLayout(new BorderLayout());
//		pnlNorth.add(new ImagePanel(new ImageIcon("images/pharmacienne1.jpg").getImage()), BorderLayout.WEST);
//		pnlNorth.add(new ImagePanel(new ImageIcon("images/pharmacienne2.jpg").getImage()), BorderLayout.EAST);
		pnlNorth.add(lblcreaMedic, BorderLayout.CENTER);
		    this.setLayout(new BorderLayout());
		    //On ajoute le bouton au content pane de la JFrame
		    //Au centre
		    
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
		    
		    JLabel lblNomDuMdicament = new JLabel(LoadProperties.getProperty("medicament.label.nom"));
			lblNomDuMdicament.setSize(new Dimension(125, 15));
			txtNomMedicament = new JTextField();
			txtNomMedicament.setMaximumSize(new Dimension(225, 25));
			
			
			JLabel lblPrix = new JLabel(LoadProperties.getProperty("medicament.label.prix"));
			lblPrix.setMaximumSize(new Dimension(160, 25));
			
			txtPrix = new JTextField();
			txtPrix.setMaximumSize(new Dimension(160, 25));
			
			JLabel lblTypeDeMdicament = new JLabel(LoadProperties.getProperty("medicament.label.typeMedicament"));
			
			List<TypeMedicament> list=this.typeMedicamentDao.findAll();
			List<ComboBoxDTO> listCombo=new ArrayList<ComboBoxDTO>();
			for (TypeMedicament typeMedicament : list) {
				listCombo.add(new ComboBoxDTO(typeMedicament.getLibelle(), typeMedicament.getNoTypeMedicament()));
			}
			
			comboTypeMedicament = new JComboBox();
			if(listCombo !=null && !listCombo.isEmpty()){
				comboTypeMedicament = new JComboBox(listCombo.toArray(new ComboBoxDTO[]{}));
				
			}
			
			JLabel lblCodeCIP = new JLabel(LoadProperties.getProperty("medicament.label.codeCIP"));
			txtCodeCIP = new JTextField();
			
			JLabel lblCodeACL = new JLabel(LoadProperties.getProperty("medicament.label.codeACL"));
			txtCodeACL = new JTextField();
			
			JLabel lblDosage = new JLabel(LoadProperties.getProperty("medicament.label.dosage"));
			txtDosage = new JTextField();
			
			JLabel lblPosologie = new JLabel(LoadProperties.getProperty("medicament.label.posologie"));
			txtPosologie = new JTextField();
			
			JLabel lblPrincipe = new JLabel(LoadProperties.getProperty("medicament.label.principe"));
			txtPrincipe = new JTextField();
			
			JLabel lblExpiant = new JLabel(LoadProperties.getProperty("medicament.label.expiant"));
			txtExpiant = new JTextField();
			
			JLabel lblListe = new JLabel(LoadProperties.getProperty("medicament.label.liste"));
			
			comboListe = new JComboBox();
			if(listCombo !=null && !listCombo.isEmpty()){
				comboListe = new JComboBox(listCombo.toArray(new ComboBoxDTO[]{}));
				
			}
			
			
			JLabel lblCategorie = new JLabel(LoadProperties.getProperty("medicament.label.categorie"));
			comboCategorie = new JComboBox();
			if(listCombo !=null && !listCombo.isEmpty()){
				comboCategorie = new JComboBox(listCombo.toArray(new ComboBoxDTO[]{}));
				
			}
			
			JLabel lblModeAdministration = new JLabel(LoadProperties.getProperty("medicament.label.modeAdministration"));
			comboModeAdministration = new JComboBox();
			if(listCombo !=null && !listCombo.isEmpty()){
				comboModeAdministration = new JComboBox(listCombo.toArray(new ComboBoxDTO[]{}));
				
			}
			
			JLabel lblModeConservation = new JLabel(LoadProperties.getProperty("medicament.label.modeConservation"));
			comboModeConservation = new JComboBox();
			if(listCombo !=null && !listCombo.isEmpty()){
				comboModeConservation = new JComboBox(listCombo.toArray(new ComboBoxDTO[]{}));
				
			}
			
			JLabel lblFormeMedicament = new JLabel(LoadProperties.getProperty("medicament.label.formeMedicament"));
			comboFormeMedicament = new JComboBox();
			if(listCombo !=null && !listCombo.isEmpty()){
				comboFormeMedicament = new JComboBox(listCombo.toArray(new ComboBoxDTO[]{}));
				
			}
			
			
			JLabel lblDescription = new JLabel(LoadProperties.getProperty("medicament.label.descriptionMedicament"));
			
			txtDescription = new JTextArea();
			txtDescription.setRows(8);
			txtDescription.setText("décrire ");
			txtDescription.setBorder(BorderFactory.createLineBorder(null));
			
			JButton btnEnregistrer = new JButton("Enregistrer");
			btnEnregistrer.setBackground(Color.WHITE);
			btnEnregistrer.setActionCommand("creer");
			btnEnregistrer.addActionListener(this);
			
			layout.row().grid().empty();
			layout.row().grid().add(lblNomDuMdicament).add(txtNomMedicament,3).empty();
			layout.row().grid().add(lblTypeDeMdicament).add(comboTypeMedicament, 3).empty();
			layout.row().grid().add(lblCodeACL).add(txtCodeACL).empty().add(lblCodeCIP).add(txtCodeCIP);
			layout.row().grid().add(lblDosage).add(txtDosage).empty().add(lblPosologie).add(txtPosologie);
			layout.row().grid().add(lblPrincipe).add(txtPrincipe).empty().add(lblExpiant).add(txtExpiant);
			layout.row().grid().add(lblListe).add(comboListe).empty().add(lblCategorie).add(comboCategorie);
			layout.row().grid().add(lblModeAdministration).add(comboModeAdministration).empty().add(lblModeConservation).add(comboModeConservation);
			layout.row().grid().add(lblPrix).add(txtPrix).empty().add(lblFormeMedicament).add(comboFormeMedicament);
			layout.row().grid().add(lblDescription).add(txtDescription, 3).empty();
			layout.row().grid().empty();
			layout.row().right().add(btnEnregistrer);
			this.getContentPane().add(pnlcentral, BorderLayout.CENTER);
			
			
			pnlSouth.setLayout(new BorderLayout());
			pnlSouth.add(new ImagePanel(new ImageIcon("images/logo-pharmacie2.jpg").getImage()), BorderLayout.WEST);
			pnlSouth.add(new ImagePanel(new ImageIcon("images/logo-pharmacie2.jpg").getImage()), BorderLayout.EAST);
		    
		    
		
	}

	

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("creer")) {
			Medicament medicament = new Medicament();
			if(!GenericValidator.isBlankOrNull(txtPrix.getText()) && GenericValidator.isDouble( txtPrix.getText())) {
				medicament.setPrix(Double.parseDouble(txtPrix.getText()));
			}
			if(comboTypeMedicament!=null && comboTypeMedicament.getSelectedItem()!=null){
				ComboBoxDTO combo= (ComboBoxDTO) comboTypeMedicament.getSelectedItem();
				TypeMedicament type=new TypeMedicament();
				type.setNoTypeMedicament(combo.getValue());
				medicament.setType(type);
			}
			
			if(!GenericValidator.isBlankOrNull(txtNomMedicament.getText())){
				medicament.setLibelle(txtNomMedicament.getText());
			}
			if(!GenericValidator.isBlankOrNull(txtCodeCIP.getText())){
				medicament.setCode(txtCodeCIP.getText());
			}
			if(!GenericValidator.isBlankOrNull(txtDescription.getText())){
				medicament.setDescription(txtDescription.getText());
			}
			medicament=this.medicamentDao.create(medicament);
		} else if(e.getActionCommand().equals("modifier")){
			if(this.getId()!=null) {
				Medicament medicament =this.medicamentDao.findByPk(this.getId());
				if(!GenericValidator.isBlankOrNull(txtPrix.getText()) && GenericValidator.isDouble( txtPrix.getText())) {
					medicament.setPrix(Double.parseDouble(txtPrix.getText()));
				}
				ComboBoxDTO combo= (ComboBoxDTO) comboTypeMedicament.getSelectedItem();
				TypeMedicament type=new TypeMedicament();
				type.setNoTypeMedicament(combo.getValue());
				medicament.setType(type);
				if(!GenericValidator.isBlankOrNull(txtNomMedicament.getText())){
					medicament.setLibelle(txtNomMedicament.getText());
				}
				if(!GenericValidator.isBlankOrNull(txtCodeCIP.getText())){
					medicament.setCode(txtCodeCIP.getText());
				}
				if(!GenericValidator.isBlankOrNull(txtDescription.getText())){
					medicament.setDescription(txtDescription.getText());
				}
				medicament=this.medicamentDao.update(medicament);
			}
			
		}
		new ListeMedicamentFenetre().setVisible(true);
		this.dispose();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
