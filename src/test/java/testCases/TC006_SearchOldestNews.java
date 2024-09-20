package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SearchedPage;

public class TC006_SearchOldestNews extends BaseClass {
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
    void find_oldest_news(){
        SearchedPage onh = new SearchedPage(driver);
        String older_news = onh.oldest_news_heading();
    }
    @Test(priority = 7, dependsOnMethods = {"search_news"})
    void clicked_oldest_news() {
        SearchedPage con = new SearchedPage(driver);
        con.clicked_oldest_news();
    }
}
