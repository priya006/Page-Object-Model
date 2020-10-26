package browserStackSetup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;


public class BrowserStackSetup {



    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/pboopathi/Downloads/chromedriver" );
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://www.google.com");
        String title =   driver.getTitle();
        System.out.println(title);


    }
}




