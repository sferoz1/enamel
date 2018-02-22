package enamel;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScenarioFileReader {
	
	public static void readScenarioFile(String fileName){
		String scenarioFileString = null;
		
		int index = 0;
		//ArrayList<ScenarioEvent> eventList = new ArrayList<ScenarioEvent>();
		
		try{
		File scenarioFile = new File(fileName);
		Scanner scenarioFileScanner = new Scanner(scenarioFile);
		scenarioFileScanner.useDelimiter("\n");
		String cell = scenarioFileScanner.next();
		String button = scenarioFileScanner.next();
		String title = scenarioFileScanner.next();
		EventList eventList = new EventList();
		
		
		while (scenarioFileScanner.hasNext()) {
			if (!scenarioFileScanner.next().startsWith("/~") && !scenarioFileScanner.next().equals("CORRECT") && !scenarioFileScanner.next().equals("INCORRECT") ) {
				String Question = scenarioFileScanner.next();
				int correctAns = Integer.parseInt(scenarioFileScanner.next());
				String responseRight = scenarioFileScanner.next();
				String responseWrong = scenarioFileScanner.next();
				index +=1;
				ScenarioEvent readEvent = new ScenarioEvent(index, title, Question, responseRight,responseWrong,correctAns);
				eventList.add(index, readEvent);
				}	
			
				
			}
			//scenarioFileString += scenarioFileScanner.next();
	
		scenarioFileScanner.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			ErrorWindow errorWindow = new ErrorWindow("Error: File Not Found");
			errorWindow.initialize("Error");
		}
		}
	
	
			

}
