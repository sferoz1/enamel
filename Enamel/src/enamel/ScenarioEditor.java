package enamel;

import java.awt.EventQueue;

import java.io.*;
import javax.swing.JFileChooser;
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
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScenarioEditor {

	private JFrame frmScenarioEditor;
	private JTextField titleField;
	private JTextField textField;
	private JTextField textField_1;
	private static JList list;
	private static DefaultListModel DLM;
	protected static EventList timeline;

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
	
	public ScenarioEditor(String filename) {
		initialize();
		setParameters();
	}
	private void setParameters() {
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		timeline = new EventList();
		frmScenarioEditor = new JFrame();
		frmScenarioEditor.setTitle("Scenario Editor");
		frmScenarioEditor.setBounds(100, 100, 579, 401);
		frmScenarioEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScenarioEditor.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 118, 542, 179);
		frmScenarioEditor.getContentPane().add(scrollPane);
		
		list = new JList();
		
		scrollPane.setViewportView(list);
		
		DLM = new DefaultListModel();
		list.setModel(DLM);
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblTitle.setBounds(38, 20, 61, 16);
		frmScenarioEditor.getContentPane().add(lblTitle);
		
		titleField = new JTextField();
		titleField.setToolTipText("Enter a title for this scenario");
		titleField.setBounds(97, 17, 304, 26);
		frmScenarioEditor.getContentPane().add(titleField);
		titleField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = saveScenarioWindow();
				Scenario createNewScenario = new Scenario(Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()) ,titleField.getText(), timeline);
				ScenWriter scenarioToFile = new ScenWriter(createNewScenario, file);
				scenarioToFile.write(createNewScenario, file);
				
				// initializes a file for a new scenario
				// pass filePath back into ScenarioWriter's FileWriter
			}
		});
	
	
		btnSave.setBounds(413, 17, 117, 29);
		frmScenarioEditor.getContentPane().add(btnSave);
		
		JLabel cellLabel = new JLabel("Cells: ");
		cellLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		cellLabel.setBounds(38, 48, 61, 16);
		frmScenarioEditor.getContentPane().add(cellLabel);
		
		textField = new JTextField();
		textField.setToolTipText("Enter the number of cells to display");
		textField.setBounds(97, 45, 97, 26);
		frmScenarioEditor.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter the number of buttons to display");
		textField_1.setColumns(10);
		textField_1.setBounds(304, 45, 97, 26);
		frmScenarioEditor.getContentPane().add(textField_1);
		
		JLabel lblButtons = new JLabel("Buttons: ");
		lblButtons.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblButtons.setBounds(226, 48, 78, 16);
		frmScenarioEditor.getContentPane().add(lblButtons);
		
		JLabel lblTimeline = new JLabel("Timeline: ");
		lblTimeline.setToolTipText("The timeline of events in this scenario");
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
				ScenarioEvent edit = (ScenarioEvent) list.getSelectedValue();
				System.out.println("RECIEVED OBJECT");
				String[] args = {"0"};
				System.out.println("MADE ARGS");
				EventEditor.main(args, edit);
			}
		});
		JButton btnDeleteEvent = new JButton("Delete Event...");
		btnDeleteEvent.setEnabled(false);
		btnDeleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScenarioEvent delete = (ScenarioEvent) list.getSelectedValue();
				//String[] args = {"1"};
				deleteEvent(delete);
				
			}
		});
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (list.isSelectionEmpty() == false) {
					btnEditEvent.setEnabled(true);
					btnDeleteEvent.setEnabled(true);
				}
			}
		});
		
		btnEditEvent.setBounds(282, 306, 133, 29);
		frmScenarioEditor.getContentPane().add(btnEditEvent);
		
		btnDeleteEvent.setEnabled(false);
		btnDeleteEvent.setBounds(143, 306, 133, 29);
		frmScenarioEditor.getContentPane().add(btnDeleteEvent);
		
		JButton btnAddEvent = new JButton("Add Event...");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {"1"};
				EventEditor.main(args, null); //load event editor to edit event
			}
		});
		btnAddEvent.setBounds(421, 306, 133, 29);
		frmScenarioEditor.getContentPane().add(btnAddEvent);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 75, 574, 9);
		frmScenarioEditor.getContentPane().add(separator);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(413, 44, 117, 29);
		frmScenarioEditor.getContentPane().add(btnExit);

		//Accessibility Features
		lblTitle.getAccessibleContext().setAccessibleName("Title");
		btnSave.getAccessibleContext().setAccessibleName("Save");
		lblButtons.getAccessibleContext().setAccessibleName("Buttons: ");
		lblTimeline.getAccessibleContext().setAccessibleName("Timeline: ");
		btnDeleteScenario.getAccessibleContext().setAccessibleName("Delete Scenario");
		btnEditEvent.getAccessibleContext().setAccessibleName("Edit Event");
		btnAddEvent.getAccessibleContext().setAccessibleName("Add Event");
		btnExit.getAccessibleContext().setAccessibleName("Exit");
		
	}

	public static void addEvent(int index, String title, String question, String responseRight, String responseWrong, String[] cellArray, int correctAns){
		ScenarioEvent addMe = new ScenarioEvent(index, title, question, responseRight, responseWrong, cellArray, correctAns);
		System.out.println("CELL ARRAY ADDED AS: " + addMe.cellArray[0]);
		timeline.add(addMe);
		Collections.sort(timeline);
		DLM.removeAllElements();
		System.out.print("TIMESIZE: " + timeline.size());
		for(int i = 0; i < timeline.size(); i++) {
			ScenarioEvent a = timeline.get(i);
			DLM.addElement(a);
			a.setIndex(i);
		}
	}
	
	public static void editEvent(ScenarioEvent e) {
		System.out.println("EDITED");
		timeline.remove(e);
		System.out.println("REMOVED");
		timeline.add(e);
		System.out.println("READDED");
		Collections.sort(timeline);
		System.out.println("REFRESHING");
		DLM.removeAllElements();
		for(int i = 0; i < timeline.size(); i++) {
			System.out.println("ITERATION: " + i);
			ScenarioEvent a = timeline.get(i);
			System.out.println("ADDING TO DLM");
			DLM.addElement(a);
			System.out.println("SETTING INDEX");
			a.setIndex(i);
		}
	}
	
	public static void deleteEvent(ScenarioEvent e) {
		timeline.remove(e);
		Collections.sort(timeline);
		DLM.removeAllElements();
		for(int i = 0; i < timeline.size(); i++) {
			ScenarioEvent d = timeline.get(i);
			DLM.addElement(d);
			d.setIndex(i);
		}
	}
	
	private static void refreshTimeline(){
		for(int i = 0; i < timeline.size(); i++) {
			ScenarioEvent e = timeline.get(i);
			DLM.addElement(e);
		}
	}
	
	public File saveScenarioWindow(){
		JFrame saveWindow = new JFrame();
		 
		JFileChooser saveFile = new JFileChooser();
		saveFile.setDialogTitle("Specify a file to save");   
		 
		int userSelection = saveFile.showSaveDialog(saveWindow);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = saveFile.getSelectedFile();
		    return fileToSave;
		    //return fileToSave.getAbsolutePath();
		} else {
			return null;
		}
	}
}
