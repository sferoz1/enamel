import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EventListTest.class, ScenarioEventTest.class,
		ScenarioFileReaderTest.class, ScenarioTest.class, ScenWriterTest.class, AudioTests.class })
public class AllTests {

}
