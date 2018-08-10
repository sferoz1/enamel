

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enamel.*;


public class EventListTest {
	static EventList tester;
	static ScenarioEvent event;
	static ScenarioEvent event1;
	static ScenarioEvent event2;
	static ScenarioEvent event3;
	static ScenarioEvent event4;
	static ScenarioEvent eventToAdd;
	static String[] cellarray = new String[2];



	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		event= new ScenarioEvent("Q", "r", "W", 0, "MyTitle0", "MyQuestion", "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		event1= new ScenarioEvent("Q", "r", "W", 1, "MyTitle1", "MyQuestion", "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		event2= new ScenarioEvent("Q", "r", "W", 2, "MyTitle2", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		event3= new ScenarioEvent("Q", "r", "W", 3, "MyTitle3", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		event4= new  ScenarioEvent("Q", "r", "W", 4, "MyTitle4", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		
		tester = new EventList();
		 
	
		
	}



	@Before
	public void setUp()  {
		/*tester.add(0, event);
		tester.add(1, event1);
		tester.add(2, event2);
		tester.add(3, event3);
		tester.add(4, event4);*/
		tester.getTimeline().add(event);
		tester.getTimeline().add(event1);
		tester.getTimeline().add(event2);
		tester.getTimeline().add(event3);
		tester.getTimeline().add(event4);
		tester.setSize(5);
		ScenarioEvent eventToAdd= new  ScenarioEvent("Q", "r", "W", 5, "MyTitle6", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);

	}

	@After
	public void tearDown() throws Exception {
		tester.getTimeline().removeAll(tester.getTimeline());
		tester.setSize(0);
	}

	@Test
	public void testAddtoEnd() {

		tester.add(5, eventToAdd);

		assertEquals(6, tester.getTimeline().size()); // passes

		assertEquals(eventToAdd, tester.getTimeline().get(5)); //  note: tester().get(0) gives an IOB, size of tester.get() is zero, timeline is a static linked list of the class
		
	}
	
	@Test
	public void testAddToMiddle() {
		//ScenarioEvent eventToAdd= new  ScenarioEvent("Q", "r", "W", 5, "MyTitle6", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		tester.add(2, eventToAdd);
		assertEquals(6, tester.getTimeline().size());
		assertEquals(eventToAdd, tester.getTimeline().get(2)); //  fails note: tester().get(0) gives an IOB, size of tester.get() is zero
	}
	
	@Test
	public void testAddToFront() {
		tester.add(0, eventToAdd);
		assertEquals(6, tester.getTimeline().size());
		assertEquals(eventToAdd, tester.getTimeline().get(0));
		
		
	}
	
	
	@Test
	public void testRemove() {
	tester.remove(2, event2);
	assertEquals(4, tester.getTimeline().size()); //passes
	assertEquals(event3, tester.getTimeline().get(2)); //all events should be shifted up one now
	}
	
	
	@Test
	public void testgetSize() {
		assertEquals(5, tester.getSize());
	}
	
	
	@Test
	public void testGetTimeline() {
		assertEquals(tester.getTimeline().get(0), event);
		assertEquals(tester.getTimeline().get(1), event1);
		assertEquals(tester.getTimeline().get(2), event2);
		assertEquals(tester.getTimeline().get(3), event3);
		assertEquals(tester.getTimeline().get(4), event4);
		
	}
	
	
	@Test
	public void testUpdateIndexes() {
		ScenarioEvent event7 = new ScenarioEvent("Q", "r", "W", 5, "MyTitle7", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
		tester.add(3, event7);
		//tester.updateIndexes();
		assertEquals(event7, tester.getTimeline().get(3));
		assertEquals(event3, tester.getTimeline().get(4));
		
	
	}
	
	/*@AfterClass
	public void tearDownAfterClass() throws Exception {
		tester.removeAll(tester);
	}*/

}
