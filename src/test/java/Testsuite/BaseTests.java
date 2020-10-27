package Testsuite;


import browserStackSetup.Setup;
import org.testng.annotations.Test;

public class BaseTests extends Setup {

    @Test(priority = 1)
    public void navigate_to_home_page(){

        browserStackHomePage.veryHeader();
        browserStackHomePage.clickOnGetStarted();
    }

    @Test(priority = 2)
    public void enter_userDetails(){

        browserStackSignUpPage.veryHeader();
        browserStackSignUpPage.enterFullName("Priya");
        browserStackSignUpPage.enterBusinessEmail("TestUser@gmail.com");
        browserStackSignUpPage.enterPasswrod("TestUserPassword");

    }
}
