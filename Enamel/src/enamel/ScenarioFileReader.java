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
			
			scenarioFileScanner.useDelimiter("\\n");
			 if (scenarioFileScanner.hasNext("/~disp-cell-pins:*")){ //*num1 has to be a valid braille cell index
				 
				 dispLine= scenarioFileScanner.next();
				 
				 String pinNumber =dispLine.substring(20);
				 charCellArray = dispLine.toCharArray();
				 int i =0;
				 for (char c : charCellArray) {
					 cellArray[i] = String.valueOf(c);
					 i++;
					 }
				 
				String findQuestion = scenarioFileScanner.next();
				String Question;
			while (findQuestion.startsWith("/~")) {
				findQuestion = scenarioFileScanner.next();
			}
				 Question = findQuestion;
			
			// find correct answer
			String findCorrAns = scenarioFileScanner.next();
			String correctAnswerString;
			Integer correctAnswerInteger;
			int correctAns;
			while (!findCorrAns.startsWith("/~skip-button")){
				findCorrAns = scenarioFileScanner.next();
			}
				correctAnswerString = findCorrAns.substring(14,15);
				correctAnswerInteger = Integer.parseInt(correctAnswerString);
				correctAns = (int) correctAnswerInteger;
	
			
			//find responseRight and responseWrong
			String findResponseRight= scenarioFileScanner.next();
			String responseRight;
			while (findResponseRight.startsWith("/~")){
				findResponseRight = scenarioFileScanner.next();
			}
			responseRight=findResponseRight;
			
			String findResponseWrong =scenarioFileScanner.next();
			String responseWrong;
			while (findResponseWrong.startsWith("/~")) {
				findResponseWrong = scenarioFileScanner.next();
			}
			responseWrong = findResponseWrong;
			
							
				index +=1;
				
				 ScenarioEvent readEvent = new ScenarioEvent(index, title, Question, responseRight,responseWrong, cellArray, correctAns);
					eventList.add(index, readEvent);

				
				
			}		
				Scenario scenario = new Scenario(Integer.parseInt(cell), Integer.parseInt(button), title, eventList);
			
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
