package fr.mmm.pharmaSoft.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.apache.commons.validator.GenericValidator;

import com.jidesoft.swing.AutoCompletion;

import fr.mmm.pharmaSoft.dao.CommandeDao;
import fr.mmm.pharmaSoft.dao.MedicamentDao;
import fr.mmm.pharmaSoft.dto.ComboBoxDTO;
import fr.mmm.pharmaSoft.dto.MedicamentDTO;
import fr.mmm.pharmaSoft.entity.Commande;
import fr.mmm.pharmaSoft.entity.Medicament;
import fr.mmm.pharmaSoft.entity.TypeMedicament;

import fr.mmm.pharmaSoft.commun.MenuUtils;







public class CommandeFenetre extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomMedicament;
	
	private JTextField txtPrix;
	private JTextField txtCode;
	private JComboBox comboMedicament;
	private JLabel lblTotal;
	private DefaultListModel dlm = new DefaultListModel();
	
	
	private JTextArea txtDescription;
	private JTextArea txtDescCommandes;
	private CommandeDao commandeDao= new CommandeDao();
	private MedicamentDao medicamentDao=new MedicamentDao();
	private Commande commande=new Commande();
	final Map<String,Medicament> mapCommande=new HashMap<String,Medicament>();
	private JTable tableau=new JTable();
	private Integer id;
	private Integer idSelected;
	private JList liste;
	
	/**
	 * Create the application.
	 */
	public CommandeFenetre() {
		initialize();
	}
	
	/**
	 * Create the application.
	 */
	public CommandeFenetre(Integer id) {
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
		
		//Create and set up the content pane.
		MenuUtils demo = new MenuUtils();
        
        // We now also set the MenuBar of the Frame to our MenuBar 
        setJMenuBar(demo.createMenuBar());
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		panel.setBounds(225, 11, 300, 30);
		//panel_1.setSize(420, 420);
		//panel.setLayout(null);
		
		JLabel lblcreaMedic = new JLabel("Commandes");
		lblcreaMedic.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblcreaMedic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Création d'une commande", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		//panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.setBounds(27, 64, 660, 200);
		//panel_1.setSize(420, 420);
		panel_1.setLayout(null);
		
		JLabel lblNomDuMdicament = new JLabel("Nom du médicament");
		lblNomDuMdicament.setBounds(43, 50, 125, 14);
		panel_1.add(lblNomDuMdicament);
		

		List<MedicamentDTO> list=this.medicamentDao.findAll();
		List<ComboBoxDTO> listCombo=new ArrayList<ComboBoxDTO>();
		listCombo.add(0, new ComboBoxDTO("", -1));
		final Map<Integer,String> mapMedic=new HashMap<Integer,String>();
		for (MedicamentDTO medicament : list) {
			listCombo.add(new ComboBoxDTO(medicament.getLibelle(), medicament.getNoMedicament()));
			mapMedic.put(medicament.getNoMedicament(), medicament.getLibelle()
					+" "+medicament.getLibelleTypeMedicament()+" "+medicament.getCode()+" "+medicament.getPrix());
		}
		if(listCombo !=null && !listCombo.isEmpty()){
			comboMedicament = new JComboBox( listCombo.toArray(new ComboBoxDTO[]{}));
			comboMedicament.setBounds(180, 50, 250, 20);
		   
			comboMedicament.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer index=((ComboBoxDTO)comboMedicament.getSelectedItem()).getValue();
					txtDescription.setText(mapMedic.get(index));
				}
			});
			
			comboMedicament.setEditable(true);
			AutoCompletion ac = new AutoCompletion(comboMedicament);
			ac.setStrict(true);
			panel_1.add(comboMedicament);
		}
		txtDescription = new JTextArea();
		txtDescription.setRows(8);
		txtDescription.setText("Résumé");
		txtDescription.setBounds(450, 50, 200, 40);
		txtDescription.setBorder(BorderFactory.createLineBorder(null));
		panel_1.add(txtDescription);
		
		
		
		
		JButton btnEnregistrer = new JButton("Ajouter");
		btnEnregistrer.setBackground(Color.WHITE);
		btnEnregistrer.setBounds(43, 100, 112, 23);
		btnEnregistrer.setActionCommand("creer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ComboBoxDTO combo= (ComboBoxDTO) comboMedicament.getSelectedItem();
				Medicament medicament=medicamentDao.findByPk(combo.getValue());
				if(medicament!=null){
					commande.addMedicament(medicament);
					if(commande.getMontantTotal()!=null){
						commande.setMontantTotal(commande.getMontantTotal()+medicament.getPrix());
					}
					else {
						commande.setMontantTotal(medicament.getPrix());
					}
				}
				String txt="";
				txt=medicament.getLibelle()+"  "+medicament.getPrix();
				//txtDescCommandes.setText(txt);
				mapCommande.put(txt, medicament);
				dlm.addElement(txt);
				lblTotal.setText("Total : "+commande.getMontantTotal());
				
				
		
			}
		});
		panel_1.add(btnEnregistrer);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.CYAN);
		
		panel2.setBounds(27, 270, 250, 250);
		panel2.setLayout(null);

		getContentPane().add(panel2);
		
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(10, 220, 125, 14);
		lblTotal.setBackground(Color.WHITE);
		panel2.add(lblTotal);
		
		
		liste = new JList(dlm);
		liste.setBounds(10,10,220,200);
		
		panel2.add(liste);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(Color.WHITE);
		btnSupprimer.setBounds(120, 220,110, 23);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=(String)liste.getSelectedValue();
				dlm.removeElement(s);
				commande.getMedicaments().remove(mapCommande.get(s));
				commande.setMontantTotal(commande.getMontantTotal()-mapCommande.get(s).getPrix());
				lblTotal.setText("Total : "+commande.getMontantTotal());
			}
		
		});
		panel2.add(btnSupprimer);
		
		
		JButton btnTerminer = new JButton("Terminer la commande");
		btnTerminer.setBackground(Color.WHITE);
		btnTerminer.setBounds(300, 400, 180, 23);
		btnTerminer.setActionCommand("Terminer");
		btnTerminer.addActionListener(this);
		getContentPane().add(btnTerminer);
	}

	

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Terminer")) {
			commande.setDateCommande(new Date());
			commande=this.commandeDao.create(commande);
			
		} 
		new ListeCommandeFenetre().setVisible(true);
		this.dispose();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
