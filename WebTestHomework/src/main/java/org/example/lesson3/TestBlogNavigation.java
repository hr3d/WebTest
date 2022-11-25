package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBlogNavigation {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://kotofey.ru");

        WebElement LinkToBlog = driver.findElement(By.cssSelector(".footer-col:nth-child(2) li:nth-child(2) > a"));
        LinkToBlog.click();

        WebElement LinkToBlogSecondPage = driver.findElement(By.linkText("2"));
        LinkToBlogSecondPage.click();

        WebElement BlogLink1 = driver.findElement(By.cssSelector(".page-menu > li:nth-child(2) > a"));
        BlogLink1.click();

        WebElement BlogLink2 = driver.findElement(By.cssSelector(".page-menu > li:nth-child(3) > a"));
        BlogLink2.click();

        WebElement BlogLink3 = driver.findElement(By.cssSelector(".blog__item:nth-child(1) > .blog__img"));
        BlogLink3.click();

        //driver.quit();
    }
}
