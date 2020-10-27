package browserStackSetup;


import browserStackPages.BrowserStackHomePage;
import browserStackPages.BrowserStackSignUpPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;


public class Setup {

    public static WebDriver driver;
    public BrowserStackHomePage browserStackHomePage;
    public BrowserStackSignUpPage browserStackSignUpPage;
    public static Logger LOGGER = null;


    public  Setup(){
        LOGGER = LogManager.getLogger(Setup.class);
        LOGGER.info("Test completed");
    }

    @BeforeTest
    public void setDriver() throws MalformedURLException, InterruptedException {
        LOGGER.info("Chrome Driver Setup");
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




