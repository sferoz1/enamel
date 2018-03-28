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

	protected JButton buttonRecord = new JButton("Record");
	protected JButton buttonPlay = new JButton("Play");
	private JLabel labelRecordTime = new JLabel("Record Time: 00:00:00");

	private RecordingsUtil recorder = new RecordingsUtil();
	private RecordingsAudioPlayer player = new RecordingsAudioPlayer();
	private Thread playbackThread;
	private RecordingsTimer timer;

	private boolean isRecording = false;
	private boolean isPlaying = false;

	public static String saveFilePath;
	protected static EventEditor currentEvent;

	// Icons used for buttons
	private ImageIcon iconRecord = new ImageIcon(getClass().getResource(
			"Record.gif"));
	private ImageIcon iconStop = new ImageIcon(getClass().getResource(
			"Stop.gif"));
	private ImageIcon iconPlay = new ImageIcon(getClass().getResource(
			"Play.gif"));

	public RecordingsSwing() {
		//super("Swing Sound Recorder");
		super();
		// currentEvent = e;
		//
		setLayout(new FlowLayout());

		buttonRecord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonRecord.setIcon(iconRecord);
		buttonPlay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonPlay.setIcon(iconPlay);
		buttonPlay.setEnabled(false);
		labelRecordTime.setFont(new Font("Tahoma", Font.PLAIN, 12));

		add(buttonRecord, BorderLayout.WEST);
		add(labelRecordTime, BorderLayout.CENTER);
		add(buttonPlay, BorderLayout.EAST);
		
		buttonRecord.addActionListener(this);
		buttonPlay.addActionListener(this);
		
		
		
		//pack();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
	
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
				stopRecording();
			}

		} else if (button == buttonPlay) {
			if (!isPlaying) {
				playBack();
			} else {
				stopPlaying();
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
	private void stopRecording() {
		isRecording = false;
		try {
			timer.cancel();
			buttonRecord.setText("Record");
			buttonRecord.setIcon(iconRecord);
			
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

			recorder.stop();

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
	private void playBack() {
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
	}

	/**
	 * Stop playing back.
	 */
	private void stopPlaying() {
		timer.reset();
		timer.interrupt();
		player.stop();
		playbackThread.interrupt();
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
						"Saved recorded sound to:\n" + saveFilePath);
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