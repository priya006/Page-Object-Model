package browserStackPages;

import browserStackSetup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserStackHomePage extends Setup {


    By Header=By.xpath("//h1");
    public By getStarted=By.xpath("//*[@id='signupModalButton']");

    public BrowserStackHomePage(WebDriver driver) {
        this.driver=driver;
    }
    public void veryHeader() {
        String getheadertext=driver.findElement(Header).getText();
//        Assert.checkNonNull(getheadertext,"not null");
    }
    public void clickOnGetStarted() throws InterruptedException {
        WebElement getStartedWebElement = new WebDriverWait((driver),10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='signupModalButton']")));
        //This sleep is needed
        Thread.sleep(1000);
//        driver.findElement(getStarted).click();
        getStartedWebElement.click();


    }
}
