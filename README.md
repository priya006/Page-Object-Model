# Page Object Model
A Selenium Project Built to master Page Factory and POM Structure in Selenium

# Installation

   1. Follow the [Guide](https://www.kenst.com/2015/03/including-the-chromedriver-location-in-macos-system-path/) and  Install ChromeDriver in  Mac
   2. Add the Maven Dependency to maven build file pom.xml
```
   <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
```
    3. Add maven-surefire-plugin to execute TestNG tests
    
```
  <groupId>org.apache.maven.plugins</groupId>
   <artifactId>maven-surefire-plugin</artifactId>
   <version>3.0.0-M5</version>

```
    4. Chrome Browser Version `86.0.4240.111` and ChromeDriver Version `86.0` are compatible 
    5. Include `log4j-api` and `log4j-core` library dependency and name the properties file as `log4j2.properties` in the path `resources`. Specify the package name which has logging to be recorded in the key  `logger.file.name`
    6. TestNG library dependency is added. [Refer pom.xml]
    7. To read data from Excel file for data driven testing we need poi and poi-ooxml as dependency
 - Install [GeckoDriver](https://www.browserstack.com/guide/run-selenium-tests-using-firefox-driver) to run Selenium tests in Firefox Browser
    
 
**Note:** Executing command `mvn test` should give you `BUILD SUCCESS` Message!


### How to run the Tests?
1. Right click `testng.xml` file and run the test suite at one shot

### How to take Screenshot in selenium
1. Entire page could be taken screenshot using the interface in selenium `TakesScreenshot`
2. Specified WebElement alone could be taken screenshot using `ashot`
3. Compare the Expected and actual image using `makeDiff` from `ashot` library. 
    **Example:** `   ImageDiff diff = imageDiffer.makeDiff(expectedImage,actualImage);`
4. Particular WebElement could be  **highlighted** in the screenshot using JavascriptExecutor from selenium

### CrossBrowser Testing / Parallel Testing
  - config.properties could be set with values for the key `browser` and the value could be accessed like `PropertyManager.getInstance().getBrowser()`
  - TestNG `@Parameters` could be used to execute same test parallelly with multiple browsers   

### Assertions
`SoftAssert` will not stop execution of the test if the assertion fails
`Hard Assert` will stop the test execution if the assertion fails
`SoftAssert softassert = new SoftAssert();`


### Data-Driven Testing
Data is entered in the spread sheet `TestData`. The class `DataProviderForExcel` reads the data from the spreadsheet and feeds into the test with the help of TestNG @Dataprovider annotation.

### How to execute a particular Suite Xml file using TestNG Maven surefire plugin
1. Run the test using maven sure fire plugin with commands `mvn clean install` and `mvn test`
2. The plugin gives sure-fire reports(target/surefire-reports directory) at the end of the run in IDE console. The report has the stack trace of all the failing tests whick makes it simple to debug a problem or while doing root cause analysis it could be very helpful.
```
<build>
        <plugins>
            <!-- Following plugin executes the testng tests -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <!-- Suite testng xml file to consider for test execution -->
                    <suiteXmlFiles>
                        <suiteXmlFile>/Users/pboopathi/Documents/Priya/PETproject/Selenium_POM_Project/testng.xml</suiteXmlFile>/
<!--                        <suiteXmlFile>suites-test-testng.xml</suiteXmlFile>-->
<!--                        <suiteXmlFile>src/test/resources/test_parameters.xml</suiteXmlFile>-->

                    </suiteXmlFiles>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>7</source>
                    <target>7</target>
                </configuration>
            </plugin>
        </plugins>


    </build>
```

## Hierarchy of Execution in TestNG
![Execution](https://github.com/priya006/Page_Object_Model/blob/master/TestNG.png)

### Custom Logging
Write a listener class and implement `ITestListener`

### Custom Reports
Write a Custom Listener class and implement `IReporter`

# Limitations in the Project
1. Could not write the loging to a file. The log4j2 properties file can create a log file. But could not write to a file
2. Data Provider in TestNG was used to provide data from a spread sheet. The TestNG skips the test which is using the annotation @Dataprovider. Different versions of TestNG tried yet the issue could not be resolved



Reference
------------------------------------
[TestNG](https://www.toolsqa.com/testng/testng-dataproviders/)