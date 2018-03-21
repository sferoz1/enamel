

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enamel.EventList;
import enamel.ScenWriter;
import enamel.Scenario;
import enamel.ScenarioEvent;
import enamel.ScenarioFileReader;

public class ScenarioFileReaderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
/*EventList tester = new EventList();
		  String[] cellarray = new String[2];
		  	cellarray[0] = "10101010";
		  	cellarray[1] = "01010101";
		 ScenarioEvent event= new ScenarioEvent(0, "MyTitle0", "MyQuestion0", "Right0", "Wrong0",cellarray, 0);
		ScenarioEvent event1= new ScenarioEvent(1, "MyTitle1", "MyQuestion1", "Right1", "Wrong1",cellarray, 0);
	tester.add(event);
	tester.add(event1);
			Scenario scenTest = new Scenario(2, 2, "title", tester);
		// try {*/
			 
		     File file = new File("testFile.txt");
		     
		     /*If file gets created then the createNewFile() 
		      * method would return true or if the file is 
		      * already present it would return false
		      */
	        // boolean fvar = file.exists();
		     //if (fvar){
		       //   System.out.println("File has been created successfully");
		 // ScenWriter.write(scenTest, file);
		ScenarioFileReader.readScenarioFile(file.getName());
		//int cell = toRead.getCellNumber();
		//int button = toRead.getButtonNumber();
		//String title = toRead.getTitle();
		
		
		    // }
		     //else{
		    	// file.delete();
		          //System.out.println("File does not exist");
		    // }
	    	//} catch (IOException e) {
	    	//	System.out.println("Exception Occurred:");
		      //  e.printStackTrace();
		  }
		 
	 
		
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
		
	}

	@Before
	public void setUp() throws Exception {
	     File file = new File("testFile.txt");
	 	ScenarioFileReader.readScenarioFile(file.getName());
		//int cell = toRead.getCellNumber();
		//int button = toRead.getButtonNumber();
		//String title = toRead.getTitle();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCellAndButtons() {
		  File file = new File("testFile.txt");
		 	//Scenario toRead= ScenarioFileReader.readScenarioFile(file.getName());
			//int cell = toRead.getCellNumber();
			//int button = toRead.getButtonNumber();
			//String title = toRead.getTitle();
		//ScenarioFileReader.readScenarioFile(file);
		
		/*assertEquals(title, "title");
		assertEquals(button, 2);
		assertEquals(cell, 2);*/
	}
	@Test
	public void testQuestions() {
		
	}

}
