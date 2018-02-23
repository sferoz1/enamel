package enamel;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TEST {
	 public static void main(String[] args) {
		 // try {
		  EventList tester = new EventList();
			 String[] cellarray = new String[2];
			 cellarray[0] = "1";
				cellarray[1] ="0";
			ScenarioEvent event= new ScenarioEvent(0, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
			ScenarioEvent event1= new ScenarioEvent(1, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
			ScenarioEvent event2= new ScenarioEvent(2, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
			ScenarioEvent event3= new ScenarioEvent(3, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
			ScenarioEvent event4= new  ScenarioEvent(4, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
			
			tester.add(0, event);
			tester.add(1, event1);
			tester.add(2, event2);
			tester.add(3, event3);
			tester.add(4, event4);
			File file = new  File("ScenWriterTestOutput.txt");
			//FileWriter writer = new FileWriter("hi.txt");
			
			Scenario scen = new Scenario(1, 4, "My Title", tester);
			
			
			//ScenWriter w = new ScenWriter(scen, file);
			ScenWriter.write(scen, file);
			
			//ScenWriter.write(scen, file);
			
			System.out.println(file.getAbsolutePath());
			System.out.println();
		  //} catch(IOException ex) {
			//  ex.printStackTrace();
		  //}
			/*System
			String pathname = "/Users/saraattalla/git/enamel/Enamel/hi.txt";
			Path p4 = FileSystems.getDefault().getPath(pathname);
			ScenarioWriter TEST = new ScenarioWriter(scenWrite, p4.toString());
			ScenWriter.write(scenWrite);*/}
}