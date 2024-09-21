package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC004_AllHeadings extends BaseClass {
    @Test(priority = 3)
    void total_num_headings(){
        logger.info("===== String TC004_AllHeadings =====");
        HomePage headings = new HomePage(driver);
        // Validation
        logger.info("Validating All Heading...");
        Assert.assertEquals(headings.allHeadings(), 23); // Expected values are depends on server fetches
        logger.info("===== Finished TC004_AllHeadings =====");
    }
}
