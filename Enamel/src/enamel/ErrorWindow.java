package enamel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ErrorWindow extends JFrame {
	
	public static String errorMessage;
	
	//get the error message from error log

	public static void readErrorLog(String fileName){
	try{
	File errorLog = new File("ERROR_LOG.txt");
	Scanner errorLogScanner = new Scanner(errorLog);
	while (errorLogScanner.hasNext()) {
		
		errorMessage= errorMessage + errorLogScanner.next();
		
	}
	errorLogScanner.close();
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	}
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorWindow frame = new ErrorWindow();
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
	//construct ErrorWindow
	public ErrorWindow() {
		initialize();
	}
	
	public ErrorWindow(String Message){
	this.errorMessage = Message;
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblError = new JLabel("Error:"+ this.errorMessage);
		lblError.setBounds(102, 62, 61, 16);
		contentPane.add(lblError);
		
		
	}
}
