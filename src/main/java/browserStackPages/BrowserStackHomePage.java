package browserStackPages;

import browserStackSetup.Setup;
import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserStackHomePage extends Setup {


    By Header=By.xpath("//h1");
    By getStarted=By.xpath("//*[@id='signupModalButton']");

    public BrowserStackHomePage(WebDriver driver) {
        this.driver=driver;
    }
    public void veryHeader() {
        String getheadertext=driver.findElement(Header).getText();
        Assert.checkNonNull(getheadertext,"not null");
    }
    public void clickOnGetStarted() {
        driver.findElement(getStarted).click();
    }
}
