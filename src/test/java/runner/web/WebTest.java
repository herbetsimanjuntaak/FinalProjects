package runner.web;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/web/WebTestingDemoBlaze-report.html", "json:reports/web/WebTestingDemoBlaze-report.json"},
        glue = {"stepDef"},
        features = {"src/test/java/features/web"}
)
public class WebTest {
}
