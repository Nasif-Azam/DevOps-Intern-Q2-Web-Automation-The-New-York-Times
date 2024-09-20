package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchedPage {
    WebDriver driver;

    // Constructor
    public SearchedPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By searchIconBtn = By.xpath("//button[@class='css-tkwi90 e1iflr850']");
    By searchInputBox = By.xpath("//input[@placeholder='SEARCH']");
    By searchGoBtn = By.xpath("//button[@type='submit']");

    By searchedNewsHead = By.xpath("//div[@class='css-e1lvw9']/a/h4");
    By searchedLatestNewsClicked = By.xpath("(//div[@class='css-e1lvw9']/a)[1]");
    By searchedOldestNewsClicked = By.xpath("(//div[@class='css-e1lvw9'])[10]");

    // Action Methods
    public String searchNews(String searchItem){
        driver.findElement(searchIconBtn).click();
        driver.findElement(searchInputBox).sendKeys(searchItem);
        driver.findElement(searchGoBtn).click();
        System.out.println("Search Item: "+searchItem);
        System.out.println("Page Title: "+driver.getTitle());
        return driver.getTitle();
    }

    public int searched_heading_num(){
        List<WebElement> searchHeadingList = driver.findElements(searchedNewsHead);
        int count = 0;
        for (WebElement element : searchHeadingList) {
            String heading = element.getText();
            if (heading.split("\\s+").length > 2) {
                System.out.println("Search-"+(count+1)+": "+heading);
                count += 1;
            }
        }
        System.out.println("Total Search Result: "+(count));
        return count;
    }

    public String latest_news_heading(){
        List<WebElement> searchHeadingList = driver.findElements(searchedNewsHead);
        System.out.println("Latest Search Result: "+ searchHeadingList.getFirst().getText());
        return searchHeadingList.getFirst().getText();
    }

    public void clicked_latest_news(){
        driver.findElement(searchedLatestNewsClicked).click();
        System.out.println("Switched to Latest News: "+driver.getCurrentUrl());
    }

    public String oldest_news_heading(){
        List<WebElement> searchHeadingList = driver.findElements(searchedNewsHead);
        System.out.println("Oldest Search Result: "+ searchHeadingList.getLast().getText());
        return searchHeadingList.getLast().getText();
    }

    public void clicked_oldest_news(){
        driver.findElement(searchedOldestNewsClicked).click();
        System.out.println("Switched to Oldest News: "+driver.getCurrentUrl());
    }


}
