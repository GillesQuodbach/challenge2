/**
 * Explications ici
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.events;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestEventJtextField extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JTextField txtName;
	private JLabel txtRep;

	public TestEventJtextField() {
		super("R�cup�rons une saisie suite � un clic");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);		
		setLocationRelativeTo(null);			
		this.setLayout(new FlowLayout());		
		
		initRead();
		initButton();		
		setVisible(true);	
	}
	
	private void initRead() {
		JLabel lblName = new JLabel("saisir nom ");	
		lblName.setPreferredSize(new Dimension(100,25));
		this.getContentPane().add(lblName);
		txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(100,25));
		this.getContentPane().add(txtName);
		txtRep = new JLabel("");
		txtRep.setForeground(Color.RED);
		txtRep.setPreferredSize(new Dimension(100,25));
		this.getContentPane().add(txtRep);
	}

	private void initButton() {
		JButton clic = new JButton("clic");
		this.add(clic);		
		clic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               txtRep.setText("Bonjour " + txtName.getText());                
            }
        });	
	}

	public static void main(String[] args) {
		new TestEventJtextField();
	}
}
