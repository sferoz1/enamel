package enamel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScenarioLoader extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ScenarioLoader dialog = new ScenarioLoader();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ScenarioLoader() {
		setBounds(100, 100, 450, 181);
		getContentPane().setLayout(new BorderLayout());
		{
			Panel panel = new Panel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JButton btnNewButton = new JButton("New Scenario");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScenarioEditor.main(null);			// Load Scenario Editor
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(36, 66, 153, 37);
			panel.add(btnNewButton);
			
			JLabel lblWouldYouLike = new JLabel("What would you like to do?");
			lblWouldYouLike.setHorizontalAlignment(SwingConstants.CENTER);
			lblWouldYouLike.setVerticalAlignment(SwingConstants.TOP);
			lblWouldYouLike.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblWouldYouLike.setBounds(0, 13, 420, 37);
			panel.add(lblWouldYouLike);
			
			JButton btnEditExistingScenario = new JButton("Edit Existing Scenario");
			btnEditExistingScenario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventEditor.main(null, null); //load Event editor
				}
			});
			btnEditExistingScenario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnEditExistingScenario.setBounds(212, 66, 178, 37);
			panel.add(btnEditExistingScenario);
			
			//Accessibility features
			btnNewButton.getAccessibleContext().setAccessibleName("New Scenario");
			btnEditExistingScenario.getAccessibleContext().setAccessibleName("Edit Existing Scenario");
		}
	}
}
