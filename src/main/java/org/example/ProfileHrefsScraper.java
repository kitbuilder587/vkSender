package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProfileHrefsScraper {

    WebDriver driver;

    public ProfileHrefsScraper(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getProfilesHrefs(){
        List<WebElement> profiles = driver.findElements(By.cssSelector(".people_row"));
        profiles = profiles.stream().filter(profile -> profile.getText().contains("Добавить в друзья")).collect(Collectors.toList());
        profiles = profiles.stream().map(profile -> profile.findElement(By.cssSelector(".info a"))).collect(Collectors.toList());
        List<String> hrefs = profiles.stream().map(profile -> profile.getAttribute("href")).collect(Collectors.toList());
        System.out.println(Arrays.toString(hrefs.toArray()));
        return hrefs;
    }
}
