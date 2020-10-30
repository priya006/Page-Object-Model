package browserStackPages;

import browserStackSetup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BrowserStackSignUpPage extends Setup {

    By Header = By.xpath("//h1");
  public  By userName = By.xpath("//*[@id='user_full_name']");
    By businessEmail = By.xpath("//*[@id='user_email_login']");
    By password = By.xpath("//*[@id='user_password']");

    /**
     * Constructor
     * @param driver
     */
    public BrowserStackSignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public void veryHeader() {
        String getheadertext = driver.findElement(Header).getText().trim();

    }
    public void enterFullName(String arg1) {
        driver.findElement(userName).sendKeys(arg1);
    }
    public void enterBusinessEmail(String arg1) {
        driver.findElement(businessEmail).sendKeys(arg1);
    }
    public void enterPasswrod(String arg1) {
        driver.findElement(password).sendKeys(arg1);
    }
}
