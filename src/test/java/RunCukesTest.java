import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        monochrome = true,
        plugin = {"pretty", "html:target/html-test-output.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml" }
)
public class RunCukesTest {
}
