package Testsuite;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserStackSetup.Setup;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BaseTests extends Setup {

    @Test(priority = 1)
    public void navigate_to_home_page() throws IOException {
        WebElement element = driver.findElement(browserStackHomePage.getStarted);
        browserStackHomePage.veryHeader();
        takeScreenshot("/Users/pboopathi/Desktop/entirepage.png");
        String webElementScreenshot = "/Users/pboopathi/Desktop/webelementscreen.png";
        takeWebElementScreenShot(element,webElementScreenshot,driver);
        browserStackHomePage.clickOnGetStarted();
    }


    @Test(priority = 2)
    @Parameters({"name"})
    public void enter_userDetails(String name){

        browserStackSignUpPage.veryHeader();
        browserStackSignUpPage.enterFullName(name);
        browserStackSignUpPage.enterBusinessEmail("TestUser@gmail.com");
        browserStackSignUpPage.enterPasswrod("TestUserPassword");

    }

    public void takeWebElementScreenShot(WebElement element, String pathname, WebDriver driver) throws IOException {
        Screenshot screenshot  = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
        ImageIO.write(screenshot.getImage(), "PNG", new File(pathname));
    }

}
