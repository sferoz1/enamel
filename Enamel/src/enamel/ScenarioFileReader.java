package enamel;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScenarioFileReader {
	//public static EventList eventList = new EventList();
	public List<BrailleCell> brailleCelllList = new LinkedList<BrailleCell>();
	
	public static void main(String[] args) {
			try {
				String scenarioFile = "testFile.txt";
				File f = new File(scenarioFile);
				
				String absolutePath = f.getAbsolutePath();
				String scenarioFilePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
				readScenarioFile(scenarioFile);
			} catch (Exception e) {
				//errorLog("Exception error: " + e.toString(),
					//	"Expected the directory path of the scenario file to"
						//		+ " a file exists in the project folder. \n Could not find directory to path: "
							//	+  "" + " \n Perhaps" + " you forgot to add the file to the directory or "
								//+ " you are looking for a different directory?");
			}
		}
	
	
	public static void readScenarioFile(String fileName){
		EventList eventList = new EventList();
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
		
		
		Scanner eventsScanner = new Scanner(scenarioFile);
		eventsScanner.useDelimiter("/~reset-buttons");
		
		
		
		
		Scanner scenarioFileScanner = new Scanner(scenarioFile);
		Scanner eventScanner = new Scanner(scenarioFile);
		eventScanner.useDelimiter("\\n");
		
		
		scenarioFileScanner.useDelimiter(" |\\n");
		scenarioFileScanner.next();
		
		String cell = scenarioFileScanner.next();
		scenarioFileScanner.next();
		String button = scenarioFileScanner.next();
		String title = FactoryMethods.findNextSpokenString(scenarioFileScanner);
		//String title = scenarioFileScanner.next();
		System.out.println("Cell: " + cell);
		System.out.println("Button: " + button);
		System.out.println("Title: " + title);
		System.out.println("Event List Size " + eventListSize);


		Scanner pinScanner = new Scanner(scenarioFile);
		Scanner audioScanner = new Scanner(scenarioFile);
		
		Scenario scenario = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
		Scenario edit = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
		/*scenarioFileScanner.useDelimiter(" |\\n");*/
		
		while (scenarioFileScanner.hasNext()) {
			//String sfsLine = scenarioFileScanner.next();
			
			//scenarioFileScanner.reset();
			//scenarioFileScanner.useDelimiter("\\n");
			String[] cellArray = new String[8];

			do{
 //(eventListSize > 0)
				{
				
				//pins
				String dispLine;
				String cellPinString;
				char[] cellsPinCharArray;
				
				String nextNonSpokenString;
				
				nextNonSpokenString = FactoryMethods.findNextNonSpokenString(pinScanner);
				if (!nextNonSpokenString.startsWith("/~disp-cell-pins:")) {
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
				pinScanner.close();
				for (String s : cellArray) {
					System.out.println(s);
				}
				scenarioFileScanner.useDelimiter("\\n"); 

				String Question = FactoryMethods.findNextSpokenString(scenarioFileScanner);
				System.out.println(Question);
				
				
				////Audio Files
				String questionAudio= "";
				String rightAnswerAudio = "";
				String wrongAnswerAudio = "";
				audioScanner.useDelimiter("\\n");
			//	while not at next question 
				 questionAudio = FactoryMethods.findNextSoundFile(audioScanner);
			
				 rightAnswerAudio = FactoryMethods.findNextSoundFile(audioScanner);
			
				 wrongAnswerAudio = FactoryMethods.findNextSoundFile(audioScanner);
				//}
				//audioScanner.close();
				//////////
	System.out.println(questionAudio);
	System.out.println(rightAnswerAudio);	
	System.out.println(wrongAnswerAudio);

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
		System.out.println(correctAnswerString);

				String responseRight = FactoryMethods.findNextSpokenString(scenarioFileScanner);
				String responseWrong = FactoryMethods.findNextSpokenString(scenarioFileScanner);
		System.out.println(responseRight);
		System.out.println(responseWrong);
		ScenarioEvent readEvent = new ScenarioEvent(index, title, Question,questionAudio, responseRight, rightAnswerAudio, responseWrong, wrongAnswerAudio, cellArray, correctAns);

			
					eventList.addLast(readEvent);
					
				
				index +=1;

				eventListSize--;

				
				//editing 
				for (ScenarioEvent e : eventList) {
					edit.getScenarioEventList().timeline.add(e);
				}
				///////////
			System.out.println("DONE, scenario arguements are: " + cell +", " + button +", " + title +", " + eventList.size()+ "The eventList arguements are as follows:" );
				
				for(ScenarioEvent e: edit.scenarioEventList) {
					
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

			}	
			//while (eventListSize == 0);
			eventScanner.next();
			eventScanner.next();
		
			
		} while (!eventScanner.hasNext("/~reset-buttons"));
		scenarioFileScanner.close();
		audioScanner.close();

	//Scenario scenario = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
	
	//Scenario edit = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
	
	//editing 
	for (ScenarioEvent e : edit.scenarioEventList) {
		edit.getScenarioEventList().timeline.add(e);
	}
	///////////



 String[] args= {"0"};
//ScenarioEditor.main(new String[ ] {"0"}, edit);
//EventEditor
	
	//test
	
	
	
				
			 

			
			//scenarioFileString += scenarioFileScanner.next();


		
	
	
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
			ErrorWindow errorWindow = new ErrorWindow("Error: File Not Found");
			errorWindow.initialize("Error"); 
		}
		}
	
	public static String findNextSpokenString(Scanner scenarioFileScanner) {
		scenarioFileScanner.useDelimiter("\\n");
		 
		String nextLine = scenarioFileScanner.next();
		String nextSpokenLine;
	while (nextLine.startsWith("/~")) {
		nextLine = scenarioFileScanner.next();
	}
		 nextSpokenLine = nextLine;
		 return nextSpokenLine;
		
	}
	
	public static String findNextSoundFile(Scanner scenarioFileScanner) {
		scenarioFileScanner.useDelimiter("\\n");
		 
		String nextLine = scenarioFileScanner.next();
		String nextSoundFile;
	while (nextLine.startsWith("/~sound:") && !nextLine.startsWith("/~sound:correct.wav") && !nextLine.startsWith("/~sound:wrong.wav")) {
		
		nextLine = scenarioFileScanner.next();
	
	}
		 nextSoundFile = nextLine;
		 return nextSoundFile;
		
	}
	
	
	
	
	
	
	public static String rearrangePinString(String pinString) {
		char[] pinArray = pinString.toCharArray();
		char[] arrangedPinArray = new char[8];
		arrangedPinArray[0] = pinArray[0];
		arrangedPinArray[1] = pinArray[2];
		arrangedPinArray[2] = pinArray[4];
		arrangedPinArray[3] = pinArray[1];
		arrangedPinArray[4] = pinArray[3];
		arrangedPinArray[5] = pinArray[5];
		arrangedPinArray[6] = pinArray[6];
		arrangedPinArray[7] = pinArray[7];
		
		
		String arrangedPinArrayString = String.copyValueOf(arrangedPinArray);
		
	
		
		return arrangedPinArrayString;
	}
			

}
