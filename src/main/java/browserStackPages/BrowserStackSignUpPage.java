package browserStackPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.jvm.hotspot.utilities.Assert;

public class BrowserStackSignUpPage {

    WebDriver driver;
    By Header = By.xpath("//h1");
    By userName = By.xpath("//*[@id='user_full_name']");
    By businessEmail = By.xpath("//*[@id='user_email_login']");
    By password = By.xpath("//*[@id='user_password']");
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
