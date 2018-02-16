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

public class EventEditor extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextField questionField;
	private JTextField textField_2;
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
		setBounds(100, 100, 359, 476);
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
		lblWhichButtonIs.setBounds(12, 163, 268, 16);
		contentPane.add(lblWhichButtonIs);
		
		textField_2 = new JTextField();
		textField_2.setBounds(279, 161, 46, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(textField_2, popupMenu);
		
		JLabel label_2 = new JLabel("3");
		popupMenu.add(label_2);
		
		JLabel label_1 = new JLabel("2");
		popupMenu.add(label_1);
		
		JLabel label = new JLabel("1");
		popupMenu.add(label);
		
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
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = 0; // CHANGE THIS!
				String title = titleField.getText();
				String question = questionField.getText();
				String answer = ifAnsCorrect.getText();
				String wrong = ifAnsWrong.getText();
				
				// TODO: Change ScenarioEvent get rid of answers array and replace with right/wrong responses
				// TODO: dropdown box for asking which answer is correct
				String[] answers = new String[2];
				answers[0] = answer;
				answers[1] = wrong;
				int correctAnswer = 0; // CHANGE THIS!
				//ScenarioEditor.addEvent(title, question, answers, correctAnswer, index);
				
			}
		});
		btnSave.setBounds(12, 391, 97, 25);
		contentPane.add(btnSave);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
