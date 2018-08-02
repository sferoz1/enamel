
import enamel.*;
import java.*;
import static org.junit.Assert.*;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScenWriterTest {

	  EventList tester = new EventList();
		 String[] cellarray = new String[2];
		 
		 
		ScenarioEvent event= new ScenarioEvent("Q", "r", "W", 0, "MyTitle", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		ScenarioEvent event1= new ScenarioEvent("Q", "r", "W",1, "MyTitle", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		ScenarioEvent event2= new ScenarioEvent("Q", "r", "W",2, "MyTitle", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		ScenarioEvent event3= new ScenarioEvent("Q", "r", "W",3, "MyTitle", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		ScenarioEvent event4= new  ScenarioEvent("Q", "r", "W",4, "MyTitle", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		
		
		
		Scenario scenWrite = new Scenario(1, 4, "My Title", tester);
		//Paths.get("/Enamel/hi.txt");
		File efile = new  File("ExpectedScenWriterTest.txt");
		File afile = new File("ScenWriterTestActual.txt");
		//file.getAbsolutePath();
		//ScenWriter we = new ScenWriter(scenWrite, efile);
		//ScenWriter wa = new ScenWriter(scenWrite, afile);
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
		ScenWriter.write(scenWrite, afile);
		System.out.println(afile.getAbsolutePath());
		System.out.println(efile.getAbsolutePath());
		
		try {
			
			FileReader e = new FileReader(efile);
			FileReader a = new FileReader(afile);
			
			BufferedReader ereader = new BufferedReader(e);
			BufferedReader areader = new BufferedReader(a);

			String eline = null;
			String aline =null;
			while ((eline=ereader.readLine())!=null && ((aline=areader.readLine())!=null) ) {
				Assert.assertEquals(eline, aline);
				
			}
			ereader.close();
			areader.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
}