/**
 * Explications ici
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.events;

import java.awt.Dimension;

public class MyDimensionButton extends Dimension {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 100;
	private static final int HEIGHT = 35;

	public MyDimensionButton() {
		super(WIDTH, HEIGHT);
	}
	public MyDimensionButton(int width, int height) {
		super(width, height);
	}	
}
