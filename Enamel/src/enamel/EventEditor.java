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

public class EventEditor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		setBounds(100, 100, 359, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setBounds(12, 13, 56, 16);
		contentPane.add(lblTitle);
		
		textField = new JTextField();
		textField.setBounds(57, 10, 268, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuestion.setBounds(12, 55, 75, 16);
		contentPane.add(lblQuestion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 76, 313, 74);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(12, 391, 97, 25);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(228, 391, 97, 25);
		contentPane.add(btnExit);
		
		JLabel lblWhichButtonIs = new JLabel("Which Button is the Correct Answer?");
		lblWhichButtonIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWhichButtonIs.setBounds(12, 163, 268, 16);
		contentPane.add(lblWhichButtonIs);
		
		textField_2 = new JTextField();
		textField_2.setBounds(279, 161, 46, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCorrectAnswer = new JLabel("If Answer is Correct");
		lblCorrectAnswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorrectAnswer.setBounds(12, 197, 151, 16);
		contentPane.add(lblCorrectAnswer);
		
		textField_3 = new JTextField();
		textField_3.setBounds(12, 226, 313, 49);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblIfAnswerIs = new JLabel("If Answer is Incorrect");
		lblIfAnswerIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIfAnswerIs.setBounds(12, 288, 164, 16);
		contentPane.add(lblIfAnswerIs);
		
		textField_4 = new JTextField();
		textField_4.setBounds(12, 315, 313, 55);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
