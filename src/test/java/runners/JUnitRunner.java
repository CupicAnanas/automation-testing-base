package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {
                "rs.ananas.automation.common",
                "rs.ananas.automation.steps"
        },
        tags = "@HappyPathRegistration",
        plugin = {"pretty", "html:src/test/resources/reports/cucumber-report.html"}
)
public class JUnitRunner { }
