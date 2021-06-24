package rs.ananas.automation.common;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

import rs.ananas.automation.utils.AccessProperties;

// Base driver class, WebDriver calls and methods
public class BaseDriverClass {

//  Initializing WebDriver from Selenium
    private static WebDriver webDriver;
//  Initializing AccessProperties class to be used later by the setUp() method
    private static final AccessProperties accessProperties = new AccessProperties();

//  Executes setUp() before each scenario
//  Checks what value was passed to currentDriver and sets up the WebDriver accordingly
    @Before
    public static void setUp() {
        String currentDriver = null;
        try {
//          Value of "browser" is in src/test/resources/test.properties
            currentDriver = accessProperties.getProperty("browser");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        switch (Objects.requireNonNull(currentDriver)) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
        }
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

//  Executes tearDown() after each scenario
//  Exits and tears down the WebDriver
    @After
    public static void tearDown() {
        webDriver.quit();
    }

}