package enamel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.List;
import javax.swing.JTextArea;
import java.awt.Window.Type;
import javax.swing.SwingConstants;

public class EventEditor extends JFrame{

	private JPanel contentPane;
	private static JFrame frmEventEditor;
	private static JTextArea textTitle, textAnsRight, textAnsWrong, textIndex, textQuestion;
	private static JTextField C1P1;
	private static JTextField C1P2;
	private static JTextField C1P3;
	private static JTextField C1P4;
	private static JTextField C1P5;
	private static JTextField C1P6;
	private static JTextField C1P7;
	private static JTextField C1P8;
	private static JTextField C2P1;
	private static JTextField C2P2;
	private static JTextField C2P3;
	private static JTextField C2P4;
	private static JTextField C2P5;
	private static JTextField C2P6;
	private static JTextField C2P7;
	private static JTextField C2P8;
	private static JTextField C3P1;
	private static JTextField C3P2;
	private static JTextField C3P3;
	private static JTextField C3P4;
	private static JTextField C3P5;
	private static JTextField C3P6;
	private static JTextField C3P7;
	private static JTextField C3P8;
	private static JTextField C4P1;
	private static JTextField C4P2;
	private static JTextField C4P3;
	private static JTextField C4P4;
	private static JTextField C4P5;
	private static JTextField C4P6;
	private static JTextField C4P7;
	private static JTextField C4P8;
	private static JTextField C5P1;
	private static JTextField C5P2;
	private static JTextField C5P3;
	private static JTextField C5P4;
	private static JTextField C5P5;
	private static JTextField C5P6;
	private static JTextField C5P7;
	private static JTextField C5P8;
	private static JTextField C6P1;
	private static JTextField C6P2;
	private static JTextField C6P3;
	private static JTextField C6P4;
	private static JTextField C6P5;
	private static JTextField C6P6;
	private static JTextField C6P7;
	private static JTextField C6P8;
	private static JTextField C7P1;
	private static JTextField C7P2;
	private static JTextField C7P3;
	private static JTextField C7P4;
	private static JTextField C7P5;
	private static JTextField C7P6;
	private static JTextField C7P7;
	private static JTextField C7P8;
	private static JTextField C8P1;
	private static JTextField C8P2;
	private static JTextField C8P3;
	private static JTextField C8P4;
	private static JTextField C8P5;
	private static JTextField C8P6;
	private static JTextField C8P7;
	private static JTextField C8P8;
	private JLabel lblCell_2;
	private JLabel lblCell_3;
	private JLabel lblCell_4;
	private JLabel lblCell_5;
	private JLabel lblCell_6;
	private JLabel lblCell_7;
	private JLabel lblCell_8;
	private static boolean isEdit;
	public static ScenarioEvent toEdit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ScenarioEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (args[0] == "0"){
						toEdit = e;
						EventEditor window = new EventEditor();
						window.frmEventEditor.setVisible(true);
						isEdit = true;
						populate(e);
					} else {
						isEdit = false;
						EventEditor window = new EventEditor();
						window.frmEventEditor.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EventEditor() {
		frmEventEditor = new JFrame();
		frmEventEditor.setResizable(false);
		frmEventEditor.setAlwaysOnTop(true);
		frmEventEditor.setTitle("Event Editor");
		frmEventEditor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEventEditor.setBounds(100, 100, 644, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmEventEditor.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(12, 13, 56, 16);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblTitle);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(11, 81, 75, 16);
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblQuestion);
		
		JLabel lblWhichButtonIs = new JLabel("Which Button is the Correct Answer?");
		lblWhichButtonIs.setBounds(11, 194, 249, 16);
		lblWhichButtonIs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblWhichButtonIs);
		
		JLabel lblCorrectAnswer = new JLabel("If Answer is Correct");
		lblCorrectAnswer.setBounds(11, 237, 151, 16);
		lblCorrectAnswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCorrectAnswer);
		
		JLabel lblIfAnswerIs = new JLabel("If Answer is Incorrect");
		lblIfAnswerIs.setBounds(11, 339, 164, 16);
		lblIfAnswerIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblIfAnswerIs);
		
		List list = new List();
		list.setBounds(270, 182, 54, 68);
		contentPane.add(list);
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		textTitle = new JTextArea();
		textTitle.setBounds(54, 12, 271, 22);
		contentPane.add(textTitle);
		textTitle.setLineWrap(true);
		
		textQuestion = new JTextArea();
		textQuestion.setBounds(11, 102, 313, 74);
		contentPane.add(textQuestion);
		textQuestion.setLineWrap(true);
		
		textAnsRight = new JTextArea();
		textAnsRight.setBounds(11, 266, 309, 68);
		contentPane.add(textAnsRight);
		textAnsRight.setLineWrap(true);
		
		textAnsWrong = new JTextArea();
		textAnsWrong.setBounds(11, 368, 309, 68);
		contentPane.add(textAnsWrong);
		textAnsWrong.setLineWrap(true);
		
		JLabel lblIndex = new JLabel("Index:");
		lblIndex.setBounds(12, 53, 56, 16);
		lblIndex.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblIndex);
		
		textIndex = new JTextArea();
		textIndex.setBounds(80, 47, 241, 22);
		textIndex.setLineWrap(true);
		contentPane.add(textIndex);
				
		JButton btnSave = new JButton("Save & Exit");
		btnSave.setEnabled(false);
		btnSave.setBounds(240, 465, 189, 25);
		btnSave.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int index = Integer.parseInt(textIndex.getText());
			String title = textTitle.getText();
			String question = textQuestion.getText();
			String responseRight = textAnsRight.getText();
			String responseWrong = textAnsWrong.getText();
			String[] cellArray = parseCells();
			int correctAns = list.getSelectedIndex();
			if (isEdit) {
				toEdit.overwrite(index, title, question, responseRight, responseWrong, cellArray, correctAns);
				ScenarioEditor.editEvent(toEdit);
				frmEventEditor.dispose();
			} else {
			ScenarioEditor.addEvent(index, title, question, responseRight, responseWrong, cellArray, correctAns); 
			frmEventEditor.dispose();
			
			}
			//ScenWriter writer = new ScenWriter(scenarioWithEventsToFile, file);
			 //writer.write(scenarioWithEventsToFile, file);
			}
		});
		
		contentPane.add(btnSave);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnSave.setEnabled(true);
			}
		});
		
		JLabel lblCell_1 = new JLabel("Cell 1");
		lblCell_1.setBounds(337, 15, 56, 16);
		contentPane.add(lblCell_1);
		
		C1P1 = new JTextField();
		C1P1.setText("0");
		C1P1.setBounds(333, 47, 17, 22);
		contentPane.add(C1P1);
		C1P1.setColumns(10);
		
		C1P2 = new JTextField();
		C1P2.setText("0");
		C1P2.setColumns(10);
		C1P2.setBounds(364, 47, 17, 22);
		contentPane.add(C1P2);
		
		C1P3 = new JTextField();
		C1P3.setText("0");
		C1P3.setColumns(10);
		C1P3.setBounds(333, 80, 17, 22);
		contentPane.add(C1P3);
		
		C1P4 = new JTextField();
		C1P4.setText("0");
		C1P4.setColumns(10);
		C1P4.setBounds(364, 80, 17, 22);
		contentPane.add(C1P4);
		
		C1P5 = new JTextField();
		C1P5.setText("0");
		C1P5.setColumns(10);
		C1P5.setBounds(333, 115, 17, 22);
		contentPane.add(C1P5);
		
		C1P6 = new JTextField();
		C1P6.setText("0");
		C1P6.setColumns(10);
		C1P6.setBounds(364, 115, 17, 22);
		contentPane.add(C1P6);
		
		C1P7 = new JTextField();
		C1P7.setText("0");
		C1P7.setColumns(10);
		C1P7.setBounds(333, 150, 17, 22);
		contentPane.add(C1P7);
		
		C1P8 = new JTextField();
		C1P8.setText("0");
		C1P8.setColumns(10);
		C1P8.setBounds(364, 150, 17, 22);
		contentPane.add(C1P8);
		
		C2P1 = new JTextField();
		C2P1.setText("0");
		C2P1.setColumns(10);
		C2P1.setBounds(412, 47, 17, 22);
		contentPane.add(C2P1);
		
		C2P2 = new JTextField();
		C2P2.setText("0");
		C2P2.setColumns(10);
		C2P2.setBounds(443, 47, 17, 22);
		contentPane.add(C2P2);
		
		C2P3 = new JTextField();
		C2P3.setText("0");
		C2P3.setColumns(10);
		C2P3.setBounds(412, 80, 17, 22);
		contentPane.add(C2P3);
		
		C2P4 = new JTextField();
		C2P4.setText("0");
		C2P4.setColumns(10);
		C2P4.setBounds(443, 80, 17, 22);
		contentPane.add(C2P4);
		
		C2P5 = new JTextField();
		C2P5.setText("0");
		C2P5.setColumns(10);
		C2P5.setBounds(412, 115, 17, 22);
		contentPane.add(C2P5);
		
		C2P6 = new JTextField();
		C2P6.setText("0");
		C2P6.setColumns(10);
		C2P6.setBounds(443, 115, 17, 22);
		contentPane.add(C2P6);
		
		C2P7 = new JTextField();
		C2P7.setText("0");
		C2P7.setColumns(10);
		C2P7.setBounds(412, 150, 17, 22);
		contentPane.add(C2P7);
		
		C2P8 = new JTextField();
		C2P8.setText("0");
		C2P8.setColumns(10);
		C2P8.setBounds(443, 150, 17, 22);
		contentPane.add(C2P8);
		
		C3P1 = new JTextField();
		C3P1.setText("0");
		C3P1.setColumns(10);
		C3P1.setBounds(490, 47, 17, 22);
		contentPane.add(C3P1);
		
		C3P2 = new JTextField();
		C3P2.setText("0");
		C3P2.setColumns(10);
		C3P2.setBounds(521, 47, 17, 22);
		contentPane.add(C3P2);
		
		C3P3 = new JTextField();
		C3P3.setText("0");
		C3P3.setColumns(10);
		C3P3.setBounds(490, 80, 17, 22);
		contentPane.add(C3P3);
		
		C3P4 = new JTextField();
		C3P4.setText("0");
		C3P4.setColumns(10);
		C3P4.setBounds(521, 80, 17, 22);
		contentPane.add(C3P4);
		
		C3P5 = new JTextField();
		C3P5.setText("0");
		C3P5.setColumns(10);
		C3P5.setBounds(490, 115, 17, 22);
		contentPane.add(C3P5);
		
		C3P6 = new JTextField();
		C3P6.setText("0");
		C3P6.setColumns(10);
		C3P6.setBounds(521, 115, 17, 22);
		contentPane.add(C3P6);
		
		C3P7 = new JTextField();
		C3P7.setText("0");
		C3P7.setColumns(10);
		C3P7.setBounds(490, 150, 17, 22);
		contentPane.add(C3P7);
		
		C3P8 = new JTextField();
		C3P8.setText("0");
		C3P8.setColumns(10);
		C3P8.setBounds(521, 150, 17, 22);
		contentPane.add(C3P8);
		
		C4P1 = new JTextField();
		C4P1.setText("0");
		C4P1.setColumns(10);
		C4P1.setBounds(573, 47, 17, 22);
		contentPane.add(C4P1);
		
		C4P2 = new JTextField();
		C4P2.setText("0");
		C4P2.setColumns(10);
		C4P2.setBounds(604, 47, 17, 22);
		contentPane.add(C4P2);
		
		C4P3 = new JTextField();
		C4P3.setText("0");
		C4P3.setColumns(10);
		C4P3.setBounds(573, 80, 17, 22);
		contentPane.add(C4P3);
		
		C4P4 = new JTextField();
		C4P4.setText("0");
		C4P4.setColumns(10);
		C4P4.setBounds(604, 80, 17, 22);
		contentPane.add(C4P4);
		
		C4P5 = new JTextField();
		C4P5.setText("0");
		C4P5.setColumns(10);
		C4P5.setBounds(573, 115, 17, 22);
		contentPane.add(C4P5);
		
		C4P6 = new JTextField();
		C4P6.setText("0");
		C4P6.setColumns(10);
		C4P6.setBounds(604, 115, 17, 22);
		contentPane.add(C4P6);
		
		C4P7 = new JTextField();
		C4P7.setText("0");
		C4P7.setColumns(10);
		C4P7.setBounds(573, 150, 17, 22);
		contentPane.add(C4P7);
		
		C4P8 = new JTextField();
		C4P8.setText("0");
		C4P8.setColumns(10);
		C4P8.setBounds(604, 150, 17, 22);
		contentPane.add(C4P8);
		
		C5P1 = new JTextField();
		C5P1.setText("0");
		C5P1.setColumns(10);
		C5P1.setBounds(333, 230, 17, 22);
		contentPane.add(C5P1);
		
		C5P2 = new JTextField();
		C5P2.setText("0");
		C5P2.setColumns(10);
		C5P2.setBounds(364, 230, 17, 22);
		contentPane.add(C5P2);
		
		C5P3 = new JTextField();
		C5P3.setText("0");
		C5P3.setColumns(10);
		C5P3.setBounds(333, 263, 17, 22);
		contentPane.add(C5P3);
		
		C5P4 = new JTextField();
		C5P4.setText("0");
		C5P4.setColumns(10);
		C5P4.setBounds(364, 263, 17, 22);
		contentPane.add(C5P4);
		
		C5P5 = new JTextField();
		C5P5.setText("0");
		C5P5.setColumns(10);
		C5P5.setBounds(333, 298, 17, 22);
		contentPane.add(C5P5);
		
		C5P6 = new JTextField();
		C5P6.setText("0");
		C5P6.setColumns(10);
		C5P6.setBounds(364, 298, 17, 22);
		contentPane.add(C5P6);
		
		C5P7 = new JTextField();
		C5P7.setText("0");
		C5P7.setColumns(10);
		C5P7.setBounds(333, 333, 17, 22);
		contentPane.add(C5P7);
		
		C5P8 = new JTextField();
		C5P8.setText("0");
		C5P8.setColumns(10);
		C5P8.setBounds(364, 333, 17, 22);
		contentPane.add(C5P8);
		
		C6P1 = new JTextField();
		C6P1.setText("0");
		C6P1.setColumns(10);
		C6P1.setBounds(412, 230, 17, 22);
		contentPane.add(C6P1);
		
		C6P2 = new JTextField();
		C6P2.setText("0");
		C6P2.setColumns(10);
		C6P2.setBounds(443, 230, 17, 22);
		contentPane.add(C6P2);
		
		C6P3 = new JTextField();
		C6P3.setText("0");
		C6P3.setColumns(10);
		C6P3.setBounds(412, 263, 17, 22);
		contentPane.add(C6P3);
		
		C6P4 = new JTextField();
		C6P4.setText("0");
		C6P4.setColumns(10);
		C6P4.setBounds(443, 263, 17, 22);
		contentPane.add(C6P4);
		
		C6P5 = new JTextField();
		C6P5.setText("0");
		C6P5.setColumns(10);
		C6P5.setBounds(412, 298, 17, 22);
		contentPane.add(C6P5);
		
		C6P6 = new JTextField();
		C6P6.setText("0");
		C6P6.setColumns(10);
		C6P6.setBounds(443, 298, 17, 22);
		contentPane.add(C6P6);
		
		C6P7 = new JTextField();
		C6P7.setText("0");
		C6P7.setColumns(10);
		C6P7.setBounds(412, 333, 17, 22);
		contentPane.add(C6P7);
		
		C6P8 = new JTextField();
		C6P8.setText("0");
		C6P8.setColumns(10);
		C6P8.setBounds(443, 333, 17, 22);
		contentPane.add(C6P8);
		
		C7P1 = new JTextField();
		C7P1.setText("0");
		C7P1.setColumns(10);
		C7P1.setBounds(490, 230, 17, 22);
		contentPane.add(C7P1);
		
		C7P2 = new JTextField();
		C7P2.setText("0");
		C7P2.setColumns(10);
		C7P2.setBounds(521, 230, 17, 22);
		contentPane.add(C7P2);
		
		C7P3 = new JTextField();
		C7P3.setText("0");
		C7P3.setColumns(10);
		C7P3.setBounds(490, 263, 17, 22);
		contentPane.add(C7P3);
		
		C7P4 = new JTextField();
		C7P4.setText("0");
		C7P4.setColumns(10);
		C7P4.setBounds(521, 263, 17, 22);
		contentPane.add(C7P4);
		
		C7P5 = new JTextField();
		C7P5.setText("0");
		C7P5.setColumns(10);
		C7P5.setBounds(490, 298, 17, 22);
		contentPane.add(C7P5);
		
		C7P6 = new JTextField();
		C7P6.setText("0");
		C7P6.setColumns(10);
		C7P6.setBounds(521, 298, 17, 22);
		contentPane.add(C7P6);
		
		C7P7 = new JTextField();
		C7P7.setText("0");
		C7P7.setColumns(10);
		C7P7.setBounds(490, 333, 17, 22);
		contentPane.add(C7P7);
		
		C7P8 = new JTextField();
		C7P8.setText("0");
		C7P8.setColumns(10);
		C7P8.setBounds(521, 333, 17, 22);
		contentPane.add(C7P8);
		
		C8P1 = new JTextField();
		C8P1.setText("0");
		C8P1.setColumns(10);
		C8P1.setBounds(573, 230, 17, 22);
		contentPane.add(C8P1);
		
		C8P2 = new JTextField();
		C8P2.setText("0");
		C8P2.setColumns(10);
		C8P2.setBounds(604, 230, 17, 22);
		contentPane.add(C8P2);
		
		C8P3 = new JTextField();
		C8P3.setText("0");
		C8P3.setColumns(10);
		C8P3.setBounds(573, 263, 17, 22);
		contentPane.add(C8P3);
		
		C8P4 = new JTextField();
		C8P4.setText("0");
		C8P4.setColumns(10);
		C8P4.setBounds(604, 263, 17, 22);
		contentPane.add(C8P4);
		
		C8P5 = new JTextField();
		C8P5.setText("0");
		C8P5.setColumns(10);
		C8P5.setBounds(573, 298, 17, 22);
		contentPane.add(C8P5);
		
		C8P6 = new JTextField();
		C8P6.setText("0");
		C8P6.setColumns(10);
		C8P6.setBounds(604, 298, 17, 22);
		contentPane.add(C8P6);
		
		C8P7 = new JTextField();
		C8P7.setText("0");
		C8P7.setColumns(10);
		C8P7.setBounds(573, 333, 17, 22);
		contentPane.add(C8P7);
		
		C8P8 = new JTextField();
		C8P8.setText("0");
		C8P8.setColumns(10);
		C8P8.setBounds(604, 333, 17, 22);
		contentPane.add(C8P8);
		
		lblCell_2 = new JLabel("Cell 2");
		lblCell_2.setBounds(414, 15, 56, 16);
		contentPane.add(lblCell_2);
		
		lblCell_3 = new JLabel("Cell 3");
		lblCell_3.setBounds(490, 15, 56, 16);
		contentPane.add(lblCell_3);
		
		lblCell_4 = new JLabel("Cell 4");
		lblCell_4.setBounds(573, 15, 56, 16);
		contentPane.add(lblCell_4);
		
		lblCell_5 = new JLabel("Cell 5");
		lblCell_5.setBounds(330, 195, 56, 16);
		contentPane.add(lblCell_5);
		
		lblCell_6 = new JLabel("Cell 6");
		lblCell_6.setBounds(412, 195, 56, 16);
		contentPane.add(lblCell_6);
		
		lblCell_7 = new JLabel("Cell 7");
		lblCell_7.setBounds(490, 195, 56, 16);
		contentPane.add(lblCell_7);
		
		lblCell_8 = new JLabel("Cell 8");
		lblCell_8.setBounds(565, 195, 56, 16);
		contentPane.add(lblCell_8);
		
		JLabel lblChangesTo = new JLabel("Change 0's to 1's in order to raise the pins");
		lblChangesTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChangesTo.setBounds(343, 370, 289, 16);
		contentPane.add(lblChangesTo);
		
		JLabel lblSeeTheUser = new JLabel("See the User Manual for more info.");
		lblSeeTheUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeeTheUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeeTheUser.setBounds(337, 397, 289, 16);
		contentPane.add(lblSeeTheUser);
		//Accessibility Features
		lblTitle.getAccessibleContext().setAccessibleName("Title");
		lblQuestion.getAccessibleContext().setAccessibleName("Question");
		btnSave.getAccessibleContext().setAccessibleName("Save");
		lblWhichButtonIs.getAccessibleContext().setAccessibleName("Which Button is the Correct Answer");
		lblCorrectAnswer.getAccessibleContext().setAccessibleName("If Answer is Correct");
		lblIfAnswerIs.getAccessibleContext().setAccessibleName("If Answer is Incorrect");		
			
		}
	
	public static void populate(ScenarioEvent e) {
		
		int index = e.getIndex();
		String title = e.getTitle();
		String question = e.getQuestion();
		String responseRight = e.getResponseRight();
		String responseWrong = e.getResponseWrong();
		int CorrectAns = e.getIndex();
		
		textIndex.setText(Integer.toString(index));
		textTitle.setText(title);
		textQuestion.setText(question);
		textAnsRight.setText(responseRight);
		textAnsWrong.setText(responseWrong);

		String[] cells = e.cellArray;
		System.out.println(cells[0]);
		System.out.println(cells[0].charAt(0));
		
		C1P1.setText(Character.toString(cells[0].charAt(0)));
		C1P2.setText(Character.toString(cells[0].charAt(1)));
		C1P3.setText(Character.toString(cells[0].charAt(2)));
		C1P4.setText(Character.toString(cells[0].charAt(3)));
		C1P5.setText(Character.toString(cells[0].charAt(4)));
		C1P6.setText(Character.toString(cells[0].charAt(5)));
		C1P7.setText(Character.toString(cells[0].charAt(6)));
		C1P8.setText(Character.toString(cells[0].charAt(7)));

		C2P1.setText(Character.toString(cells[1].charAt(0)));
		C2P2.setText(Character.toString(cells[1].charAt(1)));
		C2P3.setText(Character.toString(cells[1].charAt(2)));
		C2P4.setText(Character.toString(cells[1].charAt(3)));
		C2P5.setText(Character.toString(cells[1].charAt(4)));
		C2P6.setText(Character.toString(cells[1].charAt(5)));
		C2P7.setText(Character.toString(cells[1].charAt(6)));
		C2P8.setText(Character.toString(cells[1].charAt(7)));
		
		C3P1.setText(Character.toString(cells[2].charAt(0)));
		C3P2.setText(Character.toString(cells[2].charAt(1)));
		C3P3.setText(Character.toString(cells[2].charAt(2)));
		C3P4.setText(Character.toString(cells[2].charAt(3)));
		C3P5.setText(Character.toString(cells[2].charAt(4)));
		C3P6.setText(Character.toString(cells[2].charAt(5)));
		C3P7.setText(Character.toString(cells[2].charAt(6)));
		C3P8.setText(Character.toString(cells[2].charAt(7)));

		C4P1.setText(Character.toString(cells[3].charAt(0)));
		C4P2.setText(Character.toString(cells[3].charAt(1)));
		C4P3.setText(Character.toString(cells[3].charAt(2)));
		C4P4.setText(Character.toString(cells[3].charAt(3)));
		C4P5.setText(Character.toString(cells[3].charAt(4)));
		C4P6.setText(Character.toString(cells[3].charAt(5)));
		C4P7.setText(Character.toString(cells[3].charAt(6)));
		C4P8.setText(Character.toString(cells[3].charAt(7)));
		C5P1.setText(Character.toString(cells[4].charAt(0)));
		C5P2.setText(Character.toString(cells[4].charAt(1)));
		C5P3.setText(Character.toString(cells[4].charAt(2)));
		C5P4.setText(Character.toString(cells[4].charAt(3)));
		C5P5.setText(Character.toString(cells[4].charAt(4)));
		C5P6.setText(Character.toString(cells[4].charAt(5)));
		C5P7.setText(Character.toString(cells[4].charAt(6)));
		C5P8.setText(Character.toString(cells[4].charAt(7)));
		C6P1.setText(Character.toString(cells[5].charAt(0)));
		C6P2.setText(Character.toString(cells[5].charAt(1)));
		C6P3.setText(Character.toString(cells[5].charAt(2)));
		C6P4.setText(Character.toString(cells[5].charAt(3)));
		C6P5.setText(Character.toString(cells[5].charAt(4)));
		C6P6.setText(Character.toString(cells[5].charAt(5)));
		C6P7.setText(Character.toString(cells[5].charAt(6)));
		C6P8.setText(Character.toString(cells[5].charAt(7)));
		C7P1.setText(Character.toString(cells[6].charAt(0)));
		C7P2.setText(Character.toString(cells[6].charAt(1)));
		C7P3.setText(Character.toString(cells[6].charAt(2)));
		C7P4.setText(Character.toString(cells[6].charAt(3)));
		C7P5.setText(Character.toString(cells[6].charAt(4)));
		C7P6.setText(Character.toString(cells[6].charAt(5)));
		C7P7.setText(Character.toString(cells[6].charAt(6)));
		C7P8.setText(Character.toString(cells[6].charAt(7)));
		C8P1.setText(Character.toString(cells[7].charAt(0)));
		C8P2.setText(Character.toString(cells[7].charAt(1)));
		C8P3.setText(Character.toString(cells[7].charAt(2)));
		C8P4.setText(Character.toString(cells[7].charAt(3)));
		C8P5.setText(Character.toString(cells[7].charAt(4)));
		C8P6.setText(Character.toString(cells[7].charAt(5)));
		C8P7.setText(Character.toString(cells[7].charAt(6)));
		C8P8.setText(Character.toString(cells[7].charAt(7)));

	}
	
	public String[] parseCells(){
		String[] cellArray = new String[8];
		cellArray[0] = C1P1.getText() + C1P2.getText() + C1P3.getText() + C1P4.getText() + C1P5.getText() + C1P6.getText() + C1P7.getText() + C1P8.getText();
		cellArray[1] = C2P1.getText() + C2P2.getText() + C2P3.getText() + C2P4.getText() + C2P5.getText() + C2P6.getText() + C2P7.getText() + C2P8.getText();
		cellArray[2] = C3P1.getText() + C3P2.getText() + C3P3.getText() + C3P4.getText() + C3P5.getText() + C3P6.getText() + C3P7.getText() + C3P8.getText();
		cellArray[3] = C4P1.getText() + C4P2.getText() + C4P3.getText() + C4P4.getText() + C4P5.getText() + C4P6.getText() + C4P7.getText() + C4P8.getText();
		cellArray[4] = C5P1.getText() + C5P2.getText() + C5P3.getText() + C5P4.getText() + C5P5.getText() + C5P6.getText() + C5P7.getText() + C5P8.getText();
		cellArray[5] = C6P1.getText() + C6P2.getText() + C6P3.getText() + C6P4.getText() + C6P5.getText() + C6P6.getText() + C6P7.getText() + C6P8.getText();
		cellArray[6] = C7P1.getText() + C7P2.getText() + C7P3.getText() + C7P4.getText() + C7P5.getText() + C7P6.getText() + C7P7.getText() + C7P8.getText();
		cellArray[7] = C8P1.getText() + C8P2.getText() + C8P3.getText() + C8P4.getText() + C8P5.getText() + C8P6.getText() + C8P7.getText() + C8P8.getText();
		System.out.println(cellArray[0]);
		return cellArray;
	}
}

