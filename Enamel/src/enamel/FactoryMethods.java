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

	
}

