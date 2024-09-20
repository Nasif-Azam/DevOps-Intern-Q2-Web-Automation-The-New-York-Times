package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC001_TitleCheck extends BaseClass {
    @Test(priority = 0)
    void title_check(){
        HomePage tc = new HomePage(driver);
        // Validation
        Assert.assertEquals(driver.getTitle(), tc.titleChecker());
    }
}
