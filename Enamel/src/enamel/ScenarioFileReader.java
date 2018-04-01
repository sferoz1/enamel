package enamel;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScenarioFileReader {
	static EventList eventList = new EventList();
	static List<BrailleCell> brailleCelllList = new LinkedList<BrailleCell>();
	
	public static void main(String[] args) {
		try {
			String scenarioFile = "testFile.txt";
			File f = new File(scenarioFile);
			
			String absolutePath = f.getAbsolutePath();
			String scenarioFilePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
		readScenarioFile(scenarioFile);
		} catch (Exception e) {
		
		}
	}
	
	
	public static Scenario readScenarioFile(String fileName){
	
		
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
		
		Scanner pinScanner = new Scanner(scenarioFile);
		
		/*scenarioFileScanner.useDelimiter(" |\\n");*/
		while (scenarioFileScanner.hasNext()) {
			
		
				//scenarioFileScanner.reset();
				//scenarioFileScanner.useDelimiter("\\n");

				
			
			String[] cellArray = new String[8];

				
			do {
				
				//pins
				String dispLine;
				String cellPinString;
				char[] cellsPinCharArray;
				
				String nextNonSpokenString;
				
				nextNonSpokenString = FactoryMethods.findNextNonSpokenString(pinScanner);
				while (!nextNonSpokenString.startsWith("/~disp-cell-pins:")) {
					nextNonSpokenString = FactoryMethods.findNextNonSpokenString(pinScanner);
				}
				
				if (nextNonSpokenString.startsWith("/~disp-cell-pins:")){
					 dispLine= nextNonSpokenString;
					 String cellNumberString =dispLine.substring(17,18);
					 int CellNumber = Integer.parseInt(cellNumberString);
			
					 cellPinString= dispLine.substring(19,27);
					 
					cellArray[CellNumber] = cellPinString;
					int i =0;
					
				 }	
				//System.out.println();
				//for (String s :cellArray) {
					//System.out.println(s);
				//}
				scenarioFileScanner.useDelimiter("\\n"); 

				String Question = FactoryMethods.findNextSpokenString(scenarioFileScanner);
				String nextLine = scenarioFileScanner.next();
				String questionAudio = "";
				if (nextLine.startsWith("/~sound:")) {
					 questionAudio = nextLine;
					System.out.println("Question Audio: " + questionAudio);

				}

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
 nextLine = scenarioFileScanner.next();
 String responseRightAudio = "";
if (nextLine.startsWith("/~sound:")) {
	 responseRightAudio = nextLine;
	System.out.println("Response Right: " + responseRightAudio);

}
String responseWrongAudio = "";
String responseWrong = FactoryMethods.findNextSpokenString(scenarioFileScanner);
 nextLine = scenarioFileScanner.next();
if (nextLine.startsWith("/~sound:")) {
	 responseWrongAudio = nextLine;
	System.out.println("Response Wrong" + responseWrongAudio);

}
		

				if (eventList.isEmpty()){
					ScenarioEvent readEvent = new ScenarioEvent(index, title, Question, questionAudio, responseRight,responseRightAudio, responseWrong,responseWrongAudio, cellArray, correctAns);

				eventList.addFirst(readEvent);
				}
				else {
					index +=1;

					eventList.add(new ScenarioEvent(index, title, Question, questionAudio, responseRight,responseRightAudio, responseWrong,responseWrongAudio, cellArray, correctAns));

				}
				
			
				eventListSize--;
			}	
			while (index == 0);
		
			scenarioFileScanner.close();
	
	//System.out.print(readEvent.getQuestion());

	Scenario scenario = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
	
	// Build the Scenario object and pass it into ScenarioEditor as an existng scenario
	Scenario edit = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
	
	//editing 
	for (ScenarioEvent e : edit.scenarioEventList) {
		edit.getScenarioEventList().timeline.add(e);
	}
	///////////



String[] args = {"0"};
ScenarioEditor.main(args, edit);
	
	//test
	
	System.out.println("DONE, scenario arguements are: " + cell +", " + button +", " + title +", " + eventList.size()+ "The eventList arguements are as follows:" );
	
	for(ScenarioEvent e: eventList) {
		
		System.out.println("Question: " + e.getQuestion());
		System.out.println("Event Index:" + e.index);
		for (String s : e.getCellArray()) {
		System.out.println(s);
		}
		System.out.println("Correct Button: " + e.getCorrectAns()); 
		System.out.println("Response if Answer Correct: " + e.getResponseRight());
		System.out.println("Response if Answer Incorrect: " + e.getResponseWrong());
		System.out.println();

	}
	
				
			 
	return edit;

			}
			//scenarioFileString += scenarioFileScanner.next();
		

		
	
	
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
			ErrorWindow errorWindow = new ErrorWindow("Error: File Not Found");
			errorWindow.initialize("Error"); 
		}
		return null;
		}
	
	
			

}
