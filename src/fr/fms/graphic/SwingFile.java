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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SwingFile extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Notre super app";
	
	JLabel clockLabel;
	JLabel chronoLabel;
	JLabel LabelTimerMin;
	JLabel LabelTimerSec;
	JLabel LabelTimerMs;
	JButton BtnStart;
	JButton BtnReset;
	Timer timer;
	public int min = 0;
	public int sec = 0;
	public int ms = 0;
	
	public SwingFile() {
		super(TITLE);			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);		
		setLocationRelativeTo(null);
		LabelTimerMin = new JLabel("00");
		LabelTimerSec = new JLabel("00");
		LabelTimerMs = new JLabel("00");
		BtnStart = new JButton("Start");
		BtnReset = new JButton("Reset");
		timer = new Timer(10, new Check());
	
		BtnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BtnStartActionPerformed(e);
			}
		});
		
		BtnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BtnResetActionPerformed(e);
			}
		});
		
		JPanel mainPanel = (JPanel) this.getContentPane();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel timerPanel = new JPanel();
		timerPanel.setLayout(new GridLayout(3,3));
		mainPanel.add(timerPanel, BorderLayout.SOUTH);
		
		timerPanel.add(LabelTimerMin);
		LabelTimerMin.setFont(new Font("Serif", Font.BOLD,30));
		timerPanel.add(LabelTimerSec);
		LabelTimerSec.setFont(new Font("Serif", Font.BOLD,30));
		timerPanel.add(LabelTimerMs);
		LabelTimerMs.setFont(new Font("Serif", Font.BOLD,30));
		timerPanel.add(BtnStart);
		BtnStart.setFont(new Font("Serif", Font.BOLD,30));
		timerPanel.add(BtnReset);
		BtnReset.setFont(new Font("Serif", Font.BOLD,30));
		
		//HORLOGE
		clockLabel = new JLabel();
		clockLabel.setFont(new Font("Serif", Font.BOLD,30));
//		clockLabel.setForeground(Color.RED);
//		clockLabel.setBackground(Color.ORANGE);
//		clockLabel.setOpaque(true);
		this.add(clockLabel);
		
		//CHRONO
		
		
		// Horloge
		
		
		Thread thread = new Thread(this);
		thread.start();
		setVisible(true);	
	}
	
	public void chrono() {


	
		
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
	
	private void BtnStartActionPerformed(ActionEvent evt) {
		if(BtnStart.getText().equals("Start")) {
			BtnStart.setText("Stop");
			timer.start();
		}else {
			BtnStart.setText("Start");
			timer.stop();
		}
	}
	
	private void BtnResetActionPerformed(ActionEvent evt) {
		min = 0;
		sec = 0;
		ms = 0;
		LabelTimerMin.setText("00");
		LabelTimerSec.setText("00");
		LabelTimerMs.setText("00");
		timer.stop();
		BtnStart.setText("Start");
	}
	
	class Check implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			ms += 1;
			if(ms==100) {
				sec += 1;
				ms = 0;
			}
			if(sec==60) {
				min += 1;
				sec = 0;
			}
			if (ms < 10) {
				LabelTimerMs.setText("0" + ms);
			}else {
			LabelTimerMs.setText(String.valueOf(ms));
			}
			if (sec < 10) {
				LabelTimerSec.setText("0" + sec);
			}else {
				LabelTimerSec.setText(String.valueOf(sec));
			}
			if (min < 10) {
				LabelTimerMin.setText("0" + min);
			}else {
				LabelTimerMin.setText(String.valueOf(min));
			}
			
		}
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
