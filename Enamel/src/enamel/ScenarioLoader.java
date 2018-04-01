package enamel;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class ScenarioLoader extends JDialog {
	private static ScenarioLoader dialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new ScenarioLoader();
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
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		setResizable(false);
		setBounds(100, 100, 435, 151);
		getContentPane().setLayout(new BorderLayout());
		{
			Panel panel = new Panel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JButton btnNewButton = new JButton("Create New Scenario");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] args = {"1"};
					ScenarioEditor.main(args, null);			// Load Scenario Editor
					dialog.setVisible(false);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(10, 53, 188, 37);
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
					JFileChooser jf = new JFileChooser();
		    	    int returnValue = jf.showOpenDialog(null);
		    	    
		    		if (returnValue == JFileChooser.APPROVE_OPTION) {
		    			File selectedFile = jf.getSelectedFile();
		    			
		    			ScenarioFileReader reader = new ScenarioFileReader();
		    			reader.readScenarioFile(selectedFile.getAbsolutePath());
		    			
		    			//ScenarioFileReader.readScenarioFile(selectedFile.getAbsolutePath());
		    		}
					EventEditor.main(null, null); //load Event editor
					ScenarioEditor.main(null, null); //Load Scenario Editor
				}
			});
			btnEditExistingScenario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnEditExistingScenario.setBounds(208, 53, 193, 37);
			panel.add(btnEditExistingScenario);
			
			//Accessibility features
			btnNewButton.getAccessibleContext().setAccessibleName("New Scenario");
			btnEditExistingScenario.getAccessibleContext().setAccessibleName("Edit Existing Scenario");
		}
	}
}
