package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order = 2)
    public void setup() {
        System.out.println("Test setup");
        Driver.getDriver().manage().window().maximize();
    }

    @Before(value = "@driver", order = 1)
    public void specialSetup() {
        System.out.println("Setup for driver only");
    }

    @After("@driver")
    public void specialTearDown() {
        System.out.println("Tear down for driver only");
    }

    @After
    public void tearDown(Scenario scenario) {
        //how to check if scenario failed
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //attach screenshot to the report
            scenario.embed(image, "image/png", scenario.getName());
        }
        System.out.println("Test clean up");
        Driver.closeDriver();
    }
}
