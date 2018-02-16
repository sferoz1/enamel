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
//import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import java.awt.List;
import javax.swing.JTextArea;

public class EventEditor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventEditor frame = new EventEditor();
					frame.setVisible(true);
					JPanel panel = new JPanel();
					frame.getContentPane().add(panel);
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
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuestion.setBounds(12, 55, 75, 16);
		contentPane.add(lblQuestion);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	ScenarioEditor.overwrite(textField.getText());
				
			}
		});
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
		lblWhichButtonIs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWhichButtonIs.setBounds(12, 161, 253, 16);
		contentPane.add(lblWhichButtonIs);
		
		JLabel lblPanel = new JLabel("Select from the following choices");
		lblPanel.setVisible(true);
		JPanel panel = new JPanel();
		panel.add(lblPanel);
		String[] choices = { "1", "2","3", "4", "5" };
		//final JComboBox<String> cb = new JComboBox<String>(choices);
		//cb.setVisible(true);
		//panel.add(cb);
		
		JLabel lblCorrectAnswer = new JLabel("If Answer is Correct");
		lblCorrectAnswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorrectAnswer.setBounds(10, 202, 151, 16);
		contentPane.add(lblCorrectAnswer);
		
		JLabel lblIfAnswerIs = new JLabel("If Answer is Incorrect");
		lblIfAnswerIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIfAnswerIs.setBounds(12, 288, 164, 16);
		contentPane.add(lblIfAnswerIs);
		
		List list = new List();
		list.setBounds(271, 156, 54, 68);
		contentPane.add(list);
		
		JTextArea textQuestion = new JTextArea();
		textQuestion.setBounds(12, 76, 309, 74);
		contentPane.add(textQuestion);
		
		
		JTextArea textAnswerC = new JTextArea();
		textAnswerC.setBounds(12, 226, 309, 57);
		contentPane.add(textAnswerC);
		
		JTextArea textAnswerI = new JTextArea();
		textAnswerI.setBounds(12, 309, 309, 69);
		contentPane.add(textAnswerI);
		
		JTextArea textTitle = new JTextArea();
		textTitle.setBounds(51, 12, 270, 22);
		contentPane.add(textTitle);
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
