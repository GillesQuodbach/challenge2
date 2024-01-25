/**
 * Explications ici
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.events;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ExitButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;

	public ExitButton() {
		super("X");
		this.addActionListener(this);
		this.setPreferredSize(new MyDimensionButton());
		this.setBackground(Color.RED);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
