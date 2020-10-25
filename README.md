# Page_Object_Model
A Selenium Project Built to master Page Factory and POM Structure in Selenium

# Installation
1. Follow the [Guide](https://www.swtestacademy.com/install-chrome-driver-on-mac/) and  Install Chrome Driver in  Mac
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