/**
 * Explications ici
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.events;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestEventLambda extends JFrame {
	private static final long serialVersionUID = 1L;

	public TestEventLambda() {
		super("Testons une expression lambda ");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);		
		setLocationRelativeTo(null);			
		this.setLayout(new FlowLayout());		
		initButton();		
		setVisible(true);	
	}

	private void initButton() {
		JButton exit = new JButton("X");
		exit.setBackground(Color.RED);
		this.add(exit);		
		exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	System.exit(0);
            }
        });				
		
		JButton clic = new JButton("clic");
		this.add(clic);				
		clic.addActionListener(event -> System.out.println("vous avez cliqué sur le bouton !"));
							//argument -> corps	
	}

	public static void main(String[] args) {
		new TestEventLambda();
	}
}
