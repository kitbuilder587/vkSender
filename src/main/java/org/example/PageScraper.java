package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageScraper {
    WebDriver driver;

    public PageScraper(WebDriver driver) {
        this.driver = driver;
    }



    public void getPage(String href){
        driver.get(href);
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    public void scrapePage(String href)  {
        getPage(href);
        WebElement messageButton = driver.findElement(By.cssSelector("#profile_message_send"));
        if(messageButton.getText().contains("Написать сообщение")){
            String messageHref = messageButton.findElement(By.cssSelector("a")).getAttribute("href");
            getPage(messageHref);
            WebElement input = driver.findElement(By.cssSelector(".im-chat-input--textarea"));
            WebElement typeField = input.findElement(By.cssSelector(".im-chat-input--text"));
            typeField.sendKeys("ЭТО BILLY!!!!!!");
            WebElement send = driver.findElement(By.cssSelector(".im-chat-input .im-send-btn"));
            send.click();
            WebElement pictureButton = input.findElement(By.cssSelector(".im-chat-input--attach-file"));
            pictureButton.sendKeys("/home/nick/Pictures/XGNDhSIft0o.jpg");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            send.click();

        }


    }
}

