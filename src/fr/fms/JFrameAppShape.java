package fr.fms;

import java.awt.Graphics;
import javax.swing.JFrame;

import org.w3c.dom.css.Counter;

import fr.fms.entities.Circle;
import fr.fms.entities.Point;
import fr.fms.entities.Square;
import fr.fms.job.IJobImpl;

public class JFrameAppShape extends JFrame {
	private static final long serialVersionUID = 1L;
	private IJobImpl<Integer> shapesJobImpl = null;
	private static int counter = 0;
	
	public JFrameAppShape(){
        setTitle("Drawing shapes");
        setSize(400, 400);
        setLocationRelativeTo(null);	
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        this.shapesJobImpl = new IJobImpl<Integer>();	
        //1 : je dois avoir accès à une implementation de l'interface de gestion des formes géométriques 
        counter = 0;
    }
	
	@Override 
	public void paint(Graphics g) { //méthode appelée à chaque redimensionnement de la fenêtre
		super.paint(g);
		System.out.print(" --- ");
		if(shapesJobImpl != null) 		shapesJobImpl.drawShapes(g);
		//2 : à chaque redimensionnement de la fenêtre, afficher toutes les formes
		System.out.println(counter++);
	}	 
	
	public static void main(String[] args) {
		Circle<Integer> c1 = new Circle<Integer>(20 , 30, 50);	//rayon + x + y	
		Point<Integer> p = new Point<Integer>( 100 , 150);
		Circle<Integer> c2 = new Circle<Integer>(15 , p);		
		Square<Integer> s1 = new Square<Integer>(50 , 200 , 200);	//cote + x + y
		Square<Integer> s2 = new Square<Integer>(65, 200 , 50);		
		Circle<Integer> c3 = new Circle<Integer>(30 , 300 , 300);	//rayon + x + y
		
		JFrameAppShape frameApp = new JFrameAppShape();			//3 : création de la fenêtre
		
		IJobImpl<Integer> jobImpl = frameApp.getShapesJob();	//4 : on récupère notre gestionnaire des formes pour en rajouter
		jobImpl.addShape(1,c1);	
		jobImpl.addShape(2,c2);	
		jobImpl.addShape(3,s1);		
		jobImpl.addShape(4,s2);
		jobImpl.addShape(5,c3);
		
		jobImpl.calcAreas();
	}

	public IJobImpl<Integer> getShapesJob() {
		return shapesJobImpl;
	}
}
