package enamel;

import javax.swing.JFileChooser;
import java.io.File;

public class ToyAuthoring {

    public static void main(String[] args) { 	  	
    	    ScenarioParser s = new ScenarioParser(true);
    	    
    	    JFileChooser jf = new JFileChooser();
    	    int returnValue = jf.showOpenDialog(null);

    		if (returnValue == JFileChooser.APPROVE_OPTION) {
    			File selectedFile = jf.getSelectedFile();
    			s.setScenarioFile(selectedFile.getAbsolutePath());
    		}
    	    
    }
}