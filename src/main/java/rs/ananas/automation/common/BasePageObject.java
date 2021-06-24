package rs.ananas.automation.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
// Contains all the common methods that we write
public class BasePageObject {

    public static WebDriverWait wait;
    public static WebDriver webDriver;

    public BasePageObject(WebDriver driver){
        webDriver = driver;
    }

//  Wait for element to be available to click
    public static WebElement waitToBeClickable(WebElement element) {
        wait =  new WebDriverWait(webDriver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

//  Wait for element to be visible and return if he can be displayed or no
    public static boolean waitToBeVisible(WebElement element){
        try{
            WebElement webElementWait = new WebDriverWait(webDriver , Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(element));
            return webElementWait.isDisplayed();
        }catch(NoSuchElementException | TimeoutException exception){
            return false;
        }
    }

//  Wait for page to load
    public static void waitForLoad(Long waitTime){
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        ExpectedCondition<Boolean> expectation = input ->
                executor.executeScript("return document.readyState").toString().equals("complete");
        try{
            Thread.sleep(1000);
            WebDriverWait webDriverWait = new WebDriverWait(webDriver , Duration.ofSeconds(waitTime));
            webDriverWait.until(expectation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//  Try to find element 5 times
    public static WebElement retryFindElement(By by){
        WebElement webElement = null;
        int attempts = 0;
        while(attempts < 5){
            try{
                webElement = waitToBeClickable(webDriver.findElement(by));
                if(webElement != null){
                    break;
                }
            }catch (StaleElementReferenceException exception){
                webElement = waitToBeClickable(webDriver.findElement(by));
            }
            attempts++;
        }
        return webElement;
    }

//  Click on element
    public static void performClick(WebElement webElement){
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    public static void sendKeysToElement(WebElement element , String text){
        element.sendKeys(text);
    }

    public boolean checkIfElementExists(WebElement webElement , Long seconds){
        try{
            WebElement welcomePopUpWait = new WebDriverWait(webDriver , Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.visibilityOf(webElement));
            return welcomePopUpWait.isDisplayed();
        }catch(NoSuchElementException | TimeoutException exception){
            return false;
        }
    }

}