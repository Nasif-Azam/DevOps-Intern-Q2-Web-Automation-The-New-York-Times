package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC007_LogIn extends BaseClass {
    @Test(priority = 16)
    void login_page(){
        LoginPage lp = new LoginPage(driver);
        lp.clickLoginButton();
    }

    @Test(priority = 17, dependsOnMethods = {"login_page"})
    void TC16_loginPageLogoChecker(){
        LoginPage lp = new LoginPage(driver);
        // Validation
        Assert.assertTrue(lp.logoDisplayed(), "The logo is not displayed.");
    }

    @Test(priority = 18)
    void TC17_testLogin(){
        LoginPage lp = new LoginPage(driver);
//        lp.setUserName(randomString()+"@gmail.com");
//        lp.contUserName();
//        lp.setPassword(randomAlphaNumeric());
        lp.setUserName("nasifazam.batterylowinteractive@gmail.com");
        lp.contUserName();
        lp.setPassword("0123456789!");

        lp.clickLogin();
        // Validation
        Assert.assertEquals(driver.getTitle(), "Log in - The New York Times");
    }
}
