/**
 * Explications ici
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.events;

import java.awt.FlowLayout;
import javax.swing.JFrame;

public class TestEventClass extends JFrame {
	private static final long serialVersionUID = 1L;

	public TestEventClass() {
		super("Testons encore nos �v�nements ");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);		
		setLocationRelativeTo(null);
		
		this.setLayout(new FlowLayout());		
		this.add(new ClicButton());
		this.add(new ExitButton());
		
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new TestEventClass();
	}
}
