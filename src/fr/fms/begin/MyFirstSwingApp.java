package fr.fms.begin;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Il s'agit de notre première appli desktop utilisant Swing 
 * 
 * @author El babili - 2021
 * 
 */

public class MyFirstSwingApp extends JFrame {
	private static final long serialVersionUID = 1L;	//on implémente Serializable, indispensable sinon warning
	private static final String TITLE = "ma 1ère appli swing";
	
	public MyFirstSwingApp() {
		super(TITLE);			//titre de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Fin du thread quand clic sur croix
		setSize(500, 300);		//taille de la fenêtre en pixel (largeur, hauteur)
		setLocationRelativeTo(null);	//avec la valeur null, la fenêtre sera affichée au centre de notre écran
		
		this.setLayout(new FlowLayout());	//initialise la stratégie de placement du conteneur 
		//FlowLayout provoque l'ajout des composants à la suite les uns des autres
		this.add(new JButton("Clic"));		//ajout d'un bouton sans action
		this.add(new JTextField("Hello les stagiaires"));	//ajout d'une ligne de saisie de texte
		this.add(new JLabel("Coucou"));		//ajout d'un label
		this.add(new JTextArea(3, 10));		//ajout d'une zone de saisie de texte
		this.add(new JCheckBox());			//ajout d'une case à cocher
		
		setVisible(true);		//la fenêtre devient visible ici
	}

	public static void main(String[] args) {
		new MyFirstSwingApp();
	}
}
