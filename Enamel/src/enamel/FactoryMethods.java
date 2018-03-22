package enamel;

import java.util.Scanner;

public class FactoryMethods {
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
	
	
	public static String findNextNonSpokenString(Scanner scenarioFileScanner) {
		scenarioFileScanner.useDelimiter("\\n");
		 
		String nextLine = scenarioFileScanner.next();
		String nextNonSpokenLine;
	while (!nextLine.startsWith("/~")) {
		nextLine = scenarioFileScanner.next();
	}
		 nextNonSpokenLine = nextLine;
		 return nextNonSpokenLine;
		
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

