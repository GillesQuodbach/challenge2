/**
 * programme qui affiche une image en fond de notre JFrame
 * 
 * @author El babili - 2021
 * 
 */

package fr.fms.graphic;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingFile extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Notre super app";
	
	JLabel clockLabel;
	JLabel chronoLabel;
	
	public SwingFile() {
		super(TITLE);			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);		
		setLocationRelativeTo(null);
		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(new BorderLayout());
		
		//HORLOGE
		clockLabel = new JLabel();
		clockLabel.setFont(new Font("Serif", Font.BOLD,30));
//		clockLabel.setForeground(Color.RED);
//		clockLabel.setBackground(Color.ORANGE);
//		clockLabel.setOpaque(true);
		this.add(clockLabel, BorderLayout.NORTH);
		
		//CHRONO
		chrono();
		
		// Horloge
		Thread thread = new Thread(this);
		thread.start();
		
		
		setVisible(true);	
	}
	
	public void chrono() {
		chronoLabel = new JLabel();
		chronoLabel.setFont(new Font("Serif", Font.BOLD,30));
		
		this.add(chronoLabel);
		
		JButton chronoBtn = (new JButton("CLIC"));
		chronoBtn.setPreferredSize(new Dimension(100,50));
		this.add(chronoBtn, BorderLayout.SOUTH);
		
		
//		DateFormat df = new SimpleDateFormat("HH:mm:ss");
//		while (true) {
//			try {
//			String clock =df.format(new Date());
//			clockLabel.setText(clock);
//			
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
		
		public void run() {

			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			while (true) {
				try {
				String clock =df.format(new Date());
				//Méthode ajout variable clock au JFrame
				clockLabel.setText(clock);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
	

//	@Override
//	public void paint(Graphics g) {		
//		super.paint(g);		
//		try {
//			Image image = ImageIO.read(new File("iledejava.jpg"));
//			g.drawImage(image,0,0,this);
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
//	}

	
	
	public static void main(String[] args) {
		new SwingFile();
	}
}
