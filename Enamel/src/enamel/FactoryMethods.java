package enamel;

import java.util.Scanner;

public class FactoryMethods {
	public static String findNextSpokenString(Scanner scenarioFileScanner) {
		scenarioFileScanner.useDelimiter("\\n");
		String nextSpokenLine= "";
		String nextLine = "/~";
		 while (scenarioFileScanner.hasNext() && nextLine.startsWith("/~")){
		 nextLine = scenarioFileScanner.next();
		
	
		}
	
		 nextSpokenLine = nextLine;
		 
		 return nextSpokenLine;
		
	}
	
	public static String findNextSoundFile(Scanner scenarioFileScanner) {
		scenarioFileScanner.useDelimiter("\\n");
		String nextSoundFile= "";
		String nextLine = "/~";
		 while (scenarioFileScanner.hasNext() && !nextLine.startsWith("/~sound:")){
		 nextLine = scenarioFileScanner.next();
		}
	
		 nextSoundFile = nextLine;
		 
		 return nextSoundFile;
		
		/*scenarioFileScanner.useDelimiter("\\n");
		
		 
		String nextLine = scenarioFileScanner.next();
		String nextSoundFile;
	while (nextLine.startsWith("/~sound:") && !nextLine.startsWith("/~sound:correct.wav") && !nextLine.startsWith("/~sound:wrong.wav")) {
		
		nextLine = scenarioFileScanner.next();
	
	}
		 nextSoundFile = nextLine;
		 return nextSoundFile;*/
		 
		
	}
	
	
	
	public static String findNextNonSpokenString(Scanner scenarioFileScanner) {
		scenarioFileScanner.useDelimiter("\\n");
		String nextNonSpokenString= "";
		String nextLine = "";
		 while (scenarioFileScanner.hasNext() && (!nextLine.startsWith("/~")|| nextLine.startsWith("/~sound:"))   ){
		 nextLine = scenarioFileScanner.next();
		}
	
		 nextNonSpokenString= nextLine;
		 
		 return nextNonSpokenString;
		
		/*scenarioFileScanner.useDelimiter("\\n");
		 
		String nextLine = scenarioFileScanner.next();
		String nextNonSpokenLine;
	while (!nextLine.startsWith("/~")) {
		nextLine = scenarioFileScanner.next();
	}
		 nextNonSpokenLine = nextLine;
		 return nextNonSpokenLine;*/
		
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

