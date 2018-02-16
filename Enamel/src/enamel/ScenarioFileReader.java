package enamel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScenarioFileReader {
	//if choosing a file to edit or play
	public static void readScenarioFile(String fileName){
		String scenarioFileString = null;
		try{
		File scenarioFile = new File(fileName);
		Scanner scenarioFileScanner = new Scanner(scenarioFile);
		while (scenarioFileScanner.hasNext()) {
			scenarioFileString += scenarioFileScanner.next();
		}
		scenarioFileScanner.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			ErrorWindow errorWindow = new ErrorWindow("Error: File Not Found");
			errorWindow.initialize();
		}
		}
	
	
			

}
