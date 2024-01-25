/**
 * Explications ici
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.events;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TestEventAdapter extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtWelcome = new JTextField();

	public TestEventAdapter() {
		super("Testons nos adapteurs ");			
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);		
		setLocationRelativeTo(null);			
		this.setLayout(new FlowLayout());
		txtWelcome.setPreferredSize(new Dimension(70,30));
		this.add(txtWelcome);
		initAdapter();		
		setVisible(true);	
	}

	private void initAdapter() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
                System.out.println("bye");
                System.exit(0);
            }            
            @Override
            public void windowOpened(WindowEvent e) {
            	txtWelcome.setText("Welcome");
            	System.out.println("welcome to my window");
            }
       });		
	}
	
	public static void main(String[] args) {
		new TestEventAdapter();
	}
}
