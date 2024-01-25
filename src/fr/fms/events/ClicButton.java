/**
 * Explications ici
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ClicButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;

	public ClicButton() {
		super("Clic");
		this.addActionListener(this);
		this.setPreferredSize(new MyDimensionButton());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("vous avez cliqu� sur le bouton !");		
	}
}
