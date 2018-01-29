package enamel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutTheApp {

	private JFrame frmAboutTheApp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutTheApp window = new AboutTheApp();
					window.frmAboutTheApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AboutTheApp() {
		initialize();
	

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAboutTheApp = new JFrame();
		frmAboutTheApp.setResizable(false);
		frmAboutTheApp.setTitle("About The App");
		frmAboutTheApp.setBounds(100, 100, 450, 300);
		frmAboutTheApp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAboutTheApp.getContentPane().setLayout(null);
		frmAboutTheApp.setLocation(750, 200);
		
		JLabel lblEecsl = new JLabel("Made for EECS 2311");
		lblEecsl.setFont(new Font("Microsoft YaHei", Font.ITALIC, 14));
		lblEecsl.setHorizontalAlignment(SwingConstants.CENTER);
		lblEecsl.setBounds(121, 163, 179, 43);
		frmAboutTheApp.getContentPane().add(lblEecsl);
		
		JLabel lblCreatedBy = new JLabel("CREATED BY:");
		lblCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedBy.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 28));
		lblCreatedBy.setBounds(121, 39, 179, 43);
		frmAboutTheApp.getContentPane().add(lblCreatedBy);
		
		JLabel lblSaraAttalla = new JLabel("<html>Sara Attalla<br>Sarah Feroz<br> Sean Doyle</html>");
		lblSaraAttalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaraAttalla.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
		lblSaraAttalla.setBounds(121, 92, 179, 72);
		frmAboutTheApp.getContentPane().add(lblSaraAttalla);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAboutTheApp.dispose();
				Launcher.main(null);
			}
		});
		btnMainMenu.setBounds(121, 217, 179, 31);
		frmAboutTheApp.getContentPane().add(btnMainMenu);
	}

}
