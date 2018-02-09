package enamel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Launcher {

	private JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Launcher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setResizable(false);
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 410, 239);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		frmMainMenu.setLocation(750, 200);
		
		JButton btnAuthorAStory = new JButton("Author a Story");
		btnAuthorAStory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ScenarioLoader.main(null);			// Open Scenario Loader
			}
		});
		btnAuthorAStory.setBounds(99, 98, 199, 23);
		frmMainMenu.getContentPane().add(btnAuthorAStory);
		
		JButton btnPlayAStory = new JButton("Play a Story");
		btnPlayAStory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ToyAuthoring.main(null);			// Load FileChooser
			}
		});
		btnPlayAStory.setBounds(99, 64, 199, 23);
		frmMainMenu.getContentPane().add(btnPlayAStory);
		
		JButton btnAboutTheApp = new JButton("About The App");
		btnAboutTheApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutTheApp.main(null);		// initialize the about screen
				frmMainMenu.dispose();		// hide the main menu
				
			}
		});
		btnAboutTheApp.setBounds(99, 132, 199, 23);
		frmMainMenu.getContentPane().add(btnAboutTheApp);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 			// leave the app
			}
		});
		btnExit.setBounds(99, 166, 196, 23);
		frmMainMenu.getContentPane().add(btnExit);
		
		JLabel lblUntitled = new JLabel("MAIN MENU");
		lblUntitled.setHorizontalAlignment(SwingConstants.CENTER);
		lblUntitled.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 32));
		lblUntitled.setBounds(99, 11, 199, 36);
		frmMainMenu.getContentPane().add(lblUntitled);
		
		JLabel lblVersion = new JLabel("Version 0.1");
		lblVersion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVersion.setBounds(226, 185, 168, 14);
		frmMainMenu.getContentPane().add(lblVersion);
		
		// Accessibility features
		frmMainMenu.getAccessibleContext().setAccessibleName("Main Menu");
		btnPlayAStory.getAccessibleContext().setAccessibleName("Play A Story");
		btnAuthorAStory.getAccessibleContext().setAccessibleName("Author A Story");
		btnAboutTheApp.getAccessibleContext().setAccessibleName("About The App");
		btnExit.getAccessibleContext().setAccessibleName("Exit");
	}
}
