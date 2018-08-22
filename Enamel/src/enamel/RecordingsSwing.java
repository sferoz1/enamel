package enamel;

import java.awt.Cursor;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

/**
 * A Sound Recorder program in Java Swing.
 * @author www.codejava.net
 *
 */
public class RecordingsSwing extends JPanel implements ActionListener {


	JButton buttonRecord = new JButton("Record");
	JButton buttonPlay = new JButton("Play");
	JLabel labelRecordTime = new JLabel("Record Time: 00:00:00");
	RecordingsAudioPlayer qplayer = new RecordingsAudioPlayer();
	//JLabel labelRecordTime = new JLabel();
	// Icons used for buttons
	private ImageIcon iconRecord = new ImageIcon(getClass().getResource(
			"Record.gif"));
	private ImageIcon iconStop = new ImageIcon(getClass().getResource(
			"Stop.gif"));
	protected ImageIcon iconPlay = new ImageIcon(getClass().getResource(
			"Play.gif"));
	private RecordingsUtil recorder = new RecordingsUtil();
	private Thread playbackThread;
	private RecordingsTimer timer;
	
	
protected String Time = "sRecord Time: 00:00:00";

//JLabel labelRecordTime = new JLabel(Time);

protected  int marker;

protected ScenarioEvent event1;
	protected String saveFilePath;
	RecordingsAudioPlayer player = new RecordingsAudioPlayer();

	private boolean isRecording = false;
	public boolean isPlaying = false;

	protected static EventEditor currentEvent;

	public RecordingsSwing() {
		//super("Swing Sound Recorder");
		super();
		// currentEvent = e;
		//
		setLayout(new FlowLayout());
		marker = -1;
		buttonRecord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonRecord.setIcon(iconRecord);
		buttonPlay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonPlay.setIcon(iconPlay);
		
		
		buttonPlay.setEnabled(false);
		labelRecordTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		//labelRecordTime.setText("00:00:00");
		
		add(buttonRecord, BorderLayout.WEST);
		add(labelRecordTime, BorderLayout.CENTER);
		add(buttonPlay, BorderLayout.EAST);
		
		buttonRecord.addActionListener(this);
		buttonPlay.addActionListener(this);
		
		
	
	}

	public RecordingsSwing(ScenarioEvent e, String audioPath,String timeLabel,  int qrw) {
		super();
		event1 = e;
		setLayout(new FlowLayout());
		buttonRecord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonRecord.setIcon(iconRecord);
		buttonPlay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonPlay.setIcon(iconPlay);

		if (audioPath!=null){
			buttonPlay.setEnabled(true);
			saveFilePath= audioPath;
		}
		else {buttonPlay.setEnabled(false);}
		labelRecordTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		add(buttonRecord, BorderLayout.WEST);
		add(labelRecordTime, BorderLayout.CENTER);
		add(buttonPlay, BorderLayout.EAST);
		
		buttonRecord.addActionListener(this);
		buttonPlay.addActionListener(this);
		marker = qrw;

		System.out.println(marker);
		
		if (this.marker ==0 && audioPath!=null && e.qAudioLabel !=null) {
			Time = timeLabel;
			System.out.println("swing constructor Time:" + Time);

		}
		else if (this.marker ==1 && audioPath!= null && e.rAudioLabel !=null) {
			Time =  timeLabel;
		}
		else if (this.marker ==2 && audioPath!=null && e.wAudioLabel !=null) {
			Time =  timeLabel;
			//Time = "Record Time: 00:00:00";
		}
		else {
			Time = "Record Time: 00:00:00";
		}
		labelRecordTime.setText(Time);
		
		System.out.println("swing constructor Time:" + Time);
		//pack();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
	
	}

	
	public void setRecordingFilePath(String audioPath){
		this.saveFilePath= audioPath;
		
		
	}
	String getRecordingFilePath() {
		return this.saveFilePath;
	}

	/**
	 * Handle click events on the buttons.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();
		if (button == buttonRecord) {
			if (!isRecording) {
				startRecording();
			} else {
				stopRecording(event1);
			}

		} else if (button == buttonPlay) {
			if (!isPlaying) {
				playBack(event1);
			} else {
				stopPlaying(event1);
			}
		}
	}

	/**
	 * Start recording sound, the time will count up.
	 */
	private void startRecording() {
		Thread recordThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					isRecording = true;
					buttonRecord.setText("Stop");
					buttonRecord.setIcon(iconStop);
					buttonPlay.setEnabled(false);

					recorder.start();

				} catch (LineUnavailableException ex) {
					JOptionPane.showMessageDialog(RecordingsSwing.this,
							"Error", "Could not start recording sound!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
		recordThread.start();
		timer = new RecordingsTimer(labelRecordTime);
		timer.start();
	}

	/**
	 * Stop recording and save the sound into a WAV file
	 */
	private void stopRecording(ScenarioEvent e) {
		isRecording = false;
		try {
			timer.cancel();
			buttonRecord.setText("Record");
			buttonRecord.setIcon(iconRecord);
			
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

			recorder.stop();
			
			Time = labelRecordTime.getText();
			System.out.println("recordingmrker" + marker);
			
				
				
			if (marker ==0) {
					currentEvent.EEqAudLabel = Time;
					System.out.println("save q to  event editor:" + currentEvent.EEqAudLabel);
					if (marker ==0 && e!=null) {
						e.qAudioLabel = Time;
						System.out.println("save q to  event object:" + e.qAudioLabel);

				}
				}
				 if (marker ==1) {
						currentEvent.EErAudLabel = Time;
			if (marker == 1 && e!=null) {
				e.rAudioLabel = Time;
				
				}
			}
				 if (marker ==2) {
						currentEvent.EEwAudLabel = Time;
			if (marker ==2 && e!=null) {
				e.wAudioLabel = Time;
				

					
				}
				
			} 
			System.out.println("*" + labelRecordTime.getText());
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

			saveFile();

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(RecordingsSwing.this, "Error",
					"Error stopping sound recording!",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	/**
	 * Start playing back the sound.
	 */
	public void playBack(ScenarioEvent e) {
		System.out.println("DOES THIS EVEN RUN??");
		timer = new RecordingsTimer(labelRecordTime);
		timer.start();
		isPlaying = true;
		playbackThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {

					buttonPlay.setText("Stop");
					buttonPlay.setIcon(iconStop);
					buttonRecord.setEnabled(false);

					player.play(saveFilePath);
					

					
					
					timer.reset();

					buttonPlay.setText("Play");
					buttonRecord.setEnabled(true);
					buttonPlay.setIcon(iconPlay);
					isPlaying = false;
					/////
					Time = labelRecordTime.getText();
					System.out.println("stopplaying time" + Time);
					if (marker ==0) {
						currentEvent.EEqAudLabel = Time;
						System.out.println("save q to  event editor:" + currentEvent.EEqAudLabel);
						if (marker ==0 && e!=null) {
							e.qAudioLabel = Time;
							System.out.println("save q to  event object:" + e.qAudioLabel);

					}
					}
					 if (marker ==1) {
							currentEvent.EErAudLabel = Time;
				if (marker == 1 && e!=null) {
					e.rAudioLabel = Time;
					
					}
				}
					 if (marker ==2) {
							currentEvent.EEwAudLabel = Time;
				if (marker ==2 && e!=null) {
					e.wAudioLabel = Time;
					

						
					}
					
				}
					
					////

				} catch (UnsupportedAudioFileException ex) {
					ex.printStackTrace();
				} catch (LineUnavailableException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		});

		playbackThread.start();
		
		
		/*Time = labelRecordTime.getText();
		System.out.println("playback time" + Time);
		if (marker ==0) {
			currentEvent.EEqAudLabel = Time;
			System.out.println("save q to  event editor:" + currentEvent.EEqAudLabel);
			if (marker ==0 && e!=null) {
				e.qAudioLabel = Time;
				System.out.println("save q to  event object:" + e.qAudioLabel);

		}
		}
		 if (marker ==1) {
				currentEvent.EErAudLabel = Time;
	if (marker == 1 && e!=null) {
		e.rAudioLabel = Time;
		
		}
	}
		 if (marker ==2) {
				currentEvent.EEwAudLabel = Time;
	if (marker ==2 && e!=null) {
		e.wAudioLabel = Time;
		

			
		}
		
	}*/
	}

	/**
	 * Stop playing back.
	 * 
	 *
	 */
	public void loadFile(String file){
		
		
	}
	

	public void stopPlaying(ScenarioEvent e) {
		timer.reset();
		timer.interrupt();
		
	
		
		player.stop();
		
		///////////////////////////////////
	
		 ////
			playbackThread.interrupt();
			
			Time = labelRecordTime.getText();
			System.out.println("stopplaying time" + Time);
			if (marker ==0) {
				currentEvent.EEqAudLabel = Time;
				System.out.println("save q to  event editor:" + currentEvent.EEqAudLabel);
				if (marker ==0 && e!=null) {
					e.qAudioLabel = Time;
					System.out.println("save q to  event object:" + e.qAudioLabel);

			}
			}
			 if (marker ==1) {
					currentEvent.EErAudLabel = Time;
		if (marker == 1 && e!=null) {
			e.rAudioLabel = Time;
			
			}
		}
			 if (marker ==2) {
					currentEvent.EEwAudLabel = Time;
		if (marker ==2 && e!=null) {
			e.wAudioLabel = Time;
			

				
			}
			
		}

	}

	/**
	 * Save the recorded sound into a WAV file.
	 */
	/////////////Save File and assign the name to Event Editor's Question
	private void saveFile() {
		/*File wavFile = new File(".");
		if (!saveFilePath.toLowerCase().endsWith(".wav")) {
			saveFilePath += ".wav";
		}
	

		try {
			recorder.save(wavFile);
			buttonPlay.setEnabled(true);

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(RecordingsSwing.this, "Error",
					"Error saving to sound file!",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
		
	}*/
		JFileChooser fileChooser = new JFileChooser();
		FileFilter wavFilter = new FileFilter() {
			@Override
			public String getDescription() {
				return "Sound file (*.WAV)";
			}

			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) {
					return true;
				} else {
					return file.getName().toLowerCase().endsWith(".wav");
				}
			}
		};

		fileChooser.setFileFilter(wavFilter);
		fileChooser.setAcceptAllFileFilterUsed(false);

		int userChoice = fileChooser.showSaveDialog(this);
		if (userChoice == JFileChooser.APPROVE_OPTION) {
			saveFilePath = fileChooser.getSelectedFile().getAbsolutePath();
			if (!saveFilePath.toLowerCase().endsWith(".wav")) {
				saveFilePath += ".wav";
			}

			File wavFile = new File(saveFilePath);

			try {
				recorder.save(wavFile);

				JOptionPane.showMessageDialog(RecordingsSwing.this,
						"Saved recorded sound to:\n" + saveFilePath +"\n has been added to your scenario");
				this.saveFilePath = saveFilePath;
				
				

				buttonPlay.setEnabled(true);

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(RecordingsSwing.this, "Error",
						"Error saving to sound file!",
						JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}

	/**
	 * launch the program
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new RecordingsSwing().setVisible(true);
			}
		});
	}

}