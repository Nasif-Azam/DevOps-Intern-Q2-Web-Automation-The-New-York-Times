package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC004_AllHeadings extends BaseClass {
    @Test(priority = 3)
    void total_num_headings(){
        HomePage headings = new HomePage(driver);
        Assert.assertEquals(headings.allHeadings(), 23); // Expected values are depends on server fetches
    }
}
