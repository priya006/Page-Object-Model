package browserStackSetup;


import browserStackPages.BrowserStackHomePage;
import browserStackPages.BrowserStackSignUpPage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.io.Files;





import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;


public class Setup {

    public static WebDriver driver;
    public BrowserStackHomePage browserStackHomePage;
    public BrowserStackSignUpPage browserStackSignUpPage;
    private static Logger LOGGER = null;


    public  Setup(){
        LOGGER = LogManager.getLogger(Setup.class);
        LOGGER.info("Test completed");
    }

    @BeforeTest
    public void setDriver() throws MalformedURLException, InterruptedException {
      String macChromeDriver =  PropertyManager.getInstance().getMacChromeDriver();
        LOGGER.trace("Tracing");
        LOGGER.info("Chrome Driver Setup");
        LOGGER.debug("some");

        String browser = PropertyManager.getInstance().getBrowser();

        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", macChromeDriver );
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/Users/pboopathi/Downloads/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new WebDriverException();
        }

        browserStackHomePage =  new BrowserStackHomePage(driver);
        browserStackSignUpPage = new BrowserStackSignUpPage(driver);

        String baseUrl = PropertyManager.getInstance().getUrl();
        driver.get(baseUrl);
        String title =   driver.getTitle();
        System.out.println(title);

    }

    public void takeScreenshot(String pathname) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src, new File(pathname));
    }



    @AfterTest
    public void TearDown(){
        LOGGER.info("TearDown");
        driver.quit();

    }



}




