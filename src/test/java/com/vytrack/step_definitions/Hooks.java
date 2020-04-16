package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before(order = 2)
    public void setup(){
        System.out.println("Test setup");
        Driver.getDriver().manage().window().maximize();
    }

    @Before(value = "@driver", order = 1)
    public void specialSetup(){
        System.out.println("Setup for driver only");
    }

    @After("@driver")
    public void specialTearDown(){
        System.out.println("Tear down for driver only");
    }

    @After
    public void tearDown(){
        System.out.println("Test clean up");
        Driver.closeDriver();
    }
}
