/**
 * Appli graphique permettant à un concessionnaire de véhicules d'occasions d'ajouter des voitures à son stock avec des caractéristiques
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.cars;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class Dealer extends JFrame {	
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 100;	//largeur
	private static final int HEIGHT = 25;	//hauteur	
	private static final String WELCOME_MSG = "bienvenue dans votre application\nsaisissez les champs puis valider";
	private JTextField txtMarque;	
	private JTextField txtType;
	private JTextField txtPrice;
	private JCheckBox check;
	private JComboBox<String> combo;
	private JTextArea txtaCars;
	private ArrayList<Car>	cars;
	
	public Dealer() {
		super("Renault Occasions");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 500);		
		setLocationRelativeTo(null);	
		setResizable(false); 
		initView();		
		setVisible(true);
		cars = new ArrayList<Car>();
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel( new NimbusLookAndFeel() );
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new Dealer();
	}

	public void initView() {
		this.getContentPane().setLayout( new BorderLayout());	    
	    initNorth();
	    initCenter();
	    initSouth();	
	}
	
	private void initNorth() {
		JPanel panelNorth = new JPanel();	    
	    JTextArea txtaWelcome = new JTextArea(WELCOME_MSG);	    
	    txtaWelcome.setPreferredSize(new Dimension(200,50));
	    txtaWelcome.setEnabled(false);
	    panelNorth.add(txtaWelcome,SwingConstants.CENTER);	    
	    this.getContentPane().add(panelNorth , BorderLayout.NORTH);			
	}

	private void initCenter() {
		JPanel panelCenter = new JPanel();	 
		panelCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lblMarque = new JLabel("Marque");
	    lblMarque.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelCenter.add(lblMarque);
		txtMarque = new JTextField();
		txtMarque.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelCenter.add(txtMarque);
		
		JLabel lblType = new JLabel("Type");
		lblType.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelCenter.add(lblType);
		txtType = new JTextField();
		txtType.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelCenter.add(txtType);
		
		JLabel lblPrice = new JLabel("Price");							//formatage de l'affichage
		lblPrice.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelCenter.add(lblPrice);
		txtPrice = new JTextField();
		txtPrice.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelCenter.add(txtPrice);		
		
		JLabel lblCheck = new JLabel("CT Ok");
		lblCheck.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelCenter.add(lblCheck);
		check = new JCheckBox();
		check.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelCenter.add(check);
		
		JLabel lblCombo = new JLabel("Travaux");
		lblCombo.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelCenter.add(lblCombo);
		String[] list = {"aucun", "leger" , "moyen" , "important"}; 
		combo = new JComboBox<String>(list);
		combo.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelCenter.add(combo);
		
		JLabel lblArticles = new JLabel(" Liste des voitures récemment ajoutées :");
		lblArticles.setPreferredSize(new Dimension(250,25));
		panelCenter.add(lblArticles);
		
		txtaCars = new JTextArea();	    	    
		txtaCars.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtaCars);
		scrollPane.setPreferredSize(new Dimension(270,100));
	    panelCenter.add(scrollPane);
		
	    this.getContentPane().add(panelCenter , BorderLayout.CENTER);			
	}

	private void initSouth() {
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
		 
		JButton btnOk = new JButton("Ajouter");
		btnOk.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                   if(displayCars() == false)	{
                	   warning();                	  
                   }
            }
        });	
		panelSouth.add(btnOk);
		this.getContentPane().add(panelSouth , BorderLayout.SOUTH);			
	}
	
	private static void warning() {
		 JOptionPane.showMessageDialog(null, "Vous n'avez pas rempli tous les champs", "Attention", JOptionPane.WARNING_MESSAGE);
	}
	
	private boolean displayCars() {
		String brand,type;
		double price;
		boolean ct;
		String repair;
		
		brand = txtMarque.getText();
		if(brand.equals(""))	return false;
		
		type = txtType.getText();
		if(type.equals(""))	return false;
		
		try {
			price = Double.valueOf(txtPrice.getText());
		}
		catch(Exception e) {
			System.out.println("mauvaise saisie");
			return false;
		}		
		ct = check.isSelected();
		repair = combo.getSelectedItem().toString();
		
		Car car = new Car(brand,type,ct,repair,price);
		cars.add(car);
		
		String str = "";
		for(Car c : cars) {
			str += c.toString() + "\n";
		}
		
		txtaCars.setText(str);	
		clearAll();
		return true;
	}
	
	private void clearAll() {
		txtMarque.setText("");
		txtType.setText("");
		txtPrice.setText("");
		check.setSelected(false);
		combo.setSelectedIndex(0);
	}
}
