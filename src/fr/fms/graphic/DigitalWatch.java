package fr.fms.graphic;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class DigitalWatch extends JFrame implements Runnable, ActionListener{

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "My digital watch";
	private JLabel clockLabel;
	private JPanel panelCenter;
	private JPanel alarmPanel;
	private JLabel stopWatch;
	private JButton start, reset, stop;
	private String timer;
	private Timer alarmTimer;
	private DefaultListModel<String> alarmListModel;
	private JList<String> alarmList;
	private ArrayList<Calendar> alarms = new ArrayList<Calendar>();
	boolean on;
	int minute, second, millisecond;
	
	public DigitalWatch() {
		super(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,400);
		setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		alarmPanel = new JPanel();
		contentPane.add(alarmPanel, BorderLayout.SOUTH);
		
		Thread thread = new Thread(this);
		thread.start();
		
		clockLabel = new JLabel();
		clockLabel.setFont(new Font("serif", Font.BOLD, 40));
		this.add(clockLabel, BorderLayout.NORTH);
		timer();
		alarmClock();
		setVisible(true);
	}
	
	public void timer() {		
		minute = second = millisecond = 0;
		stopWatch = new JLabel();
		stopWatch.setFont(new Font("serif", Font.BOLD, 40));
		timer = "00:00:00";
		stopWatch.setText(timer);
		panelCenter.add(stopWatch, BorderLayout.CENTER);
		JButton start = new JButton("Start");
		start.addActionListener(event -> {on = true; 
											Thread timerThread = new Thread() {
												public void run() {
													while(on) {
														try {
															Thread.sleep(10);
															
															updateTimer();
															
															printLabel();
															
														}catch(InterruptedException e) {
															e.printStackTrace();
														}
													}
												}
											};
											timerThread.start();});
		panelCenter.add(start, BorderLayout.CENTER);
		JButton reset = new JButton("reset");
		reset.addActionListener(event -> {on = false;
											reset();
											printLabel();});
		panelCenter.add(reset, BorderLayout.CENTER);
		JButton stop = new JButton("stop");
		stop.addActionListener(event -> on = false);
		panelCenter.add(stop, BorderLayout.CENTER);
		
	}
	
	public void updateTimer() {
		millisecond++;
		if(millisecond == 100) {
			millisecond = 0;
			second++;
			if(second == 60) {
				second = 0;
				minute++;	
			}
		}
	}
	
	public void printLabel() {
		
		if(minute < 10) {
			timer = "0" + minute + ":";
		}else timer = minute + ":";
		
		if(second < 10) {
			timer += "0" + second + ":";
		}else timer += second + ":";
		
		if(millisecond < 100) {
			timer += millisecond;
		}
		
		stopWatch.setText(timer);
	}
	
	public void reset() {
		try {
			Thread.sleep(10);
		}catch(Exception e) {
			e.printStackTrace();
		}
		minute = second = millisecond = 0;
	}
	
	public void alarmClock() {
		JTextArea alarmField = new JTextArea();
		JLabel hours = new JLabel("Heures :");
		JTextField hoursField = new JTextField(2);
		JLabel minutes = new JLabel("Minutes :");
		JTextField minutesField = new JTextField(2);
		JButton addAlarm = new JButton("Ajouter");
		JButton removeAlarm = new JButton("Supprimer");
		alarmListModel = new DefaultListModel<String>();
		alarmList = new JList<String>(alarmListModel);
		JScrollPane scrollPane = new JScrollPane(alarmList);
		alarmPanel.add(scrollPane, BorderLayout.SOUTH);
		alarmPanel.add(alarmField, BorderLayout.SOUTH);
		alarmPanel.add(hours, BorderLayout.SOUTH);
		alarmPanel.add(hoursField, BorderLayout.SOUTH);
		alarmPanel.add(minutes, BorderLayout.SOUTH);
		alarmPanel.add(minutesField, BorderLayout.SOUTH);
		alarmPanel.add(addAlarm, BorderLayout.SOUTH);
		alarmPanel.add(removeAlarm, BorderLayout.SOUTH);
		updateAlarmList();
		addAlarm.addActionListener(event -> {
			int hour = Integer.parseInt(hoursField.getText());
			int minute = Integer.parseInt(minutesField.getText());
			Calendar alarm = Calendar.getInstance();
			alarm.set(Calendar.HOUR_OF_DAY, hour);
			alarm.set(Calendar.MINUTE, minute);
			alarm.set(Calendar.SECOND, 0);
			alarms.add(alarm);
			updateAlarmList();
		});
		
		removeAlarm.addActionListener(event -> {
			int selectIndex = alarmList.getSelectedIndex();
			if(selectIndex != -1) {
				alarms.remove(selectIndex);
				updateAlarmList();
			}
		});
		alarmTimer = new Timer(1000, event -> {
			updateClock();
			checkAlarm();
		});
		
		alarmTimer.start();
	}
	
	public void updateClock() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String time = formatter.format(new Date());
		clockLabel.setText(time);
	}
	
	public void updateAlarmList() {
		alarmListModel.clear();
		for(Calendar alarm : alarms) {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			String alarmTime = df.format(alarm.getTime());
			alarmListModel.addElement(alarmTime);;
		}
	}
	
	public void checkAlarm() {
		try {
			for(Calendar alarm : alarms) {
				if(alarm.getTimeInMillis() <= System.currentTimeMillis()) {
					ringAlarm(alarm);
					alarms.remove(alarm);
					updateAlarmList();
					alarmTimer.start();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ringAlarm(Calendar alarm) {
		//alarmTimer.stop();
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(this, "Time'up!", "Alarm", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Date date = Calendar.getInstance().getTime();
				
				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
				String timeString = formatter.format(date);
				  
				clockLabel.setText(timeString);
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(start)) {
			on = true;
			new Thread(this).start();
		}else if(e.getSource().equals(reset)) {
			on = false;
			reset();
			printLabel();
		}else on = false;
		
		
	}
	
	public static void main(String[] args) {
		new DigitalWatch();
	}

	
	
}
