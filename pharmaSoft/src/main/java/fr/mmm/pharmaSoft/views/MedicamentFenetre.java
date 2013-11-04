package fr.mmm.pharmaSoft.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import fr.mmm.pharmaSoft.entity.Medicament;

public class MedicamentFenetre {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Medicament medicament;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicamentFenetre window = new MedicamentFenetre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MedicamentFenetre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 250, 154));
		frame.setBounds(100, 100,800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setBounds(225, 11, 300, 30);
		//panel_1.setSize(420, 420);
		//panel.setLayout(null);
		
		JLabel lblcreaMedic = new JLabel("Création d'un médicament");
		lblcreaMedic.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblcreaMedic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cr\u00E9ation / Modification de M\u00E9dicament", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		//panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.setBounds(27, 64, 660, 335);
		//panel_1.setSize(420, 420);
		panel_1.setLayout(null);
		
		JLabel lblNomDuMdicament = new JLabel("Nom du médicament");
		lblNomDuMdicament.setBounds(43, 53, 119, 14);
		panel_1.add(lblNomDuMdicament);
		
		textField = new JTextField();
		textField.setBounds(263, 50, 150, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(43, 174, 119, 14);
		panel_1.add(lblPrix);
		
		textField_1 = new JTextField();
		textField_1.setBounds(263, 110, 150, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTypeDeMdicament = new JLabel("Type de médicament");
		lblTypeDeMdicament.setBounds(43, 113, 119, 14);
		panel_1.add(lblTypeDeMdicament);
		
		textField_2 = new JTextField();
		textField_2.setBounds(263, 168, 150, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description ");
		lblDescription.setBounds(43, 259, 119, 14);
		panel_1.add(lblDescription);
		
		JTextArea txtrDcrire = new JTextArea();
		
		txtrDcrire.setRows(8);
		txtrDcrire.setText("décrire ");
		txtrDcrire.setBounds(263, 234, 321, 68);
		txtrDcrire.setBorder(BorderFactory.createLineBorder(null));
		panel_1.add(txtrDcrire);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(Color.WHITE);
		btnEnregistrer.setBounds(27, 420, 112, 23);
		frame.getContentPane().add(btnEnregistrer);
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
}
