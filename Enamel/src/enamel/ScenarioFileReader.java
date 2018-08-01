package enamel;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScenarioFileReader {
	public EventList eventList = new EventList();
	public List<BrailleCell> brailleCelllList = new LinkedList<BrailleCell>();
	
/*	public static void main(String[] args) {
		try {
			String scenarioFile = "testFile.txt";
			File f = new File(scenarioFile);
			
			String absolutePath = f.getAbsolutePath();
			String scenarioFilePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
		readScenarioFile(scenarioFile);
		} catch (Exception e) {
		
		}
	}*/
	
	public  Scenario readScenarioFile(File fileName){
	
		try{
	//only once per scenario
		int index = -1;
		File scenarioFile = fileName;

		
		Scanner numQScanner = new Scanner(scenarioFile);
		numQScanner.useDelimiter("\n");
		int eventListSize =0;
		while (numQScanner.hasNext()) {
		if (numQScanner.hasNext("/~reset-buttons")) {
			eventListSize++;
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
		
		System.out.println("cell: " + cell);
		System.out.println("button: " + button);
		System.out.println("title: " + title);
		System.out.println("numQuestions: " + eventListSize);
		

		
		Scanner pinScanner = new Scanner(scenarioFile);
		pinScanner.useDelimiter("\\n");
	//while (scenarioFileScanner.hasNext()) {
		//for (int i = 0; i< Integer.parseInt(cell); i++){
		do{
			
			
			//////PINSSSSSSSSSSSSS
			String[] cellArray = new String[8];
			int j = Integer.parseInt(cell);

				
			do {
				String dispLine;
				String cellPinString;
				char[] cellsPinCharArray;
				
				String nextNonSpokenString;
				
				nextNonSpokenString = FactoryMethods.findNextNonSpokenString(pinScanner);
				System.out.print("LINE 89" + nextNonSpokenString);

				while (!nextNonSpokenString.startsWith("/~disp-cell-pins")) {
					nextNonSpokenString = FactoryMethods.findNextNonSpokenString(pinScanner);
				}
				
				if (nextNonSpokenString.startsWith("/~disp-cell-pins")){
					 dispLine= nextNonSpokenString;
						System.out.print("LINE 86" + dispLine);

					 String cellNumberString =dispLine.substring(17,18);
					 int CellNumber = Integer.parseInt(cellNumberString);
			
					 cellPinString= dispLine.substring(19,27);
					 
					 cellArray[CellNumber] = cellPinString;
					
					
				 }	
				System.out.print("LINE 89");
				for (String s :cellArray) {
					System.out.println(s);
				}
				j--;
		}while (j!=0);
				/////////////////
			
			
				scenarioFileScanner.useDelimiter("\\n"); 
				String Question = FactoryMethods.findNextSpokenString(scenarioFileScanner);
				System.out.println("Question: " + Question);
				String nextLine = scenarioFileScanner.next();
				String questionAudio = null;
				if (nextLine.startsWith("/~sound:")) {
					 questionAudio = nextLine.substring(8);
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
				System.out.println(" correct Ans: " + correctAnswerInteger);


String responseRight = FactoryMethods.findNextSpokenString(scenarioFileScanner);
System.out.println(" response Right: " + responseRight);

 nextLine = scenarioFileScanner.next();
 String responseRightAudio = null;
if (nextLine.startsWith("/~sound:")) {
	 responseRightAudio = nextLine.substring(8);;
	System.out.println("Response Right: " + responseRightAudio);

}
String responseWrongAudio = null;
String responseWrong = FactoryMethods.findNextSpokenString(scenarioFileScanner);
System.out.println(" response Wrong: " + responseWrong);

 nextLine = scenarioFileScanner.next();
if (nextLine.startsWith("/~sound:")) {
	 responseWrongAudio = nextLine.substring(8);;
	System.out.println("Response Wrong" + responseWrongAudio);

}
		
				index +=1;

				//if (eventList.isEmpty()){
					//ScenarioEvent readEvent = new ScenarioEvent(index, title, Question, questionAudio, responseRight,responseRightAudio, responseWrong,responseWrongAudio, cellArray, correctAns);

				//eventList.addFirst(readEvent);
				//}
				//else {

					eventList.add(new ScenarioEvent(index, title, Question, questionAudio, responseRight,responseRightAudio, responseWrong,responseWrongAudio, cellArray, correctAns));
					
				//}

			eventListSize--;
		}
			while (eventListSize!=0);

			//while (eventListSize != 0);
			//while (index ==0)
		
			scenarioFileScanner.close();
			pinScanner.close();
	//}
	//System.out.print(readEvent.getQuestion());

	//Scenario scenario = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
	
	// Build the Scenario object and pass it into ScenarioEditor as an existng scenario
	Scenario edit = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
	
	//editing 
	for (ScenarioEvent e : edit.scenarioEventList) {
		edit.getScenarioEventList().timeline.add(e);
	}
	///////////
	//test
	
	System.out.println("DONE, scenario arguements are: " + cell +", " + button +", " + title +", " + eventList.size()+ "The eventList arguements are as follows:" );
	String[] args = {"0"};

	for(ScenarioEvent e: edit.getScenarioEventList()) {

		//EventEditor.main(args, e);
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
	//end test

//String[] args = {"0"};
ScenarioEditor.main(args, edit);

//EventEditor.main(args, e);

				
			 
	return edit;

			
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
