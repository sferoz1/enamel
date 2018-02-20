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

public class EventEditor extends JFrame{

	private JPanel contentPane;
	private static JFrame frmEventEditor;
	private static JTextArea textTitle, textAnsRight, textAnsWrong, textIndex, textQuestion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ScenarioEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (args[0] == "0"){
					EventEditor window = new EventEditor();
					window.frmEventEditor.setVisible(true);
					populate(e);
					} else {
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
		frmEventEditor.setBounds(100, 100, 351, 538);
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
		btnSave.setBounds(71, 463, 189, 25);
		btnSave.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int index = Integer.parseInt(textIndex.getText());
			String title = textTitle.getText();
			String question = textQuestion.getText();
			String responseRight = textAnsRight.getText();
			String responseWrong = textAnsWrong.getText();
			int correctAns = list.getSelectedIndex();
			ScenarioEditor.addEvent(index, title, question, responseRight, responseWrong, correctAns);
			frmEventEditor.dispose();
			}
		});
		
		contentPane.add(btnSave);
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
		
	}
	
}

