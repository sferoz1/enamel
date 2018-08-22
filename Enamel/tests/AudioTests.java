import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enamel.EventList;
import enamel.RecordingsAudioPlayer;
import enamel.ScenWriter;
import enamel.Scenario;
import enamel.ScenarioEvent;

public class AudioTests {
	static RecordingsAudioPlayer testPlayer = new RecordingsAudioPlayer();
	static File wrongFormat = new File("incorrectFormat.txt");
	
	
	
	@Before //makes sure that file exists, if no file exists (for example running tests for first time on a different computer) it creates one
	public void setUp() throws Exception {
		if (!wrongFormat.exists()) {
			try {
				wrongFormat = new File("incorrectFormat.txt");
	     
				     /*If file gets created then the createNewFile() 
				      * method would return true or if the file is 
				      * already present it would return false
				      */
				boolean fcr = wrongFormat.createNewFile();
						if (fcr){
							wrongFormat.canWrite();
							BufferedWriter writer = new BufferedWriter(new FileWriter(wrongFormat.getPath()));
							writer.write("Not an audio file");
							writer.close();
							System.out.println("New file has been created successfully");
	 
	          				
						}
						else{
							wrongFormat.delete();
							System.out.println("File does not exist");
							}}
							catch(IOException e) {
								System.out.print("Exception");
							}}
		
		  	
		
			}
	
	
	
	
	//tests that play method throws  proper exceptions
	@Test (expected = UnsupportedAudioFileException.class )
	public void playerTestException() throws UnsupportedAudioFileException, IOException, LineUnavailableException {			

		testPlayer.play(wrongFormat.getAbsolutePath());
			
		//testPlayer.play(wrongFormat.getPath());
		
		/*if (wrongFormat.exists()) {
			testPlayer.play(wrongFormat.getPath());
		}
		
		if (!wrongFormat.exists()) {
			
			
			try {
				//wrongFormat = new File("wrongFormat.txt");
				
	     
				     /*If file gets created then the createNewFile() 
				      * method would return true or if the file is 
				      * already present it would return false
				      */
				/*	boolean fcr = wrongFormat.createNewFile();
						if (fcr){
							System.out.println("New file has been created successfully");
							
								testPlayer.play(wrongFormat.getName());
							
				
	          				
						}
						else{
							wrongFormat.delete();
							System.out.println("File does not exist");
							}}
							catch(IOException e) {
								System.out.print("Exception");
							}}*/
		
	
		
		
	/*	if (fv==true){
		try {
			testPlayer.play(wrongFormat.getName());
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}*/

		}
	@Test //tests that recording is properly stopped 
	public void testStop(){
		testPlayer.stop();
		assertEquals(true, testPlayer.isStopped());
		
	}
	
	
}
	
