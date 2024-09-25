package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.util.Properties;

public class TC008_LogIn extends BaseClass {
    Properties prop;
    @Test(priority = 16)
    void login_page(){
        logger.info("===== String TC008_LogIn =====");
        LoginPage lp = new LoginPage(driver);
        logger.info("Clicked Login Button...");
        lp.clickLoginButton();
    }

    @Test(priority = 17, dependsOnMethods = {"login_page"})
    void loginPageLogoChecker(){
        LoginPage lp = new LoginPage(driver);
        // Validation
        logger.info("Clicked Login Page Logo...");
        Assert.assertTrue(lp.logoDisplayed(), "The logo is not displayed.");
    }

    @Test(priority = 18)
    void testLogin() {
        LoginPage lp = new LoginPage(driver);
        try {
            logger.info("Set User Name");
            lp.setUserName("abc@gmail.com");
            logger.info("Clicked Continue Button");
            lp.contUserName();
            logger.info("Set Password");
            lp.setPassword("0123456789!");
            logger.info("Clicked Login Button");
            lp.clickLogin();
            // Validation
            logger.info("Validating Login Page Title...");
            Assert.assertEquals(driver.getTitle(), "Log in - The New York Times");
        } catch (Exception e){
            logger.error("Test Failed!!");
            logger.debug("Debug Logs...");
            Assert.fail();
        }
        logger.info("===== Finished TC008_LogIn =====");
    }
}
