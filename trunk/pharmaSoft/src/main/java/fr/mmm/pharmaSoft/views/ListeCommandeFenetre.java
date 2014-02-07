package fr.mmm.pharmaSoft.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import net.sf.jga.swing.GenericTableModel;
import fr.mmm.pharmaSoft.dao.CommandeDao;
import fr.mmm.pharmaSoft.dto.CommandeDTO;
import fr.mmm.pharmaSoft.entity.Commande;
import fr.mmm.pharmaSoft.presentation.LanceurMenuMulticolore;

public class ListeCommandeFenetre extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Commande commande;
	
	private Integer idSelected;
	
	private JLabel libelleTypeMed;
	
	private CommandeDao commandeDao= new CommandeDao();
	

	/**
	 * Create the application.
	 */
	public ListeCommandeFenetre() {
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
		
		JLabel lblcreaMedic = new JLabel("Commandes");
		lblcreaMedic.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblcreaMedic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1,BorderLayout.CENTER);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Liste des commandes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		//panel_1.setBounds(27, 64, 660, 150);
		panel_1.setLayout(new BorderLayout());
		
		List<CommandeDTO> list=this.commandeDao.findAll();
		
		
		if(list!=null && !list.isEmpty()) {
			
			/*********************************/
			TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

			    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

			    public Component getTableCellRendererComponent(JTable table,
			            Object value, boolean isSelected, boolean hasFocus,
			            int row, int column) {
			        if( value instanceof Date) {
			            value = f.format(value);
			        }
			        setHorizontalAlignment(JLabel.LEFT);
			        return super.getTableCellRendererComponent(table, value, isSelected,
			                hasFocus, row, column);
			    }
			};

			/*********************************/
			
			GenericTableModel<CommandeDTO> tabModel = new GenericTableModel<CommandeDTO>(CommandeDTO.class,list);
			tabModel.addColumn(Integer.class, "NoCommande");
			tabModel.addColumn(String.class, "DateCommande");
			tabModel.addColumn(String.class, "LibelleMedicaments");
			tabModel.addColumn(Double.class, "MontantCommande");
			final JTable tableau=new JTable(tabModel, tabModel.getColumnModel());
			tableau.getColumnModel().getColumn(0).setHeaderValue("Numéro");
			tableau.getColumnModel().getColumn(1).setHeaderValue("Date Commande");
			tableau.getColumnModel().getColumn(2).setHeaderValue("Médicaments");
			tableau.getColumnModel().getColumn(3).setHeaderValue("Montant");
			tableau.getTableHeader().setBackground(new Color(0, 250, 154));
			tableau.setPreferredScrollableViewportSize(new Dimension(500, tableau.getRowHeight()*tableau.getRowCount()));
			tableau.setDefaultRenderer(String.class, new MultiLineCellRenderer());
			
			
			tableau.getColumnModel().getColumn(0).setCellRenderer(tableCellRenderer);
			tableau.getColumnModel().getColumn(1).setCellRenderer(tableCellRenderer);
			tableau.getColumnModel().getColumn(3).setCellRenderer(tableCellRenderer);
			
			int lines = 2;
			for(int i=0;i<tabModel.getRowCount();i++){
				CommandeDTO com=tabModel.getRowValue(i);
				Integer j=com.getLibelleMedicaments().split("\n").length;
				if(j==0){
					j=1;
				}
				tableau.setRowHeight(i, j*20);
			}
			
			ListSelectionModel ligneSelectionModel = tableau.getSelectionModel();
			ligneSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ligneSelectionModel.addListSelectionListener(new ListSelectionListener() {
				
				public void valueChanged(ListSelectionEvent selected) {
					int row=tableau.getSelectedRow();
					int idCommande=(Integer)tableau.getValueAt(row, 0);
					ListeCommandeFenetre.this.idSelected=idCommande;
				}
			});
			     
			panel_1.add(new JScrollPane(tableau));
			
			JPanel panelBtn = new JPanel();
			panelBtn.setBackground(Color.WHITE);
			getContentPane().add(panelBtn,BorderLayout.SOUTH);
			
			panelBtn.setLayout(new FlowLayout());
			JButton btnCreer = new JButton("Nouvelle");
			btnCreer.setBackground(Color.CYAN);
			//btnCreer.setBounds(150, 50, 112, 23);
			btnCreer.setActionCommand("fermer");
			btnCreer.addActionListener(this);
			panelBtn.add(btnCreer);
			
			JButton btnMenuPrincipal = new JButton("Menu Principal");
			btnMenuPrincipal.setBackground(Color.WHITE);
			//btnSupprimer.setBounds(150, 150, 112, 23);
			btnMenuPrincipal.setActionCommand("menuPrincipal");
			btnMenuPrincipal.addActionListener(this);
			panelBtn.add(btnMenuPrincipal);
			
		}
		
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public JLabel getLibelleTypeMed() {
		return libelleTypeMed;
	}

	public void setLibelleTypeMed(JLabel libelleTypeMed) {
		this.libelleTypeMed = libelleTypeMed;
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("fermer")){
			CommandeFenetre commandeFenetre = new CommandeFenetre();
			commandeFenetre.setVisible(Boolean.TRUE);
			this.dispose();
		}else if(event.getActionCommand().equals("menuPrincipal")){
			LanceurMenuMulticolore menuPrincipalFenetre = new LanceurMenuMulticolore();
			menuPrincipalFenetre.setVisible(true);
			this.dispose();
		}
			
		
		
	}
	
	
		

}




class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {

	  public MultiLineCellRenderer() {
	    setLineWrap(true);
	    setWrapStyleWord(true);
	    setOpaque(true);
	   
	    
	  }

	  public Component getTableCellRendererComponent(JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column) {
		  
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      setBackground(table.getSelectionBackground());
	    } else {
	      setForeground(table.getForeground());
	      setBackground(table.getBackground());
	    }
	    setFont(table.getFont());
	    if (hasFocus) {
	      setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
	      if (table.isCellEditable(row, column)) {
	        setForeground(UIManager.getColor("Table.focusCellForeground"));
	        setBackground(UIManager.getColor("Table.focusCellBackground"));
	      }
	    } else {
	      setBorder(new EmptyBorder(1, 2, 1, 2));
	    }
	    setText((value == null) ? "" : value.toString());
	    return this;
	  }
	}