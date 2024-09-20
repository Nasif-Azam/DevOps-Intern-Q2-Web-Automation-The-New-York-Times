package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class HomePage{
    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By linkMyAccount = By.xpath("//a[normalize-space()='My Account']");
    By linkRegister = By.xpath("//a[normalize-space()='Register']");

    By logoSVG = By.xpath("//a[@class='css-1qcrlqu eoab3xr0']//*[name()='svg']");
    By all_img_tags = By.tagName("img");
    By allHeadings = By.xpath("//div[@class='css-xdandi']/p");

    By englishLanguage = By.xpath("//li[@class='css-1shpxcj']/a[@lang='en-US']");
    By internationalLanguage = By.xpath("//li[@class='css-1nrdlje']/a[@lang='en']");
    By canadaLanguage = By.xpath("//li[@class='css-1nrdlje']/a[@lang='en-CA']");
    By spanishLanguage = By.xpath("//li[@class='css-1nrdlje']/a[@lang='es-ES']");
    By chineseLanguage = By.xpath("//li[@class='css-1nrdlje']/a[@lang='zh-hans']");
    By reset = By.xpath("//a[contains(text(),'ENGLISH (英文)')]");

    By today_paper_btn = By.xpath("//a[contains(text(),'Today’s Paper')]");
    By trending_news_btn = By.xpath("//*[@id='collection-todays-new-york-times']/div[1]/section[1]/div[1]/ol/li[1]/article/div");


    // Action Methods
    public String titleChecker(){
        return "The New York Times - Breaking News, US News, World News and Videos";
    }
    public boolean homeLogoSVG() {
        boolean logoDis = driver.findElement(logoSVG).isDisplayed();
        System.out.println("Home Logo Displayed: "+logoDis);
        return logoDis;
    }
    public int allImageChecker(){
        List<WebElement> images = driver.findElements(all_img_tags);
        System.out.println("Total images: "+images.size());
        return images.size();
    }

    public int allHeadings(){
        List<WebElement> headingList = driver.findElements(allHeadings);
        int count = 0;
        for (WebElement element : headingList) {
            String heading = element.getText();
            if (heading.split("\\s+").length > 2) {
                System.out.println("Heading-"+(count+1)+": "+heading);
                count += 1;
            }
        }
        System.out.println("Total Head Lines: "+(count));
        return count;
    }

    public String engLanChecker(){
        driver.findElement(englishLanguage).click();
        return driver.getTitle();
    }
    public String intaLanChecker(){
        driver.findElement(internationalLanguage).click();
        return driver.getTitle();
    }
    public String canLanChecker(){
        driver.findElement(canadaLanguage).click();
        return driver.getTitle();
    }
    public String spnLanChecker(){
        driver.findElement(spanishLanguage).click();
        return driver.getTitle();
    }
    public String chnLanChecker(){
        driver.findElement(chineseLanguage).click();
        return driver.getTitle();
    }
    public String navigateToNewTab(){
        String originalWindow = driver.getWindowHandle();
        driver.findElement(reset).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        String newTabTitle = driver.getTitle();
        System.out.println("New Tab Title: " + newTabTitle);
        return newTabTitle;
    }

    public void get_today_trending_news(){
        driver.findElement(today_paper_btn).click();
        driver.findElement(trending_news_btn).click();
    }

    public void clickMyAccount(){
        driver.findElement(linkMyAccount).click();
    }

    public void clickRegister(){
        driver.findElement(linkRegister).click();
    }

}
