package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Open login page");
        String URL = ConfigurationReader.getProperty("qa3");
        Driver.getDriver().get(URL);
    }

    @When("user logs in as a sales manager")
    public void user_logs_in_as_a_sales_manager() {
        System.out.println("Login as sales manager");
        loginPage.login("salesmanager110", "UserUser123");
    }

    @When("user logs in as a store manager")
    public void user_logs_in_as_a_store_manager() {
        loginPage.login("storemanager85", "UserUser123");
    }


    @Then("user should verify that title is a Dashboard")
    public void user_should_verify_that_title_is_a_Dashboard() {
        System.out.println("Verify that title is a Dashboard");
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
    }

    @When("user logs in as a driver")
    public void user_logs_in_as_a_driver() {
        System.out.println("Login as a driver");
        loginPage.login("user19", "UserUser123");
    }

    //    When user enters "storemanager85" username and "UserUser123" password
    @When("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {
        System.out.printf("Login with user name %s and %s password\n", string, string2);
        loginPage.login(string, string2);
    }

    @When("user navigates to {string} and {string}")
    public void user_navigates_to_and(String tab, String module) {
        System.out.printf("User clicks on the %s tab and navigates to %s module\n", tab, module);
        loginPage.navigateTo(tab, module);
    }

    @Then("user name should be {string}")
    public void user_name_should_be(String string) {
        Assert.assertEquals(string, loginPage.getCurrentUserName());
    }


    @When("user logs in as {string}")
    public void user_logs_in_as(String userType) {
        loginPage.login(userType);
    }

    @Then("user verifies that page title is {string}")
    public void user_verifies_that_page_title_is(String string) {
        System.out.println("Verify that page title is: " + string);
        Assert.assertEquals(string, Driver.getDriver().getTitle());
    }

}
