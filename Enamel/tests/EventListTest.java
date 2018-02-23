

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enamel.*;


public class EventListTest {
	 EventList tester = new EventList();
	 String[] cellarray = new String[2];
	ScenarioEvent event= new ScenarioEvent(0, "MyTitle0", "MyQuestion", "Right", "Wrong",cellarray, 0);
	ScenarioEvent event1= new ScenarioEvent(1, "MyTitle1", "MyQuestion", "Right", "Wrong",cellarray, 0);
	ScenarioEvent event2= new ScenarioEvent(2, "MyTitle2", "MyQuestion", "Right", "Wrong",cellarray, 0);
	ScenarioEvent event3= new ScenarioEvent(3, "MyTitle3", "MyQuestion", "Right", "Wrong",cellarray, 0);
	ScenarioEvent event4= new  ScenarioEvent(4, "MyTitle4", "MyQuestion", "Right", "Wrong",cellarray, 0);
	
	


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp()  {
		tester.add(0, event);
		tester.add(1, event1);
		tester.add(2, event2);
		tester.add(3, event3);
		tester.add(4, event4);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		//tester.add(event4);
		assertEquals(5, tester.getSize());
		
	}
	
	
	@Test
	public void testRemove() {
	tester.remove(2, event2);
	assertEquals(4, tester.getSize());
		
	}
	@Test
	public void testgetSize() {
		assertEquals(5, tester.getSize());
	
		

	
	}
	
	@Test
	public void testGetTimeline() {
		assertEquals(tester.getTimeline().get(0), event);
	}
	
	@Test
	public void testUpdateIndexes() {
		tester.add(2, event3);
		assertEquals(event3, tester.getTimeline().get(2));
	
	
	}
	

}
