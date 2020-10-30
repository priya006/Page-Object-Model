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
  
 
**Note:** Executing command `mvn test` should give you `BUILD SUCCESS` Message!


### How to run the Tests?
1. Right click `testng.xml` file and run the test suite at one shot

### How to take Screenshot in selenium
1. Entire page could be taken screenshot using the interface in selenium `TakesScreenshot`
2. Specified WebElement alone could be taken screenshot using `ashot`
3. Compare the Expected and actual image using `makeDiff` from `ashot` library. 
    **Example:** `   ImageDiff diff = imageDiffer.makeDiff(expectedImage,actualImage);`
4. Particular WebElement could be  **highlighted** in the screenshot using JavascriptExecutor from selenium

### CrossBrowser Testing    

### Assertions

# Limitation
1. Could not write the loging to a file. The log4j2 properties file can create a log file. But could not write to a file