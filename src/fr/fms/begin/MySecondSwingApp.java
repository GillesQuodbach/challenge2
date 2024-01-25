package fr.fms.begin;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * Dans cette seconde appli swing, on met en evidence les différentes possibilités offertes aux composants
 * tout en introduisant une nouvelle stratégie de placement BorderLayout
 * 
 * @author El babili - 2021
 * 
 */

public class MySecondSwingApp extends JFrame {
	private static final long serialVersionUID = 1L;	
	private static final String TITLE = "ma 2ème appli swing";
	
	public MySecondSwingApp() {
		super(TITLE);			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);		
		setLocationRelativeTo(null);	
		
		JPanel contentPane = (JPanel) this.getContentPane();	//cette fois-ci, on récupère d'abord le conteneur 
	    contentPane.setLayout( new BorderLayout());		// puis on initialise sa stratégie de placement
	    
	    JButton btnClic = new JButton("Clic");
		this.add(btnClic , BorderLayout.NORTH);	
				
		JTextField txtfHello = new JTextField("Hello les stagiaires");
		txtfHello.setPreferredSize(new Dimension(100 , 50));	//cette fois-ci on spécifie la taille minimale
		this.add(txtfHello , BorderLayout.SOUTH);	
		
		this.add(new JLabel("Coucou") , BorderLayout.EAST);		
		this.add(new JTextArea(3, 10) , BorderLayout.CENTER);		
		this.add(new JCheckBox() , BorderLayout.WEST);		
		
		setVisible(true);		
	}

	public static void main(String[] args) {
		new MySecondSwingApp();
	}
}
