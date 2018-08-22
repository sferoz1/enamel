
import enamel.*;
import java.*;
import static org.junit.Assert.*;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScenWriterTest {

	 //	static EventList tester;
	
		
		
		//Paths.get("/Enamel/hi.txt");
		 static File efile = new  File("ScenWriterTest_Expected.txt");
		 static File afile = new File("ScenWriterTest_Actual.txt");
		//public static EventList toWrite;
		//static Scenario scenWrite;
		 ScenarioEvent event, event1, event2, event3, event4;
		//file.getAbsolutePath();
		//ScenWriter we = new ScenWriter(scenWrite, efile);
		//ScenWriter wa = new ScenWriter(scenWrite, afile);
		//String s = file.toString();
		
	@Before //set values
	public void setUp() throws Exception {
		boolean fvlar = afile.exists();
		String[] cellarray = new String[2];
		 
		 cellarray[0] = "10000000";
		 cellarray[1] = "10111111";
		 
		  event= new ScenarioEvent("Q", "r", "W", 0, "MyTitle", "MyQuestion0",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		  event1= new ScenarioEvent("Q", "r", "W",1, "MyTitle", "MyQuestion1",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		  event2= new ScenarioEvent("Q", "r", "W",2, "MyTitle", "MyQuestion2",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		  event3= new ScenarioEvent("Q", "r", "W",3, "MyTitle", "MyQuestion3",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		  event4= new  ScenarioEvent("Q", "r", "W",4, "MyTitle", "MyQuestion4",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		

			EventList list = new EventList();
			list.add(event);
			list.add(event1);
			list.add(event2);
			list.add(event3);
			list.add(event4);
			Scenario scenario = new Scenario();
			scenario.scenarioEventList = list;
			scenario.Title = "Scenario Title";
			scenario.setCellNumber(2);
			scenario.setButtonNumber(4);
			//toWrite.add(event);
			//toWrite.add(event1);
			System.out.println(list.size());
			//scenWrite.scenarioEventList = list;
		//	ScenWriter.write(scenario, afile);
			//toWrite.add(event);
			//System.out.println(fvlar + "lien 64");

		boolean fvar = afile.exists();
		if (fvar == true) {
			ScenWriter.write(scenario, afile);
		}
		if (fvar ==false) {
		
		
		
		// boolean fvar = file.exists();
		 //if (fvar == false) { //if file does not exist, create it, and use scenario writer to write to it
		
		/*	 EventList tester = new EventList();
			 String[] cellarray = new String[2];
			 cellarray[0] = "01111111";
			 cellarray[1] = "10111111";
			 ScenarioEvent event= new ScenarioEvent("Q", "r", "W", 0, "MyTitle0", "MyQuestion0","Q0Audio", "Right0","R0Audio","Wrong0", "W0Audio",cellarray, 0);
			 ScenarioEvent event1= new ScenarioEvent("Q", "r", "W", 1, "MyTitle1", "MyQuestion1","Q1Audio", "Right1", "R1Audio", "Wrong1", "W1Audio", cellarray, 0);
			 tester.add(event);
			 tester.add(event1);
			 Scenario scenTest = new Scenario(2, 2, "title", tester);*/
		
				try {
					afile = new File("ScenWriterTest_Actual.txt");
		     
					     /*If file gets created then the createNewFile() 
					      * method would return true or if the file is 
					      * already present it would return false
					      */
						boolean fcr = afile.createNewFile();
							if (fcr){
								System.out.println("New file has been created successfully");
								//ScenWriter.write(scenario, afile);

								//ScenWriter.write(scenWrite, afile);
								//ScenarioFileReader.readScenarioFile(file);
								//Read = ScenarioFileReader.eventList;
		          				
							}
							else{
								afile.delete();
								System.out.println("File does not exist");
								}}
								catch(IOException e) {
									System.out.print("Exception");
								}}
		else {
			//ScenWriter.write(scenario, afile);

			//scenWrite = new Scenario(1, 4, "My Title", toWrite);

		}
		ScenWriter.write(scenario, afile);

		}
		

		
		 
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//tester.removeAll(tester);
		
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void testWrite() {
		
	
		try {
			
			FileReader e = new FileReader(efile);
			FileReader a = new FileReader(afile);
			
			BufferedReader ereader = new BufferedReader(e);
			BufferedReader areader = new BufferedReader(a);

			String eline = null;
			String aline =null;
			Logger.getGlobal().setLevel(Level.OFF);

			while ((eline=ereader.readLine())!=null && ((aline=areader.readLine())!=null) ) {
				
				Logger.getGlobal().info("Expected: " + eline + " Actual: " + aline);
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