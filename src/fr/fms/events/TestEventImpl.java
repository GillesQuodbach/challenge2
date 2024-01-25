package fr.fms.events;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Explications ici
 * 
 * @author El babili - 2021
 * 
 */

public class TestEventImpl extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton clic;
	private JButton exit;

	public TestEventImpl() {
		super("Testons nos �v�nements diff�remment ");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);		
		setLocationRelativeTo(null);			
		
		this.setLayout(new FlowLayout());	
		clic = new JButton("clic");
		this.add(clic);
		clic.addActionListener(this);
		
		exit = new JButton("X");
		exit.setBackground(Color.RED);
		this.add(exit);
		exit.addActionListener(this);
				
		setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == clic)	System.out.println("vous avez cliqu� sur le bouton !");
		else if(e.getSource() == exit)	System.exit(0);
	}
	
	public static void main(String[] args) {
		new TestEventImpl();
	}
}
