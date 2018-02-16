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

public class EventEditor extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextField questionField;
	private JTextField ifAnsCorrect;
	private JTextField ifAnsWrong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventEditor frame = new EventEditor();
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
	public EventEditor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setBounds(12, 13, 56, 16);
		contentPane.add(lblTitle);
		
		titleField = new JTextField();
		titleField.setBounds(57, 10, 268, 22);
		contentPane.add(titleField);
		titleField.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuestion.setBounds(12, 55, 75, 16);
		contentPane.add(lblQuestion);
		
		questionField = new JTextField();
		questionField.setBounds(12, 76, 313, 74);
		contentPane.add(questionField);
		questionField.setColumns(10);
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(12, 391, 97, 25);
		contentPane.add(btnSave);
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(228, 391, 97, 25);
		contentPane.add(btnExit);
		
		JLabel lblWhichButtonIs = new JLabel("Which Button is the Correct Answer?");
		lblWhichButtonIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWhichButtonIs.setBounds(0, 163, 268, 16);
		contentPane.add(lblWhichButtonIs);
		
		
		JLabel lblCorrectAnswer = new JLabel("If Answer is Correct");
		lblCorrectAnswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorrectAnswer.setBounds(12, 197, 151, 16);
		contentPane.add(lblCorrectAnswer);
		
		ifAnsCorrect = new JTextField();
		ifAnsCorrect.setBounds(12, 226, 313, 49);
		contentPane.add(ifAnsCorrect);
		ifAnsCorrect.setColumns(10);
		
		JLabel lblIfAnswerIs = new JLabel("If Answer is Incorrect");
		lblIfAnswerIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIfAnswerIs.setBounds(12, 288, 164, 16);
		contentPane.add(lblIfAnswerIs);
		
		ifAnsWrong = new JTextField();
		ifAnsWrong.setBounds(12, 315, 313, 55);
		contentPane.add(ifAnsWrong);
		ifAnsWrong.setColumns(10);
		
		List list = new List();
		list.setBounds(271, 156, 54, 68);
		contentPane.add(list);
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
				
	
		//Accessibility Features
		lblTitle.getAccessibleContext().setAccessibleName("Title");
		lblQuestion.getAccessibleContext().setAccessibleName("Question");
		btnSave.getAccessibleContext().setAccessibleName("Save");
		btnExit.getAccessibleContext().setAccessibleName("Exit");
		lblWhichButtonIs.getAccessibleContext().setAccessibleName("Which Button is the Correct Answer");
		lblCorrectAnswer.getAccessibleContext().setAccessibleName("If Answer is Correct");
		lblIfAnswerIs.getAccessibleContext().setAccessibleName("If Answer is Incorrect");
	
	}
}
