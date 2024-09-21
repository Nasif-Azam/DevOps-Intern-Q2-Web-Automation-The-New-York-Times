package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SearchedPage;

public class TC005_SearchLatestNews extends BaseClass {
    @Test(priority = 4)
    void search_news(){
        try {
            logger.info("===== String TC005_SearchLatestNews =====");
            SearchedPage sn = new SearchedPage(driver);
            logger.info("Validating Search News...");
            Assert.assertEquals(sn.searchNews("Putin"), "The New York Times - Search");
        } catch (Exception e) {
            logger.error("Search News Test Failed!!");
            logger.debug("Search News Debug Logs...");
            Assert.fail();
        }
    }

    @Test(priority = 5, dependsOnMethods = {"search_news"})
    void num_searched_heading(){
        try {
            SearchedPage tnsh = new SearchedPage(driver);
            logger.info("Validating Searched Heading Number...");
            Assert.assertEquals(tnsh.searched_heading_num(), 9); // Expected values are depends on server fetches
        } catch (Exception e) {
            logger.error("Searched Heading Number Test Failed!!");
            logger.debug("Searched Heading Number Debug Logs...");
            Assert.fail();
        }
    }

    @Test(priority = 6, dependsOnMethods = {"search_news"})
    void find_latest_news(){
        try {
            logger.info("Finding Latest News...");
            SearchedPage lnh = new SearchedPage(driver);
            String latest_news = lnh.latest_news_heading();
        } catch (Exception e) {
            logger.error("Finding Latest News Test Failed!!");
            logger.debug("Finding Latest News Debug Logs...");
            Assert.fail();
        }

    }
    @Test(priority = 7, dependsOnMethods = {"search_news"})
    void clicked_latest_news(){
        try {
            logger.info("Clicked The Latest News");
            SearchedPage cln = new SearchedPage(driver);
            cln.clicked_latest_news();
        } catch (Exception e) {
            logger.error("Clicked Latest News Test Failed!!");
            logger.debug("Clicked Latest News Debug Logs...");
            Assert.fail();
        }
        logger.info("===== Finished TC005_SearchLatestNews =====");
    }
}
