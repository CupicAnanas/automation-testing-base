package rs.ananas.automation.poms;

import rs.ananas.automation.common.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Placeholder class, to be REFACTORED --> RENAMED, please follow the naming convention
// Used to store WebElements, and methods that use those web elements
// Suggested annotations --> @FindBy, @CacheLookup
public class PlaceholderPage extends BasePageObject {

//  Constructor initializing WebDriver, waiting for the website to load, and maximizing the window
    public PlaceholderPage(WebDriver webDriver){
        super(webDriver);
        waitForLoad(3L);
        PageFactory.initElements(webDriver , this);
        webDriver.manage().window().maximize();
    }

}
