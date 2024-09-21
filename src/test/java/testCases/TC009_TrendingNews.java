package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC009_TrendingNews extends BaseClass{
    @Test
    void today_trending_news(){
        try {
            logger.info("===== String TC009_TrendingNews =====");
            HomePage hp = new HomePage(driver);
            logger.info("Validating Trending News...");
            hp.get_today_trending_news();
        }catch (Exception e){
            logger.error("Test Failed!!");
            logger.debug("Debug Logs...");
            Assert.fail();
        }
        logger.info("===== Finished TC009_TrendingNews =====");

    }
}
