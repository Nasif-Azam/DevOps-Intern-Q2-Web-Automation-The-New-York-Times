package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC002_HomePageLogo extends BaseClass {
    @Test(priority = 1)
    void homepage_logo_status(){
        HomePage hpLogo = new HomePage(driver);
        // Validation
        Assert.assertTrue(hpLogo.homeLogoSVG(), "The logo is not displayed.");
    }
}
