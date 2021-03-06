package browserStackSetup;


import browserStackPages.BrowserStackHomePage;
import browserStackPages.BrowserStackSignUpPage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.google.common.io.Files;





import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

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

//    @BeforeTest
//    @Parameters({"browser"})
//
//    public void setDriver(String browser) throws MalformedURLException, InterruptedException {
//      String macChromeDriver =  PropertyManager.getInstance().getMacChromeDriver();
//        LOGGER.trace("Tracing");
//        LOGGER.info("Chrome Driver Setup");
//        LOGGER.debug("some");
//
//        //Un comment the below line if you want to run the test with config
//      //browser = PropertyManager.getInstance().getBrowser();
//
//        switch (browser){
//            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "/Users/pboopathi/Downloads/chromedriver" );
//                ChromeOptions chromeOptions = new ChromeOptions();
//                driver = new ChromeDriver(chromeOptions);
//                chromeOptions.addArguments("start-maximized");
//
//                break;
//            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "/Users/pboopathi/Downloads/geckodriver");
//                driver = new FirefoxDriver();
//                break;
//            default:
//                throw new WebDriverException();
//        }
//
//        browserStackHomePage =  new BrowserStackHomePage(driver);
//        browserStackSignUpPage = new BrowserStackSignUpPage(driver);
//
//        String baseUrl = PropertyManager.getInstance().getUrl();
//        driver.get(baseUrl);
//        String title =   driver.getTitle();
//        System.out.println(title);
//
//    }


    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) throws Exception{
              String macChromeDriver =  PropertyManager.getInstance().getMacChromeDriver();
        LOGGER.trace("Tracing logger testing");
        LOGGER.info("Chrome Driver Setup");
//        LOGGER.debug("");
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "/Users/pboopathi/Downloads/geckodriver");
            driver = new FirefoxDriver();
            LOGGER.info("Firefox Driver is instantiated");
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "/Users/pboopathi/Downloads/chromedriver" );
            //create chrome instance
            ChromeOptions chromeOptions = new ChromeOptions();
          driver = new ChromeDriver(chromeOptions);
            LOGGER.info("Chrome Driver is instantiated");
                chromeOptions.addArguments("start-maximized");
        }

        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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



    @AfterMethod
    public void TearDown(){
        LOGGER.info("TearDown Method is called and browser is quitted");
        driver.quit();

    }



}




