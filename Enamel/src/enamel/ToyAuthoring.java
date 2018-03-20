package enamel;

import javax.swing.JFileChooser;
import java.io.File;
import java.util.prefs.Preferences;

public class ToyAuthoring {


	public static void main(String[] args) { 	
	    Thread starterCodeThread = new Thread("Starter Code Thread") {
	    	public void run() { 
    	    ScenarioParser s = new ScenarioParser(true);
    	    
    	    
    	    JFileChooser jf = new JFileChooser();
    	    int returnValue = jf.showOpenDialog(null);

    	    if (returnValue == JFileChooser.APPROVE_OPTION) {
    	    	File selectedFile = jf.getSelectedFile();
    	    	s.setScenarioFile(selectedFile.getAbsolutePath());
    	    }
    	    }
	    	};
	    starterCodeThread.start();
    }
}

/*JFileChooser jf = new JFileChooser();
int returnValue = jf.showOpenDialog(null);

if (returnValue == JFileChooser.APPROVE_OPTION) {
	File selectedFile = jf.getSelectedFile();
	s.setScenarioFile(selectedFile.getAbsolutePath());
}

 OR
 */