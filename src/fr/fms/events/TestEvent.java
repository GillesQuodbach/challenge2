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

public class TestEvent extends JFrame {
	private static final long serialVersionUID = 1L;

	public TestEvent() {
		super("Testons nos �v�nements ");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);		
		setLocationRelativeTo(null);			
		this.setLayout(new FlowLayout());		
		initButton();		
		setVisible(true);	
	}

	private void initButton() {
		JButton clic = new JButton("clic");
		this.add(clic);		
		clic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("vous avez cliqu� sur le bouton !");
                System.out.println(event.getSource());
            }
        });	
		
		JButton exit = new JButton("X");
		exit.setBackground(Color.RED);
		this.add(exit);		
		exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	System.exit(0);
            }
        });			
	}

	public static void main(String[] args) {
		new TestEvent();
	}
}
