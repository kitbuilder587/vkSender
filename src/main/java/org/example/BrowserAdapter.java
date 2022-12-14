package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BrowserAdapter {

    WebDriver driver;
    String href;
    public BrowserAdapter(String href) {
        this.href = href;
        System.setProperty("webdriver.chrome.driver", "/home/nick/webdriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/home/nick/webdriver/My Custom Profile");
        driver = new ChromeDriver(options);
        PageFactory.initElements(driver, this);
    }


    public void scrape() throws InterruptedException {
        driver.get(href);

        for(int i=0;i<10;i++){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,10000)", "");
            Thread.sleep(1000);
        }

        ProfileHrefsScraper profileHrefsScraper = new ProfileHrefsScraper(driver);
        List<String> hrefs = profileHrefsScraper.getProfilesHrefs();
        for( String href  : hrefs ){
            PageScraper pageScraper = new PageScraper(driver);
            pageScraper.scrapePage(href);
        }
    }
}
