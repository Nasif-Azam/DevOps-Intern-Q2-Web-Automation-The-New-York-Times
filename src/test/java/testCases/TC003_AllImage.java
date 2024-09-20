package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC003_AllImage extends BaseClass {
    @Test(priority = 2)
    void total_num_images(){
        HomePage allImage = new HomePage(driver);
        // Validation
        Assert.assertEquals(allImage.allImageChecker(), 93); // Expected values are depends on server fetches
    }
}
