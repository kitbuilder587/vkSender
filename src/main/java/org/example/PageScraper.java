package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

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
            ArrayList<String> phrases = new ArrayList<>();
            phrases.add("Привет, это мой второй аккаунт, я случайно заметил твою страницу, понравились фотографии. Если хочешь продолжить общение, вот мой телеграм (@zajdelovm) , потому что я не сижу на этом аккаунте. Вот фотография, чтобы ты меня не пугалась");
            phrases.add("Здравствуй, это мой второй аккаунт вк, я случайно заметил твой профиль, понравились фотографии. Если хочешь продолжить общение, вот мой телеграм (@zajdelovm) , потому что я не сижу на этом аккаунте. Вот фотография, чтобы ты меня не пугалась");
            phrases.add("Доброго времени суток, это мой второй аккаунт вк, я случайно заметил твой профиль, понравились фотографии. Если хочешь продолжить общение, вот мой телеграм: @zajdelovm , потому что я не сижу на этом аккаунте. Вот фотография, чтобы ты меня не пугалась");
            phrases.add("Доброго времени суток, это мой второй аккаунт вк, я случайно заметил твой профиль, понравились фотографии. Если хочешь продолжить общение, вот мой телеграм: @zajdelovm , потому что я не сижу на этом аккаунте. Вот фотография, чтобы ты поняла, что такое арийская раса");
            Random random = new Random();
            int si = random.nextInt(phrases.size()-1);
            typeField.sendKeys(phrases.get(si));
            WebElement send = driver.findElement(By.cssSelector(".im-chat-input .im-send-btn"));
            send.click();
            WebElement pictureButton = input.findElement(By.cssSelector(".im-chat-input--attach-file"));
            ArrayList<String> photos = new ArrayList<>();
            photos.add("/home/nick/Pictures/44423234234.jpg");
            photos.add("/home/nick/Pictures/SoggyRemarkableAddax-size_restricted.gif");
            photos.add("/home/nick/Pictures/miklosh.png");
            photos.add("/home/nick/Pictures/yjvHaBIPlf8.jpg");
            pictureButton.sendKeys(photos.get(si));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            send.click();

        }


    }
}

