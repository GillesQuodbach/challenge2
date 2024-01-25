package fr.fms.begin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * 
 * Dans cette troisième appli swing, on met en evidence les différentes possibilités offertes aux composants
 * tout en introduisant une nouvelle stratégie de placement GridLayout
 * 
 * @author El babili - 2021
 * 
 */

public class MyThirdSwingApp extends JFrame {
	private static final long serialVersionUID = 1L;	
	private static final String TITLE = "ma 3ème appli swing";
	
	public MyThirdSwingApp() {
		super();			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);		
		setLocationRelativeTo(null);	
		
		initView();		// quand le code commence à être important, utiliser des méthodes !
		
		setVisible(true);		
	}
	
	public void initView() {
		JPanel contentPane = (JPanel) this.getContentPane();	//cette fois-ci, on récupère d'abord le conteneur 
	    contentPane.setLayout( new BorderLayout());				// puis on initialise sa stratégie de placement
	    
	    JPanel panelCenter = new JPanel();						//ajout d'un panel qui sera au centre du panel principale
	    panelCenter.setLayout(new GridLayout(3, 3));			//affectation d'une stratégie de placement en grille de 3*3
	    for(int i=1; i<10 ;i++) {
	    	panelCenter.add(new JButton(String.valueOf(i)));	//ajout de Boutons de 1 à 9
	    }
	    contentPane.add(panelCenter , BorderLayout.CENTER);		//ajout du "panelCenter" au centre du panel principale
				
		JTextField txtfHello = new JTextField("Hello les stagiaires");
		txtfHello.setPreferredSize(new Dimension(100 , 50));	//cette fois-ci on spécifie la taille minimale
		this.add(txtfHello , BorderLayout.SOUTH);	
		
		this.add(new JLabel("Coucou") , BorderLayout.EAST);			
		this.add(new JCheckBox() , BorderLayout.WEST);		
	}

	public static void main(String[] args) {	
		try {
			UIManager.setLookAndFeel( new NimbusLookAndFeel() );
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		MyThirdSwingApp mySwingApp = new MyThirdSwingApp();
		mySwingApp.setTitle(TITLE);
		
		JFrame frame = new JFrame("Une autre fenêtre");	//autre manière d'instancier une fenêtre !
		frame.setSize(250, 150);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setVisible(true);
	}
}
