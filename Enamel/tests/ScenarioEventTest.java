
import java.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enamel.ScenarioEvent;

public class ScenarioEventTest {
	
	String[] cellarray = new String[2];
	
	ScenarioEvent event= new ScenarioEvent("Q", "r", "W", 0, "MyTitle", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);
	ScenarioEvent event1 = new ScenarioEvent("Q", "r", "W", 0, "MyTitle", "MyQuestion",  "QuestionPath", "Right", "RPath", "Wrong", "WPath", cellarray, 0);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cellarray[0] = "1";
		cellarray[1] = "2";
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
		event.overwrite("Q", "r", "W", 0,"OverwriteTitle", "ORQuestion", "ORQuestionPath", "ORRight", "ORRPath", "ORWrong","ORWPath", cellarray, 2);
		
		assertEquals("OverwriteTitle", event.getTitle());
		
		assertEquals("ORQuestion", event.getQuestion());
		
		assertEquals("ORRight", event.getResponseRight());
		
		assertEquals("ORWrong", event.getResponseWrong());
		
		assertEquals(2, event.getCorrectAns());
		
		assertEquals(0, event.getIndex());
	}
	
	
}
