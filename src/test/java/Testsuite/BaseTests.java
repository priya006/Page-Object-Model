package Testsuite;


import browserStackSetup.Setup;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTests extends Setup {

    @Test(priority = 1)
    public void navigate_to_home_page(){

        browserStackHomePage.veryHeader();
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
}
