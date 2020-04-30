package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources",
        dryRun = false,
        strict = false,
        tags = "not @smoke_test",
        plugin = {
                "html:target/default-report-for-regression",
                "json:target/cucumber_regression.json",
                "rerun:target/rerun.txt"
        }

)
public class RegressionRunner {
}
