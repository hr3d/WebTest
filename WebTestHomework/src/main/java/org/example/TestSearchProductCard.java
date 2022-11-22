package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestSearchProductCard {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://kotofey.ru");

        WebElement ButtonToSearch = driver.findElement(By.cssSelector(".header-search:nth-child(8)"));
        ButtonToSearch.click();

        WebElement InputSearch = driver.findElement(By.cssSelector(".navbar-search:nth-child(9) > .search-query"));
        InputSearch.sendKeys("254999-41");

        WebElement Link1 = driver.findElement(By.cssSelector(".autocomplete-suggestion-content > a"));
        Link1.click();

        WebElement Button1 = driver.findElement(By.id("description-tab"));
        Button1.click();

        //driver.quit();
    }
}
