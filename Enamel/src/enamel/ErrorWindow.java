package enamel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ErrorWindow extends JFrame {
	
	public static String ErrorMessage;

	

	//get the error message from error log
	
/*public static void readErrorFile(String fileName){
		
		String fileString = "";
		try{
		String filePath = new File(fileName).getAbsolutePath();
		File textFile = new File(filePath);
		Scanner fileScanner = new Scanner(textFile);
		while (fileScanner.hasNext()) {
			fileString = fileScanner.next();
			errorMessage= fileString;
		}
		System.out.println(errorMessage);
		fileScanner.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			ErrorWindow errorWindow = new ErrorWindow("Error: File Not Found");
			errorWindow.initialize();
		}
		}*/


	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ErrorLogReader.readErrorFile("ERROR_LOG.txt");//read error log
		
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
		
	//initialize window
	}

	/**
	 * Create the frame.
	 */
	//construct ErrorWindow
	public ErrorWindow() {
		initialize(ErrorLogReader.errorLogString);
	}
	
	public ErrorWindow(String customMessage){
	initialize(customMessage);
	}
	
	public void initialize(String message) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblError = new JLabel("Error!" + message);
		lblError.setBounds(60, 45, 61, 16);
		contentPane.add(lblError);
		
		contentPane.setVisible(true);
		
		
	}
}
