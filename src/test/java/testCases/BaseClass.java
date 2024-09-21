package testCases;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;

    public Logger logger; // Log4j
    Properties prop;

    @BeforeClass
    @Parameters({"browser"})
    void setup(String br) throws InterruptedException, IOException {
//        System.setProperty("log4j.configurationFile", System.getProperty("user.dir")+"\\resources\\log4j2.xml");
        System.setProperty("log4j.configurationFile", System.getProperty("user.dir") + "/resources/log4j2.xml");
        logger = LogManager.getLogger(getClass());  // Fixed type mismatch
        logger.info("Logger is configured and working.");

        // Loading config.properties
        prop = new Properties();
        FileReader file = new FileReader("./src/test/resources/config.properties");
        prop.load(file);

        switch (br.toLowerCase()){
            case "chrome": driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid Browser"); return;
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.nytimes.com/");
        driver.get(prop.getProperty("appURL"));
//        Thread.sleep(5000);
    }
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

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // Define the target file path (use forward slashes for better compatibility)
        String targetFilePath = System.getProperty("user.dir") + "/screenshots/" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        // Copy the file instead of renaming it to avoid potential IO issues
        FileUtils.copyFile(sourceFile, targetFile);
        return targetFilePath;
    }
}
