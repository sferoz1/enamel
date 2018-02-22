package enamel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class SucessfulScenFileCreation extends JFrame {

	private JPanel contentPane;
	private Scenario scenarioCreated;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SucessfulScenFileCreation frame = new SucessfulScenFileCreation(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SucessfulScenFileCreation(Scenario scenarioCreated) {
		this.scenarioCreated = scenarioCreated;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 118);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scenario File"+ scenarioCreated.Title + "has been successfully created.");
		lblNewLabel.setBounds(43, 6, 332, 61);
		contentPane.add(lblNewLabel);
	}

}
