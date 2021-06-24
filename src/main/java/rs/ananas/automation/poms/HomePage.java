package rs.ananas.automation.poms;

import rs.ananas.automation.common.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageObject {

    public HomePage(WebDriver webDriver){
        super(webDriver);
        waitForLoad(3L);
        PageFactory.initElements(webDriver , this);
        webDriver.manage().window().maximize();
    }


}
