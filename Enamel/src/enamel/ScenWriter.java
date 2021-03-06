package enamel;
import java.io.*;
public class ScenWriter {
	
	public  Scenario scenarioToFile;
	public String fileContent = "content";
	public  File pathName;
	
	public ScenWriter(Scenario scenario, File p){ 
		scenarioToFile = scenario;
		pathName = p;

	}
	
	public static void  write(Scenario scenarioToFile, File pathName){
		try {
			pathName.getName();
			BufferedWriter writer = new BufferedWriter(new FileWriter(pathName));
			//WRITING STUFF;
			writer.write("Cell " + Integer.toString(scenarioToFile.cellNumber));
			writer.newLine();
			writer.write("Button "+ Integer.toString(scenarioToFile.buttonNumber));
			writer.newLine();
			//writer.write("/~disp-clearAll");
			//writer.newLine();
			writer.write(scenarioToFile.Title);
			writer.newLine();
			
			// writing for events
			//for(ScenarioEvent i : scenarioToFile.scenarioEventList) {
				
			//}
			
			//writing for pins
		  	  for(int i = 0; i < scenarioToFile.scenarioEventList.size(); i++){ 
		  		  
		  		ScenarioEvent myEvent = scenarioToFile.getScenarioEventList().get(i);
		  		
		  		writer.write("/~reset-buttons");
		  		writer.newLine();
		  		writer.write("/~disp-clearAll");
		  		writer.newLine();
		  		  //get pins
		  		 int k = 0;
		  		  for (String pins: myEvent.getCellArray()){
		  			pins = FactoryMethods.rearrangePinString(pins);
		  			if (!pins.equals(null) && k< scenarioToFile.cellNumber){
		  			writer.write( "/~disp-cell-pins:" +k+ " " + pins);
		  			k++;
		  			writer.newLine();
		  			}
		  			//else if (pins.equals(null)){
		  			//k++;
		  			//}
		  		  }
		  	
		  		writer.write(myEvent.getQuestion());
		  		//writer.write(myEvent.);
		  		writer.newLine(); 
		  		if (myEvent.getQuestionAudio() !=null) {
		  		writer.write("/~sound:" + myEvent.getQuestionAudio());
		  		}
		  		writer.newLine();
		  		writer.write("/~pause:1");
		  		writer.newLine();
		  		writer.write("/~skip-button:" + myEvent.getCorrectAns() + " CORRECT");
		  		writer.newLine();
		  				  		
		  		 for (int j =0; j< scenarioToFile.buttonNumber; j++){
			  			  if (j != myEvent.getCorrectAns()){
			  				writer.write("/~skip-button:"+Integer.toString(j) + " INCORRECT");
			  				writer.newLine();
			  			  }
			  	}
		  		writer.write("/~user-input");
		  		writer.newLine();
		  		writer.write("/~CORRECT"); 
			  	writer.newLine();
			  	writer.write("/~sound:correct.wav");
				writer.newLine();
		  		writer.write("/~pause:1");
		  		writer.newLine();
			  	writer.write(myEvent.getResponseRight()); 
			  	writer.newLine();
			  	if (myEvent.getResponseRightAudio() !=null) {
			  	writer.write("/~sound:" + myEvent.getResponseRightAudio());
				writer.newLine();
		  		writer.write("/~pause:1");
			  	}
			  	writer.newLine();
			  	writer.write("/~skip:NEXTT"); 
			  	writer.newLine();
		  		writer.write( "/~INCORRECT");
		  		writer.newLine(); 
		  		writer.write("/~sound:wrong.wav");
		  		writer.newLine();
		  		writer.write("/~pause:1"); 
		  		writer.newLine();
		  		writer.write(myEvent.getResponseWrong()); 
		  		writer.newLine();
		  		if (myEvent.getResponseWrongAudio() !=null) {
		  		writer.write("/~sound:" + myEvent.getResponseWrongAudio());
		  		writer.newLine();
		  		writer.write("/~pause:1");
		  		}
		  		writer.newLine();
		  		writer.write("/~skip:NEXTT"); 
		  		writer.newLine();
		  		writer.write( "/~NEXTT");
		  		//writer.newLine();
		  		//writer.write("/~reset-buttons "); 
		  		writer.newLine();
		  		writer.write("/~disp-clearAll");
		  		writer.newLine();
		  	  }

			writer.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	
}
	//public static void main (String[] args) {
		//write(scenarioToFile, pathName );
	//}
}
