package enamel;
import enamel.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScenarioTest {
	ScenarioEvent event= new ScenarioEvent(0, "MyTitle", "MyQuestion", "Right", "Wrong", 0);
	ScenarioEvent event1= new ScenarioEvent(1, "MyTitle", "MyQuestion", "Right", "Wrong", 0);
	ScenarioEvent event2= new ScenarioEvent(2, "MyTitle", "MyQuestion", "Right", "Wrong", 0);
	ScenarioEvent event3= new ScenarioEvent(3, "MyTitle", "MyQuestion", "Right", "Wrong", 0);

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
	public void testGetCellNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCellNumber() {
		fail("Not yet implemented");
	}
	

}
