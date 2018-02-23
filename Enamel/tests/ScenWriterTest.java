
import enamel.*;
import java.*;
import static org.junit.Assert.*;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScenWriterTest {

	  EventList tester = new EventList();
		 String[] cellarray = new String[2];
		 
		 
		ScenarioEvent event= new ScenarioEvent(0, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
		ScenarioEvent event1= new ScenarioEvent(1, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
		ScenarioEvent event2= new ScenarioEvent(2, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
		ScenarioEvent event3= new ScenarioEvent(3, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
		ScenarioEvent event4= new  ScenarioEvent(4, "MyTitle", "MyQuestion", "Right", "Wrong",cellarray, 0);
		
		
		
		Scenario scenWrite = new Scenario(3, 4, "My Title", tester);
		//Paths.get("/Enamel/hi.txt");
		File file = new  File("hi.txt");
		//file.getAbsolutePath();
		ScenWriter w = new ScenWriter(scenWrite, file);
		
		//String s = file.toString();
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		;
		 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cellarray[0] = "100";
		 cellarray[1] = "100";
		 
		tester.add(0, event);
		tester.add(1, event1);
		tester.add(2, event2);
		tester.add(2, event3);
		tester.add(4, event4);
	
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void testWrite() {
		w.write(scenWrite, file);
		
		Assert.Equals()
		
	}

}