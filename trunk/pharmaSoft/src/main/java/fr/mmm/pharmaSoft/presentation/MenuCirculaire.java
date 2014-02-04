package fr.mmm.pharmaSoft.presentation;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import javax.swing.JPanel;

/**
 * <b>MenuCirculaire est la classe qui permet de d�finir un menu circulaire</b>
 * <p>
 * Cette classe est caract�ris�e par les informations suivantes :
 * <ul>
 * <li>La couleur de fond du menu</li>
 * <li>Le rayon s�parant les bulles</li>
 * <li>La taille d'une bulle du menu</li>
 * <li>La liste des items du menu</li>
 * </ul>
 * </p>
 * 
 * @author Julien
 *
 */
public class MenuCirculaire extends JPanel{

	private static final long serialVersionUID = 8334369610498563446L;

	/**
	 * La liste des items du menu
	 */
	private List<ElementMenu> items;

	/**
	 * La taille d'une bulle du menu
	 */
	private int taille;

	/**
	 * Le rayon s�parant les bulles
	 */
	private int rayon;

	/**
	 * La couleur de fond du menu
	 */
	private Color couleur;

	/**
	 * constructeur du menu
	 * @param couleur
	 * 	La couleur de fond du menu
	 * @param width
	 * 	La largeur du menu
	 * @param height
	 * 	La heuteur du menu
	 * @param rayon
	 * 	Le rayon s�parant les bulles
	 * @param taille
	 * 	La taille d'une bulle du menu
	 * @param items
	 * 	La liste des items du menu
	 */
	public MenuCirculaire(Color couleur, int width, int height, int rayon, int taille, List<ElementMenu> items) {
		this.couleur=couleur;
		this.items = items;
		this.taille=taille;
		this.rayon=rayon;
		setSize(width, height);
		build();
	}

	/**
	 * Cette proc�dure permet de placer les bulles sur le menu
	 */
	private void build(){
		if(items!=null && items.size()>0){
			setLayout(null);
			double angle=2*Math.PI/(items.size());
			int xCentre=getWidth()/2;
			int yCentre=getHeight()/2;
			for(int i=items.size()-1; i>=0; i--){
				items.get(i).setBounds((int)(xCentre-taille/2+rayon*Math.cos(i*angle-Math.PI/2)), (int)(yCentre-taille/2+rayon*Math.sin(i*angle-Math.PI/2)), taille+10, taille+10);
				add(items.get(i));
			}
		}
	}

	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(new Point(0, 0), couleur, new Point(getWidth(), getHeight()), new Color(255,255,255,200));
		g2d.setPaint(gradient);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

}
