
import enamel.*;
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
//import enamel.ScenFileReader;
import enamel.ScenWriter;
import enamel.Scenario;
import enamel.ScenarioEvent;
import enamel.ScenarioFileReader;

public class ScenarioFileReaderTest {

	static File file = new File("testFile.txt");
	static EventList Read; //somewhere to store the read events

	@BeforeClass //assigning values;
	public static void setUpBeforeClass() throws Exception {
		
	
		 boolean fvar = file.exists();
		 if (fvar == false) { //if file does not exist, create it, and use scenario writer to write to it
		
			 EventList tester = new EventList();
			 String[] cellarray = new String[2];
			 cellarray[0] = "01111111";
			 cellarray[1] = "10111111";
			 ScenarioEvent event= new ScenarioEvent("Q", "r", "W", 0, "MyTitle0", "MyQuestion0","Q0Audio", "Right0","R0Audio","Wrong0", "W0Audio",cellarray, 0);
			 ScenarioEvent event1= new ScenarioEvent("Q", "r", "W", 1, "MyTitle1", "MyQuestion1","Q1Audio", "Right1", "R1Audio", "Wrong1", "W1Audio", cellarray, 0);
			 tester.add(event);
			 tester.add(event1);
			 Scenario scenTest = new Scenario(2, 2, "title", tester);
		
				try {
					file = new File("testFile.txt");
		     
					     /*If file gets created then the createNewFile() 
					      * method would return true or if the file is 
					      * already present it would return false
					      */
						boolean fcr = file.createNewFile();
							if (fcr){
								System.out.println("New file has been created successfully");
		 
								ScenWriter.write(scenTest, file);
								//ScenarioFileReader.readScenarioFile(file);
								//Read = ScenarioFileReader.eventList;
		          				
							}
							else{
								file.delete();
								System.out.println("File does not exist");
								}}
								catch(IOException e) {
									System.out.print("Exception");
								}}
		}
	@Before
	public void setUp() throws Exception {
	    //check that file exists before running every test
		
		 boolean fex = file.exists();
	     if (fex){
	          System.out.println("File exists or was created sucessfuly if running test for first time");
	 
	          	ScenarioFileReader.readScenarioFile(file);
	          	Read = ScenarioFileReader.eventList;

	    }
	     else{
	    	 file.delete();
	          System.out.println("File does not exist");
	     } 
	}
		
	@After
	public void tearDown() {
		Read.removeAll(Read);
	}
	@Test
	public void fileExists() {
	     boolean fvar = file.exists();
	     assertTrue(fvar);
	}
	@Test
	public void testQuestions() {
		assertEquals("MyQuestion0", Read.get(0).getQuestion());
		
	}
	@Test
	public void testAudioFilePaths() {
		assertEquals("Q0Audio", Read.get(0).getQuestionAudio());
		assertEquals("R0Audio", Read.get(0).getResponseRightAudio());
		assertEquals("W0Audio", Read.get(0).getResponseWrongAudio());
	}
	@Test
	public void testResponseRight() {
		assertEquals("Right0", Read.get(0).getResponseRight());
		
	}
	
	@Test
	public void testResponseWrong() {
		assertEquals("Wrong0", Read.get(0).getResponseWrong());

		
	}
	
	@Test
	public void testCorrectAnswer() {
		assertEquals(0, Read.get(0).getCorrectAns());

		
	}
	
	@Test
	public void testPins() {
		assertEquals("01111111", Read.get(0).getCellArray()[0]);
		assertEquals("11101111", Read.get(0).getCellArray()[1]);
		assertEquals(null, Read.get(0).getCellArray()[2]);
		assertEquals(null, Read.get(0).getCellArray()[3]);
		assertEquals(null, Read.get(0).getCellArray()[4]);
		assertEquals(null, Read.get(0).getCellArray()[5]);
		assertEquals(null, Read.get(0).getCellArray()[6]);
		assertEquals(null, Read.get(0).getCellArray()[7]);
	}
	
	@Test
	public void testIndex() {
		assertEquals(0, Read.get(0).getIndex());

	}
	
	@Test
	public void testSize() {
		assertEquals(2, Read.size()); 

	}

	@Test
	public void testread() {
		//ScenarioFileReader.readScenarioFile(file);

		 //File file = new File("testFile.txt");
			//ScenFileReader.readScenarioFile(file.getName());
			//EventList ReadEvents = test.getScenarioEventList();
			
			//int cell = Read.getCellNumber();
			//int button = Read.buttons;
			//String title = Read.getTitle(); 
			//assertEquals(title, "title");
			//assertEquals(button, 2);
			//assertEquals(cell, 2);
		
			assertEquals(2, Read.size()); 
			assertEquals(0, Read.get(0).getIndex());
			assertEquals("01111111", Read.get(0).getCellArray()[0]);
			assertEquals("11101111", Read.get(0).getCellArray()[1]);
			assertEquals(null, Read.get(0).getCellArray()[2]);
			assertEquals(null, Read.get(0).getCellArray()[3]);
			assertEquals(null, Read.get(0).getCellArray()[4]);
			assertEquals(null, Read.get(0).getCellArray()[5]);
			assertEquals(null, Read.get(0).getCellArray()[6]);
			assertEquals(null, Read.get(0).getCellArray()[7]);
			assertEquals("MyQuestion0", Read.get(0).getQuestion());
			assertEquals(0, Read.get(0).getCorrectAns());
			assertEquals("Right0", Read.get(0).getResponseRight());
			assertEquals("Wrong0", Read.get(0).getResponseWrong());
			assertEquals("Q0Audio", Read.get(0).getQuestionAudio());
			assertEquals("R0Audio", Read.get(0).getResponseRightAudio());
			assertEquals("W0Audio", Read.get(0).getResponseWrongAudio());
			
			
			assertEquals(Read.get(1).getIndex(), 1);
			assertEquals(Read.get(1).getCellArray()[0], "01111111");
			assertEquals(Read.get(1).getCellArray()[1], "11101111");
			assertEquals(Read.get(1).getCellArray()[2], null);
			assertEquals(Read.get(1).getCellArray()[3], null);
			assertEquals(Read.get(1).getCellArray()[4], null);
			assertEquals(Read.get(1).getCellArray()[5], null);
			assertEquals(Read.get(1).getCellArray()[6], null);
			assertEquals(Read.get(1).getCellArray()[7], null);
			assertEquals(Read.get(1).getQuestion(), "MyQuestion1");
			assertEquals(Read.get(1).getCorrectAns(), 0);
			assertEquals(Read.get(1).getResponseRight(),"Right1");
			assertEquals(Read.get(1).getResponseWrong(), "Wrong1");
			assertEquals("Q1Audio", Read.get(1).getQuestionAudio());
			assertEquals("R1Audio", Read.get(1).getResponseRightAudio());
			assertEquals("W1Audio", Read.get(1).getResponseWrongAudio());
			
			Logger.getGlobal().setLevel(Level.OFF);
			
			Logger.getGlobal().info("DONE" +  Read.size() + "The eventList arguements are as follows:" );

			for(ScenarioEvent e: Read) {
				
				Logger.getGlobal().info("Question: " + e.getQuestion());
				Logger.getGlobal().info("Event Index:" + e.index);
				for (String s : e.getCellArray()) {
				Logger.getGlobal().info(s);
				}
			
				Logger.getGlobal().info("Correct Button: " + e.getCorrectAns()); 
				Logger.getGlobal().info("Response if Answer Correct: " + e.getResponseRight());
				Logger.getGlobal().info("Response if Answer Incorrect: " + e.getResponseWrong());
			}
			}


	
	

}
