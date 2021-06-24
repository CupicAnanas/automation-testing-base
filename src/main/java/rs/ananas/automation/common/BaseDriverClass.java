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

public class BaseDriverClass {

    private static WebDriver webDriver;
    private static final AccessProperties accessProperties = new AccessProperties();

    @Before
    public static void setUp() {
        String currentDriver = null;
        try {
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

    @After
    public static void tearDown() {
        webDriver.quit();
    }

}