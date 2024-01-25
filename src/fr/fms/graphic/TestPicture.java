/**
 * programme qui affiche plusieurs formes géométriques sur fond d'une image
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.graphic;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class TestPicture extends JFrame {
	private static final long serialVersionUID = 1L;

	public TestPicture() {
		super("Jouons avec Swing !");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);		
		setLocationRelativeTo(null);	
		setVisible(true);			
	}
	
	@Override
	public void paint(Graphics g) {	//le repère x,y commence en haut à gauche (0,0)
		super.paint(g);
		g.fillOval(50, 50, 35, 35);	// x , y , largeur , hauteur (diamètre)
		g.drawOval(150, 50, 45, 70);
		g.drawRect(50, 150, 50, 50);
		g.fillRect(150, 150, 70, 50);		
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint( new GradientPaint(0, 0, Color.GREEN, 50, 50, Color.RED,true));
		g2d.fillRect(250, 50, 70, 50);		
	}
	
	public static void main(String[] args) {
		
	}
}
