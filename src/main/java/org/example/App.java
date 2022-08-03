package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        BrowserAdapter adapter = new BrowserAdapter("https://vk.com/friends?act=find&c%5Bage_from%5D=16&c%5Bage_to%5D=16&c%5Bcity%5D=2&c%5Bcountry%5D=1&c%5Bname%5D=1&c%5Bper_page%5D=40&c%5Bphoto%5D=1&c%5Bsection%5D=people&c%5Bsex%5D=1");
        adapter.scrape();

    }

}
