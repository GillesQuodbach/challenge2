/**
 * programme qui affiche une image en fond de notre JFrame
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.graphic;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class SwingFile extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public SwingFile() {
		super();			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);		
		setLocationRelativeTo(null);	
		setVisible(true);	
	}

	@Override
	public void paint(Graphics g) {		
		super.paint(g);		
		try {
			Image image = ImageIO.read(new File("iledejava.jpg"));
			g.drawImage(image,0,0,this);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SwingFile();
	}
}
