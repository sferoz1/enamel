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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class ScenarioEditor {

	private JFrame frmScenarioEditor;
	private static JTextField titleField;
	private static JList list;
	private static DefaultListModel DLM;
	private static JComboBox cellBox, buttonBox;
	public static EventList timeline;
	private static Scenario editing;
	private static boolean isEdit;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args, Scenario editMe) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(args[0] == "0") {
						ScenarioEditor window = new ScenarioEditor();
						window.frmScenarioEditor.setVisible(true);
						isEdit = true;
						editing = editMe;
						
						populate();
					}
					 else {
						ScenarioEditor window = new ScenarioEditor();
						window.frmScenarioEditor.setVisible(true);
						isEdit = false;
					}
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

	private static void populate() {
		String title = editing.getTitle();
		int cells = editing.getCellNumber();
		int buttons = editing.getButtonNumber();
		EventList events = editing.getScenarioEventList();
		//EventList events = editing.getScenarioEventList();
		titleField.setText(title);
		cellBox.setSelectedIndex(cells-1);
		buttonBox.setSelectedIndex(buttons-1);
		timeline = events;
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
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
		
		cellBox = new JComboBox();
		cellBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		cellBox.setBounds(97, 47, 97, 26);
		frmScenarioEditor.getContentPane().add(cellBox);
		
		buttonBox = new JComboBox();
		buttonBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		buttonBox.setBounds(304, 46, 97, 26);
		frmScenarioEditor.getContentPane().add(buttonBox);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = saveScenarioWindow();
				int cells = Integer.parseInt(cellBox.getSelectedItem().toString());
				int buttons = Integer.parseInt(buttonBox.getSelectedItem().toString());
				Scenario createNewScenario = new Scenario(cells, buttons, titleField.getText(), timeline);
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
				String[] args = {"0"};
				EventEditor.main(args, edit);
			}
		});
		JButton btnDeleteEvent = new JButton("Delete Event...");
		btnDeleteEvent.setEnabled(false);
		btnDeleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScenarioEvent delete = (ScenarioEvent) list.getSelectedValue();
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
				frmScenarioEditor.dispose();
				Launcher.main(null);
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

	public static void addEvent(int index, String title, String question, String QFilePath, String responseRight, String RRFilePath,  String responseWrong, String RWFilePath, String[] cellArray, int correctAns){
		ScenarioEvent addMe = new ScenarioEvent(index, title, question,QFilePath, responseRight,RRFilePath, responseWrong, RWFilePath , cellArray, correctAns);
		timeline.add(addMe);
		Collections.sort(timeline);
		DLM.removeAllElements();
		for(int i = 0; i < timeline.size(); i++) {
			ScenarioEvent a = timeline.get(i);
			DLM.addElement(a);
			a.setIndex(i);
		}
	}
	
	public static void editEvent(ScenarioEvent e) {
		timeline.remove(e);
		timeline.add(e);
		Collections.sort(timeline);
		DLM.removeAllElements();
		for(int i = 0; i < timeline.size(); i++) {
			ScenarioEvent a = timeline.get(i);
			DLM.addElement(a);
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
