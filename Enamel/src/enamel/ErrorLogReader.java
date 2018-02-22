package enamel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ErrorLogReader {
	public static String errorLogString;
	
	//modified general readFile method 
	public static void readErrorFile(String fileName){
		
		String fileString = "";
		try{
		String filePath = new File(fileName).getAbsolutePath();
		File textFile = new File(filePath);
		Scanner fileScanner = new Scanner(textFile);
		while (fileScanner.hasNext()) {
			fileString = fileScanner.next() + " ";
			errorLogString= fileString;
			
			System.out.print(errorLogString); //make sure file is being read 
		}
		fileScanner.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			ErrorWindow errorWindow = new ErrorWindow("Error: File Not Found");
			//errorWindow.initialize();
		}
		}
	
	public static void main(String[] args) {
		readErrorFile("ERROR_LOG.txt");
		ErrorWindow window = new ErrorWindow(errorLogString);
		window.initialize(errorLogString);
	}	
}
package enamel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ErrorLogReader {
	public static String errorLogString;
	
	//modified general readFile method 
	public static void readErrorFile(String fileName){
		
		String fileString = "";
		try{
		String filePath = new File(fileName).getAbsolutePath();
		File textFile = new File(filePath);
		Scanner fileScanner = new Scanner(textFile);
		while (fileScanner.hasNext()) {
			fileString = fileScanner.next() + " ";
			errorLogString= fileString;
			
			System.out.print(errorLogString); //make sure file is being read 
		}
		fileScanner.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			ErrorWindow errorWindow = new ErrorWindow("Error: File Not Found");
			//errorWindow.initialize();
		}
		}
	
	public static void main(String[] args) {
		readErrorFile("ERROR_LOG.txt");
		ErrorWindow window = new ErrorWindow(errorLogString);
		window.initialize(errorLogString);
	}	
}