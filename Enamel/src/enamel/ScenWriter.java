package enamel;
import java.io.*;
public class ScenWriter {
	
	public static Scenario scenarioToFile;
	public String fileContent = "content";
	public static File pathName;
	
	public ScenWriter(Scenario scenario, File p){ 
		scenarioToFile = scenario;
		pathName = p;
		
		
	
	}
	
	public static void  write(Scenario scenarioToFile, File pathName){
		try {
			pathName.getName();
			BufferedWriter writer = new BufferedWriter(new FileWriter(pathName));

			//WRITING STUFF;
			writer.write("Cell " + Integer.toString(scenarioToFile.cellNumber) +  '\n' + "Button "+ Integer.toString(scenarioToFile.buttonNumber) + '\n');
			writer.write("/~disp-clearAll" + '\n');
			writer.write(scenarioToFile.Title + '\n');
			
			
			
			// file content for events
		  	  for(int i = 0; i < scenarioToFile.scenarioEventList.getSize(); i++){
		  		  
		  		  ScenarioEvent myEvent = scenarioToFile.scenarioEventList.getTimeline().get(i);
		  		  
		  		  //get pins
		  		  int k = 0;
		  		  for (String pins: myEvent.getCellArray()){
		  			if (!pins.equals(null)){
		  			writer.write( "/~disp-cell-pins: " + k + " " + pins + "\n"); 
		  			}
		  			k++;
		  			break;
		  		  }
		  		
		  		 
		  		writer.write( myEvent.getQuestion() + '\n' + "/~pause:3" + '\n' + "/~skip-button:"+myEvent.getCorrectAns() + " CORRECT" + '\n');
		  				  

		  		
		  		 for (int j =0; j<= scenarioToFile.buttonNumber; j++){
			  			  if (j != myEvent.getCorrectAns()){
			  				writer.write("/~skip-button:"+Integer.toString(j) + " INCORRECT" + '\n');
			  			  }
			  			writer.write("/~user-input"+ '\n');
			  			  }
		  		writer.write("/~CORRECT" + '\n' + "/~sound:correct.wav" + '\n' + myEvent.getResponseRight()+ '\n' + "/~skip:NEXTT" + '\n');
		  		writer.write( "/~INCORRECT" + '\n' + "/~sound:wrong.wav" + '\n' + myEvent.getResponseWrong()+ '\n' + "/~skip:NEXTT" + '\n');
		  		writer.write( "/~NEXTT" + '\n' +  "/~reset-buttons "+ '\n'+ "/~disp-clearAll" + '\n');
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
