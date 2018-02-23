import java.io.File;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.*;

import enamel.*;
public class TEST {
	  public static void main(String[] args) {
		  
		  EventList tester = new EventList();
			 String[] cellarray = new String[2];
			 cellarray[0] = "100";
			 cellarray[1] = "100";
			ScenarioEvent event= new ScenarioEvent(0, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
			ScenarioEvent event1= new ScenarioEvent(1, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
			ScenarioEvent event2= new ScenarioEvent(2, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
			ScenarioEvent event3= new ScenarioEvent(3, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
			ScenarioEvent event4= new  ScenarioEvent(4, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
			
			tester.add(0, event);
			tester.add(1, event1);
			tester.add(2, event2);
			tester.add(2, event3);
			tester.add(4, event4);
			
			Scenario scenWrite = new Scenario(3, 4, "My Title", tester);
			//Paths.get("/Enamel/hi.txt");
			File file = new  File("hi.txt");
			file.getAbsolutePath();
			ScenWriter w = new ScenWriter(scenWrite, file);
			w.write(scenWrite, file);
			
			String s = file.toString();
			
			System.out.print(s);
			/*String pathname = "/Users/saraattalla/git/enamel/Enamel/hi.txt";
			Path p4 = FileSystems.getDefault().getPath(pathname);
			ScenarioWriter TEST = new ScenarioWriter(scenWrite, p4.toString());
			ScenWriter.write(scenWrite);*/

}
}