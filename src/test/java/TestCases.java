import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestCases {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.nytimes.com/");
    }
    @Test(priority = 0)
    void TC00_titleCheck(){
        ActionMethods lp = new ActionMethods(driver);
        // Validation
        Assert.assertEquals(driver.getTitle(), lp.titleChecker());
    }

    @Test(priority = 1)
    void TC01_allImagesCheckTC(){
        ActionMethods lp = new ActionMethods(driver);
        // Validation
        Assert.assertEquals(lp.allImageChecker(), 102); // Expected values are depends on server fetches
    }
    @Test(priority = 2)
    void TC02_allHeadingCheckTC(){
        ActionMethods lp = new ActionMethods(driver);
        Assert.assertEquals(lp.allHeadings(), 31); // Expected values are depends on server fetches
    }
    @Test(priority = 3)
    void TC03_searchTC(){
        ActionMethods lp = new ActionMethods(driver);
        Assert.assertEquals(lp.search("Putin"), "The New York Times - Search");
    }
    @Test(priority = 4, dependsOnMethods = {"TC03_searchTC"})
    void TC04_searchedHeadingCheckTC(){
        ActionMethods lp = new ActionMethods(driver);
        Assert.assertEquals(lp.searchedHeadings(), 10);
    }
    @Test(priority = 5, dependsOnMethods = {"TC03_searchTC"})
    void TC05_searchedLatestCheckTC(){
        ActionMethods lp = new ActionMethods(driver);
        String latest_news = lp.searchedLatestHeading();
    }
    @Test(priority = 6, dependsOnMethods = {"TC03_searchTC"})
    void TC06_searchedOlderCheckTC(){
        ActionMethods lp = new ActionMethods(driver);
        String older_news = lp.searchedOlderHeading();
    }
    @Test(priority = 7, dependsOnMethods = {"TC03_searchTC"})
    void TC07_clickLatestNewsTC(){
        ActionMethods lp = new ActionMethods(driver);
        lp.clickLatestNews();
        lp.directedHomepage();
    }
    @Test(priority = 8)
    void TC08_clickOldestNewsTC(){
        ActionMethods lp = new ActionMethods(driver);
        lp.search("Putin");
        lp.clickOldestNews();
    }
    @Test(priority = 9)
    void TC09_englishLangTC(){
        ActionMethods lp = new ActionMethods(driver);
        Assert.assertEquals("The New York Times - Breaking News, US News, World News and Videos", lp.engLanChecker());
    }
    @Test(priority = 10)
    void TC10_internationalLangTC(){
        ActionMethods lp = new ActionMethods(driver);
        Assert.assertEquals("The New York Times International - Breaking News, US News, World News, Videos", lp.intaLanChecker());
    }
    @Test(priority = 11)
    void TC11_canadaLangTC(){
        ActionMethods lp = new ActionMethods(driver);
        Assert.assertEquals("The New York Times Canada - Breaking News, US News, World News, Videos", lp.canLanChecker());
    }
    @Test(priority = 12)
    void TC12_spainLangTC(){
        ActionMethods lp = new ActionMethods(driver);
        Assert.assertEquals("The New York Times en Español - The New York Times", lp.spnLanChecker());
    }
    @Test(priority = 13)
    void TC13_chineseLangTC(){
        ActionMethods lp = new ActionMethods(driver);
        Assert.assertEquals("纽约时报中文网 国际纵览", lp.chnLanChecker());
    }

    @Test(priority = 14)
    void TC14_switchTabTC(){
        ActionMethods lp = new ActionMethods(driver);
        Assert.assertEquals("The New York Times - Breaking News, US News, World News and Videos", lp.navigateToNewTab());
    }

    @Test(priority = 15)
    void TC15_loginPage(){
        ActionMethods lp = new ActionMethods(driver);
        lp.clickLoginButton();
    }

    @Test(priority = 16, dependsOnMethods = {"TC15_loginPage"})
    void TC16_loginPageLogoChecker(){
        ActionMethods lp = new ActionMethods(driver);
        // Validation
        Assert.assertTrue(lp.logoDisplayed(), "The logo is not displayed.");
    }

    @Test(priority = 17)
    void TC17_testLogin(){
        ActionMethods lp = new ActionMethods(driver);
        lp.setUserName("nasifazam.batterylowinteractive@gmail.com");
        lp.contUserName();
        lp.setPassword("0123456789!");
        lp.clickLogin();
        // Validation
        Assert.assertEquals(driver.getTitle(), "Log in - The New York Times");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }

}

