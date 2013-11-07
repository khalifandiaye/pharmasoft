package fr.mmm.pharmaSoft.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.apache.commons.validator.GenericValidator;

import com.jidesoft.swing.AutoCompletion;

import fr.mmm.pharmaSoft.dao.MedicamentDao;
import fr.mmm.pharmaSoft.dao.StockDao;
import fr.mmm.pharmaSoft.dto.ComboBoxDTO;
import fr.mmm.pharmaSoft.dto.MedicamentDTO;
import fr.mmm.pharmaSoft.entity.Medicament;
import fr.mmm.pharmaSoft.entity.TypeMedicament;









public class StockFenetre extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomMedicament;
	
	private JTextField txtQuantite;
	private JTextField txtCode;
	private JComboBox comboTypeMedicament;
	private JTextArea txtDescription;
	private StockDao stock= new StockDao();
	private MedicamentDao medicamentDao=new MedicamentDao();
	private Integer id;
	private JTextField txtPeremption;
	
	/**
	 * Create the application.
	 */
	public StockFenetre() {
		initialize();
	}
	
	/**
	 * Create the application.
	 */
	public StockFenetre(Integer id) {
		this.setId(id);
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
		
	
		
		JLabel lblNomDuMdicament = new JLabel("Nom du médicament");
		lblNomDuMdicament.setBounds(43, 50, 125, 14);
		panel_1.add(lblNomDuMdicament);
		
		List<MedicamentDTO> list=this.medicamentDao.findAll();
		List<ComboBoxDTO> listCombo=new ArrayList<ComboBoxDTO>();
		final Map<Integer,String> mapMedic=new HashMap<Integer,String>();
		for (MedicamentDTO medicament : list) {
			listCombo.add(new ComboBoxDTO(medicament.getLibelle(), medicament.getNoMedicament()));
			mapMedic.put(medicament.getNoMedicament(), medicament.getLibelle()
					+" "+medicament.getLibelleTypeMedicament()+" "+medicament.getCode()+" "+medicament.getPrix());
		}
		if(listCombo !=null && !listCombo.isEmpty()){
			
			
			
			comboTypeMedicament = new JComboBox( listCombo.toArray(new ComboBoxDTO[]{}));
			comboTypeMedicament.setBounds(263, 50, 150, 20);
			
			comboTypeMedicament.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer index=((ComboBoxDTO)comboTypeMedicament.getSelectedItem()).getValue();
					txtDescription.setText(mapMedic.get(index));
				}
			});
			
			comboTypeMedicament.setEditable(true);
			AutoCompletion ac = new AutoCompletion(comboTypeMedicament);
			ac.setStrict(false);
			panel_1.add(comboTypeMedicament);
		}
		
		txtDescription = new JTextArea();
		txtDescription.setRows(8);
		txtDescription.setText("Résumé");
		txtDescription.setBounds(450, 50, 200, 40);
		txtDescription.setBorder(BorderFactory.createLineBorder(null));
		panel_1.add(txtDescription);
		
		JLabel lblQuantite = new JLabel("Quantité");
		lblQuantite.setBounds(43, 100, 125, 14);
		panel_1.add(lblQuantite);
		
		txtQuantite = new JTextField();
		txtQuantite.setBounds(263, 100, 150, 20);
		panel_1.add(txtQuantite);
		txtQuantite.setColumns(10);
		
		JLabel lblPeremption = new JLabel("Date de péremption");
		lblPeremption.setBounds(43, 150, 125, 14);
		panel_1.add(lblPeremption);
		
		txtPeremption = new JTextField();
		txtPeremption.setBounds(263, 150, 150, 20);
		panel_1.add(txtPeremption);
		txtQuantite.setColumns(10);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(Color.WHITE);
		btnEnregistrer.setBounds(27, 420, 112, 23);
		btnEnregistrer.setActionCommand("creer");
		btnEnregistrer.addActionListener(this);
		getContentPane().add(btnEnregistrer);
	}

	

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("creer")) {
			Medicament medicament = new Medicament();
			if(!GenericValidator.isBlankOrNull(txtQuantite.getText()) && GenericValidator.isDouble( txtQuantite.getText())) {
				medicament.setPrix(Double.parseDouble(txtQuantite.getText()));
			}
			ComboBoxDTO combo= (ComboBoxDTO) comboTypeMedicament.getSelectedItem();
			TypeMedicament type=new TypeMedicament();
			type.setNoTypeMedicament(combo.getValue());
			medicament.setType(type);
			if(!GenericValidator.isBlankOrNull(txtNomMedicament.getText())){
				medicament.setLibelle(txtNomMedicament.getText());
			}
			if(!GenericValidator.isBlankOrNull(txtCode.getText())){
				medicament.setCode(txtCode.getText());
			}
			if(!GenericValidator.isBlankOrNull(txtDescription.getText())){
				medicament.setDescription(txtDescription.getText());
			}
			medicament=this.medicamentDao.create(medicament);
		} else if(e.getActionCommand().equals("modifier")){
			if(this.getId()!=null) {
				Medicament medicament =this.medicamentDao.findByPk(this.getId());
				if(!GenericValidator.isBlankOrNull(txtQuantite.getText()) && GenericValidator.isDouble( txtQuantite.getText())) {
					medicament.setPrix(Double.parseDouble(txtQuantite.getText()));
				}
				ComboBoxDTO combo= (ComboBoxDTO) comboTypeMedicament.getSelectedItem();
				TypeMedicament type=new TypeMedicament();
				type.setNoTypeMedicament(combo.getValue());
				medicament.setType(type);
				if(!GenericValidator.isBlankOrNull(txtNomMedicament.getText())){
					medicament.setLibelle(txtNomMedicament.getText());
				}
				if(!GenericValidator.isBlankOrNull(txtCode.getText())){
					medicament.setCode(txtCode.getText());
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
