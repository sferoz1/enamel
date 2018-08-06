package enamel;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScenFileReader {
	//public static EventList eventList = new EventList();
	public List<BrailleCell> brailleCelllList = new LinkedList<BrailleCell>();
	
	public static void main(String[] args) {
			try {
				String scenarioFile = "testFile.txt";
				File f = new File(scenarioFile);
				
				String absolutePath = f.getAbsolutePath();
				String scenarioFilePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
				ScenFileReader reader = new ScenFileReader();
				reader.readScenarioFile(scenarioFile);
			} catch (Exception e) {
			
			}
		}
	
	
	public static  void readScenarioFile(String fileName){
		EventList eventList = new EventList();
		
		try{
	//only once per scenario
		int eventsRemaining = 0;
		File scenarioFile = new File(fileName);
		Scanner numQScanner = new Scanner(scenarioFile);
		numQScanner.useDelimiter("\n");
		int eventListSize =0;
		int index = -1;
		while (numQScanner.hasNext()) {
		if (numQScanner.hasNext("/~reset-buttons")) {
			numQScanner.next();
			eventListSize++;
			numQScanner.next();
		}
		numQScanner.next();
		}
		numQScanner.close();
		eventsRemaining = eventListSize;  
		
		Scanner eventsScanner = new Scanner(scenarioFile);
		eventsScanner.useDelimiter("/~reset-buttons");
		String scenarioInfo = eventsScanner.next();
		
		Scanner scenarioFileScanner = new Scanner(scenarioFile);
		scenarioFileScanner.useDelimiter(" |\\n");
		scenarioFileScanner.next();
		String cell = scenarioFileScanner.next();
		scenarioFileScanner.next();
		String button = scenarioFileScanner.next();
		String title = FactoryMethods.findNextSpokenString(scenarioFileScanner);
		

		eventsScanner.useDelimiter("/~reset-buttons");
		while (eventsScanner.hasNext()) {
			
			
		do  {	eventsScanner.useDelimiter("/~reset-buttons");
		String event = eventsScanner.next();
		Scanner eScanner = new Scanner(event);
		
		
		Scanner pinScanner = new Scanner(event);
		//String[] cellArray = findPins(pinScanner);
		String[]  cellArray = null;
		
		//get question
		String question = FactoryMethods.findNextSpokenString(eScanner);

		//get question audio
		String questionAudio = "";
		String nextLine = eScanner.next();
		if (nextLine.startsWith("/~sound:")) {
			 questionAudio = nextLine;
		}
		
		//get correct answer
		int correctAnswer = findCorrectAnswer(event);
		
		//correct response
		String correctResponse = FactoryMethods.findNextSpokenString(eScanner);
		
		//cr audio
		String correctResponseAudio = "";
		 nextLine = eScanner.next();
		if (nextLine.startsWith("/~sound:")) {
			 correctResponseAudio = nextLine;
		}
		
		/// wr 
		String wrongResponse = FactoryMethods.findNextSpokenString(eScanner);
		
		//wr audio
		 nextLine = eScanner.next();
		 String wrongResponseAudio="";
			if (nextLine.startsWith("/~sound:")) {
				 wrongResponseAudio = nextLine;

			}
			 index++;
			ScenarioEvent addThis = new ScenarioEvent(null, null, null, index, title, question, questionAudio, correctResponse,correctResponseAudio, wrongResponse,wrongResponseAudio, cellArray, correctAnswer);
			eScanner.close();
			eventList.add(addThis);
		}  while (eventsRemaining ==0);
			
		
		Scenario scenario = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
		
		// Build the Scenario object and pass it into ScenarioEditor as an existng scenario
		Scenario edit = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
		
		//editing 
		for (ScenarioEvent e : eventList) {
			edit.getScenarioEventList().timeline.add(e);
			e.cells = Integer.parseInt(cell);
			e.buttons = Integer.parseInt(button);
		}
		///////////

		
		/*System.out.println("DONE, scenario arguements are: " + cell +", " + button +", " + title +", " + edit.getScenarioEventList().getSize() +", " + "The eventList arguements are as follows:" ); 
		
		for(ScenarioEvent e: edit.getScenarioEventList()) {
			
			System.out.println("Question: " + e.getQuestion() + "," + e.getQuestionAudio());
			System.out.println("Event Index:" + e.index);
			//for (String s : e.getCellArray()) {
			//System.out.println(s);
			//}
			System.out.println("Correct Button: " + e.getCorrectAns() ); 
			System.out.println("Response if Answer Correct: " + e.getResponseRight() +  "," + e.getResponseRightAudio());
			System.out.println("Response if Answer Incorrect: " + e.getResponseWrong() +  "," + e.getResponseWrongAudio());
			System.out.println();
			/////////////
		}*/
			String[] args = {"0"};
			ScenarioEditor.main(args, edit);
		
			//return edit;

		} }
		catch(Exception e) {}
		//return null;
	}
	
	public static int findCorrectAnswer(String event) {
		Scanner correctAnswerScanner = new Scanner(event);
		String findCorrAns = correctAnswerScanner.next();
		String correctAnswerString;
		Integer correctAnswerInteger;
		
		
		int correctAns;
		while (!findCorrAns.startsWith("/~skip-button:")){
			findCorrAns = correctAnswerScanner.next();
		}
			correctAnswerString = findCorrAns.substring(14,15);
			correctAnswerInteger = Integer.parseInt(correctAnswerString);
			correctAns = (int) correctAnswerInteger;
			return correctAns;
	}
	
	public static String[] findPins(Scanner pinScanner) {
		
		String[] cellArray = new String[8];
		String line ="";
		String dispLine;
		String cellPinString;
		

		while (pinScanner.hasNext()) {
			
			line = pinScanner.next();
				//String nextNonSpokenString;
				
				
				//if (!line.startsWith("/~disp-cell-pins:")) {
				
				if (line.startsWith("/~disp-cell-pins:")){
					 dispLine= line;
					 String cellNumberString =dispLine.substring(17,18);
					 int CellNumber = Integer.parseInt(cellNumberString);
			
					 cellPinString= dispLine.substring(19,27);
					 
					cellArray[CellNumber] = cellPinString;
				}
				}

		pinScanner.close();
		return cellArray;
		
	}
}