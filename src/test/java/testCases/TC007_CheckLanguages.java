package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchedPage;

public class TC007_CheckLanguages extends BaseClass {
    @Test(priority = 10)
    void english_lang_check(){
        HomePage hp = new HomePage(driver);
        Assert.assertEquals("The New York Times - Breaking News, US News, World News and Videos", hp.engLanChecker());
    }
    @Test(priority = 11)
    void international_lang_check(){
        HomePage hp = new HomePage(driver);
        Assert.assertEquals("The New York Times International - Breaking News, US News, World News, Videos", hp.intaLanChecker());
    }
    @Test(priority = 12)
    void canada_lang_check(){
        HomePage hp = new HomePage(driver);
        Assert.assertEquals("The New York Times Canada - Breaking News, US News, World News, Videos", hp.canLanChecker());
    }
    @Test(priority = 13)
    void spain_lang_check(){
        HomePage hp = new HomePage(driver);
        Assert.assertEquals("The New York Times en Español - The New York Times", hp.spnLanChecker());
    }
    @Test(priority = 14)
    void chinese_lang_check(){
        HomePage hp = new HomePage(driver);
        Assert.assertEquals("纽约时报中文网 国际纵览", hp.chnLanChecker());
    }

    @Test(priority = 15)
    void switch_home_tabTC(){
        HomePage hp = new HomePage(driver);
        Assert.assertEquals("The New York Times - Breaking News, US News, World News and Videos", hp.navigateToNewTab());
    }
}
