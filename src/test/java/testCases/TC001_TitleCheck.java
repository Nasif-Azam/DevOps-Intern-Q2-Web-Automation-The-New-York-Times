package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC001_TitleCheck extends BaseClass {
    @Test(priority = 0)
    void title_check(){
        logger.info("===== String TC001_TitleCheck =====");
        HomePage tc = new HomePage(driver);
        // Validation
        logger.info("Validating Expected Message...");
        Assert.assertEquals(driver.getTitle(), tc.titleChecker());
        logger.info("===== Finished TC001_TitleCheck =====");
    }
}
