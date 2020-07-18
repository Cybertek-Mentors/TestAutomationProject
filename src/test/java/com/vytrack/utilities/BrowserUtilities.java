package com.vytrack.utilities;

import com.vytrack.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BrowserUtilities {
    private static final Logger logger = Logger.getLogger(BrowserUtilities.class);

    /**
     * Pause test for some time
     *
     * @param seconds
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param elements represents collection of WebElements
     * @return collection of strings
     */
    public static List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * This method takes a screenshot and saves it with a date&time stamp.
     *
     * @return path to screenshot
     */
    public static String takeAScreenshotAndSave(String testName) {
        String path = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + testName + "/";
        path = path.replace("/", File.separator);
        File file = new File(path);
        file.mkdirs();
        Date date = new Date();
        path += date + "screenshot.jpeg";
        try (OutputStream outputStream = new FileOutputStream(path)) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            outputStream.write(screenshot);
        } catch (IOException e) {
            logger.error(e);
            e.printStackTrace();
            throw new RuntimeException("Failed to create a screenshot :: " + path);
        }
       logger.info("Screenshot saved here :: " + path);
        return path;
    }


    /**
     * This method will switch webdriver from current window
     * to target window based on page title
     * @param title of the window to switch
     */
    public static void switchWindow(String title){
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for(String window : windowHandles){
            Driver.getDriver().switchTo().window(window);
            if(Driver.getDriver().getTitle().equals(title)){
                break;
            }
        }
    }
}
