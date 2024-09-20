package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; // Log4j
import org.apache.logging.log4j.Logger; // Log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;

    public Logger logger; // Log4j

    @BeforeClass
    void setup() {
//        System.setProperty("log4j.configurationFile", "src/test/resources/log4j.xml");
//        logger = LogManager.getLogger(getClass());  // Fixed type mismatch
//        logger.info("Logger is configured and working.");

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.nytimes.com/");
//        driver.manage().window().maximize();
    }
//    @BeforeClass
//    @Parameters({"browser", "url"})
//    void setup(String br) throws InterruptedException{
//        switch (br){
//            case "chrome": driver = new ChromeDriver(); break;
//            case "edge": driver = new EdgeDriver(); break;
//            case "firefox": driver = new FirefoxDriver(); break;
//            default: System.out.println("Invalid Browser"); return;
//        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.nytimes.com/");
//        Thread.sleep(5000);
//    }
    @AfterClass
    void tearDown() {
        driver.quit();
    }

    public String randomString () {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
    public String randomNumber () {
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }
    public String randomAlphaNumeric () {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        return (generatedString+"&"+generatedNumber);
    }
}
