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
		scenarioFileScanner.useDelimiter(" |\\n");
		scenarioFileScanner.next();
		String cell = scenarioFileScanner.next();
		scenarioFileScanner.next();
		String button = scenarioFileScanner.next();
		scenarioFileScanner.next();
		String title = scenarioFileScanner.next();
		EventList eventList = new EventList();
		
		while (scenarioFileScanner.hasNext()) {
			String dispLine = null;
			char[] charCellArray = null;
			String [] cellArray = new String [8];
			
			 if (scenarioFileScanner.hasNext(" /~disp-cell-pins:")){
				 
				 dispLine= scenarioFileScanner.next();
				 String pinNumber =dispLine.substring(20);
				 charCellArray = dispLine.toCharArray();
				 int i =0;
				 for (char c : charCellArray) {
					 cellArray[i] = String.valueOf(c);
					 i++;
					 }
				 }
				 
			if (!scenarioFileScanner.next().startsWith("/~") && !scenarioFileScanner.next().equals("CORRECT") && !scenarioFileScanner.next().equals("INCORRECT") ) {
				String Question = scenarioFileScanner.next();
				int correctAns = Integer.parseInt(scenarioFileScanner.next());
				String responseRight = scenarioFileScanner.next();
				String responseWrong = scenarioFileScanner.next();
				index +=1;

				ScenarioEvent readEvent = new ScenarioEvent(index, title, Question, responseRight,responseWrong, cellArray, correctAns);
				eventList.add(index, readEvent);
				
				}	
			
			}
			//scenarioFileString += scenarioFileScanner.next();
		
		scenarioFileScanner.close();
		
		// Build the Scenario object and pass it into ScenarioEditor as an existng scenario
		Scenario edit = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
		String[] args = {"0"};
		ScenarioEditor.main(args, edit);
		
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
			ErrorWindow errorWindow = new ErrorWindow("Error: File Not Found");
			errorWindow.initialize("Error");
		}
		}
	
	
			

}
