package enamel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class ScenarioEditor {

	private JFrame frmScenarioEditor;
	private JTextField titleField;
	private JTextField textField;
	private JTextField textField_1;
	private JTable eventTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScenarioEditor window = new ScenarioEditor();
					window.frmScenarioEditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScenarioEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScenarioEditor = new JFrame();
		frmScenarioEditor.setTitle("Scenario Editor");
		frmScenarioEditor.setBounds(100, 100, 554, 364);
		frmScenarioEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScenarioEditor.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblTitle.setBounds(38, 20, 61, 16);
		frmScenarioEditor.getContentPane().add(lblTitle);
		
		titleField = new JTextField();
		titleField.setBounds(97, 17, 304, 26);
		frmScenarioEditor.getContentPane().add(titleField);
		titleField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(413, 17, 117, 29);
		frmScenarioEditor.getContentPane().add(btnSave);
		
		JLabel cellLabel = new JLabel("Cells: ");
		cellLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		cellLabel.setBounds(38, 48, 61, 16);
		frmScenarioEditor.getContentPane().add(cellLabel);
		
		textField = new JTextField();
		textField.setBounds(97, 45, 97, 26);
		frmScenarioEditor.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(304, 45, 97, 26);
		frmScenarioEditor.getContentPane().add(textField_1);
		
		JLabel lblButtons = new JLabel("Buttons: ");
		lblButtons.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblButtons.setBounds(226, 48, 78, 16);
		frmScenarioEditor.getContentPane().add(lblButtons);
		
		eventTable = new JTable();
		eventTable.setBounds(3, 112, 542, 184);
		frmScenarioEditor.getContentPane().add(eventTable);
		
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setBounds(6, 110, 542, 184);
		frmScenarioEditor.getContentPane().add(rigidArea);
		
		JLabel lblTimeline = new JLabel("Timeline: ");
		lblTimeline.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeline.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblTimeline.setBounds(5, 90, 542, 16);
		frmScenarioEditor.getContentPane().add(lblTimeline);
		
		JButton btnDeleteScenario = new JButton("Delete Scenario");
		btnDeleteScenario.setBounds(6, 306, 133, 29);
		frmScenarioEditor.getContentPane().add(btnDeleteScenario);
		
		JButton btnEditEvent = new JButton("Edit Event...");
		btnEditEvent.setEnabled(false);
		btnEditEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditEvent.setBounds(282, 306, 133, 29);
		frmScenarioEditor.getContentPane().add(btnEditEvent);
		
		JButton btnAddEvent = new JButton("Add Event...");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddEvent.setBounds(421, 306, 133, 29);
		frmScenarioEditor.getContentPane().add(btnAddEvent);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-2, 76, 574, 9);
		frmScenarioEditor.getContentPane().add(separator);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(413, 44, 117, 29);
		frmScenarioEditor.getContentPane().add(btnExit);
		
		JButton btnDeleteEvent = new JButton("Delete Event");
		btnDeleteEvent.setEnabled(false);
		btnDeleteEvent.setBounds(143, 306, 133, 29);
		frmScenarioEditor.getContentPane().add(btnDeleteEvent);
	}
}
