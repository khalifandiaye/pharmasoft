package fr.mmm.pharmaSoft.presentation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.mmm.pharmaSoft.views.ListeCommandeFenetre;
import fr.mmm.pharmaSoft.views.ListeMedicamentFenetre;
import fr.mmm.pharmaSoft.views.ListeStockFenetre;
import fr.mmm.pharmaSoft.views.ListeTypeMedicamentFenetre;

/**
 * Classe qui definit une bulle
 *
 * @author julien
 *
 */
public class ElementMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	/** 
	 * largeur de la bulle 
	 */
	private int largeur;

	/**
	 *  couleur de la bulle 
	 */
	private Color couleur;

	/**
	 * Couleur de la bulle active
	 */
	private Color couleurActif;

	/**
	 * Couleur de la bulle normale
	 */
	private Color couleurNormal;

	private String texte;
	
	private String code;
	
	/**
	 * Constructeur de bulle
	 * @param couleur : la couleur
	 * @param taille : la taille
	 */
	public ElementMenu(String texte, Color couleurNormal, Color couleurActif, int taille, String code) {
		this.couleur=couleurNormal;
		this.couleurNormal=couleurNormal;
		this.couleurActif=couleurActif;
		this.texte=texte;
		this.code=code;
		largeur=taille;
		this.setSize(new Dimension(largeur + 10, largeur + 10));
		this.setOpaque(false);
		ajouterListener();
	}

	private void ajouterListener(){
		addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				Component component = (Component) e.getSource();
		        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
				if("medicament".equals(code)){
					ListeMedicamentFenetre frameListes=new ListeMedicamentFenetre();
					frameListes.setVisible(true);
					 frame.dispose();
				}else if("typeMedicament".equals(code)){
					ListeTypeMedicamentFenetre frameListes=new ListeTypeMedicamentFenetre();
					frameListes.setVisible(true);
					 frame.dispose();
				}else if("stock".equals(code)){
					ListeStockFenetre frameListes=new ListeStockFenetre();
					frameListes.setVisible(true);
					 frame.dispose();
				}else if("commandes".equals(code)){
					ListeCommandeFenetre frameListes=new ListeCommandeFenetre();
					frameListes.setVisible(true);
					 frame.dispose();
				}
				
		       
				
			}

			public void mouseReleased(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {
				couleur=couleurNormal;
				repaint();
			}

			public void mouseEntered(MouseEvent e) {
				couleur=couleurActif;
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				repaint();
				
			}

		});
	}

	/**
	 * Surcharge de paintComponent
	 */
	public void paint(Graphics arg0) {
		super.paint(arg0);
		Graphics2D g2d = (Graphics2D) arg0;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(couleur);
		g2d.setStroke(new BasicStroke(3));
		GradientPaint gradient = new GradientPaint(largeur / 2, 4, couleur, (largeur) / 2, 4 + largeur, new Color(255,255,255,200));
		g2d.setPaint(gradient);
		g2d.fillOval(4, 4, largeur, largeur);
		gradient = new GradientPaint(largeur / 2, 4, Color.white, largeur / 2, 4 + largeur / 2, new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue(), 0));
		g2d.setPaint(gradient);
		g2d.fillOval(4+largeur/5, 4, 5*largeur/8, largeur/3);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Calibri", Font.BOLD, 14));
		FontMetrics fm = g2d.getFontMetrics();
		int x = (this.getWidth() - fm.stringWidth(texte)) / 2;
		int y = (fm.getAscent() + (this.getHeight() -
				(fm.getAscent() + fm.getDescent())) / 2);
		g2d.drawString(texte, x, y);
	}
}