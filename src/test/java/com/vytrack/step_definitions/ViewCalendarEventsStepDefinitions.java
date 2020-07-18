package com.vytrack.step_definitions;

import com.vytrack.pages.activities.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.List;

public class ViewCalendarEventsStepDefinitions {
    private static final Logger logger = Logger.getLogger(ViewCalendarEventsStepDefinitions.class);
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("View Per Page menu should have following options")
    public void view_Per_Page_menu_should_have_following_options(List<String> dataTable) {
        logger.info("Expected values: " + dataTable);
        Assert.assertEquals(dataTable, calendarEventsPage.getViewPerPageOptions());
    }
}
