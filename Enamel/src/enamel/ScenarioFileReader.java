package enamel;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScenarioFileReader {
	static EventList eventList = new EventList();
	

	
	//index, title, Question, responseRight,responseWrong, cellArray, correctAns
	//cell, button, title, eventList
	public static void readScenarioFile(String fileName){
	
		//String scenarioFileString = null;
		
		//ArrayList<ScenarioEvent> eventList = new ArrayList<ScenarioEvent>();
		
		try{
	//only once per scenario
		int index = 0;

		File scenarioFile = new File(fileName);
		Scanner scenarioFileScanner = new Scanner(scenarioFile);
		scenarioFileScanner.useDelimiter(" |\\n");
		scenarioFileScanner.next();
		String cell = scenarioFileScanner.next();
//System.out.println("cell:" + cell); //test

		scenarioFileScanner.next();
		String button = scenarioFileScanner.next();
//System.out.println("button: " + button);

		//scenarioFileScanner.useDelimiter("\\n");
		
		String title = FactoryMethods.findNextSpokenString(scenarioFileScanner);
		
		/*scenarioFileScanner.useDelimiter(" |\\n");*/
		while (scenarioFileScanner.hasNext()) {
			
			
			String dispLine = null;
			String cellPinString = null;
			char[] cellsPinCharArray = null;
			String [] cellArray = new String [8];
			scenarioFileScanner.reset();
			scenarioFileScanner.useDelimiter("\\n|:");
			int cellMax = Integer.parseInt(cell);
			//"/~disp-cell-pins:x where x is 0 to max cell pins ADD MAX HERE
			 while (scenarioFileScanner.hasNext("/~disp-cell-pins:0") || scenarioFileScanner.hasNext("/~disp-cell-pins:1") || scenarioFileScanner.hasNext("/~disp-cell-pins:2") || scenarioFileScanner.hasNext("/~disp-cell-pins:3") || scenarioFileScanner.hasNext("/~disp-cell-pins:4") || scenarioFileScanner.hasNext("/~disp-cell-pins:5") || scenarioFileScanner.hasNext("/~disp-cell-pins:6") || scenarioFileScanner.hasNext("/~disp-cell-pins:7") || scenarioFileScanner.hasNext("/~disp-cell-pins:8")){
				 dispLine= scenarioFileScanner.next();
				 System.out.println("dispLine: " + dispLine);
				 String cellNumberString =dispLine.substring(17);
				 int CellNumber = Integer.parseInt(cellNumberString);
				 System.out.println("cellNumber: " + cellNumberString);
				 cellPinString= scenarioFileScanner.next();
				 //cellPinCharArray = dispLine.toCharArray();
				 cellArray[CellNumber] = cellPinString;
				int i =0;
				System.out.print("cellPinsStringArray: ");
				/*for (char c : cellPinsCharArray) {
					 cellPinsStringArray[i] = String.valueOf(c);
					 System.out.print(c);
					 i++;
					 }
					System.out.println();*/
			 }
				scenarioFileScanner.reset();
				scenarioFileScanner.useDelimiter("\\n");

				
			 
				/* scenarioFileScanner.useDelimiter("\\n");

		
				String findQuestion = scenarioFileScanner.next();
				String Question;
			while (findQuestion.startsWith("/~")) {
				findQuestion = scenarioFileScanner.next();
			}
				Question = findQuestion;*/
			 String Question = FactoryMethods.findNextSpokenString(scenarioFileScanner);
//System.out.println("QUESTION: " + Question); //test

			// find correct answer
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

//System.out.println("Correct Button: " + correctAnswerString);

			
			//find responseRight and responseWrong
			/*String findResponseRight= scenarioFileScanner.next();
			String responseRight;
			if (findResponseRight.startsWith("/~")){
				do{
				findResponseRight = scenarioFileScanner.next();
				}
				while (!findResponseRight.startsWith("/~"));
			}
			responseRight=findResponseRight;*/
String responseRight = FactoryMethods.findNextSpokenString(scenarioFileScanner);
//System.out.println("RESPONSE RIGHT: " +responseRight);
String responseWrong = FactoryMethods.findNextSpokenString(scenarioFileScanner);
			/*String findResponseWrong =scenarioFileScanner.next();
			String responseWrong;
			
			if (findResponseWrong.startsWith("/~")) {
				do{
				findResponseWrong = scenarioFileScanner.next();
				}
				while (!findResponseWrong.startsWith("/~"));
		
			}
			responseWrong = findResponseWrong;*/

	//System.out.println("Response Wrong: " + responseWrong);

				index +=1;
				//System.out.println("index" + index);
				//System.out.println(cellNumber + cellArray[i]); //test

				ScenarioEvent readEvent = new ScenarioEvent(index, title, Question, responseRight,responseWrong, cellArray, correctAns);
				if (eventList.isEmpty()){
				eventList.addFirst(readEvent);
				}
				else {
				eventList.add(index, readEvent);
				}
					
					
	//System.out.print(readEvent.getQuestion());

	Scenario scenario = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
	//test
	System.out.println("DONE, scenario arguements are: " + cell +", " + button +", " + title +", " + eventList.timeline.size()+ "The eventList arguements are as follows:" );
	
	for(ScenarioEvent e: eventList) {
		System.out.println("Event Index:" + e.index);
		System.out.println("Question: " + e.getQuestion());
		System.out.println("Correct Button: " + e.getCorrectAns()); 
		System.out.println("Response if Answer Correct: " + e.getResponseRight());
		System.out.println("Response if Answer Incorrect: " + e.getResponseWrong());
	}
	
				
			 
			
			}
			//scenarioFileString += scenarioFileScanner.next();
		
		scenarioFileScanner.close();

		
		
	
			// Build the Scenario object and pass it into ScenarioEditor as an existng scenario
			Scenario edit = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
		
		
	
		String[] args = {"0"};
		ScenarioEditor.main(args, edit);
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
