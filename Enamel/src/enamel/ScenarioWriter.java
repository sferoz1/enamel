package enamel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ScenarioWriter {
	private static Scenario scenarioToFile = null;
	private static String fileContent;
	protected static String pathName;
	
	public ScenarioWriter(Scenario scenario, String pathName){
		
		scenarioToFile = scenario;

	//file content INTRO + set up
  	  fileContent = "Cell Number: " + Integer.toString(scenarioToFile.cellNumber) +  '\n' + Integer.toString(scenarioToFile.buttonNumber) + '\n';
  	  fileContent += "/~disp-clearAll";
  	  fileContent += scenarioToFile.Title + '\n';
  	 // fileContent +=   "/~disp-cell-pins:" + "NEED TO SET NUM1 AND PINS" + '\n';
  	  //this.fileContent += "These are pins" + PIN NUMBERS;
  
  	  // file content events
  	  for(int i = 0; i < scenarioToFile.scenarioEventList.timeline.size(); i++){
  		  
  		  ScenarioEvent myEvent = scenarioToFile.scenarioEventList.timeline.get(i);
  		
  		 
  		   fileContent += fileContent + myEvent.getQuestion() + '\n' + "/~pause:3" + '\n' + "/~skip-button:"+myEvent.getCorrectAns() + " CORRECT" + '\n';
  				  

  		
  		 for (int j =0; j<= scenarioToFile.buttonNumber; j++){
	  			  if (j != myEvent.getCorrectAns()){
	  				fileContent += fileContent + "/~skip-button:"+Integer.toString(j) + "INCORRECT" + '\n';
	  			  }
	  			fileContent += fileContent +"/~user-input"+ '\n';
	  			  }
  			fileContent += fileContent + "/~CORRECT" + '\n' + "/~sound:correct.wav" + '\n' + myEvent.getResponseRight()+ '\n' + "/~skip:NEXTT" + '\n';
  			fileContent += fileContent + "/~INCORRECT" + '\n' + "/~sound:wrong.wav" + '\n' + myEvent.getResponseWrong()+ '\n' + "/~skip:NEXTT" + '\n';
  			fileContent += fileContent + "/~NEXTT" +  "/~reset-buttons "+ '\n'+ "/~disp-clearAll" + '\n';
  		   
  	  }
				
	}
	
	
		
	  public static void main(String[] args) {
	      BufferedWriter bw = null;
	      try {
	    
	         //Specify the file name and path here
		 File file = new File(pathName); //
		 //String fileAbsolutePath = file.getAbsolutePath();
		 /* This logic will make sure that the file 
		  * gets created if it is not present at the
		  * specified location*/
		  if (!file.exists()) {
		     file.createNewFile();
		  }

		  FileWriter fw = new FileWriter(file);
		  bw = new BufferedWriter(fw);
		  bw.write(fileContent);
		 // SucessfulScenFileCreation successWindow = new SucessfulScenFileCreation(scenarioToFile);
		  //successWindow.main(args);
	       System.out.println("File written Successfully");

	      } catch (IOException ioe) {
		   ioe.printStackTrace();
		}
		finally
		{ 
		   try{
		      if(bw!=null)
			 bw.close();
		   }catch(Exception ex){
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}
	   }
	}