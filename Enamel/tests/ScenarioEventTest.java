

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enamel.ScenarioEvent;

public class ScenarioEventTest {
	
	ScenarioEvent event= new ScenarioEvent(0, "MyTitle", "MyQuestion", "Right", "Wrong", 0);
	ScenarioEvent event1 = new ScenarioEvent(0, "MyTitle", "MyQuestion", "Right", "Wrong", 0);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testgetTitle(){
		assertEquals(event.getTitle(), "MyTitle");
	}
	
	@Test
	public void testgetQuestion(){
		assertEquals(event.getQuestion(), "MyQuestion");
		
	}
	
	@Test
	public void testgetResponseRight(){
		assertEquals(event.getResponseRight(), "Right");
		
	}
	@Test
	public void testgetResponseWrong(){
		assertEquals(event.getResponseWrong(), "Wrong");
		
	}
	@Test
	public void getCorrectAns(){
		assertEquals(event.getCorrectAns(), 0);
	}

	public void setIndex(int i) {
		event.setIndex(2);
		assertEquals(event.getIndex(), 2);
		
	}
	
	public void testgetIndex() {
		assertEquals(event.getIndex(), 0);
		
	}
	
	public void testtoString(){
		assertEquals(event.toString(), "Title");
	}	
	
	
	@Test
	public void testOverwrite() {
		event.overwrite("OverwriteTitle", "ORQuestion", "ORRight", "ORWrong", 2);
		
		assertEquals("OverwriteTitle", event.getTitle());
		
		assertEquals("ORQuestion", event.getQuestion());
		
		assertEquals("ORRight", event.getResponseRight());
		
		assertEquals("ORWrong", event.getResponseWrong());
		
		assertEquals(2, event.getCorrectAns());
	}
	
	public void testCompareTo() {
		assertEquals(event.compareTo(event1), 0);
	}
	
	
}
