package runner.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/api/DummyAPITesting-report.html", "json:reports/api/DummyAPITesting-report.json"},
        glue = {"stepDef"},
        features = {"src/test/java/features/web"}
)
public class ApiTest {
}
