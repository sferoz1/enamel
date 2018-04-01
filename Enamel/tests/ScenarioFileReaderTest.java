

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
		
EventList tester = new EventList();
		  String[] cellarray = new String[2];
		  	cellarray[0] = "01111111";
		  	cellarray[1] = "10111111";
		  	//cellarray[2] = "11111111";
		 ScenarioEvent event= new ScenarioEvent(0, "MyTitle0", "MyQuestion0","Q0Audio", "Right0","R0Audio","Wrong0", "W0 Audio",cellarray, 0);
		ScenarioEvent event1= new ScenarioEvent(1, "MyTitle1", "MyQuestion1","Q1Audio", "Right1", "R1Audio", "Wrong1", "W1Audio", cellarray, 0);
	tester.add(event);
	tester.add(event1);
			Scenario scenTest = new Scenario(2, 2, "title", tester);
		// try {*/
			 
		   //  File file = new File("testFile.txt");
		     
		     /*If file gets created then the createNewFile() 
		      * method would return true or if the file is 
		      * already present it would return false
		      */
	        // boolean fvar = file.exists();
		     //if (fvar){/*
		       //   System.out.println("File has been created successfully");
		 
		//ScenWriter.write(scenTest, file);
		//Scenario test = ScenarioFileReader.readScenarioFile(file.getName());
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
	    // File file = new File("testFile.txt");
	 	//ScenarioFileReader.readScenarioFile(file.getName());
		//int cell = toRead.getCellNumber();
		//int button = toRead.getButtonNumber();
		//String title = toRead.getTitle();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Test
	/*public void testCellAndButtons() {
		 // File file = new File("testFile.txt");
			//Scenario Read = ScenarioFileReader.readScenarioFile(file.getName());
			//EventList ReadEvents = Read.scenarioEventList;
		 	//Scenario toRead= ScenarioFileReader.readScenarioFile(file.getName());
		  File file = new File("testFile.txt");
			Scenario Read = ScenarioFileReader.readScenarioFile(file.getName());
			EventList ReadEvents = Read.scenarioEventList;
	
			int cell = Read.getCellNumber();
			int button = Read.getButtonNumber();
			String title = Read.getTitle();
			assertEquals(title, "title");
			assertEquals(button, 2);
			assertEquals(cell, 2);
			System.out.println("DONE, scenario arguements are: " + cell +", " + button +", " + title +", " + ReadEvents.size() + "The eventList arguements are as follows:" );

		
	}*/
	@Test
	public void testreadScenarioFile() {
		//ScenarioFileReader.readScenarioFile(file);

		 /* File file = new File("testFile.txt");
			ScenarioFileReader.readScenarioFile(file.getName());
			EventList ReadEvents = Read.getScenarioEventList();
			
			int cell = Read.getCellNumber();
			int button = Read.getButtonNumber();
			String title = Read.getTitle(); 
			assertEquals(title, "title");
			assertEquals(button, 2);
			assertEquals(cell, 2);
			assertEquals(ReadEvents.size(), 2); //use .size() not .getSize()
			assertEquals(ReadEvents.get(0).getIndex(), 0);
			assertEquals(ReadEvents.get(0).getCellArray()[0], "01111111");
			assertEquals(ReadEvents.get(0).getCellArray()[1], "11101111");
			assertEquals(ReadEvents.get(0).getCellArray()[2], null);
			assertEquals(ReadEvents.get(0).getCellArray()[3], null);
			assertEquals(ReadEvents.get(0).getCellArray()[4], null);
			assertEquals(ReadEvents.get(0).getCellArray()[5], null);
			assertEquals(ReadEvents.get(0).getCellArray()[6], null);
			assertEquals(ReadEvents.get(0).getCellArray()[7], null);
			assertEquals(ReadEvents.get(0).getQuestion(), "MyQuestion0");
			assertEquals(ReadEvents.get(0).getCorrectAns(), 0);
			assertEquals(ReadEvents.get(0).getResponseRight(),"Right0");
			assertEquals(ReadEvents.get(0).getResponseWrong(), "Wrong0");
			
			assertEquals(ReadEvents.get(1).getIndex(), 1);
			assertEquals(ReadEvents.get(1).getCellArray()[0], "01111111");
			assertEquals(ReadEvents.get(1).getCellArray()[1], "11101111");
			assertEquals(ReadEvents.get(1).getCellArray()[2], null);
			assertEquals(ReadEvents.get(1).getCellArray()[3], null);
			assertEquals(ReadEvents.get(1).getCellArray()[4], null);
			assertEquals(ReadEvents.get(1).getCellArray()[5], null);
			assertEquals(ReadEvents.get(1).getCellArray()[6], null);
			assertEquals(ReadEvents.get(1).getCellArray()[7], null);
			assertEquals(ReadEvents.get(1).getQuestion(), "MyQuestion1");
			assertEquals(ReadEvents.get(1).getCorrectAns(), 0);
			assertEquals(ReadEvents.get(1).getResponseRight(),"Right1");
			assertEquals(ReadEvents.get(1).getResponseWrong(), "Wrong1");
			
			Logger.getGlobal().setLevel(Level.OFF);
			
			Logger.getGlobal().info("DONE, scenario arguements are: " + cell +", " + button +", " + title +", " + ReadEvents.size() + "The eventList arguements are as follows:" );

			for(ScenarioEvent e: ReadEvents) {
				
				Logger.getGlobal().info("Question: " + e.getQuestion());
				Logger.getGlobal().info("Event Index:" + e.index);
				for (String s : e.getCellArray()) {
				Logger.getGlobal().info(s);
				}
			
				Logger.getGlobal().info("Correct Button: " + e.getCorrectAns()); 
				Logger.getGlobal().info("Response if Answer Correct: " + e.getResponseRight());
				Logger.getGlobal().info("Response if Answer Incorrect: " + e.getResponseWrong());
			}*/
			}

	
	@Test
	public void testQuestions() {
		
	}

}
