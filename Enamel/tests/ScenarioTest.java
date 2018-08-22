import enamel.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScenarioTest {
String[] cellarray = new String[2];
	
	ScenarioEvent event= new ScenarioEvent("Q", "r", "W", 0, "MyTitle", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
	ScenarioEvent event1 = new ScenarioEvent("Q", "r", "W", 0, "MyTitle", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);

	 EventList tester = new EventList();
	 
	 	
		Scenario scentest = new Scenario(1,2,"Title", tester);

	@Before
	public void setUp() throws Exception {
		
		tester.add(event);
		tester.add(event1);
		Scenario scentest = new Scenario(1,2,"Title", tester);
		
	}

	
	
	@Test
	public void testgetCellNumber() {
		
		assertEquals(scentest.getCellNumber(), 1); 
	}
	
	
	@Test
	public void testsetCellNumber(){
		scentest.setCellNumber(5);
		assertEquals(scentest.getCellNumber(), 5);

	}
	
	
	@Test
	public void testgetButtonNumber() {
		assertEquals(scentest.getButtonNumber(), 2);
		
		
	}
	
	
	@Test
	public void testsetButtonNumber() {
		scentest.setButtonNumber(5);
		assertEquals(scentest.getButtonNumber(), 5);
		
	}
	
	
	@Test
	public void testgetScenarioEventList() {
		
		assertEquals(scentest.getScenarioEventList().size(), 2);
	}
	
	
	
	@Test
	public void testsetScenarioEventList() {
		scentest.setScenarioEventList(tester);
		assertEquals(scentest.getScenarioEventList(),tester);
		
	}
	
	
	
	@Test
	public void setTitle () {
		scentest.setTitle("title");
		assertEquals(scentest.getTitle(),  "title");
		
	}
	
	
	
	
	@Test
	public void testgetTitle () {
		assertEquals(scentest.getTitle(),  "Title");
		
	}
	
	
	
	


}
