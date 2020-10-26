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
3. Add maven-surefire-plugin to execute testng tests
```
  <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
```
**Note:** Executing command `mvn test` should give you `BUILD SUCCESS` Message!
3. Chrome Browser Version `Version 86.0.4240.111` and ChromeDriver Version `86.0`
