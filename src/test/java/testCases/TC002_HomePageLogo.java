package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC002_HomePageLogo extends BaseClass {
    @Test(priority = 1)
    void homepage_logo_status(){
        logger.info("===== String TC002_HomePageLogo =====");
        HomePage hpLogo = new HomePage(driver);
        // Validation
        logger.info("Validating Homepage Logo...");
        Assert.assertTrue(hpLogo.homeLogoSVG(), "The logo is not displayed.");
        logger.info("===== Finished TC002_HomePageLogo =====");
    }
}
