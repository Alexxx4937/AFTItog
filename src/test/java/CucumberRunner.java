import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"autotest"},
        plugin = {
            "autotest.util.AllureReporter",
        },tags = {"@test1"}
)
public class CucumberRunner {

}
