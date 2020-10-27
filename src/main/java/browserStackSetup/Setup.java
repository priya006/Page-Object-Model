package browserStackSetup;


import browserStackPages.BrowserStackHomePage;
import browserStackPages.BrowserStackSignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class Setup {

    public   static   WebDriver driver;
    public BrowserStackHomePage browserStackHomePage;
    public BrowserStackSignUpPage browserStackSignUpPage;

    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/pboopathi/Downloads/chromedriver" );
        browserStackHomePage =  new BrowserStackHomePage(driver);
        browserStackSignUpPage = new BrowserStackSignUpPage(driver);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
         driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.browserstack.com/");
        String title =   driver.getTitle();
        System.out.println(title);

    }


}




