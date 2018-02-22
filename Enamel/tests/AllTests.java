import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ErrorLogReaderTest.class, ErrorWindowTest.class, EventEditorTest.class, EventListTest.class,
		LauncherTest.class, ListMainTest.class, ScenarioEditorTest.class, ScenarioEventTest.class,
		ScenarioFileReaderTest.class, ScenarioLoaderTest.class, ScenarioTest.class, ScenarioWriterTest.class,
		SucessfulScenFileCreationTest.class, ToyAuthoringTest.class })
public class AllTests {

}
