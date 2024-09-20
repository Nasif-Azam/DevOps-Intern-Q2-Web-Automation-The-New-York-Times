package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC008_TrendingNews extends BaseClass{
    @Test
    void today_trending_news(){
        HomePage hp = new HomePage(driver);
        hp.get_today_trending_news();
    }
}
