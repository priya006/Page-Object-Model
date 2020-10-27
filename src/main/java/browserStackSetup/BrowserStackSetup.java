package browserStackSetup;


import browserStackPages.BrowserStackHomePage;
import browserStackPages.BrowserStackSignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class BrowserStackSetup {

  private  static   WebDriver driver;
    BrowserStackHomePage browserStackHomePage;
    BrowserStackSignUpPage browserStackSignUpPage;

    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/pboopathi/Downloads/chromedriver" );
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
         driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.browserstack.com/");
        String title =   driver.getTitle();
        System.out.println(title);

    }

    @Test(priority = 1)
    public void navigate_to_home_page(){
        browserStackHomePage = new BrowserStackHomePage(driver);
        browserStackHomePage.veryHeader();
        browserStackHomePage.clickOnGetStarted();
    }

    @Test(priority = 2)
    public void enter_userDetails(){
        browserStackSignUpPage = new BrowserStackSignUpPage(driver);
        browserStackSignUpPage.veryHeader();
        browserStackSignUpPage.enterFullName("Priya");
        browserStackSignUpPage.enterBusinessEmail("TestUser@gmail.com");
        browserStackSignUpPage.enterPasswrod("TestUserPassword");


    }
}




