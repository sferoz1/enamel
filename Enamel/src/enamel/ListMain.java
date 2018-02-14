package enamel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class ListMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListMain frame = new ListMain();
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
	public ListMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(34, 35, 154, 168);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setVisibleRowCount(-1);
		final JTextArea textArea = new JTextArea(10,20);
		JScrollPane listScroller = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		listScroller.setPreferredSize(new Dimension(250, 80));
		contentPane.add(list);
		DefaultListModel DLM=new DefaultListModel();
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DefaultListModel DLM=new DefaultListModel();
				String nameText = null;
				String element = nameText ;
				nameText = textField.getText();
	
				DLM.addElement(element);
				list.setModel(DLM);
			}
		});
		btnNewButton.setBounds(291, 101, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLM.clear();
			}
		});
		btnClear.setBounds(291, 139, 97, 25);
		contentPane.add(btnClear);
			
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(200, 36, 56, 16);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(291, 33, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
