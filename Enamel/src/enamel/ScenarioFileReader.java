package enamel;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScenarioFileReader {
	static EventList eventList = new EventList();
	
	public static void readScenarioFile(String fileName){
	
		
		try{
	//only once per scenario
		int index = 0;
		File scenarioFile = new File(fileName);
		
		
		Scanner numQScanner = new Scanner(scenarioFile);
		numQScanner.useDelimiter("\n");
		int eventListSize =0;
		while (numQScanner.hasNext()) {
		if (numQScanner.hasNext("/~reset-buttons")) {
			numQScanner.next();
			eventListSize++;
			numQScanner.next();
		}
		numQScanner.next();
		}
		numQScanner.close();
		
		
		Scanner scenarioFileScanner = new Scanner(scenarioFile);
		scenarioFileScanner.useDelimiter(" |\\n");
		scenarioFileScanner.next();
		
		String cell = scenarioFileScanner.next();
		scenarioFileScanner.next();
		String button = scenarioFileScanner.next();
		String title = FactoryMethods.findNextSpokenString(scenarioFileScanner);
		
		/*scenarioFileScanner.useDelimiter(" |\\n");*/
		while (scenarioFileScanner.hasNext()) {
			
			//pins
			String dispLine = null;
			String cellPinString = null;
			char[] cellsPinCharArray = null;
			String [] cellArray = new String [8];
			scenarioFileScanner.reset();
			scenarioFileScanner.useDelimiter("\\n|:");
			int cellMax = Integer.parseInt(cell);
			 if (scenarioFileScanner.hasNext("/~disp-cell-pins:0") || scenarioFileScanner.hasNext("/~disp-cell-pins:1") || scenarioFileScanner.hasNext("/~disp-cell-pins:2") || scenarioFileScanner.hasNext("/~disp-cell-pins:3") || scenarioFileScanner.hasNext("/~disp-cell-pins:4") || scenarioFileScanner.hasNext("/~disp-cell-pins:5") || scenarioFileScanner.hasNext("/~disp-cell-pins:6") || scenarioFileScanner.hasNext("/~disp-cell-pins:7") || scenarioFileScanner.hasNext("/~disp-cell-pins:8")){
				 dispLine= scenarioFileScanner.next();
				 System.out.println("dispLine: " + dispLine);
				 String cellNumberString =dispLine.substring(17);
				 int CellNumber = Integer.parseInt(cellNumberString);
				 System.out.println("cellNumber: " + cellNumberString);
				 cellPinString= scenarioFileScanner.next();
				 cellArray[CellNumber] = cellPinString;
				int i =0;
				System.out.print("cellPinsStringArray: ");
			
			 }
				scenarioFileScanner.reset();
				scenarioFileScanner.useDelimiter("\\n");

				
			
			
				
			do {
			 String Question = FactoryMethods.findNextSpokenString(scenarioFileScanner);

			String findCorrAns = scenarioFileScanner.next();
			String correctAnswerString;
			
			Integer correctAnswerInteger;
			
			int correctAns;
			while (!findCorrAns.startsWith("/~skip-button:")){
				findCorrAns = scenarioFileScanner.next();
			}
				correctAnswerString = findCorrAns.substring(14,15);
				correctAnswerInteger = Integer.parseInt(correctAnswerString);
				correctAns = (int) correctAnswerInteger;


String responseRight = FactoryMethods.findNextSpokenString(scenarioFileScanner);
String responseWrong = FactoryMethods.findNextSpokenString(scenarioFileScanner);


				if (eventList.isEmpty()){
					ScenarioEvent readEvent = new ScenarioEvent(index, title, Question, responseRight,responseWrong, cellArray, correctAns);

				eventList.addFirst(readEvent);
				}
				else {
					index +=1;

					eventList.add(new ScenarioEvent(index, title, Question, responseRight,responseWrong, cellArray, correctAns));

				}
				
				eventListSize--;
			}	
			while (index == 0);
		
			scenarioFileScanner.close();
	
	//System.out.print(readEvent.getQuestion());

	Scenario scenario = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
	
	// Build the Scenario object and pass it into ScenarioEditor as an existng scenario
	Scenario edit = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);



String[] args = {"0"};
ScenarioEditor.main(args, edit);
	
	//test
	
	System.out.println("DONE, scenario arguements are: " + cell +", " + button +", " + title +", " + eventList.size()+ "The eventList arguements are as follows:" );
	
	for(ScenarioEvent e: eventList) {
		System.out.println("Event Index:" + e.index);
		System.out.println("Question: " + e.getQuestion());
		System.out.println("Correct Button: " + e.getCorrectAns()); 
		System.out.println("Response if Answer Correct: " + e.getResponseRight());
		System.out.println("Response if Answer Incorrect: " + e.getResponseWrong());
	}
	
				
			 
			
			}
			//scenarioFileString += scenarioFileScanner.next();
		

		
		
	
	
		//return edit;
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
			ErrorWindow errorWindow = new ErrorWindow("Error: File Not Found");
			errorWindow.initialize("Error"); 
		}
		//return null;
		}
	
	
			

}
