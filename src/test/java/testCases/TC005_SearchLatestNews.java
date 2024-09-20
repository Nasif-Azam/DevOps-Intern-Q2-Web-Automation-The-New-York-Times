package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SearchedPage;

public class TC005_SearchLatestNews extends BaseClass {
    @Test(priority = 4)
    void search_news(){
        SearchedPage sn = new SearchedPage(driver);
        Assert.assertEquals(sn.searchNews("Putin"), "The New York Times - Search");
    }

    @Test(priority = 5, dependsOnMethods = {"search_news"})
    void num_searched_heading(){
        SearchedPage tnsh = new SearchedPage(driver);
        Assert.assertEquals(tnsh.searched_heading_num(), 10);
    }

    @Test(priority = 6, dependsOnMethods = {"search_news"})
    void find_latest_news(){
        SearchedPage lnh = new SearchedPage(driver);
        String latest_news = lnh.latest_news_heading();
    }
    @Test(priority = 7, dependsOnMethods = {"search_news"})
    void clicked_latest_news(){
        SearchedPage cln = new SearchedPage(driver);
        cln.clicked_latest_news();
    }
}
